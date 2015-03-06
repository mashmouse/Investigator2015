/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import client.Client;
import server.Server;

/**
 *
 * @author Aaron Jacobson
 */
public class ClientRunner {
    
    public static void main(String[] args){
        Client client = new Client();
        client.connectToServer(Server.IP, Server.PORT_NUMBER);
        client.serverConnection.sendMessage(Server.COM_MAKE_TEAM + "4180");
    }
}
