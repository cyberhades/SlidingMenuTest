package com.example.slidingmenutext;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Fragment ��ģ���ࣨ�����õ�������е�ģ��ģʽ��ʹ��������Բ��ı�һ���㷨�Ľṹ�������¶�����㷨��ĳЩ�ض����裩
 * @author yixiang
 *
 */
public abstract class BaseFragment extends Fragment implements OnClickListener{
	public View mView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		container.removeAllViews();
		try {
			onInitView(inflater, container, savedInstanceState);
			setTopLeftButton(R.drawable.menu_icon);
		} catch (OutOfMemoryError e) {
			System.gc();
			System.runFinalization();
			return super.onCreateView(inflater, container, savedInstanceState);
		}
	
		return mView;
	}
	
	//�������ʵ�ֵĸ÷���
	public abstract void onInitView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState);
	
	/**
	 * ���ñ���
	 * @param title
	 */
	public void setTitle(String title) {
		TextView titleView = (TextView) mView.findViewById(R.id.title);
		titleView.setText(title);
	}
	
	/**
	 * ���ö�����ť
	 * @param iconId
	 */
	public void setTopLeftButton(int iconId) {
		ImageButton button = (ImageButton) mView.findViewById(R.id.left_button);
		button.setImageResource(iconId);
		button.setOnClickListener(this);
	}
	
	
	/**
	 *  ��ť����¼�
	 */
	public void leftButtonOnClick() {
		MainActivity m=(MainActivity) getActivity();
		m.toggle();
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.left_button:
			leftButtonOnClick();
			break;
		default:
			break;
		}
	}
	

}
