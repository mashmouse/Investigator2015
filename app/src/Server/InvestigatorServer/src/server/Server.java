/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Aaron Jacobson
 */
public class Server {
    
    private Socket socket;
    private ServerSocket serverSocket;
    private ArrayList<ServerToClientConnection> clientConnections;
    private boolean waitForClientConnections;
    public Server(){
        clientConnections = new ArrayList<>();
}
    
    public void startServer(int portNumber){
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException ex) {
            System.out.println("Server: Can't initialize the ServerSocket.");
        }
    }
    
    public void waitForClientConnections(){
        waitForClientConnections = true;
        while(waitForClientConnections){
            try {
                socket = serverSocket.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                ServerToClientConnection clientConnection = new ServerToClientConnection(this,clientConnections,in,out);
                Thread clientConnectionThread = new Thread(clientConnection);
                clientConnectionThread.start();
            } catch (IOException ex) {
                System.out.println("Server: Can't initialize the socket.");
            }
        }
    }
    
    public ArrayList<ServerToClientConnection> getClientConnections(){
        return clientConnections;
    }
}
