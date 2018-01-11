package com.jdev.countryutility;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.jdev.countryutil.Constants;
import com.jdev.countryutil.CountriesActivity;
import com.jdev.countryutil.Country;


public class MainActivity extends AppCompatActivity {

    private TextView mTvCountryName, mTvCountryIsoCode, mTvCountryDialCode;
    private ImageView mIvCountryFlag;
    private Button mBtnPickCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpLayout();
        setDataInViewObjects();
    }

    private void setUpLayout() {
        mTvCountryName = (TextView) findViewById(R.id.tv_country_name);
        mTvCountryIsoCode = (TextView) findViewById(R.id.tv_country_iso);
        mTvCountryDialCode = (TextView) findViewById(R.id.tv_country_isd);
        mBtnPickCountry = (Button) findViewById(R.id.btn_select_country);
        mIvCountryFlag = (ImageView) findViewById(R.id.iv_country_flag);
    }

    private void getUserCountryInfo() {
        Country country = Country.getCountryFromSIM(getApplicationContext());
        if (country != null) {
            mIvCountryFlag.setImageResource(country.getFlag());
            mTvCountryDialCode.setText(country.getDialCode());
            mTvCountryIsoCode.setText(country.getCode());
            mTvCountryName.setText(country.getName());
        }
    }

    private void setDataInViewObjects() {
        mBtnPickCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CountriesActivity.class);
                startActivityForResult(intent, Constants.KEY_RESULT_CODE);
            }
        });
        getUserCountryInfo();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.KEY_RESULT_CODE) {
            try {
                mTvCountryName.setText(data.getStringExtra(Constants.KEY_COUNTRY_NAME));
                mTvCountryIsoCode.setText(data.getStringExtra(Constants.KEY_COUNTRY_ISO_CODE));
                mTvCountryDialCode.setText(data.getStringExtra(Constants.KEY_COUNTRY_ISD_CODE));
                mIvCountryFlag.setImageResource(data.getIntExtra(Constants.KEY_COUNTRY_FLAG, 0));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
