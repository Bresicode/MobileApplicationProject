package com.example.evilcards.game.network;

import android.net.wifi.p2p.WifiP2pManager;

import com.example.evilcards.game.view.GameActivity;

public class MyConnectListener implements WifiP2pManager.ActionListener {
    GameActivity activity;

    public MyConnectListener(GameActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onSuccess() {
        activity.showMsg("Connect success!");
        activity.setStatusText("connection to peers");
        // WiFiDirectBroadcastReceiver notifies us. Ignore for now.

    }

    @Override
    public void onFailure(int reason) {
        activity.showMsg("Connect failed!");
    }
}
