package com.example.tpapp.s2;

import com.example.tpapp.R;
import com.example.tpapp.R.id;
import com.example.tpapp.R.layout;
import com.example.tpapp.R.menu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ContextMenuTest extends Activity {
	final int MENU1 = 0x111;
	final int MENU2 = 0x112;
	final int MENU3 = 0x113;
	private TextView txt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.context_menu_test);
		txt = (TextView)findViewById(R.id.txt);
		registerForContextMenu(txt);
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		menu.add(0,MENU1,0,"红色");
		menu.add(0,MENU2,0,"绿色");
		menu.add(0,MENU3,0,"蓝色");
		menu.setGroupCheckable(0, true, true);
		menu.setHeaderIcon(R.drawable.tools);
		menu.setHeaderTitle("选择背景颜色");
		
	}


	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case MENU1:
			item.setChecked(true);
			txt.setBackgroundColor(Color.RED);
			break;
		case MENU2:
			item.setChecked(true);
			txt.setBackgroundColor(Color.GREEN);
			break;
		case MENU3:
			item.setChecked(true);
			txt.setBackgroundColor(Color.BLUE);
			break;
		}
		return true;
	}
	

 
}
