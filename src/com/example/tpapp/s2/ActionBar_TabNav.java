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
				.addTab(actionBar.newTab().setText("��һҳ").setTabListener(this));
		actionBar
				.addTab(actionBar.newTab().setText("�ڶ�ҳ").setTabListener(this));
		actionBar
				.addTab(actionBar.newTab().setText("����ҳ").setTabListener(this));

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
//		// ����һ���µ�Fragment����
//		Fragment fragment = new DummyFragment();
//		// ����һ��Bundle����������Fragment�������
//		Bundle args = new Bundle();
//		args.putInt(DummyFragment.ARG_SECTION_NUMBER, tab.getPosition() + 1);
//		// ��fragment�������
//		fragment.setArguments(args);
//		// ��ȡFragmentTransaction����
//		FragmentTransaction ft = getFragmentManager().beginTransaction();
//		// ʹ��fragment�����Activity�е�container���
//		ft.replace(R.id.container, fragment);
//		// �ύ����
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
