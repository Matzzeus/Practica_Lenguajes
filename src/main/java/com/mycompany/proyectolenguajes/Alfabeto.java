
package com.mycompany.proyectolenguajes;


public  class Alfabeto {
    public static char[]Letras = {'a','b', 'c', 'd','e','f','g','h',
        'i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x', 'y','z', 'A', 'B','C','D','E','F','G'
    ,'H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    
    public static char[]Numeros = { '1', '2', '3', '4','5','6','7','8','9','0'};
    
    public static char[]Aritmeticos = {'+', '-','*','/','%'};
    public static char[]Comparacion = { '=','>','<','!'};
    public static String []Logicos = {"and", "or", "not","False", "Treu" };
    public static String [] Plabraclave = {"as", "assert", "break", "class", "continue","def", "del", "elif", "else", 
    "except", "Fase", "finally", "for", "from",
    "global", "if", "import", "in", "is", "lmabda", "None", "nomlocal", 
    "not", "or", "pas", "raise", "return", "true", "try", "while", "with", "yield", "Matz"};
    public static char[] Otros = {'(',')','[',']', '{','}',',',';',':'};
    
    public static boolean esPunto (char caracter){
        if (caracter == '.'){
            return true;
        }
        return false;
    }
        
    public static boolean recorrerLetra ( char caracter){
        for (int i = 0; i < Letras.length; i++) {
            if(caracter == Letras[i]){
                return true;
            }
        }
        return false;
    } 
      public static boolean recorrerComparacion ( char caracter){
        for (int i = 0; i < Comparacion.length; i++) {
            if(caracter == Comparacion[i]){
                return true;
            }
        }
        return false;
    }
   
    public static boolean recorrerNumeros ( char caracter){
        for (int i = 0; i < Numeros.length; i++) {
            if(caracter == Numeros[i]){
                return true;
            }
        }
        return false;
    } 
    public static boolean recorrerAritmeticos (char caracter){
        
        for (int i = 0; i < Aritmeticos.length; i++) {
            if (caracter == Aritmeticos[i]){
                return true;
            } 
        }
        return false;
    }
    
    public static boolean recorrerOtros (char caracter){
         for (int i = 0; i < Otros.length; i++) {
            if (caracter == Otros[i]){
                return true;
            } 
        }
        return false;
    }
    
    public static boolean espacioOTabulacion(char a){
        return a==(char)9 || a==(char)32;
    }
    
    public static boolean saltoDeLinea(char a){
        return a==(char)10;
    }

    public static boolean validarIDInicial(char caracter){
        if(recorrerLetra(caracter) || caracter=='_'){
            return true;
        }
        return false;
    }
   
    public static boolean validarID(char caracter){
        if(recorrerLetra(caracter) || caracter=='_' || recorrerNumeros(caracter)){
            return true;
        }
        return false;
    }
    public static boolean delimitador (char caracter){
        if(recorrerAritmeticos(caracter) || recorrerOtros(caracter) || recorrerComparacion(caracter) || esPunto (caracter) ){
            return true;
        }
        return false;
    }
    public static boolean delimitadorSinPunto (char caracter){
        if(recorrerAritmeticos(caracter) || recorrerOtros(caracter) || recorrerComparacion(caracter) ){
            return true;
        }
        return false;
    }
    public static boolean comparacion (char caracter){
        
        
       return false;  
    }
    
   
}
