package com.chyrus.rijksmuseum.ui.rijks;

import com.chyrus.rijksmuseum.base.BaseView;
import com.chyrus.rijksmuseum.data.RijksModel;

import java.util.List;

interface RijksView extends BaseView {
    void onSuccess(List<RijksModel> res);
}
