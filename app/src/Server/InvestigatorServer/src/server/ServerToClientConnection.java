/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import databaseManagement.database.RoboTeam;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import main.ServerRunner;

/**
 *
 * @author Aaron Jacobson
 */
public class ServerToClientConnection implements Runnable{

    private Server server;
    private ArrayList<ServerToClientConnection> clientConnections;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private boolean shouldRun;
    public ServerToClientConnection(Server server,ArrayList<ServerToClientConnection> clientConnections,DataInputStream in,DataOutputStream out){
        this.server = server;
        this.clientConnections = clientConnections;
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
                System.out.println("ServerToClientConnection: Lost connection with the client.");
                shouldRun = false;
                break;
            }
        }
    }
    
    public void interpretMessage(String message){
        Scanner messageScanner = new Scanner(message);
        String command = messageScanner.next();
        if(command.equals(Server.CREATE_TEAM)){
            System.out.println("ServerToClientConnection: Creating a team.");
            ServerRunner.THE_DATABASE.add(new RoboTeam(messageScanner.next()));
        }
    }
}
