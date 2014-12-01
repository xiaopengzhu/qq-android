package com.zxp.qq;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class Welcome extends Activity{
    //页面容器
	private ViewPager viewPager;
    //指示
	private ImageView imageView1, imageView2, imageView3;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		viewPager = (ViewPager)findViewById(R.id.viewpager);
		
		imageView1 = (ImageView)findViewById(R.id.page1);
		imageView2 = (ImageView)findViewById(R.id.page2);
		imageView3 = (ImageView)findViewById(R.id.page3);
		
		LayoutInflater li = LayoutInflater.from(this);
		View view1 = li.inflate(R.layout.viewpager_1, null);
		View view2 = li.inflate(R.layout.viewpager_2, null);
		View view3 = li.inflate(R.layout.viewpager_3, null);
		
		final ArrayList<View> views = new ArrayList<View>();
		views.add(view1);
		views.add(view2);
		views.add(view3);

		viewPager.setAdapter(new PagerAdapter() {
			
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;
			}
			
			@Override
			public Object instantiateItem(View container, int position) {
				// TODO Auto-generated method stub
				((ViewPager)container).addView(views.get(position));
				return views.get(position);
			}

			@Override
			public void destroyItem(View container, int position, Object object) {
				// TODO Auto-generated method stub
				((ViewPager)container).removeView(views.get(position));
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return views.size();
			}
		});
		
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				switch (arg0) {
				case 0:
					imageView1.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
					imageView2.setImageDrawable(getResources().getDrawable(R.drawable.page));
					break;
				case 1:
					imageView1.setImageDrawable(getResources().getDrawable(R.drawable.page));
					imageView2.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
					imageView3.setImageDrawable(getResources().getDrawable(R.drawable.page));
					break;
				case 2:
					imageView2.setImageDrawable(getResources().getDrawable(R.drawable.page));
					imageView3.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
					break;

				default:
					break;
				}
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void start(View v) {
		Intent intent = new Intent(Welcome.this, Frame.class);
		startActivity(intent);
		this.finish();
	}

}
