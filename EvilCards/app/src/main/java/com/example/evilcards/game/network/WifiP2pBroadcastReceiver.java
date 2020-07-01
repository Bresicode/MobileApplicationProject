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
                Log.e(TAG, "WIFI_P2P_STATE_ENABLED");
            } else {
                // Wi-Fi P2P is not enabled
                Log.e(TAG, "WIFI_P2P_STATE_NOT_ENABLED");
            }
            // Check to see if Wi-Fi is enabled and notify appropriate activity
        } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {
            Log.e(TAG, "WIFI_P2P_PEERS_CHANGED_ACTION");
            // Call WifiP2pManager.requestPeers() to get a list of current peers
            if (wifiP2pManager != null) {
                wifiP2pManager.requestPeers(channel, new MyPeerListListener(activity));
            }
            if (activity.getPeers() != null) {
                for (int i = 0; i < activity.getPeers().size(); i++) {
                    if (activity.getPeers().get(i).deviceAddress.compareTo("3e:fa:43:ff:eb:60") == 0 || activity.getPeers().get(i).deviceAddress.compareTo("b2:e2:35:f3:80:a8") == 0)
                        activity.connect(activity.getPeers().get(i));
                }
            }
        } else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {
            Log.e(TAG, "WIFI_P2P_CONNECTION_CHANGED_ACTION");
            if (wifiP2pManager == null) {
                return;
            }

            NetworkInfo networkInfo = (NetworkInfo) intent
                    .getParcelableExtra(WifiP2pManager.EXTRA_NETWORK_INFO);

            if (networkInfo.isConnected()) {
                Log.d(TAG, "onReceive: networkInfo.isConnected true");
                wifiP2pManager.requestConnectionInfo(channel, new MyConnectionInfoListener(activity));
            }

        } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {
            // Respond to this device's wifi state changing
        }
    }

}

