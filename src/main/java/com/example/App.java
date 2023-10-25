package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "client attivo!" );
        


        try {
        
            Socket s = new Socket("localhost", 3000);
            Scanner scanner = new Scanner(System.in);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
            
            String stringaRicevuta = null;
            Integer cont = 0;
            do {
                System.out.println("Inserisci un numero");
                String num = scanner.nextLine();
                out.writeBytes(num + '\n');
                
                stringaRicevuta = in.readLine();

                if(Integer.parseInt(stringaRicevuta) == 2){

                    System.out.println("numero troppo grande");

                }

                else if(Integer.parseInt(stringaRicevuta) == 1){

                    System.out.println("numero troppo piccolo");
                    
                } 
                cont++;
                
            } while (Integer.parseInt(stringaRicevuta) != 3);
            System.out.println("numero indovinato in " + cont + " tentativi");
            s.close();
       
        } catch (UnknownHostException e) {
            
            e.printStackTrace();
        
        } catch (IOException e) {
            
            e.printStackTrace();
        
        }
    }
}