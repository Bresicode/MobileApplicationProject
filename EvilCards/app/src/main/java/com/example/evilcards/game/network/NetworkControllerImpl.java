package com.example.evilcards.game.network;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;

import static android.os.Looper.getMainLooper;

public class NetworkControllerImpl implements NetworkController {
    WifiManager wifiManager;
    WifiP2pManager wifiP2pManager;
    WifiP2pManager.Channel channel;
    IntentFilter intentFilter;


    public NetworkControllerImpl(Context context) {
        wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        wifiP2pManager = (WifiP2pManager) context.getSystemService(Context.WIFI_P2P_SERVICE);
        channel = wifiP2pManager.initialize(context, getMainLooper(), null);
        intentFilter = new IntentFilter();
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
    }
    @Override
    public WifiManager getWifiManager() {
        return wifiManager;
    }
    @Override
    public WifiP2pManager getWifiP2pManager() {
        return wifiP2pManager;
    }
    @Override
    public WifiP2pManager.Channel getChannel() {
        return channel;
    }
    @Override
    public IntentFilter getIntentFilter() {
        return intentFilter;
    }


}
