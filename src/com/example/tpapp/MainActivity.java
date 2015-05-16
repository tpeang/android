package com.example.tpapp;

import com.example.tpapp.s10.BindServiceTest;
import com.example.tpapp.s2.*;
import com.example.tpapp.s4.SelectBookActivity;
import com.example.tpapp.s7.AnimatorTest;
import com.example.tpapp.s7.Blast;
import com.example.tpapp.s7.Butterfly;
import com.example.tpapp.s7.FatPo;
import com.example.tpapp.s7.MatrixTest;
import com.example.tpapp.s7.MeshTest;
import com.example.tpapp.s7.ShaderTest;
import com.example.tpapp.s7.ShowWave;
import com.example.tpapp.s7.SurfaceViewTest;
import com.example.tpapp.s8.DBTest;
import com.example.tpapp.s8.Dict;
import com.example.tpapp.s8.FileTest;
import com.example.tpapp.s8.SharedPreferencesTest;
import com.example.tpapp.s9.ContactProviderTest;
import com.example.tpapp.s9.DictResolverTest;
import com.example.tpapp.s9.FirstResolver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends Activity {
	Class<?>[] names = new Class[] { BindServiceTest.class,GridLayoutTest.class,
			CheckButtonTest.class, ToggleButtonTest.class, ClockTest.class,
			ChronometerTest.class, ImageViewTest.class,
			SimpleListViewTest.class, ArrayAdapterTest.class,
			ExpandableListViewTest.class, SearchViewTest.class,
			AlertDialogTest.class, DateDialogTest.class, MenuTest.class,
			ContextMenuTest.class, ActionBar_TabNav.class,
			PreferenceActivityTest.class, SelectBookActivity.class,
			MatrixTest.class, MeshTest.class, ShaderTest.class, FatPo.class,
			Blast.class, Butterfly.class, AnimatorTest.class,
			SurfaceViewTest.class, ShowWave.class, SharedPreferencesTest.class,
			FileTest.class, DBTest.class,Dict.class,FirstResolver.class,DictResolverTest.class,ContactProviderTest.class};

	String[] arr = new String[] { names[0].getSimpleName(),
			names[1].getSimpleName(), names[2].getSimpleName() };
	String[] arr1 = new String[names.length];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		for (int i = 0; i < names.length; i++) {
			arr1[i] = names[i].getSimpleName();
		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView gridView = (ListView) findViewById(R.id.gridViewRoot);

		System.out.println(arr);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.item_of_main, arr1);
		gridView.setAdapter(adapter);

		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				System.out.println(names[position]);
				Intent intent = new Intent(MainActivity.this, names[position]);

				startActivity(intent);
				Log.e("²éÕÒÌø×ªµÄActivity£º", "xia");

			}
		});

	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
