package com.example.evilcards.game.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;

import com.example.evilcards.game.view.GameActivity;

public class WifiP2pBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = WifiP2pBroadcastReceiver.class.getName();

    private WifiP2pManager wifiP2pManager;
    private WifiP2pManager.Channel channel;
    private GameActivity activity;

    public WifiP2pBroadcastReceiver(WifiP2pManager wifiP2pManager, WifiP2pManager.Channel channel, GameActivity activity) {
        super();
        this.wifiP2pManager = wifiP2pManager;
        this.channel = channel;
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
            int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
            if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
                // Wifi P2P is enabled
                Log.d(TAG, "Wifi P2P enabled");
            } else {
                // Wi-Fi P2P is not enabled
                Log.d(TAG, "Wifi P2P not enabled");
            }
            // Check to see if Wi-Fi is enabled and notify appropriate activity
        } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {
            // Call WifiP2pManager.requestPeers() to get a list of current peers
            Log.d(TAG, "Peer found");

            if (wifiP2pManager != null) {
                wifiP2pManager.requestPeers(channel, new MyPeerListListener());
                Log.d("peers", GameActivity.peers.toString());
            }
        } else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {
            // Respond to new connection or disconnections
            Log.d(TAG, "WIFI_P2P_CONNECTION_CHANGED_ACTION");
            if (wifiP2pManager == null) {
                return;
            }

            NetworkInfo networkInfo = (NetworkInfo) intent
                    .getParcelableExtra(WifiP2pManager.EXTRA_NETWORK_INFO);

            if (networkInfo.isConnected()) {

                // We are connected with the other device, request connection
                // info to find group owner IP

                wifiP2pManager.requestConnectionInfo(channel, new MyConnectionInfoListener());
            }

        } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {
            // Respond to this device's wifi state changing
        }
    }

}
