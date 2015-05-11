package com.example.tpapp.s2;

import java.util.Calendar;

import com.example.tpapp.R;
import com.example.tpapp.R.id;
import com.example.tpapp.R.layout;
import com.example.tpapp.R.menu;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TabActivity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TimePicker;

public class DateDialogTest extends Activity {
	Button dateBn, timeBn;
	  EditText show;
	  Calendar c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.date_dialog_test);
		dateBn = (Button) findViewById(R.id.dateBn);
		timeBn = (Button) findViewById(R.id.timeBn);
		show = (EditText) findViewById(R.id.showOfDateDialog);
		c = Calendar.getInstance();
	 
		 
		
		dateBn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Calendar c = Calendar.getInstance();
				new DatePickerDialog(DateDialogTest.this,
						new DatePickerDialog.OnDateSetListener() {

							@Override
							public void onDateSet(DatePicker view, int year,
									int monthOfYear, int dayOfMonth) {
								// TODO Auto-generated method stub

								show.setText("您选择了：" + year + "年"
										+ (monthOfYear + 1) + "月" + dayOfMonth
										+ "日");

							}
						}, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
								.get(Calendar.DAY_OF_MONTH)).show();
				;
			}

		});
		timeBn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new TimePickerDialog(DateDialogTest.this,
						new TimePickerDialog.OnTimeSetListener() {

							@Override
							public void onTimeSet(TimePicker view,
									int hourOfDay, int minute) {
								// TODO Auto-generated method stub
								show.setText("您选择了：" + hourOfDay + "时" + minute
										+ "分");

							}
						}, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE),
						true).show();
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.date_dialog_test, menu);
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
