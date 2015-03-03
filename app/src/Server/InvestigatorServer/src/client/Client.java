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
    
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private Socket socket;
    private ClientToServerConnection serverConnection;
    public Client(){
        
    }
    
    public void connectToServer(int portNumber,String ip){
        try {
            socket = new Socket(ip,portNumber);
            dataIn = new DataInputStream(socket.getInputStream());
            dataOut = new DataOutputStream(socket.getOutputStream());
            System.out.println("ClientTest: Successfully connected to the server at " + ip);
            serverConnection = new ClientToServerConnection(this,dataIn,dataOut);
            Thread serverConnectionThread = new Thread(serverConnection);
            serverConnectionThread.start();
        } catch (IOException ex) {
            System.out.println("ClientTest: Can't initialize the socket.");
        }
    }
}
