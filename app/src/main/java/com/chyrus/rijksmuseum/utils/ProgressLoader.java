package com.chyrus.rijksmuseum.utils;

import android.app.ProgressDialog;
import android.content.Context;

import com.chyrus.rijksmuseum.R;

public class ProgressLoader {

    private ProgressDialog mProgressDialog;
    private Context context;

    public ProgressLoader(Context context) {
        this.context = context;
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage(context.getString(R.string.loading));
    }

    public void show(){
        mProgressDialog.show();
    }

    public void hide(){
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

}
