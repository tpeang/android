package com.example.tpapp.s2;

import com.example.tpapp.R;
import com.example.tpapp.R.id;
import com.example.tpapp.R.layout;
import com.example.tpapp.R.menu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;

public class MenuTest extends Activity {
	final int FONT_10 = 0x111;
	final int FONT_12 = 0x112;
	final int FONT_14 = 0x113;
	final int FONT_16 = 0x114;
	final int FONT_18 = 0x115;

	final int PLAIN_ITEM = 0x11b;
	final int FONT_RED = 0x116;
	final int FONT_BLUE = 0x117;
	final int FONT_GREEN = 0x118;
	private EditText edit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_test);
		edit = (EditText) findViewById(R.id.txt);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		SubMenu fontMenu = menu.addSubMenu("字体大小");
		fontMenu.setIcon(R.drawable.font);
		fontMenu.setHeaderIcon(R.drawable.font);
		fontMenu.setHeaderTitle("选择字体大小");
		fontMenu.add(0, FONT_10, 0, "十号字体");
		fontMenu.add(0, FONT_12, 0, "12号字体");
		fontMenu.add(0, FONT_14, 0, "14号字体");
		fontMenu.add(0, FONT_16, 0, "16号字体");
		fontMenu.add(0, FONT_16, 0, "18号字体");
		menu.add("普通菜单项");
		SubMenu colorMenu = menu.addSubMenu("字体颜色");
		colorMenu.setIcon(R.drawable.color);
		colorMenu.setHeaderIcon(R.drawable.color);
		colorMenu.setHeaderTitle("选择文字颜色");

		colorMenu.add(0, FONT_RED, 0, "红色");
		colorMenu.add(0, FONT_BLUE, 0, "蓝色");
		colorMenu.add(0, FONT_GREEN, 0, "绿色");

		getMenuInflater().inflate(R.menu.menu_test, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		case FONT_10:
			edit.setTextSize(10 * 2);
			break;
		case FONT_12:
			edit.setTextSize(12 * 2);
			break;
		case FONT_14:
			edit.setTextSize(14 * 2);
			break;
		case FONT_16:
			edit.setTextSize(16 * 2);
			break;
		case FONT_18:
			edit.setTextSize(18 * 2);
			break;
		case FONT_RED:
			edit.setTextColor(Color.RED);
			break;
		case FONT_BLUE:
			edit.setTextColor(Color.BLUE);
			break;
		case FONT_GREEN:
			edit.setTextColor(Color.GREEN);
			break;
		 
		}
		return super.onOptionsItemSelected(item);
	}
}
