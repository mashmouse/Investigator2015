/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import database.RoboTeam;
import database.match.Action;
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
public class ServerToClientConnection implements Runnable {

    private Server server;
    private Socket socket;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private boolean shouldRun;
    private String ip;

    public ServerToClientConnection(Server server, Socket socket, DataInputStream dataIn, DataOutputStream dataOut) {
        this.server = server;
        this.socket = socket;
        this.dataIn = dataIn;
        this.dataOut = dataOut;
        ip = socket.getInetAddress().toString();
    }

    @Override
    public void run() {
        shouldRun = true;
        while (shouldRun) {
            try {
//                System.out.println("ServerToClientConnection: incoming message- " + dataIn.readUTF());
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

    public boolean sendMessage(String toSend) {
        try {
            dataOut.writeUTF(toSend);
        } catch (IOException ex) {
            System.out.println("ServerToClientConnection: Unable to send information to the client.");
            return false;
        }
        return true;
    }

    public void interpretMessage(Scanner messageScanner) {
        String command = messageScanner.next();
        System.out.println(command);
        if (command.equals(Server.COM_MAKE_TEAM)) {
            String teamNumber = messageScanner.next();
            ServerRunner.THE_DATABASE.addTeam(new RoboTeam(teamNumber));
        } else if (command.equals(Server.COM_MAKE_MATCH)) {
            String matchNumber = messageScanner.next();
            if (ServerRunner.THE_DATABASE.getMatch(matchNumber) == null) {
                Match m = new Match(matchNumber);
                m.addTeam(messageScanner.next());
                m.addTeam(messageScanner.next());
                m.addTeam(messageScanner.next());
                m.addTeam(messageScanner.next());
                m.addTeam(messageScanner.next());
                m.addTeam(messageScanner.next());
                ServerRunner.THE_DATABASE.addMatch(m);
            }
        } else if (command.equals(Server.COM_ADD_ACTION)) {
            interpretMessage(messageScanner);
        } else if (command.equals(Server.COM_ADD_MATCH)) {
        } else if (command.equals(Server.PIT_BIN)) {
            ServerRunner.THE_DATABASE.getTeam(messageScanner.next()).getPitNotes().FUNCTION_BIN = messageScanner.nextBoolean();
        } else if (command.equals(Server.PIT_FLIP)) {
            ServerRunner.THE_DATABASE.getTeam(messageScanner.next()).getPitNotes().FUNCTION_FLIP_TOTE = messageScanner.nextBoolean();
        } else if (command.equals(Server.PIT_MISC)) {
            String teamNumber = messageScanner.next();
            String misc = "";
            for (int currentToken = messageScanner.nextInt(); currentToken > 0; currentToken--) {
                misc += messageScanner.next();
            }
            ServerRunner.THE_DATABASE.getTeam(teamNumber).getPitNotes().addMiscFuntion(misc);
        } else if (command.equals(Server.PIT_NOODLE)) {
            ServerRunner.THE_DATABASE.getTeam(messageScanner.next()).getPitNotes().FUNCTION_NOODLE = messageScanner.nextBoolean();
        } else if (command.equals(Server.PIT_OMNI)) {
            ServerRunner.THE_DATABASE.getTeam(messageScanner.next()).getPitNotes().FUNCTION_OMNIWEEL = messageScanner.nextBoolean();
        } else if (command.equals(Server.PIT_ROBOT_BALANCE)) {
            ServerRunner.THE_DATABASE.getTeam(messageScanner.next()).getPitNotes().FUNCTION_BALANCE_ROBOT = messageScanner.nextBoolean();
        } else if (command.equals(Server.PIT_SLOPE)) {
            ServerRunner.THE_DATABASE.getTeam(messageScanner.next()).getPitNotes().FUNCTION_SLOPE = messageScanner.nextBoolean();
        } else if (command.equals(Server.PIT_TOTE)) {
            ServerRunner.THE_DATABASE.getTeam(messageScanner.next()).getPitNotes().FUNCTION_TOTE = messageScanner.nextBoolean();
        } else if (command.equals(Server.AUTO_CONT_SET)) {
            ServerRunner.THE_DATABASE.getTeam(messageScanner.next()).addAutoAction(messageScanner.next(), Action.CONTAINER_SET);
        } else if (command.equals(Server.AUTO_ROBOT_SET)) {
            ServerRunner.THE_DATABASE.getTeam(messageScanner.next()).addAutoAction(messageScanner.next(), Action.ROBOT_SET);
        } else if (command.equals(Server.AUTO_S_TOTE_SET)) {
            ServerRunner.THE_DATABASE.getTeam(messageScanner.next()).addAutoAction(messageScanner.next(), Action.STACKED_TOTE_SET);
        } else if (command.equals(Server.AUTO_TOTE_SET)) {
            ServerRunner.THE_DATABASE.getTeam(messageScanner.next()).addAutoAction(messageScanner.next(), Action.TOTE_SET);
        } else if (command.equals(Server.TELE_COOP_SET)) {
            ServerRunner.THE_DATABASE.getTeam(messageScanner.next()).addTeleAction(messageScanner.next(), Action.COOPERATION_SET);
        } else if (command.equals(Server.TELE_NOODLE_BIN)) {
            ServerRunner.THE_DATABASE.getTeam(messageScanner.next()).addTeleAction(messageScanner.next(), Action.NOODLE_IN_BIN);
        } else if (command.equals(Server.TELE_PUSH_NOODLE)) {
            ServerRunner.THE_DATABASE.getTeam(messageScanner.next()).addTeleAction(messageScanner.next(), Action.PUSH_NOODLE);
        } else if (command.equals(Server.TELE_S_BIN)) {
            ServerRunner.THE_DATABASE.getTeam(messageScanner.next()).addTeleAction(messageScanner.next(), Action.STACK_BIN);
        } else if (command.equals(Server.TELE_S_TOTE)) {
            ServerRunner.THE_DATABASE.getTeam(messageScanner.next()).addTeleAction(messageScanner.next(), Action.STACK_TOTE);
        }else{
        }
        if (messageScanner.hasNext()) {
            interpretMessage(messageScanner);
        }
    }

    public boolean getShouldRun() {
        return shouldRun;
    }

    public void setShouldRun(boolean shouldRun) {
        this.shouldRun = shouldRun;
    }

}
