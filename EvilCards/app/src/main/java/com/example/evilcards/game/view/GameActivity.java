package com.example.evilcards.game.view;

import android.net.wifi.WpsInfo;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Bundle;
import android.util.Log;
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

    //game.view
    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    //samplecards
    private List<CardImpl> sampleCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //network setup
        nc = new NetworkControllerImpl(this);
        peers = new ArrayList<WifiP2pDevice>();

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        receiver = new WifiP2pBroadcastReceiver(nc.getWifiP2pManager(), nc.getChannel(), this);
        registerReceiver(receiver, nc.getIntentFilter());
        startPeerDiscovery();
    }

    /* unregister the broadcast receiver */
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
        stopPeerDiscovery();
        nc.getWifiP2pManager().cancelConnect(nc.getChannel(), null);
    }

    private void startPeerDiscovery() {
        nc.getWifiP2pManager().discoverPeers(nc.getChannel(), new MyDiscoverPeersListener(this));
    }

    private void stopPeerDiscovery() {
        nc.getWifiP2pManager().stopPeerDiscovery(nc.getChannel(), new MyStopDiscoverPeersListener(this));
    }

    public void connect(final WifiP2pDevice device) {
        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = device.deviceAddress;
        config.wps.setup = WpsInfo.PBC;
        Log.d("deviceAddress connect", String.valueOf(device.deviceAddress));
        nc.getWifiP2pManager().connect(nc.getChannel(), config, new MyConnectListener(this));
    }

    public void showMsg(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public NetworkControllerImpl getNc() {
        return nc;
    }

    public List<WifiP2pDevice> getPeers() {
        return peers;
    }
}


