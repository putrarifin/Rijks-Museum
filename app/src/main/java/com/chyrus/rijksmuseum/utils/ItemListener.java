package com.chyrus.rijksmuseum.utils;

import android.view.View;

public interface ItemListener <M> {
    void onClick(View view, M data);
}