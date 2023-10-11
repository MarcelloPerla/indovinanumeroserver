package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try { 
            System.out.println( "Il client è partito" );
            Socket s = new Socket("localhost", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

           int num = 0;
           Scanner scan = new Scanner(System.in);
        String stringaRicevuta = in.readLine();
           do{
                
                if(stringaRicevuta == "2"){
                    System.out.println("numero troppo grande\n");
                    System.out.println("inserisci un numero\n");
                    num = scan.nextInt();
                }
                if(stringaRicevuta == "1"){
                    System.out.println("numero troppo piccolo\n");
                    System.out.println("inserisci un numero\n");
                    num = scan.nextInt();
                }

           }while(stringaRicevuta != "1");

            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
    }
}