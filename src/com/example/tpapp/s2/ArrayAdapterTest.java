package com.example.tpapp.s2;

import com.example.tpapp.R;
import com.example.tpapp.R.id;
import com.example.tpapp.R.layout;
import com.example.tpapp.R.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayAdapterTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.array_adapter_test);
		ListView list1 = (ListView)findViewById(R.id.list1);
		ListView list2 = (ListView)findViewById(R.id.list2);
		String[] arr1 = new String[]{
				"ËïÎò¿Õ", "Öí°Ë½ä", "Å£Ä§Íõ"
		};
		 ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.array_items,arr1); 
		 list1.setAdapter(adapter1);
		 
		 String[] arr2 = new String[]{
				 "java", "hibernate", "spring", "android"
		 };
		 ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.check_item,arr2);
		 list2.setAdapter(adapter2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.array_adapter_test, menu);
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
