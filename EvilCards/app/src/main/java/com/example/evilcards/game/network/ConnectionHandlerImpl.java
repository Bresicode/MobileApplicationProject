package com.example.evilcards.game.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ConnectionHandlerImpl implements ConnectionHandler{
    private final String name;
    private HashMap<Integer, InputReader> activeReader = new HashMap<>();
    private HashMap<Integer, OutputStream> activeOutputStreams = new HashMap<>();

    private int nextReadNumber = 0;
    private List<String> usedIDs = new ArrayList<>();
    public ConnectionHandlerImpl(String name) {
        this.name = name;
    }

    @Override
    public void handleConnection(InputStream is, OutputStream os) throws IOException {
        int id = nextReadNumber++;
        this.activeReader.put(id, new InputReader(id, is));
        this.activeOutputStreams.put(id, os);
    }
    public void sendGossipMessage(String message) {
        Collection<OutputStream> openConnections = this.activeOutputStreams.values();
        if(openConnections.size() > 0) {
            // create id - very very simple
            long time = System.currentTimeMillis();
            int random = new Random().nextInt();

            StringBuilder idBuilder = new StringBuilder();
            idBuilder.append(time);
            idBuilder.append(random);

            String id = idBuilder.toString();

            // remember
            this.usedIDs.add(id);

            // create pdu
            Data data = new Data(id, message);

            // send to all others
            for(OutputStream os : openConnections) {
                try {
                    data.writeData(os);
                } catch (IOException e) {
                    // should remove output stream (TODO)
                }
            }
        }
    }



    private synchronized void handleData(Data data, InputReader inputReader) {
        // got pdu
        // already read this pdu?

        if(this.usedIDs.contains(data.id)) {
            System.out.println("Log: id already exists: " + data.id);
        } else {
            // now message do gossip
            System.out.println(this.name + ": got message: " + data);
            List<Integer> deadIDs = new ArrayList<>();
            for(Integer id : activeOutputStreams.keySet()) {
                if(inputReader.id != id) {
                    // don't send back to sender but anybody else
                    try {
                        data.writeData(activeOutputStreams.get(id));
                    } catch (IOException e) {
                        // problems with this output stream - remember
                        deadIDs.add(id);
                    }
                }
            }

            // remove dead connections
            for(Integer id : deadIDs) {
                this.activeOutputStreams.remove(id);
                InputReader reader = this.activeReader.remove(id);
                reader.kill();
            }
        }
    }

    private synchronized void inputStreamDead(int id) {
        // kill and remove output stream as well
        OutputStream os = this.activeOutputStreams.remove(id);

        try {
            os.close();
        } catch (IOException e) {
            // did my best
        }
    }

    private class InputReader extends Thread {
        private final InputStream is;
        private final int id;

        InputReader(int id, InputStream is) {
            this.id = id;
            this.is = is;
            this.start(); // start yourself
        }

        public void run() {
            boolean again = true;
            while (again) {
                try {
                    // read pdu
                    Data data = new Data(is);
                    // handle pdu
                    ConnectionHandlerImpl.this.handleData(data, this);
                } catch (IOException e) {
                    // cannot recover from that.
                    ConnectionHandlerImpl.this.inputStreamDead(id);
                    again = false; // end thread
                }
            }
        }

        public void kill() {
            try {
                this.is.close();
            } catch (IOException e) {
                // cannot do anything here - did my best
            }
        }
    }

    private class Data {
        private String id;
        private String message;

        Data(String id, String message) {
            this.id = id;
            this.message = message;
        }

        Data(InputStream is) throws IOException {
            DataInputStream dis = new DataInputStream(is);
            this.id = dis.readUTF();
            this.message = dis.readUTF();
        }

        void writeData(OutputStream os) throws IOException {
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(id);
            dos.writeUTF(message);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("id: ");
            sb.append(this.id);
            sb.append(" | message: ");
            sb.append(this.message);
            return sb.toString();
        }
    }
}
