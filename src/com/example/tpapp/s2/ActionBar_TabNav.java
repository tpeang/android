package com.example.tpapp.s2;

import com.example.tpapp.R;
import com.example.tpapp.R.id;
import com.example.tpapp.R.layout;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;

public class ActionBar_TabNav extends Activity implements TabListener {
	private static final String SELECTED_ITEM = "selected_item";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.action_bar__tab_nav);
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar
				.addTab(actionBar.newTab().setText("第一页").setTabListener(this));
		actionBar
				.addTab(actionBar.newTab().setText("第二页").setTabListener(this));
		actionBar
				.addTab(actionBar.newTab().setText("第三页").setTabListener(this));

	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if (savedInstanceState.containsKey(SELECTED_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(SELECTED_ITEM));
		}

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		outState.putInt(SELECTED_ITEM, getActionBar()
				.getSelectedNavigationIndex());

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {
		// TODO Auto-generated method stub

		Fragment fragment = new DummyFragment();
		Bundle args = new Bundle();
		args.putInt(DummyFragment.ARG_SECTION_NUMBER, tab.getPosition() + 1);
		fragment.setArguments(args);
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.container, fragment);
		
		 
		ft.commit();
//
//		// 创建一个新的Fragment对象
//		Fragment fragment = new DummyFragment();
//		// 创建一个Bundle对象，用于向Fragment传入参数
//		Bundle args = new Bundle();
//		args.putInt(DummyFragment.ARG_SECTION_NUMBER, tab.getPosition() + 1);
//		// 向fragment传入参数
//		fragment.setArguments(args);
//		// 获取FragmentTransaction对象
//		FragmentTransaction ft = getFragmentManager().beginTransaction();
//		// 使用fragment代替该Activity中的container组件
//		ft.replace(R.id.container, fragment);
//		// 提交事务
//		ft.commit();

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

}
