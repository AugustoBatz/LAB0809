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
            stream.writeInt(1234567);
            //segundo contenedor
            stream.writeShort(0); //puntero siguiente
            stream.writeByte(5);//Longitud
            stream.writeByte('P');//
            stream.writeByte('E');    //nombre
            stream.writeByte('D');
            stream.writeByte('R');//
            stream.writeByte('O');//
            stream.writeInt(1234567);
            
           
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
//        try {
//            FileInputStream archivo= new FileInputStream("agenda.ag");
//            DataInputStream streamEntrada= new DataInputStream(archivo);
//            
//            int dato1=streamEntrada.readInt();
//            System.out.println("Dato entero "+dato1);
//            
//            dato1=streamEntrada.readByte();
//            System.out.println("Dato entero "+dato1);
//            
//            double x=streamEntrada.readDouble();
//            System.out.println("Dato entero "+x );
//            streamEntrada.close();
//            archivo.close();
//            
//         
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Archivos809.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Archivos809.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
   }
   
}
