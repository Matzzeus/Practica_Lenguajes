
package com.mycompany.proyectolenguajes;

import java.util.*;

public class Analizador_Lexico {
    String texto;
    String textoToken = "";
    int posicion = 0;
    int fila = 1,  inicialF=1;
    int colum = 1, inicialC =1;
    int estado = 0;
    /*
    estado 0 inicial
    estado 1 identificador
    estado 2 aritmetico
    estado 3 comparacion
    estado 4 constante
    estado 5 cadena
    estado 6 comentario
    estado 7 otro
    estado 8 error
    */
    ArrayList<Token> tokens = new ArrayList<>();    
    

    public Analizador_Lexico(String texto) {
        this.texto = texto;
    }
    
  
    public void analizar(){
        for(int i=0;i<texto.length();i++){
            char caracterActual = texto.charAt(i);
            switch (estado) {
                case 0:
                    estadoInicial(caracterActual);
                    break;
                case 1:
                    estadoIdentificador(caracterActual);
                    break;
                case 2:
                    estadoAritmetico(caracterActual);
                    break;
                case 3:
                    estadoComparacion(caracterActual);
                    break;
                case 4:
                    estadoConstante(caracterActual);
                    break;
                case 5:
                    estadoCadena(caracterActual);
                    break;
                case 6:
                    estadoComentario(caracterActual);
                    break;
                case 7:
                    estadoOtro(caracterActual);
                    break;
                case 8:
                    estadoError(caracterActual); 
                    
            }
            posicion = i;//en el estado inicial 0
        }
    }
    
    public void estadoInicial(char caracter){
        
        textoToken = "";
        if(Alfabeto.espacioOTabulacion(caracter)){
            colum++;
            //tokens.add(new Token(textoToken,fila,inicialC,posicion,TipoToken.ID)); crear token
        }
        else if(Alfabeto.saltoDeLinea(caracter)){
            colum = 1;
            fila++;
        }
        
        else if(Alfabeto.validarIDInicial(caracter)){
            textoToken += caracter;
            inicialC = colum;
            colum++;
            estado = 1;
        }
        else if(Alfabeto.recorrerAritmeticos(caracter)){
            textoToken += caracter;
            inicialC = colum;
            colum++;
            estado = 2;
        }
    }
    public void estadoIdentificador (char caracter){
        if(Alfabeto.validarID(caracter) ){
            textoToken += caracter;
            colum ++;
        }
        else if (Alfabeto.delimitador(caracter)){
            tokens.add(new Token(textoToken, fila, inicialC, posicion, TipoToken.ID));
            textoToken = "";
            estadoInicial(caracter);
        }  
        else{
            estado = 8;
            textoToken += caracter;
            colum ++;
        }
        
    }
    public void estadoAritmetico (char caracter){
        if (textoToken.equals("*") && caracter == '*' ){
            textoToken += caracter;
            tokens.add(new Token(texto, fila, colum, posicion, TipoToken.ARITMETICO));
            colum++;
            estado = 0;
            textoToken = "";
        }
        else if (textoToken.equals("/") && caracter == '/' ){
            textoToken += caracter;
            tokens.add(new Token(texto, fila, colum, posicion, TipoToken.ARITMETICO));
            colum++;
            estado = 0;
            textoToken = "";
        }   
        else if (caracter == '='){
            textoToken += caracter;
            
        }
        else {
            tokens.add(new Token(texto, fila, colum, posicion, TipoToken.ARITMETICO));
            estadoInicial(caracter);
        }
    }
    public void estadoComparacion (char caracter){
        if( caracter == '='){
            textoToken += caracter;
            tokens.add(new Token(texto, fila, colum, posicion, TipoToken.COMPARACION));
            colum++;
            estado = 0;
            textoToken = "";
        }
        else if(textoToken.equals( "=") ){
            tokens.add(new Token(texto, fila, colum, posicion, TipoToken.ASIGANACION));
            estadoInicial(caracter);
        }
        else {
            tokens.add(new Token(texto, fila, colum, posicion, TipoToken.COMPARACION));
            estadoInicial(caracter);
        }   
    }
    
    public void estadoConstante (char caracter){
        
            
    }
    public void estadoCadena (char caracter){
        
            
    }
    public void estadoComentario (char caracter){
        if (textoToken.equals("#") ){
            
        }
            
    }
    public void estadoOtro (char caracter){
        
            
    }
    public void estadoError (char caracter){
        if (Alfabeto.delimitadorSinPunto(caracter) ) {
            tokens.add(new Token(textoToken, fila, inicialC, posicion, TipoToken.ERROR));
            estadoInicial(caracter);
        }
            
    }
    
    
    
    public String getTexto() {
        return texto;
    }

    public int getPosicion() {
        return posicion;
    }

    
}
