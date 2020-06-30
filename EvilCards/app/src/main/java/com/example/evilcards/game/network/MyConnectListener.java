package com.example.evilcards.game.network;

import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;

public class MyConnectListener implements WifiP2pManager.ActionListener {
    public static String TAG = MyConnectListener.class.getName();

    @Override
    public void onSuccess() {
        // WiFiDirectBroadcastReceiver notifies us. Ignore for now.

    }

    @Override
    public void onFailure(int reason) {
        Log.e(TAG, "onFailure: ");
    }
}
