package com.jdev.countryutil;


import java.util.ArrayList;
import java.util.Locale;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;


public class CountriesAdapter extends BaseAdapter implements SectionIndexer {
	private final Activity context;
	int resource;
	ArrayList<Country> mCountrtList;
	private ArrayList<Country> arraylist;
	private String mSections = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	static class ViewHolder {
		public TextView mTvTitle;
		public ImageView mIvCountryFlag;
	}

	public CountriesAdapter(Activity context, int resource,
							ArrayList<Country> slangPojo) {
		super();
		this.resource = resource;
		this.context = context;
		this.mCountrtList = slangPojo;
		this.arraylist = new ArrayList<Country>();
		if (slangPojo != null) {
			this.arraylist.addAll(slangPojo);
		}

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		ViewHolder viewHolder = null;
		//
		if (rowView == null) {
			rowView = context.getLayoutInflater().inflate(resource, null);
			viewHolder = new ViewHolder();
			viewHolder.mTvTitle = (TextView) rowView
					.findViewById(R.id.tv_country_name);
			viewHolder.mIvCountryFlag = (ImageView) rowView
					.findViewById(R.id.iv_flag);
			rowView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) rowView.getTag();
		}

		try {
			Country country = getItem(position);
			//
			viewHolder.mTvTitle.setText(country.getName());
			viewHolder.mIvCountryFlag.setImageResource(country.getFlag());
			//
		} catch (Exception e) {
			 e.printStackTrace();
		}

		return rowView;
	}

	@Override
	public int getCount() {
		return mCountrtList.size();
	}

	@Override
	public Country getItem(int position) {
		return mCountrtList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public int getSectionForPosition(int position) {
		return 0;
	}

	@Override
	public Object[] getSections() {
		String[] sections = new String[mSections.length()];
		for (int i = 0; i < mSections.length(); i++)
			sections[i] = String.valueOf(mSections.charAt(i));
		return sections;
	}

	@Override
	public int getPositionForSection(int section) {
		// If there is no item for current section, previous section will be
		// selected
		for (int i = section; i >= 0; i--) {
			for (int j = 0; j < getCount(); j++) {
				if (i == 0) {
					// For numeric section
					for (int k = 0; k <= 9; k++) {
						if (StringMatcher.match(String.valueOf(getItem(j)
								.getName().charAt(0)), String.valueOf(k)))
							return j;
					}
				} else {
					if (StringMatcher.match(String.valueOf(getItem(j)
							.getName().charAt(0)), String
							.valueOf(mSections.charAt(i))))
						return j;
				}
			}
		}
		return 0;
	}

	// Filter Class
	public void filter(String charText) {
		charText = charText.toLowerCase(Locale.getDefault());
		mCountrtList.clear();
		if (charText.length() == 0) {
			mCountrtList.addAll(arraylist);
		} else {
			for (Country country : arraylist) {
				if (country.getName().toLowerCase(Locale.getDefault())
						.contains(charText)) {
					mCountrtList.add(country);
				}
			}
		}
		notifyDataSetChanged();
	}

}