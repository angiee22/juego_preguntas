/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_preguntas;

import java.util.Scanner;
/**
 *
 * @author ASUS
 */


public class main {
    
    public static void main(String[] args) {
        
        int ronda=0;
        boolean juego_activo=true;
        Scanner sc = new Scanner(System.in);
        
        metodos m = new metodos();
   
        m.cargarPreguntas("banco_de_preguntas.txt");//cargar las preguntas del archivo .txt
        
        while(juego_activo){
        
            if (ronda<5){
                m.mostrarPregunta(ronda);//muestra una pregunta aleatoria de cada categoria
                
                
                String r = sc.nextLine();//recibe la respuesta del usuario
                
                m.comprobarDato(r, ronda);//comprueba el dato ingresado por el usuario
                juego_activo=m.juegoActivo();//comprueba si el juego sigue activo
            }
            else{
                juego_activo=false;//termina el juego si se llega a la ronda 5
            }
       
        ronda++;
        
        }
        
    }

}
