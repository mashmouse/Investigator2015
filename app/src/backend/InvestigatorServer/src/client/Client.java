/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aaron Jacobson
 */
public class Client {
    
    private Socket socket;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    public ClientToServerConnection serverConnection;
    public Client(){
        
    }
    
    public void connectToServer(String ip,int portNumber){
        try {
            socket = new Socket(ip,portNumber);
            dataIn = new DataInputStream(socket.getInputStream());
            dataOut = new DataOutputStream(socket.getOutputStream());
            serverConnection = new ClientToServerConnection(this,socket,dataIn,dataOut);
            Thread serverConnectionThread = new Thread(serverConnection);
            serverConnectionThread.start();
            System.out.println("Client: Successfully connected to the server.");
        } catch (IOException ex) {
            System.out.println("Client: Unable to connect to the server.");
        }
    }
}
