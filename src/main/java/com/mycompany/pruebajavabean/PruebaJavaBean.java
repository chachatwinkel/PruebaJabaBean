/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebajavabean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import ut2.examen.modelo.Sistema;

/**
 *
 * @author samah
 */
public class PruebaJavaBean {

    public static void main(String[] args) {
        
        //primero creo una lista vacia
         ArrayList<Sistema> criticos = new ArrayList<>();

        
         //ahora leo linea por linea
     try(BufferedReader br = new BufferedReader(new FileReader("estado_sistemas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null){
                String[] partes = linea.split(",");   
                if(partes[2].equals("Critico")){ 
                     //si el estado es Critico añade el objeto a la lista
                    criticos.add(new Sistema(partes[0], partes[1]));
                }
            }
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return;
        }

       
        if (criticos.isEmpty()) {//si no hay critico pues termina aqui
            System.out.println("No hay sistemas críticos.");
            return;
        }
        

       File fichero = new File("objetivo_urgente.xml");//se crea el xml donde se guardara

     try {
         
            //aqui le digo que clase va a convertir en xml y lee los @xmlroot etc
             JAXBContext contexto = JAXBContext.newInstance(Sistema.class);
             Marshaller marshaller = contexto.createMarshaller();
             marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

               Sistema sistema = criticos.get(0);//aqui coje el primer sistema critico de la lista

             marshaller.marshal(sistema, fichero);
             System.out.println("Archivo 'objetivo_urgente.xml' generado correctamente mediante Binding");

            System.out.println("--- Contenido generado ---");//aqui muestra el contenido final
             marshaller.marshal(sistema, System.out);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    
    
    
    
    
    
    
    
    }
    
    
    }

