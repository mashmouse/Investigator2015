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
    public static final int PORT_NUMBER = 41801;
    public static final String COM_MAKE_TEAM = "COM_MAKE_TEAM ";
    public static final String COM_ADD_MATCH = "COM_ADD_MATCH ";
    public static final String COM_MAKE_MATCH = "COM_MAKE_MATCH ";
    public static final String COM_ADD_ACTION = "COM_ADD_ACTION ";
    
    public static final String PIT = "PIT_";
    public static final String PIT_NOODLE = "NOODLE ";
    public static final String PIT_BIN = "BIN";
    public static final String PIT_TOTE = "TOTE ";
    public static final String PIT_SLOPE = "SLOPE ";
    public static final String PIT_FLIP = "FLIP ";
    public static final String PIT_OMNI = "OMNI ";
    public static final String PIT_ROBOT_BALANCE = "BALANCE ";
    public static final String PIT_STACK = "STACK ";
    public static final String PIT_MISC = "MISC ";
    
    public static final String AUTO_ROBOT_SET = "AUTO_ROBOT_SET ";
    public static final String AUTO_TOTE_SET = "AUTO_TOTE_SET ";
    public static final String AUTO_CONT_SET = "AUTO_CONT_SET ";
    public static final String AUTO_S_TOTE_SET = "AUTO_S_TOTE_SET ";
    
    public static final String TELE_S_TOTE = "TELE_STACKED_TOTE ";
    public static final String TELE_S_BIN = "TELE_STACKED_BIN ";
    public static final String TELE_NOODLE_BIN = "TELE_NOODLE_IN_BIN ";
    public static final String TELE_PUSH_NOODLE = "TELE_PUSHED_NOODLES ";
    public static final String TELE_COOP_SET = "TELE_COOP_SET ";
    
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
