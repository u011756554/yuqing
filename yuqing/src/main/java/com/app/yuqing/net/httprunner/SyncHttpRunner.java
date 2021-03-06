package com.app.yuqing.net.httprunner;

import okhttp3.FormBody;
import okhttp3.RequestBody;
import android.util.Log;

import com.app.yuqing.AppContext;
import com.app.yuqing.net.Event;
import com.app.yuqing.net.OKHttpUtil;
import com.app.yuqing.net.URLUtils;
import com.app.yuqing.net.bean.BaseRongYunResponseBean;
import com.app.yuqing.utils.CommonUtils;

public class SyncHttpRunner extends HttpRunner{

	@Override
	public void onEventRun(Event event) throws Exception {
		// TODO Auto-generated method stub
		String groupId = (String) event.getParamAtIndex(0);
		String userId = (String) event.getParamAtIndex(1);
		
        RequestBody body=new FormBody.Builder()
        .add("groupId",groupId)
        .add("userId",userId).build();
        
        String result = OKHttpUtil.getInstance().request(URLUtils.SYNC, body, "post",false);
		
		Log.i(AppContext.LOG_NET, result);
		System.out.println("result : "+result);
		if (CommonUtils.isEmpty(result)) {
			event.setSuccess(false);
			event.setFailException(new Exception("网络错误"));
			return;
		}
		
		
		if ("false".equals(result)) {
			event.setSuccess(false);
			event.setFailException(new Exception("创建失败"));
		} else {
			BaseRongYunResponseBean bean = gson.fromJson(result, BaseRongYunResponseBean.class);
			if (bean != null) {
				if (checkRongYun(bean)) {
					event.setSuccess(true);
					event.addReturnParam(bean);
					return;
				}
			}
			event.setSuccess(false);
		}
	}

}
