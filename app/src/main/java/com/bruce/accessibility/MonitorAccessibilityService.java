package com.bruce.accessibility;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;

import com.orhanobut.logger.Logger;

/**
 * Created by Bruce on 2017/3/9.
 */
public class MonitorAccessibilityService extends AccessibilityService {

    private static MonitorAccessibilityService sInstance;

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Logger.i(event.toString());
    }

    @Override
    public void onInterrupt() {

    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        sInstance = this;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        sInstance = null;
        return super.onUnbind(intent);
    }

    public static MonitorAccessibilityService getInstance() {
        return sInstance;
    }
}
