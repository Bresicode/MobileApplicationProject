package com.example.evilcards.game.network;

import android.net.wifi.WpsInfo;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;

import static com.example.evilcards.game.view.GameActivity.nc;
import static com.example.evilcards.game.view.GameActivity.peers;

public class MyDiscoverPeersListener implements WifiP2pManager.ActionListener {
    public static String TAG = MyDiscoverPeersListener.class.getName();

    @Override
    public void onSuccess() {
        if (peers != null) {
            for (WifiP2pDevice device : peers) {
                WifiP2pConfig config = new WifiP2pConfig();
                config.deviceAddress = device.deviceAddress;
                config.wps.setup = WpsInfo.PBC;
                nc.getWifiP2pManager().connect(nc.getChannel(), config, new MyConnectListener());
            }
        }
    }

    @Override
    public void onFailure(int reason) {

    }
}
