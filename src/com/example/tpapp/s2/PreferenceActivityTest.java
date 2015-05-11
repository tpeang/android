package com.example.tpapp.s2;

import java.util.List;

import com.example.tpapp.R;
 



import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class PreferenceActivityTest extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.preference_activity_test);
		if(hasHeaders()){
			Button button = new Button(this);
			button.setText("设置操作");
			setListFooter(button);
		}
	}

	@Override
	public void onBuildHeaders(List<Header> target) {
		// TODO Auto-generated method stub
		loadHeadersFromResource(R.xml.preference_headers,target);
	}
	public static class Prefs1Fragment extends PreferenceFragment{

		@Override
		public void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.preferences);
		}
		
	}
	public static class Prefs2Fragment extends PreferenceFragment{

		@Override
		public void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.display_prefs);
			String website = getArguments().getString("website");
			Toast.makeText(getActivity(), "网站域名是： "+website ,Toast.LENGTH_SHORT).show();
		}
		
	}
	 
}
