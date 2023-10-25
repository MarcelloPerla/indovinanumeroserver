package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Server Partito!" );

        try {

            ServerSocket server = new ServerSocket(3000);
            do{
                Socket s = server.accept();
                MioThread thread = new MioThread(s);
                thread.start();
            }while(true);
            
            
            

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}