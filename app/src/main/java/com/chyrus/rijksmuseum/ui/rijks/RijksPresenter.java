package com.chyrus.rijksmuseum.ui.rijks;

import com.chyrus.rijksmuseum.base.BasePresenter;
import com.chyrus.rijksmuseum.data.RijksModel;
import com.chyrus.rijksmuseum.utils.rx.MainScheduler;

import java.util.ArrayList;
import java.util.List;

public class RijksPresenter extends BasePresenter<RijksView> {

    RijksPresenter(RijksView view) {
        attachView(view);
    }

    void showRijks() {
        view().showLoading();
        if (view().isNetworkConnected())
            subscribe(service().getRijks()
                    .compose(new MainScheduler<>())
                    .subscribe(res -> {
                        view().hideLoading();
                        List<RijksModel> listData = new ArrayList<>();
                        for (int i = 0; i < res.getArtObjects().size(); i++) {
                            RijksModel data = new RijksModel();
                            data.setTitle(res.getArtObjects().get(i).getTitle());
                            data.setDesc(res.getArtObjects().get(i).getLongTitle());
                            data.setImg(res.getArtObjects().get(i).getWebImage().getUrl());
                            listData.add(data);
                        }
                        view().onSuccess(listData);
                    }, err -> {
                        view().hideLoading();
                        handleError(err);
                    })
            );
        else
            view().onError("Network Issue!");
    }

}
