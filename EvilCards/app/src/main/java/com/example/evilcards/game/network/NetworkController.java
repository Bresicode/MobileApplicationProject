package com.example.evilcards.game.network;

import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;

/**
 * Interface providing getters for wifi/wifi p2p managers wifi p2p channel and an intentFilter
 */
public interface NetworkController {

    /**
     * gets a wifi p2p manager
     * @return WifiP2pManager wifiP2pManager
     */
    WifiP2pManager getWifiP2pManager();

    /**
     * gets a WifiP2pManager.Channel
     * @return WifiP2pManagerChannel channel
     */
    WifiP2pManager.Channel getChannel();

    /**
     * gets an IntentFilter
     * @return IntentFilter intentFilter
     */
    IntentFilter getIntentFilter();
}
