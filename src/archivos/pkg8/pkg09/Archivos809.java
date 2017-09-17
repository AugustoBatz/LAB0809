/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.pkg8.pkg09;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author archivos
 */
public class Archivos809 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        int x=0;
        Scanner leer= new Scanner(System.in);
        while(x!=3)
        {
            System.out.println("Agenda");
            System.out.println("Que desea hacer?");
            System.out.println("1. Leer");
            System.out.println("2. Crear archivo");
            int opcion;
            opcion=leer.nextInt();
            switch(opcion)
            {
                case 1:
                    leer();
                    break;
                case 2:
                    Crear();
                    break;
                    
            }
            
            
            
        }
        
        
     
        
   }
    
    public static void leer()
    {
        try {
            FileInputStream archivo= new FileInputStream("agenda.ag");
            DataInputStream streamEntrada= new DataInputStream(archivo);
            
            
            byte dato1[]={streamEntrada.readByte(),streamEntrada.readByte()};
            if(dato1[0]==65&&dato1[1]==71)
            {
                
                System.out.println("Archivo permitido");
                byte c=streamEntrada.readByte();//numero de los contenderores
                if(c!=0)
                {
                short vp[]= new short[c];//array de short que guarda todas las posiciones de los punteros de tamaño c
                for(int x=0;x<c;x++)
                {      
                    vp[x]=streamEntrada.readShort();//guarda el puntero del contendero 1
                    byte l=streamEntrada.readByte();//guarda el largo del nombre
                    System.out.println("Nombre :");
                    for(int y=0;y<l;y++)
                    {
                        byte nom=streamEntrada.readByte();
                        System.out.print((char)nom);
                       
                    }
                    System.out.println("\n");
                    System.out.println("Telefono :");
                    int telefono=streamEntrada.readInt();
                    System.out.println(telefono);
                    System.out.println("\n");
                }
                
                }
                else
                {
                    System.out.println("archivo vacio");
                }
            }
            else
            {
                System.out.println("Archivo dañado");
            }
            
           
            streamEntrada.close();
            archivo.close();
            
         
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos809.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivos809.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void Crear()
    {
        FileOutputStream archivo=null;
        try {
            archivo = new FileOutputStream("agenda.ag");
            DataOutputStream stream = new DataOutputStream(archivo);
            stream.writeByte('A');
            stream.writeByte('G');
            stream.writeByte(2);
            //primer contenedor
            stream.writeShort(18); //puntero siguiente
            stream.writeByte(4);//Longitud
            stream.writeByte('L');//
            stream.writeByte('U');    //nombre
            stream.writeByte('I');
            stream.writeByte('S');//
            stream.writeInt(12345678);
            //segundo contenedor
            stream.writeShort(0); //puntero siguiente
            stream.writeByte(5);//Longitud
            stream.writeByte('P');//
            stream.writeByte('E');    //nombre
            stream.writeByte('D');
            stream.writeByte('R');//
            stream.writeByte('O');//
            stream.writeInt(12345678);
            
           
            stream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos809.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivos809.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                archivo.close();
            } catch (IOException ex) {
                Logger.getLogger(Archivos809.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
}
