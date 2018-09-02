package com.chyrus.rijksmuseum.ui.main;

import com.chyrus.rijksmuseum.base.BasePresenter;

public class MainPresenter extends BasePresenter<MainView> {

    MainPresenter(MainView view) {
        super.attachView(view);
    }

    void getRijks() {
        view().showLoading();
//        subscribe(service().getHome()
//                .compose(new MainScheduler<>())
//                .subscribe(res -> {
//                    view().hideLoading();
//                    view().onSuccess(res);
//                }, err -> {
//                    view().hideLoading();
//                    handleError(err);
//                })
//        );
    }
}
