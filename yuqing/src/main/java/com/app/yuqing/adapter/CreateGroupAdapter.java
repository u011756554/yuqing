package com.app.yuqing.adapter;

import java.util.List;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.yuqing.R;
import com.app.yuqing.bean.ContactUser;
import com.app.yuqing.utils.ImageLoaderUtil;
import com.app.yuqing.view.RoundImageView;

public class CreateGroupAdapter extends SetBaseAdapter<ContactUser>{

	public CreateGroupAdapter(Context context, List<ContactUser> list) {
		super(context, list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_creategroup, null);
			holder = new ViewHolder();
			holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
			holder.ivHead = (RoundImageView) convertView.findViewById(R.id.iv_head);
			holder.ivSelect = (ImageView) convertView.findViewById(R.id.iv_select);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		ContactUser bean = mList.get(position);
		holder.tvName.setText(bean.getName());
		if (!TextUtils.isEmpty(bean.getPhoto())) {
			ImageLoaderUtil.display(bean.getPhoto(), holder.ivHead);
		}
		if (bean.isSelected()) {
			holder.ivSelect.setSelected(true);
		} else {
			holder.ivSelect.setSelected(false);
		}
		return convertView;
	}

	private class ViewHolder {
		private TextView tvName;
		private RoundImageView ivHead;
		private ImageView ivSelect;
	}
}
