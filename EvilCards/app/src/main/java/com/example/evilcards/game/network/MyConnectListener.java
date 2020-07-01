package com.example.evilcards.game.network;

import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;

import com.example.evilcards.game.view.GameActivity;

public class MyConnectListener implements WifiP2pManager.ActionListener {
    GameActivity activity;
    public MyConnectListener(GameActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onSuccess() {
        Log.d(activity.TAG, "onSuccess: Connection established");
        // WiFiDirectBroadcastReceiver notifies us. Ignore for now.

    }

    @Override
    public void onFailure(int reason) {
        switch (reason) {
            case WifiP2pManager.ERROR:
                Log.e("connect", "ERROR");
                break;
            case WifiP2pManager.P2P_UNSUPPORTED:
                Log.e("connect", "P2P_UNSUPPORTED");
                break;
            case WifiP2pManager.BUSY:
                Log.e("connect", "BUSY");
                break;
            case WifiP2pManager.NO_SERVICE_REQUESTS:
                Log.e("connect", "NO_SERVICE_REQUESTS");
                break;
        }
    }
}
