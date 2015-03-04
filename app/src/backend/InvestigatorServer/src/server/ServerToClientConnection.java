/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

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
public class ServerToClientConnection implements Runnable{

    private Server server;
    private Socket socket;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private boolean shouldRun;
    private String ip;
    
    public ServerToClientConnection(Server server,Socket socket,DataInputStream dataIn,DataOutputStream dataOut){
        this.server = server;
        this.socket = socket;
        this.dataIn = dataIn;
        this.dataOut = dataOut;
        ip = socket.getInetAddress().toString();
    }
    @Override
    public void run() {
        shouldRun = true;
        while(shouldRun){
            try {
                interpretMessage(dataIn.readUTF());
            } catch (IOException ex) {
                System.out.println("ServerToClientConnection: Lost connection with the connection from " + ip + ".");
                System.out.println("ServerToClientConnection: Terminating connection.");
                server.getConnections().remove(this);
                shouldRun = false;
                break;
            }
        }
    }
    
    public void interpretMessage(String message){
        
    }
    
    public boolean getShouldRun(){
        return shouldRun;
    }
    
    public void setShouldRun(boolean shouldRun){
        this.shouldRun = shouldRun;
    }
    
}
