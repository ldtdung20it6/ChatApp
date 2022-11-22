/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.rmi.chatapp;

import com.rmi.client.ClientDriver;
import com.rmi.server.ServerDriver;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 *
 * @author TRUNG DUNG
 */
public class ChatApp {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        ServerDriver.main(args);
        ClientDriver.main(args);
    }
}
