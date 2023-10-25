package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MioThread extends Thread{
    Socket s;
    public MioThread(Socket s){
        this.s = s;
    }
    
    public void run(){
        try{
            System.out.println("client collegato");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            int num = (int)(Math.random()*101);
            String stringaRicevuta;
            int c = 0;
            
            System.out.println(num);
            do{
                
                c++;
                
                stringaRicevuta = in.readLine();
                
                if(Integer.parseInt(stringaRicevuta) < num){
                    
                    out.writeBytes("1" + "\n");

                }

                else if(Integer.parseInt(stringaRicevuta) > num){

                    out.writeBytes("2" + '\n');
                }

                else if(Integer.parseInt(stringaRicevuta) == num){

                    out.writeBytes("3" + '\n');
                    out.writeBytes(String.valueOf(c));
            
                }
                

                

            }while(Integer.parseInt(stringaRicevuta) != num);
        
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
