package utils;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Numero {
    int numero;
    char color;
    String ispar;
    String vecinosDoble;
    String vecinosCuadruple;
    String docena;
    String altos;
    String linea;
    String columna;
    
    public Numero(){
        
    }
    public Numero(int numero,char color,String ispar, String vecinosdoble,
            String vecinoscuadruple, String docena,String altos,
            String linea, String columna){
        this.numero = numero;
        this.color = color;
        this.ispar = ispar;
        this.vecinosDoble = vecinosdoble;
        this.vecinosCuadruple = vecinoscuadruple;
        this.docena = docena;
        this.altos = altos;
        this.linea = linea;
        this.columna = columna;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public String isIspar() {
        return ispar;
    }

    public void setIspar(String ispar) {
        this.ispar = ispar;
    }

    public String getVecinosDoble() {
        return vecinosDoble;
    }

    public void setVecinosDoble(String vecinosDoble) {
        this.vecinosDoble = vecinosDoble;
    }

    public String getVecinosCuadruple() {
        return vecinosCuadruple;
    }

    public void setVecinosCuadruple(String vecinosCuadruple) {
        this.vecinosCuadruple = vecinosCuadruple;
    }

    public String getDocena() {
        return docena;
    }

    public void setDocena(String docena) {
        this.docena = docena;
    }

    public String getAltos() {
        return altos;
    }

    public void setAltos(String altos) {
        this.altos = altos;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }
    
}
