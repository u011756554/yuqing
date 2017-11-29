package com.app.yuqing.view;

import com.app.yuqing.R;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NoRightDialog extends BaseDialog{

	public NoRightDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	private TextView tvConfirm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_noright);
		initView();
	}
	
	private void initView() {
		addClickCancel();
		tvConfirm = (TextView) findViewById(R.id.tv_confirm);
		tvConfirm.setOnClickListener(new android.view.View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});
	}
}
