package com.example.evilcards.game.view;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.evilcards.R;
import com.example.evilcards.game.network.NetworkControllerImpl;
import com.example.evilcards.game.network.WifiP2pBroadcastReceiver;
import com.example.evilcards.library.control.LibraryAccessorImpl;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {
    public static final String TAG = GameActivity.class.getName();

    private TextView statusText;
    private LibraryAccessorImpl libraryAccessorImpl;
    private WifiP2pBroadcastReceiver receiver;

    public static NetworkControllerImpl nc;
    public static List<WifiP2pDevice> peers = new ArrayList<WifiP2pDevice>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        nc = new NetworkControllerImpl(this);
        libraryAccessorImpl = new LibraryAccessorImpl(this);
        receiver = new WifiP2pBroadcastReceiver(nc.getWifiP2pManager(), nc.getChannel(), this);

    }

    /* register the broadcast receiver with the intent values to be matched */
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, nc.getIntentFilter());
        discoverPeers();
    }

    /* unregister the broadcast receiver */
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
        stopPeerDiscovery();
    }

    public void showMsg(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void discoverPeers() {
        nc.getWifiP2pManager().discoverPeers(nc.getChannel(), new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess() {
                Log.d("discover", "onSuccess");
            }

            @Override
            public void onFailure(int reason) {

            }
        });
    }

    private void stopPeerDiscovery() {
        nc.getWifiP2pManager().stopPeerDiscovery(nc.getChannel(), new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess() {
                showMsg("stopPeerDiscovery: onSuccess");
                Log.e("stopPeerDiscovery", "onSuccess");
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
        });
    }

    public void wifi(View view) {

    }

    public void connect(View view) {

    }

}

