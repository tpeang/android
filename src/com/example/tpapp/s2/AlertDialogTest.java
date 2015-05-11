package com.example.tpapp.s2;

import com.example.tpapp.R;
 

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

public class AlertDialogTest extends Activity {
	TextView show;
	String[] items = new String[]{
			"疯狂java讲义","疯狂ajax讲义","轻量级java ee企业应用实战","疯狂android讲义"
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alert_dialog_test);
		show = (TextView)findViewById(R.id.show);
	}
 
	public void simple(View source){
	 
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
		.setTitle("简单对话框")
		.setIcon(R.drawable.tools)
		.setMessage("对话框的测试内容\n第二行内容");
		setPositiveButton(builder);
		setNegativeButton(builder).create().show();
		
	} 
	
	public void simpleList(View source){
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
		.setTitle("简单列表对话框")
		.setIcon(R.drawable.tools)
		.setItems(items, new OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which){
				show.setText("您选中了【"+items[which]+"】 ");
			}
		});
		setPositiveButton(builder);
		setNegativeButton(builder).create().show();
	}
	public void singleChoice(View source){
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
		.setTitle("单选列表项对话框")
		.setIcon(R.drawable.tools)
		.setSingleChoiceItems(items, 1, new OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				show.setText("您选中了【"+items[which]+"】 ");
			}
			
		});
		setPositiveButton(builder);
		setNegativeButton(builder).create().show();
	}
	public void mutiChoice(View source){
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
		.setTitle("多选列表对话框")
		.setIcon(R.drawable.tools)
		.setMultiChoiceItems(items, new boolean[]{false, true, false, true},null);
		setPositiveButton(builder);
		setNegativeButton(builder).create().show();
		
	}
	public void customList(View source){
		AlertDialog.Builder builder  = new AlertDialog.Builder(this)
		.setTitle("自定义列表对话框")
		.setIcon(R.drawable.tools)
		.setAdapter(new ArrayAdapter<String>(this, R.layout.array_items, items),null);
		setPositiveButton(builder);
		setNegativeButton(builder).create().show();
	}
	public void customView(View source)
	{
		TableLayout loginForm = (TableLayout)getLayoutInflater()
			.inflate( R.layout.login, null);		
		new AlertDialog.Builder(this)
			.setIcon(R.drawable.tools)
			.setTitle("自定义View对话框")
			.setView(loginForm)
			.setPositiveButton("登录" , new OnClickListener()
			{
				@Override
				public void onClick(DialogInterface dialog,
						int which)
				{
					 show.setText("点击了登陆");
				}
			})
			.setNegativeButton("取消", new OnClickListener()
			{
				@Override
				public void onClick(DialogInterface dialog,
						int which)
				{
					show.setText("点击了取消");
				}
			})
			.create()
			.show();
	}
	
	 
	private Builder setPositiveButton(Builder builder){
		return builder.setPositiveButton("确定", new OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				show.setText("单击了【确定】按钮");
			}
			
		});
	}
	private Builder setNegativeButton(Builder builder){
		return builder.setNegativeButton("取消", new OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which){
				show.setText("单击了【取消】按钮");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alert_dialog, menu);
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
