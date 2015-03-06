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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aaron Jacobson
 */
public class ClientToServerConnection implements Runnable{

    private Client client;
    private Socket socket;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private boolean shouldRun;
    
    public ClientToServerConnection(Client client,Socket socket,DataInputStream in,DataOutputStream out){
        this.client = client;
        this.socket = socket;
        this.dataIn = in;
        this.dataOut = out;
    }
    
    public boolean getShouldRun(){
        return shouldRun;
    }
    
    public void setShouldRun(boolean toSet){
        shouldRun = toSet;
    }
    @Override
    public void run() {
        shouldRun = true;
        while(shouldRun){
            try {
                interpretMessage(new Scanner(dataIn.readUTF()));
            } catch (IOException ex) {
                System.out.println("ClientToServerConnection: Lost connection to the server, shutting down connection.");
                shouldRun = false;
                break;
            }
        }
    }
    
    public void sendMessage(String toSend){
        try {
            dataOut.writeUTF(toSend);
        } catch (IOException ex) {
            System.out.println("ClientToServerConnection: Can't send information to the server, perhaps the network connection has been lost?");
        }
    }
    
    public void interpretMessage(Scanner messageScanner){
        while(messageScanner.hasNext()){
            System.out.print(messageScanner.next());
        }
        System.out.print("\n");
    }
    
}
