package com.zxp.qq;

import java.util.Arrays;

import android.R.integer;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TabHost.OnTabChangeListener;

public class Frame extends FragmentActivity{
    //TabHost常量
	private FragmentTabHost fth;
    private int imgAry[] = {R.drawable.message, R.drawable.contact, R.drawable.chat}; //Tab按钮背景图片
    private int imgPressAry[] = {R.drawable.message_on, R.drawable.contact_on, R.drawable.chat_on};//Tab按钮选中图片
    private String txtAry[] = {"消息","联系人","动态"};//Tab按钮文字
    private Class<?> clsAry[] = { Message.class, Contact.class, Chat.class};//点击Tab按钮加载的Activty Or Fragement
	
    //侧滑常量
    private int screenWidth; //屏幕宽度
    private View menu; //菜单视图
    private LinearLayout.LayoutParams menuParams;//menu参数
    private int menuWidth;//菜单最大宽度
    private View content;//内容视图
    private float xStart;//按下时X坐标
    private float xMove;//移动时X坐标
    private float xEnd;//松开时X坐标
    final int MIN_DISTANCE = 200;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame);
		
		/**
		 * TabHost效果代码
		 */
		fth = (FragmentTabHost)findViewById(android.R.id.tabhost);
		fth.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
		for (int i =0; i < 3; i++) {
		    fth.addTab(fth.newTabSpec(txtAry[i]).setIndicator(getTabView(i)), clsAry[i], null);
		}
		
		OnTabChangeListener lisener = new FragmentTabHost.OnTabChangeListener() {
			ImageView v;
			@Override
			public void onTabChanged(String arg0) {
				int vid = fth.getCurrentTab();
			
				switch (vid) {
				case 0:
					v = (ImageView)fth.getTabWidget().getChildAt(0).findViewById(R.id.image);
					v.setImageResource(imgPressAry[0]);
					v = (ImageView)fth.getTabWidget().getChildAt(1).findViewById(R.id.image);
					v.setImageResource(imgAry[1]);
					v = (ImageView)fth.getTabWidget().getChildAt(2).findViewById(R.id.image);
					v.setImageResource(imgAry[2]);
					break;
				case 1:
					v = (ImageView)fth.getTabWidget().getChildAt(0).findViewById(R.id.image);
					v.setImageResource(imgAry[0]);
					v = (ImageView)fth.getTabWidget().getChildAt(1).findViewById(R.id.image);
					v.setImageResource(imgPressAry[1]);
					v = (ImageView)fth.getTabWidget().getChildAt(2).findViewById(R.id.image);
					v.setImageResource(imgAry[2]);
					break;
				case 2:
					v = (ImageView)fth.getTabWidget().getChildAt(0).findViewById(R.id.image);
					v.setImageResource(imgAry[0]);
					v = (ImageView)fth.getTabWidget().getChildAt(1).findViewById(R.id.image);
					v.setImageResource(imgAry[1]);
					v = (ImageView)fth.getTabWidget().getChildAt(2).findViewById(R.id.image);
					v.setImageResource(imgPressAry[2]);
					break;

				default:
					break;
				}
			}
		};
		
		fth.setOnTabChangedListener(lisener);
		
		//初始化TabHost
		ImageView v = (ImageView)fth.getTabWidget().getChildAt(0).findViewById(R.id.image);
		v.setImageResource(imgPressAry[0]);
		//初始化侧滑
		DisplayMetrics dm = new DisplayMetrics();
		this.getWindowManager().getDefaultDisplay().getMetrics(dm);
		screenWidth = dm.widthPixels;
		
		content = findViewById(R.id.content);
		menu = findViewById(R.id.menu);
		
		//隐藏左边菜单
		menuParams = (LinearLayout.LayoutParams) menu.getLayoutParams();
		menuParams.leftMargin = -menuParams.width;
		menuWidth = menuParams.width;

	}
	
	// 侧滑效果代码
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN://手指按下
				xStart = event.getRawX();
				break;
			case MotionEvent.ACTION_MOVE://手指移动, 如果和初始值差为200就滑出
				xMove = event.getRawX();
				int distance =(int)(xMove - xStart);
				if (distance > menuWidth) distance = menuWidth;
				if (distance < -menuWidth) distance = -menuWidth;
				menuParams.leftMargin = distance;
				//滑动超过一半距离时 
				if (Math.abs(distance) > menuWidth/2) {
				    menu.setLayoutParams(menuParams);
				}
				break;
			case MotionEvent.ACTION_UP://手指松开
				
				break;

			default:
				break;
		}
		
		return false;
	}
	
	//生成Tab按钮
	private View getTabView(int index) {
		View view = LayoutInflater.from(this).inflate(R.layout.tabhost_item, null);
		ImageView image = (ImageView)view.findViewById(R.id.image);
		image.setImageResource(imgAry[index]);
		
		TextView txt = (TextView)view.findViewById(R.id.title);
		txt.setText(txtAry[index]);
		return view;
	}
	
	//显示菜单
	private void toggleMenu(Boolean tag) {
		if (tag == true) {
			
		} else {
			
		}
	}

}
