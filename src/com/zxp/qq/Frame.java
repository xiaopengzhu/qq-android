package com.zxp.qq;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Frame extends FragmentActivity{
    private FragmentTabHost fth;
    private int imgAry[] = {R.drawable.contact, R.drawable.message, R.drawable.chat};
    private String txtAry[] = {"通讯", "消息", "聊天"};
    private Class<?> clsAry[] = { Contact.class, Message.class, Chat.class};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame);
		
		fth = (FragmentTabHost)findViewById(android.R.id.tabhost);
		fth.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
		for (int i =0; i < 3; i++) {
		    fth.addTab(fth.newTabSpec(txtAry[i]).setIndicator(getTabView(i)), clsAry[i], null);
		}
	}
	
	private View getTabView(int index) {
		View view = LayoutInflater.from(this).inflate(R.layout.tabhost_item, null);
		ImageView image = (ImageView)view.findViewById(R.id.image);
		image.setImageResource(imgAry[index]);
		
		TextView txt = (TextView)view.findViewById(R.id.title);
		txt.setText(txtAry[index]);
		return view;
	}

}
