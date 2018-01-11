package com.jdev.countryutil;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by jitenderdev on 11/1/18.
 */

public class CountryUtil {

    Activity mContext;
    String mTitle = "";

    public CountryUtil(Activity context) {
        this.mContext = context;
    }

    public void build() {
        Intent intent = new Intent(mContext, CountriesActivity.class);
        intent.putExtra(Constants.KEY_TITLE, mTitle);
        mContext.startActivityForResult(intent, Constants.KEY_RESULT_CODE);
    }

    public CountryUtil setTitle(String title) {
        if (mTitle != null)
            mTitle = title;
        return this;
    }
}
