package com.example.evilcards.game.view;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.net.wifi.WpsInfo;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evilcards.R;
import com.example.evilcards.game.network.MyConnectListener;
import com.example.evilcards.game.network.MyDiscoverPeersListener;
import com.example.evilcards.game.network.MyStopDiscoverPeersListener;
import com.example.evilcards.game.network.NetworkControllerImpl;
import com.example.evilcards.game.network.WifiP2pBroadcastReceiver;
import com.example.evilcards.library.model.CardImpl;
import com.example.evilcards.library.view.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {
    public static final String TAG = GameActivity.class.getName();

    //Network
    private WifiP2pBroadcastReceiver receiver;
    private NetworkControllerImpl nc;
    private List<WifiP2pDevice> peers;
    private MyConnectListener connectListener;
    private MyDiscoverPeersListener discoverPeersListener;
    private MyStopDiscoverPeersListener stopDiscoverPeersListener;

    //game.view
    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView statusText;

    //samplecards
    private List<CardImpl> sampleCards;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //network setup
        nc = new NetworkControllerImpl(this);
        peers = new ArrayList<WifiP2pDevice>();
        connectListener = new MyConnectListener(this);
        discoverPeersListener = new MyDiscoverPeersListener(this);
        stopDiscoverPeersListener = new MyStopDiscoverPeersListener(this);

        //initiate sampleCards
        sampleCards = new ArrayList<CardImpl>();
        sampleCards.add(new CardImpl("DummyKarte1", 1, false));
        sampleCards.add(new CardImpl("DummyKarte2", 2, false));
        sampleCards.add(new CardImpl("DummyKarte3", 3, false));
        sampleCards.add(new CardImpl("DummyKarte4", 4, false));
        sampleCards.add(new CardImpl("DummyKarte5", 5, false));

        //UI setup
        recyclerView = findViewById(R.id.recyclerView2);
        layoutManager = new LinearLayoutManager(this);
        myAdapter = new MyAdapter(sampleCards);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);
        statusText = findViewById(R.id.statusText);
    }

    @Override
    protected void onResume() {
        super.onResume();
        receiver = new WifiP2pBroadcastReceiver(nc.getWifiP2pManager(), nc.getChannel(), this);
        registerReceiver(receiver, nc.getIntentFilter());
        startPeerDiscovery();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
        stopPeerDiscovery();
    }

    private void startPeerDiscovery() {
        nc.getWifiP2pManager().discoverPeers(nc.getChannel(), discoverPeersListener);
    }

    private void stopPeerDiscovery() {
        nc.getWifiP2pManager().stopPeerDiscovery(nc.getChannel(), stopDiscoverPeersListener);
    }

    public void connect(final WifiP2pDevice device) {
        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = device.deviceAddress;
        config.wps.setup = WpsInfo.PBC;
        nc.getWifiP2pManager().connect(nc.getChannel(), config, connectListener);
    }

    public void showMsg(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void setStatusText(String text) {
        statusText.setText(text);
    }

    public List<WifiP2pDevice> getPeers() {
        return peers;
    }

    public void connectClients(View view) {
        for (WifiP2pDevice device : peers) {
            if (device.deviceName.contains("Player")) {
                connect(device);
            }
        }
    }
}


