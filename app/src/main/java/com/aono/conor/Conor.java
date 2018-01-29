package com.aono.conor;

import android.app.Application;

import com.mixpush.client.core.MixPushClient;
import com.mixpush.client.core.MixPushManager;
import com.mixpush.client.getui.GeTuiManager;
import com.mixpush.client.mipush.MiPushManager;

import java.util.Map;

/**
 * Created by Aono on 2018/1/29.
 */

public class Conor extends Application{
	public static final String MIPUSH_APP_ID = "<MIPUSH_APP_ID>";
	public static final String MIPUSH_APP_KEY = "<MIPUSH_APP_KEY>";

	@Override
	public void onCreate() {
		super.onCreate();
		initPush();
	}
	private void initPush() {
		MixPushClient.addPushManager(new MiPushManager(MIPUSH_APP_ID, MIPUSH_APP_KEY));
		MixPushClient.addPushManager(new GeTuiManager());
		MixPushClient.setPushIntentService(PushIntentService.class);
		MixPushClient.setSelector(new MixPushClient.Selector() {
			@Override
			public String select(Map<String, MixPushManager> pushAdapterMap, String brand) {
				// return GeTuiManager.NAME;
				//底层已经做了小米推送、魅族推送、个推判断，也可以按照自己的需求来选择推送
				return super.select(pushAdapterMap, brand);
			}
		});
		// 配置接收推送消息的服务类
		MixPushClient.setPushIntentService(PushIntentService.class);
		// 注册推送
		MixPushClient.registerPush(this);
		// 绑定别名，一般是填写用户的ID，便于定向推送
		MixPushClient.setAlias(this, getUserId());
		// 设置标签，用于对用户进行划分
		MixPushClient.setTags(this,"广东");
	}
	private String getUserId(){
		return "103";
	}
}
