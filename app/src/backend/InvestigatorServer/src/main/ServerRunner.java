/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import database.TeamDataBase;
import server.Server;

/**
 *
 * @author Aaron Jacobson
 */
public class ServerRunner {
    public static TeamDataBase THE_DATABASE;
    public static Server THE_SERVER;
    public static void main(String[] args){
        THE_DATABASE = new TeamDataBase();
        THE_SERVER = new Server();
        THE_SERVER.startServer();
        THE_SERVER.waitForClientConnections();
    }
}
