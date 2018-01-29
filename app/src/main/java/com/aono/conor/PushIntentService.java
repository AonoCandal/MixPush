package com.aono.conor;

import android.util.Log;

import com.mixpush.client.core.MixPushIntentService;
import com.mixpush.client.core.MixPushMessage;

/**
 * Created by Aono on 2018/1/29.
 */

public class PushIntentService extends MixPushIntentService {
	@Override
	public void onReceivePassThroughMessage(MixPushMessage message) {
		Log.e(TAG, "收到透传消息 -> " + message.getContent());
	}

	@Override
	public void onNotificationMessageClicked(MixPushMessage message) {
		Log.e(TAG, "通知栏消息点击 -> " + message.getContent());
	}
}