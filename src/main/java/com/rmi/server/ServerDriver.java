/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rmi.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author TRUNG DUNG
 */
public class ServerDriver {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        IServer iServer = null;
        String url = iServer.LOOKUP_NAME;
        ServerImp server = new ServerImp();
        // user
        LocateRegistry.createRegistry(2909);
        Naming.rebind(url, server);
        System.out.println("[System] Server 1 is ready...");

        //data chat
        LocateRegistry.createRegistry(2310);
        Naming.rebind(url, server);
        System.out.println("[System] Server 2 is ready...");

    }
}
