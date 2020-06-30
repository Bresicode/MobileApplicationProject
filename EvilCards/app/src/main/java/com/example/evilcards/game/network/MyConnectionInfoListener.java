package com.example.evilcards.game.network;

import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;

import com.example.evilcards.game.view.GameActivity;

public class MyConnectionInfoListener implements WifiP2pManager.ConnectionInfoListener {
    public static String TAG = MyConnectionInfoListener.class.getName();
    @Override
    public void onConnectionInfoAvailable(WifiP2pInfo wifiP2pInfo) {
        // String from WifiP2pInfo struct
        String groupOwnerAddress = wifiP2pInfo.groupOwnerAddress.getHostAddress();

        // After the group negotiation, we can determine the group owner
        // (server).
        if (wifiP2pInfo.groupFormed && wifiP2pInfo.isGroupOwner) {
            Log.d(TAG, "onConnectionInfoAvailable: start InputStream");
            // Do whatever tasks are specific to the group owner.
            // One common case is creating a group owner thread and accepting
            // incoming connections.
        } else if (wifiP2pInfo.groupFormed) {
            Log.d(TAG, "onConnectionInfoAvailable: start OutputStream");
            // The other device acts as the peer (client). In this case,
            // you'll want to create a peer thread that connects
            // to the group owner.
        }
    }
}
