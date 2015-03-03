/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aaron Jacobson
 */
public class ClientToServerConnection implements Runnable{
    private Client client;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private boolean shouldRun;
    
    public ClientToServerConnection(Client client,DataInputStream in,DataOutputStream out){
        this.client = client;
        this.dataIn = in;
        this.dataOut = out;
    }

    @Override
    public void run() {
        shouldRun = true;
        while(shouldRun){
            try {
                interpretMessage(dataIn.readUTF());
            } catch (IOException ex) {
                System.out.println("ClientToServerConnection: Lost connection to the server.");
                shouldRun = false;
                break;
            }
        }
    }
    
    public boolean sendMessage(String toSend){
        try {
            dataOut.writeUTF(toSend);
        } catch (IOException ex) {
            System.out.println("ClientToServerConnection: Failed to send the message, maybe the connection was lost?");
            return false;
        }
        return true;
    }
    
    public void interpretMessage(String message){
        
    }
}
