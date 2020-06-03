package com.example.evilcards.game.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.evilcards.R;
import com.example.evilcards.game.network.DiscoverPeersListener;
import com.example.evilcards.game.network.NetworkControllerImpl;
import com.example.evilcards.game.network.WifiP2pBroadcastReceiver;
import com.example.evilcards.library.control.LibraryAccessorImpl;

public class GameActivity extends AppCompatActivity {
    public static final String TAG = "GameActivity";


    LibraryAccessorImpl libraryAccessorImpl;
    private WifiP2pBroadcastReceiver receiver;
    private NetworkControllerImpl nc;

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
    }

    /* unregister the broadcast receiver */
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public void wifi(View view) {
        if (!nc.getWifiManager().isWifiEnabled()) {
            nc.getWifiManager().setWifiEnabled(true);
        }
        nc.getWifiP2pManager().discoverPeers(nc.getChannel(), new DiscoverPeersListener());
    }

    public void connect(View view) {

    }

}

