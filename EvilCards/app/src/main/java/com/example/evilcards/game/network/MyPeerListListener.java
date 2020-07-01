package com.example.evilcards.game.network;

import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;

import com.example.evilcards.game.view.GameActivity;

public class MyPeerListListener implements WifiP2pManager.PeerListListener {
    GameActivity activity;

    public MyPeerListListener(GameActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onPeersAvailable(WifiP2pDeviceList peers) {
        activity.getPeers().clear();
        activity.getPeers().addAll(peers.getDeviceList());
        Log.d("peers", activity.getPeers().toString());

        if (activity.getPeers().size() == 0) {
            Log.d(MyPeerListListener.class.getName(), "No devices found");
            return;
        }
    }
}
