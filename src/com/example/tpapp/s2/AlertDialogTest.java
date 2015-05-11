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
			"���java����","���ajax����","������java ee��ҵӦ��ʵս","���android����"
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alert_dialog_test);
		show = (TextView)findViewById(R.id.show);
	}
 
	public void simple(View source){
	 
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
		.setTitle("�򵥶Ի���")
		.setIcon(R.drawable.tools)
		.setMessage("�Ի���Ĳ�������\n�ڶ�������");
		setPositiveButton(builder);
		setNegativeButton(builder).create().show();
		
	} 
	
	public void simpleList(View source){
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
		.setTitle("���б�Ի���")
		.setIcon(R.drawable.tools)
		.setItems(items, new OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which){
				show.setText("��ѡ���ˡ�"+items[which]+"�� ");
			}
		});
		setPositiveButton(builder);
		setNegativeButton(builder).create().show();
	}
	public void singleChoice(View source){
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
		.setTitle("��ѡ�б���Ի���")
		.setIcon(R.drawable.tools)
		.setSingleChoiceItems(items, 1, new OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				show.setText("��ѡ���ˡ�"+items[which]+"�� ");
			}
			
		});
		setPositiveButton(builder);
		setNegativeButton(builder).create().show();
	}
	public void mutiChoice(View source){
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
		.setTitle("��ѡ�б�Ի���")
		.setIcon(R.drawable.tools)
		.setMultiChoiceItems(items, new boolean[]{false, true, false, true},null);
		setPositiveButton(builder);
		setNegativeButton(builder).create().show();
		
	}
	public void customList(View source){
		AlertDialog.Builder builder  = new AlertDialog.Builder(this)
		.setTitle("�Զ����б�Ի���")
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
			.setTitle("�Զ���View�Ի���")
			.setView(loginForm)
			.setPositiveButton("��¼" , new OnClickListener()
			{
				@Override
				public void onClick(DialogInterface dialog,
						int which)
				{
					 show.setText("����˵�½");
				}
			})
			.setNegativeButton("ȡ��", new OnClickListener()
			{
				@Override
				public void onClick(DialogInterface dialog,
						int which)
				{
					show.setText("�����ȡ��");
				}
			})
			.create()
			.show();
	}
	
	 
	private Builder setPositiveButton(Builder builder){
		return builder.setPositiveButton("ȷ��", new OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				show.setText("�����ˡ�ȷ������ť");
			}
			
		});
	}
	private Builder setNegativeButton(Builder builder){
		return builder.setNegativeButton("ȡ��", new OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which){
				show.setText("�����ˡ�ȡ������ť");
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
