package com.chyrus.rijksmuseum.utils.rx;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainScheduler<T> extends SchedulerTransformer<T> {

    public MainScheduler() {
        super(Schedulers.io(), AndroidSchedulers.mainThread());
    }
}
