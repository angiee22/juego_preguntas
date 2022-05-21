/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_preguntas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Ansh
 */
public class metodos {
    
    List<List<String>> preguntas = new ArrayList<>();
    String respuesta_correcta="";
    int puntaje_total = 0;
    boolean juego_activo=true;
    
            public void cargarPreguntas(String nombreArchivo){    
            File archivo;
            FileReader fr;
            BufferedReader br;
            
        
            try {
                archivo=new File(nombreArchivo);
                fr=new FileReader(archivo);
                br=new BufferedReader(fr);
                
                String linea;
                
                for(int i=0;i<5;i++){
                    preguntas.add(new ArrayList<>());//Agrega nueva categoria de preguntas
                    for(int j=0;j<5;j++){
                    linea=br.readLine();//lee cada linea del archivo .txt
                    preguntas.get(i).add(linea); //Agrega nueva pregunta a la categoria i                
                }
                }

                br.close();
                fr.close();
                
            }catch(IOException e){
               System.out.println(e); 
            }
            };
            
            public void mostrarPregunta(int ronda){
                    String[] categoria= {"MATEMATICAS","CAPITALES","ANIMALES","PAISES","MONEDAS"};
                    String[] pregunta, desencriptar_respuesta;
                    String texto_obtenido, pregunta_obtenida;
                    
                    Random random = new Random();
	            int random_pregunta = random.nextInt(5);
                    
                    texto_obtenido=preguntas.get(ronda).get(random_pregunta);//selecciona una pregunta aleatoria de la categoria actual
                    pregunta_obtenida =texto_obtenido.replace("&", "");
                    
                        pregunta = pregunta_obtenida.split("#s#");//separa la pregunta y cada respuesta para añadirle salto de linea más adelante
                        desencriptar_respuesta = texto_obtenido.split("&");//Extrae la respuesta correcta encriptada entre simbolos & en el txt
                        respuesta_correcta=desencriptar_respuesta[1];
                        
                    System.out.println("Ronda " + (ronda+1) + " Categoria " + categoria[ronda]);//indica la ronda y el nombre de la categoria
                    for(int i=0;i<5;i++){
                    System.out.println(pregunta[i]);//muestra pregunta y las opciones de respuesta
                    }
                    System.out.println("Digite la letra 'a', 'b', 'c', o 'd' para indicar su respues o 's' para retirarse del juego");
            };
            
            public void comprobarDato(String dato_ingresado, int ronda){
                    int[] puntos= {100,200,300,400,500};
                    String mensaje = "";
        
                    
                    if (respuesta_correcta.equals(dato_ingresado)){
                        puntaje_total=puntaje_total+puntos[ronda];
                        if (ronda < 4){
                           mensaje = "Respuesta correcta, has sumado " + puntos[ronda] + " puntos, tu puntaje total es "+ puntaje_total+"\n";
                        }
                        else{
                           mensaje = "FELICIDADES!! GANASTE EL JUEGO, has sumado " + puntos[ronda] + " puntos y tu puntaje total es "+ puntaje_total+"\n"; 
                        }
                    }
                    else if("s".equals(dato_ingresado)){
                        mensaje = "Gracias por participar, te llevas " + puntaje_total + " puntos"+"\n";
                        juego_activo=false;
                    }
                    else{
                        mensaje = "Respuesta incorrecta, has perdido el juego"+"\n";
                        juego_activo=false;
                    }
                    System.out.println(mensaje);
                    
            };
            
            public boolean juegoActivo(){
                    
                    return juego_activo;
            };
}
