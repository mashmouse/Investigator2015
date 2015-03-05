/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import database.RoboTeam;
import database.match.Match;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import main.ServerRunner;

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
                interpretMessage(new Scanner(dataIn.readUTF()));
            } catch (IOException ex) {
                System.out.println("ServerToClientConnection: Lost connection with the connection from " + ip + ".");
                System.out.println("ServerToClientConnection: Terminating connection.");
                server.getConnections().remove(this);
                shouldRun = false;
                break;
            }
        }
    }
    
    public boolean sendMessage(String toSend){
        try {
            dataOut.writeUTF(toSend);
        } catch (IOException ex) {
            System.out.println("ServerToClientConnection: Unable to send information to the client.");
            return false;
        }
        return true;
    }
    
    public void interpretMessage(Scanner messageScanner){
        String command = messageScanner.next();
        if(command.equals(Server.COM_MAKE_TEAM)){
            String teamNumber = messageScanner.next();
            ServerRunner.THE_DATABASE.addTeam(new RoboTeam(teamNumber));
        }else if(command.equals(Server.COM_MAKE_MATCH)){
            Match m = new Match(messageScanner.next());
            m.addTeam(messageScanner.next());
            m.addTeam(messageScanner.next());
            m.addTeam(messageScanner.next());
            m.addTeam(messageScanner.next());
            m.addTeam(messageScanner.next());
            m.addTeam(messageScanner.next());
            ServerRunner.THE_DATABASE.addMatch(m);
        }else if(command.equals(Server.COM_ADD_ACTION)){
//            ServerRunner.THE_DATABASE.
        }else if(command.equals(Server.COM_ADD_MATCH)){
            
        }else if(command.equals(Server.PIT_BIN)){
            
        }else if(command.equals(Server.PIT_FLIP)){
            
        }else if(command.equals(Server.PIT_MISC)){
            
        }else if(command.equals(Server.PIT_NOODLE)){
            
        }else if(command.equals(Server.PIT_OMNI)){
            
        }else if(command.equals(Server.PIT_ROBOT_BALANCE)){
            
        }else if(command.equals(Server.PIT_SLOPE)){
            
        }else if(command.equals(Server.PIT_TOTE)){
            
        }else if(command.equals(Server.AUTO_CONT_SET)){
            
        }else if(command.equals(Server.AUTO_ROBOT_SET)){
            
        }else if(command.equals(Server.AUTO_S_TOTE_SET)){
            
        }else if(command.equals(Server.AUTO_TOTE_SET)){
            
        }else if(command.equals(Server.TELE_COOP_SET)){
            
        }else if(command.equals(Server.TELE_NOODLE_BIN)){
            
        }else if(command.equals(Server.TELE_PUSH_NOODLE)){
            
        }else if(command.equals(Server.TELE_S_BIN)){
            
        }else if(command.equals(Server.TELE_S_TOTE)){
            
        }
    }
    
    public boolean getShouldRun(){
        return shouldRun;
    }
    
    public void setShouldRun(boolean shouldRun){
        this.shouldRun = shouldRun;
    }
    
}
