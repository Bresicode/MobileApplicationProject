package com.example.evilcards.game.network;

import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;

import com.example.evilcards.game.view.GameActivity;

public class MyConnectionInfoListener implements WifiP2pManager.ConnectionInfoListener {
    GameActivity activity;
    public MyConnectionInfoListener(GameActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onConnectionInfoAvailable(WifiP2pInfo wifiP2pInfo) {
        String groupOwnerAddress = wifiP2pInfo.groupOwnerAddress.getHostAddress();
        if (wifiP2pInfo.groupFormed && wifiP2pInfo.isGroupOwner) {
            Log.d(activity.TAG, "onConnectionInfoAvailable: Host action required");

        } else if (wifiP2pInfo.groupFormed) {
            Log.d(activity.TAG, "onConnectionInfoAvailable: Client action required");
        }
    }
}
