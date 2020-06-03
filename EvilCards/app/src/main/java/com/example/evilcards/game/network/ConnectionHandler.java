package com.example.evilcards.game.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Interface providing a method to handle an input and output stream
 */
public interface ConnectionHandler {
    void handleConnection(InputStream is, OutputStream os) throws IOException;
}
