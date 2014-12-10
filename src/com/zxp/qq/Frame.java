package com.zxp.qq;

import java.util.Arrays;

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
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
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
}
