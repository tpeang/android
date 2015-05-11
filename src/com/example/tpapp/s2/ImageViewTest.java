package com.example.tpapp.s2;

import com.example.tpapp.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
 

public class ImageViewTest extends Activity {
	
	Button minus, plus, next;
	ImageView image1, image2;
	int[] images = new int[]{
			R.drawable.lijiang,
			R.drawable.qiao,
			R.drawable.shuangta,
			R.drawable.xiangbi
	};
	int currentImg = 2;
	private int alpha = 255;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_view);
		minus = (Button)findViewById(R.id.minus);
		plus = (Button)findViewById(R.id.plus);
		next = (Button)findViewById(R.id.next);
		image1  = (ImageView)findViewById(R.id.image1);
		image2 = (ImageView)findViewById(R.id.image2);
		next.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				image1.setImageResource(images[++currentImg%images.length]);
				
			}
			
		});
		OnClickListener listener = new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v == plus){
					alpha += 20;
				}
				if(v == minus){
					alpha -= 20;
				}
				if(alpha >255){
					alpha=255;
				}
				if(alpha < 0){
					alpha = 0;
				}
				image1.setAlpha(alpha);
				
			}
			
		};
		minus.setOnClickListener(listener);
		plus.setOnClickListener(listener);
		image1.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				BitmapDrawable bitmapDrawable = (BitmapDrawable)image1.getDrawable();
				Bitmap bitmap = bitmapDrawable.getBitmap();
				double scale = bitmap.getWidth()/320;
				int x = (int) (event.getX()*scale);
				int y = (int ) (event.getY()*scale);
				if(x+120>bitmap.getWidth()){
					x  = bitmap.getWidth()-120;
				}
				if(y+120> bitmap.getHeight()){
					y  = bitmap.getHeight()-120;
				}
				image2.setImageBitmap(bitmap.createBitmap(bitmap,x, y, 120, 120));
				image2.setAlpha(alpha);
				return false;
			}
			
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image_view, menu);
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
