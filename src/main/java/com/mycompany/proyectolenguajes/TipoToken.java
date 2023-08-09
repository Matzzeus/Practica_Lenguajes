/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectolenguajes;

/**
 *
 * @author matzeus
 */
public enum TipoToken {
    ID("Identificador"),ARITMETICO("Aritmético"), COMPARACION ("Comparación"), 
    LOGICOS ("Lógicos"), ASIGANACION ("Asignacion"), PALABRAS_CLAVE ("Plabra Clava"),
    CONSTANTES ("Constantes"), COMENTARIO ("Comentario"), OTROS ("Otros"),   ;
    private String tipo;
    private TipoToken(String tipo){
        this.tipo=tipo;
    }
    public String getTipo(){
        return tipo;
    }
    
}
