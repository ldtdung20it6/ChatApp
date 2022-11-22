/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rmi.server;

import com.rmi.model.User;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author TRUNG DUNG
 */
public interface IServer extends Remote{
    public String LOOKUP_NAME = "rmi://localhost:2909/ChatApp";
    public boolean login(String email,String password) throws RemoteException;
    public boolean register(String email,String password,String name) throws RemoteException;
    public String myEmail() throws RemoteException;
    public String myPassword() throws RemoteException;
    public String myName() throws RemoteException;
    public String myPhone() throws RemoteException;
    public String Status() throws RemoteException;
    public void updateInfo(String password, String name, String phone) throws RemoteException;
    public void search(String name) throws RemoteException;
    public void sendChat(String message) throws RemoteException;
    public ArrayList<User> getUser() throws RemoteException;
}
