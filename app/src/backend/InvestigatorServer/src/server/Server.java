/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Aaron Jacobson
 */
public class Server {
    public static final int portNumber = 41801;
    
    private ServerSocket serverSocket;
    private Socket socket;
    private ArrayList<ServerToClientConnection> clientConnections;
    
    public Server(){
        clientConnections = new ArrayList<>();
    }
    
    public void startServer(){
        
    }
    
    public void waitForClientConnections(){
        
    }
    
    public void shutDownConnections(){
        
    }
    
    public ArrayList<ServerToClientConnection> getConnections(){
        return clientConnections;
    }
}
