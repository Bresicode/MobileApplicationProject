package com.example.evilcards.game.network;

import android.net.wifi.p2p.WifiP2pManager;

import com.example.evilcards.game.view.GameActivity;

public class MyDiscoverPeersListener implements WifiP2pManager.ActionListener {
        GameActivity activity;
    public MyDiscoverPeersListener(GameActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onSuccess() {
        activity.setStatusText("discovering peers");
    }

    @Override
    public void onFailure(int reason) {
    }
}
