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

    /**
     * The port number that will be used to communicate with the clients. They must
     * also be using this port number.
     */
    public static final int PORT_NUMBER = 41801;

    /**
     * The command for making a team.
     * FORMAT: COM_MAKE_TEAM 4180
     */
    public static final String COM_MAKE_TEAM = "COM_MAKE_TEAM ";

    /**
     * The command for adding a match to a team
     * FORMAT: COM_ADD_MATCH 4180
     */
    public static final String COM_ADD_MATCH = "COM_ADD_MATCH ";

    /**
     * The command for creating a match, with the teams that were in it
     * FORMAT: COM_MAKE_MATCH 4180 948 4911 1318 4030 27
     */
    public static final String COM_MAKE_MATCH = "COM_MAKE_MATCH ";

    /**
     * The command for adding an action to a robot when you have the team and match numbers
     * FORMAT: COM_ADD_ACTION 4180 GLA_23 ACTION_TYPE AWARDED_POINTS DESCRIPTION
     */
    public static final String COM_ADD_ACTION = "COM_ADD_ACTION ";
    
    /**
     * The start of the pit commands.
     */
    public static final String PIT = "PIT_";

    /**
     *
     */
    public static final String PIT_NOODLE = PIT + "NOODLE ";

    /**
     *
     */
    public static final String PIT_BIN = PIT + "BIN";

    /**
     *
     */
    public static final String PIT_TOTE = PIT + "TOTE ";

    /**
     *
     */
    public static final String PIT_SLOPE = PIT + "SLOPE ";

    /**
     *
     */
    public static final String PIT_FLIP = PIT + "FLIP ";

    /**
     *
     */
    public static final String PIT_OMNI = PIT + "OMNI ";

    /**
     *
     */
    public static final String PIT_ROBOT_BALANCE = PIT + "BALANCE ";

    /**
     *
     */
    public static final String PIT_STACK = PIT + "STACK ";

    /**
     *
     */
    public static final String PIT_MISC = PIT + "MISC ";
    
    /**
     * THe start of auto commands
     */
    public static final String AUTO = "AUTO_";
    /**
     *
     */
    public static final String AUTO_ROBOT_SET = AUTO + "ROBOT_SET ";

    /**
     *
     */
    public static final String AUTO_TOTE_SET = AUTO + "AUTO_TOTE_SET ";

    /**
     *
     */
    public static final String AUTO_CONT_SET = AUTO + "AUTO_CONT_SET ";

    /**
     *
     */
    public static final String AUTO_S_TOTE_SET = AUTO + "AUTO_S_TOTE_SET ";
    
    /**
     *
     */
    public static final String TELE_S_TOTE = "TELE_STACKED_TOTE ";

    /**
     *
     */
    public static final String TELE_S_BIN = "TELE_STACKED_BIN ";

    /**
     *
     */
    public static final String TELE_NOODLE_BIN = "TELE_NOODLE_IN_BIN ";

    /**
     *
     */
    public static final String TELE_PUSH_NOODLE = "TELE_PUSHED_NOODLES ";

    /**
     *
     */
    public static final String TELE_COOP_SET = "TELE_COOP_SET ";
    
    private ServerSocket serverSocket;
    private Socket socket;
    private ArrayList<ServerToClientConnection> clientConnections;
    
    /**
     *
     */
    public Server(){
        clientConnections = new ArrayList<>();
    }
    
    /**
     *
     */
    public void startServer(){
        
    }
    
    /**
     *
     */
    public void waitForClientConnections(){
        
    }
    
    /**
     *
     */
    public void shutDownConnections(){
        
    }
    
    /**
     *
     * @return
     */
    public ArrayList<ServerToClientConnection> getConnections(){
        return clientConnections;
    }
}
