package com.chyrus.rijksmuseum.base;

import com.chyrus.rijksmuseum.R;
import com.chyrus.rijksmuseum.network.Network;
import com.chyrus.rijksmuseum.network.Routes;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public class BasePresenter<V extends BaseView> {

    private V view;
    private Routes service;
    private CompositeDisposable composite;

    protected void attachView(V view) {
        this.view = view;
        service = Network.builder().create(Routes.class);
    }

    public V view() {
        return view;
    }

    public Routes service() {
        return service;
    }

    private String getToken() {
        return ""; //@TODO("local storage")
    }

    private void resetToken() {
        //@TODO("reset token")
    }

    protected void subscribe(Disposable disposable) {
        if (composite == null) composite = new CompositeDisposable();
        composite.add(disposable);
    }

    protected void handleError(Throwable error) {
        if (error == null) {
            view().onError(R.string.network_error);
            return;
        }

        if (error instanceof HttpException) {
            switch (((HttpException) error).code()) {
                case 408: //RTO
                    view().onError(R.string.network_retry);
                    break;
                default:
                    view().onError(R.string.network_error);
            }
        }
    }

    void dettachView() {
        this.view = null;
        if (composite != null) {
            composite.clear();
        }
    }

}