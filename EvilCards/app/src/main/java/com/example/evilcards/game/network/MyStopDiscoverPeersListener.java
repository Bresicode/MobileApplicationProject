package com.example.evilcards.game.network;

import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;

import com.example.evilcards.game.view.GameActivity;

public class MyStopDiscoverPeersListener implements WifiP2pManager.ActionListener {
    GameActivity activity;
    public MyStopDiscoverPeersListener(GameActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onSuccess() {
        activity.showMsg("stopPeerDiscovery: onSuccess");
    }

    @Override
    public void onFailure(int reason) {
        switch (reason) {
            case WifiP2pManager.ERROR:
                Log.e("stopPeerDiscovery", "ERROR");
                break;
            case WifiP2pManager.P2P_UNSUPPORTED:
                Log.e("stopPeerDiscovery", "P2P_UNSUPPORTED");
                break;
            case WifiP2pManager.BUSY:
                Log.e("stopPeerDiscovery", "BUSY");
                break;
            case WifiP2pManager.NO_SERVICE_REQUESTS:
                Log.e("stopPeerDiscovery", "NO_SERVICE_REQUESTS");
                break;
        }
    }
}
