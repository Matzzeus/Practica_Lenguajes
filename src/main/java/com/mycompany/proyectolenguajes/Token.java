/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectolenguajes;

/**
 *
 * @author matzeus
 */
public class Token {
    String lexema;
    int fila;
    int columna;
    int posicion;
    TipoToken tipo;
    
    public Token(String lexema,int fila,int columna,int posicion,TipoToken tipo){
        this.lexema=lexema;
        this.fila=fila;
        this.columna=columna;
        this.posicion=posicion;
        this.tipo = tipo;
    }
    
    public String getLexema(){
        return lexema;
    }
    
}
