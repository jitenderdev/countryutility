package com.jdev.countryutil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CountriesActivity extends AppCompatActivity {
    public static CountriesAdapter mCountriesAdapter;
    ListView mLvCountries;
    ArrayList<Country> mCountriesList = new ArrayList<Country>();
    Toolbar mToolbar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        setUpLayout();
        setUpToolbar();
        setDataInViewObjects();
    }

    private void setDataInViewObjects() {
        try {
            for (Country c : Country.getAllCountries()) {
                mCountriesList.add(c);
            }
            //
            mCountriesAdapter = new CountriesAdapter(CountriesActivity.this,
                    R.layout.list_item_country, mCountriesList);
            mLvCountries.setFastScrollEnabled(true);
            mLvCountries.setAdapter(mCountriesAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUpLayout() {
        mLvCountries = (ListView) findViewById(R.id.lv_countries);
        mLvCountries.setFastScrollEnabled(true);
        //
        mLvCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Country country = mCountriesList.get(position);
                    //
                    Intent intent = new Intent();
                    String countryName = country.getName();
                    String countryCode = country.getCode();
                    String countryDialCode = country.getDialCode();
                    int countryFlag = country.getFlag();
                    //
                    intent.putExtra(Constants.KEY_COUNTRY_NAME, countryName);
                    intent.putExtra(Constants.KEY_COUNTRY_ISO_CODE, countryCode);
                    intent.putExtra(Constants.KEY_COUNTRY_ISD_CODE, countryDialCode);
                    intent.putExtra(Constants.KEY_COUNTRY_FLAG, countryFlag);
                    setResult(Constants.KEY_RESULT_CODE, intent);
                    //
                    finish();

            }
        });

    }

    public void setUpToolbar() {
        try {
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(mToolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(R.string.all_countries);
            }
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_right_to_left_return,
                R.anim.anim_left_to_right_return);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.action_search:
//                return true;
        }
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_countries, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) myActionMenuItem.getActionView();

        try {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    if (TextUtils.isEmpty(newText)) {
                        CountriesActivity.mCountriesAdapter.filter("");
                    } else {
                        CountriesActivity.mCountriesAdapter.filter(newText);
                    }
                    return true;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

}