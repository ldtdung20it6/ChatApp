/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rmi.server;

import com.rmi.database.Database;
import com.rmi.model.User;
import com.rmi.ui.Home;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author TRUNG DUNG
 */
public class ServerImp extends UnicastRemoteObject implements IServer {

    User user = new User();
    Home home;
    ArrayList<User> users = new ArrayList<>();

    public ServerImp() throws RemoteException {
        super();
    }

    @Override
    public boolean login(String email, String password) throws RemoteException {
        try {
            Statement statement = Database.chatapp_user().createStatement();
            String sql = "SELECT * FROM user WHERE email = '" + email + "' AND password = '" + password + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                user.setId(id);
                user.setName(name);
                user.setEmail(email);
                user.setPassword(password);
                user.setStatus("online");
                user.setPhone(phone);
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean register(String email, String password, String name) throws RemoteException {
        try {
            Statement statementLogin = Database.chatapp_user().createStatement();
            String sqlLogin = "SELECT * FROM user WHERE email = '" + email + "'";
            ResultSet resultSetLogin = statementLogin.executeQuery(sqlLogin);
            if (resultSetLogin.next()) {
                // User already exists
                System.out.println("User already exists");
            } else {
                Statement statementRegister = Database.chatapp_user().createStatement();
                String sqlRegister = "INSERT INTO `user`(`email`, `password`, `name`) VALUES ('" + email + "','" + password + "','" + name + "')";
                int resultSetRegister = statementRegister.executeUpdate(sqlRegister);
                System.out.println(resultSetRegister);
                if (resultSetRegister == 1) {
                    Statement statementLoginTwo = Database.chatapp_user().createStatement();
                    String sql = "SELECT * FROM user WHERE email = '" + email + "' AND password = '" + password + "'";
                    ResultSet resultSet = statementLoginTwo.executeQuery(sql);
                    if (resultSet.next()) {
                        String id = resultSet.getString("id");
                        user.setId(id);
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public void updateInfo(String password, String name, String phone) throws RemoteException {
        try {
            Statement statement = Database.chatapp_user().createStatement();
            String sql = "SELECT * FROM user WHERE email = '" + user.getEmail() + "' AND password = '" + user.getPassword() + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Statement statementUpdate = Database.chatapp_user().createStatement();
                String sqlUpdate = "UPDATE `user` SET `password`='" + password + "',`name`='" + name + "',`phone`='" + phone + "' WHERE email = '" + user.getEmail() + "'";
                int resultSetUpdate = statementUpdate.executeUpdate(sqlUpdate);
                if (resultSetUpdate == 1) {
                    System.out.println("update thanh cong");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void search(String name) throws RemoteException {
        try {

        } catch (Exception e) {
        }
    }

    @Override
    public void sendChat(String message) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<User> getUser() throws RemoteException {
        try {
            Statement statement = Database.chatapp_user().createStatement();
            String sql = "SELECT * FROM `user` WHERE id";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String getuser = resultSet.getString("name");
                this.users.add(user);
            }
        } catch (Exception e) {
        }
        return users;
    }

    @Override
    public String myName() throws RemoteException {
        return user.getName();
    }

    @Override
    public String myEmail() throws RemoteException {
        return user.getEmail();
    }

    @Override
    public String myPhone() throws RemoteException {
        return user.getPhone();
    }

    @Override
    public String Status() throws RemoteException {
        return user.getStatus();
    }

    @Override
    public String myPassword() throws RemoteException {
        return user.getPassword();
    }


}
