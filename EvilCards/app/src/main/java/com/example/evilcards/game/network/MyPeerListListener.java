package com.example.evilcards.game.network;

import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;

import com.example.evilcards.game.view.GameActivity;

public class MyPeerListListener implements WifiP2pManager.PeerListListener {

    @Override
        public void onPeersAvailable(WifiP2pDeviceList peers) {
            GameActivity.peers.clear();
            GameActivity.peers.addAll(peers.getDeviceList());
        }

}
