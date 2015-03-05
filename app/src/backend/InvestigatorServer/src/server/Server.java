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
import java.util.logging.Level;
import java.util.logging.Logger;

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
     * the command followed by the team number
     */
    public static final String COM_MAKE_TEAM = "COM_MAKE_TEAM ";

    /**
     * The command for adding a match to a team
     * FORMAT: COM_ADD_MATCH 4180 GLA_23
     * the command followed by the team number of the team and the match number
     */
    public static final String COM_ADD_MATCH = "COM_ADD_MATCH ";

    /**
     * The command for creating a match, with the teams that were in it
     * FORMAT: COM_MAKE_MATCH GLA_23 4180 948 4911 1318 4030 27
     * the command followed by the match number followed by the six teams which were in it
     */
    public static final String COM_MAKE_MATCH = "COM_MAKE_MATCH ";

    /**
     * The command for adding an action to a robot when you have the team and match numbers
     * FORMAT: COM_ADD_ACTION 4180 GLA_23 ACTION_TYPE AWARDED_POINTS DESCRIPTION
     * the command followed by the team and match numbers, then the type of action, the points which were awarded, then a description of the action
     */
    public static final String COM_ADD_ACTION = "COM_ADD_ACTION ";
    
    /**
     * The start of the pit commands.
     */
    public static final String PIT = "PIT_";

    /**
     * The command for a team's ability to manipulate a noodle
     * FORMAT: PIT_NOODLE 4180 false
     * the command followed by the team number and then a boolean
     */
    public static final String PIT_NOODLE = PIT + "NOODLE ";

    /**
     * The command for a team's ability to manipulate a bin
     * FORMAT: PIT_BIN 4180 true
     * the command followed by the team number and then a boolean
     */
    public static final String PIT_BIN = PIT + "BIN";

    /**
     * The command for a team's ability to manipulate a tote
     * FORMAT: PIT_TOTE 4180 true
     * the command followed by the team number and then a boolean
     */
    public static final String PIT_TOTE = PIT + "TOTE ";

    /**
     * The command for a team's ability to go over the slope
     * FORMAT: PIT_SLOPE 4180 true
     * the command followed by the team number and then a boolean
     */
    public static final String PIT_SLOPE = PIT + "SLOPE ";

    /**
     * The command for a team's ability to manipulate flipped totes
     * FORMAT: PIT_FLIP 4180 false
     * the command followed by the team number and then a boolean
     */
    public static final String PIT_FLIP = PIT + "FLIP ";

    /**
     * The command for a team with omni-wheels or some equivalent
     * FORMAT: PUIT_OMNI 4180 false
     * the command followed by the team number and then a boolean
     */
    public static final String PIT_OMNI = PIT + "OMNI ";

    /**
     * The command for a team's ability to keep their robot balanced
     * FORMAT: PIT_BALANCE 4180 true
     * the command followed by the team number and then a boolean
     */
    public static final String PIT_ROBOT_BALANCE = PIT + "BALANCE ";

    /**
     * The command for a team's ability to keep the stack of totes balanced
     * FORMAT: PIT_STACK_BALANCE 4180 true
     * the command followed by the team number and then a boolean
     */
    public static final String PIT_STACK_BALANCE = PIT + "STACK_BALANCE ";

    /**
     * The command for any misc notes that are being sent to the server
     * FORMAT: PIT_MISC 4180 4 the robot has leds!
     * the command followed by the number of tokens in the message and then the message
     */
    public static final String PIT_MISC = PIT + "MISC ";
    
    /**
     * The start of auto commands
     */
    public static final String AUTO = "AUTO_";
    /**
     * The command for a team participating in a robot set
     * FORMAT: AUTO_ROBOT_SET 4180 true
     * the command followed by the team number and then a boolean
     */
    public static final String AUTO_ROBOT_SET = AUTO + "ROBOT_SET ";

    /**
     * The command for a team participating in a tote set
     * FORMAT: AUTO_TOTE_SET 4180 false
     * the command followed by the team number and a boolean
     */
    public static final String AUTO_TOTE_SET = AUTO + "TOTE_SET ";

    /**
     * The command for a team participating in a container set
     * FORMAT: AUTO_CONT_SET 4180 true
     * the command followed by the team number the a boolean
     */
    public static final String AUTO_CONT_SET = AUTO + "CONT_SET ";

    /**
     * The command for a team facilitating a stacked tote set
     * FORMAT: AUTO_S_TOTE_SET 4180 boolean
     * the command followed by the team number and a boolean
     */
    public static final String AUTO_S_TOTE_SET = AUTO + "S_TOTE_SET ";
    
    /**
     * The start of all tele-operated commands
     */
    public static final String TELE = "TELE_";
    
    /**
     * The command for a team stacking totes
     * FORMAT: TELE_STACK_TOTE 4180 5
     * the command followed by the team number and the level the robot stacked their highest tote at
     */
    public static final String TELE_S_TOTE = TELE + "STACKED_TOTE ";

    /**
     * The command for a team adding a container to a tote stack
     * FORMAT: TELE_STACKED_BIN 4180 4
     * the command followed by the team number and the level which the team added the bin at
     */
    public static final String TELE_S_BIN = TELE + "STACKED_BIN ";

    /**
     * The command for a team putting a noodle in a bin
     * FORMAT: TELE_NOODLE_IN_BIN 4180 true
     * the command followed by the team number and a boolean
     */
    public static final String TELE_NOODLE_BIN = TELE + "NOODLE_IN_BIN ";

    /**
     * The command for a team pushing noodles and not damaging the robot or the noodles
     * FORMAT: TELE_PUSHED_NOODLES 4180 true
     * the command followed by the team number and a boolean
     */
    public static final String TELE_PUSH_NOODLE = TELE + "PUSHED_NOODLES ";

    /**
     * The command for a team participating in a coopertition set
     * FORMAT: TELE_COOP_SET 4180 4
     * the command followed by the team number and the highest level the robot added a tote at
     */
    public static final String TELE_COOP_SET = TELE + "COOP_SET ";
    
    private ServerSocket serverSocket;
    private Socket socket;
    private boolean shouldWait;
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
        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
        } catch (IOException ex) {
            System.out.println("Server: Unable to initialize the server socket.");
        }
    }
    
    /**
     *
     */
    public void waitForClientConnections(){
        shouldWait = true;
        if(serverSocket!= null){
            while(shouldWait){
                try {
                    socket = serverSocket.accept();
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    clientConnections.add(new ServerToClientConnection(this,socket,in,out));
                    Thread clientConnectionThread = new Thread(clientConnections.get(clientConnections.size()-1));
                    clientConnectionThread.start();
                } catch (IOException ex) {
                    System.out.println("Server: Unable to accpet the socket.");
                }
            }
        }
    }
    
    /**
     *
     */
    public void shutDownConnections(){
        for(ServerToClientConnection s : clientConnections){
            s.setShouldRun(false);
            shouldWait = false;
        }
    }
    
    /**
     *
     * @return
     */
    public ArrayList<ServerToClientConnection> getConnections(){
        return clientConnections;
    }
}
