package com.example.slidingmenutext;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;



public class MainActivity extends SlidingFragmentActivity implements OnClickListener{
	private SlidingMenu slidingMenu;
	private Fragment mFrag;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setBehindContentView(R.layout.slidingmenu_left);
		
		if (savedInstanceState == null) {
			FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
			mFrag = new LeftFragment();
			t.replace(R.id.menu_frame, mFrag);
			t.commit();
		} else {
			mFrag = (Fragment)this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
		}
		
		slidingMenu=getSlidingMenu();
		slidingMenu.setMode(SlidingMenu.LEFT);// �������󻬻����һ����������Ҷ����Ի���������ֻ������
		slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);// ���ò˵����
		slidingMenu.setFadeDegree(0.35f);// ���õ��뵭���ı���
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);//��������ģʽ
		slidingMenu.setShadowDrawable(R.drawable.shadow);// ������˵���ӰͼƬ
		slidingMenu.setFadeEnabled(true);// ���û���ʱ�˵����Ƿ��뵭��
		slidingMenu.setBehindScrollScale(0.333f);// ���û���ʱ��קЧ��
		
		setContentView(R.layout.slidingmenu_center);
		
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, new MainFragment())
		.commit();
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		default:
			break;
		}
		
	}

	public void swtichFragment(Fragment newFragment) {
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, newFragment)
		.commit();
		getSlidingMenu().showContent();
	}
	
	

}
