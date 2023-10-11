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
public class App {
    public static void main(String[] args) {
        try {      
            System.out.println("Startando il server!");

            int ran = (int)Math.floor(Math.random() * (100 - 1 + 1) + 1);
            int cont = 0;

            ServerSocket server = new ServerSocket(3000);
            Socket s = server.accept();

            System.out.println("Client collegato");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
            Integer numeroRicevuto = Integer.parseInt(in.readLine());
            System.out.println("Numero ricevuto " + numeroRicevuto);

            if(numeroRicevuto < ran){
                out.writeBytes(numeroRicevuto + " è troppo piccolo");
                cont++;
            } else if(numeroRicevuto > ran){
                out.writeBytes(numeroRicevuto + " è troppo grande");
                cont++;
            } else if(numeroRicevuto == ran){
                out.writeBytes(numeroRicevuto + " è esatto!!" + "\n Hai indovinato in " + cont + " tentativi");
            }

            s.close();
            server.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
    }
}