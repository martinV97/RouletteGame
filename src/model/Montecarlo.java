package model;

import java.util.ArrayList;

import persisstence.FileMannager;
import utils.Constants;

public class Montecarlo {

	private Uniforme tipoApuesta;
	private FileMannager fileMannager ;
	private FileMannager file;
	public PseudoRandom pseudoRandom;
	private RandomTest randomTest;
	int countgano = 0;
	int countganod = 0;
	int perdioo = 0;
	public Montecarlo() {
		tipoApuesta = new Uniforme();
		pseudoRandom = new PseudoRandom();
		fileMannager = new FileMannager();
		file = new FileMannager();
		randomTest = new RandomTest();
		typeBet();
	}
	
	public char typeBet(){
		ArrayList<Double> numbers = pseudoRandom.uniform1(0, 100);
		String path = "./file/apuesta.txt";
		file.cleanFile(path);
		file.writeNumber(numbers, path);
		double tipoApuesta  = this.tipoApuesta.pseudoaleatorios(0.0, 100.0);
		char claseApuesta = 0;
		if(tipoApuesta > 0.0 && tipoApuesta < 11.11){
			claseApuesta = Constants.SIMPLE_BET;
		}else if(tipoApuesta > 11.11 && tipoApuesta < 22.22){
			claseApuesta = Constants.DIVIDED_BET;
		}else if(tipoApuesta > 22.22 && tipoApuesta < 33.33){
			claseApuesta = Constants.QUADRUPLE_BET;
		}else if(tipoApuesta > 33.33 && tipoApuesta < 44.44){
			claseApuesta = Constants.LINE_BET;
		}else if(tipoApuesta > 44.44 && tipoApuesta < 55.55){
			claseApuesta = Constants.COLOR_BET;
		}else if(tipoApuesta > 55.55 && tipoApuesta < 66.66){
			claseApuesta = Constants.EVEN_OR_ODD_BET;
		}else if(tipoApuesta > 66.66 && tipoApuesta < 77.77){
			claseApuesta = Constants.COLUMN_BET;
		}else if(tipoApuesta > 77.77 && tipoApuesta < 88.88){
			claseApuesta = Constants.DOZEN_BET;
		}else{
			claseApuesta = Constants.HIGH_OR_LOW_BET;
		}
		return claseApuesta;
		
	}

	public void generar() {
		fileMannager.cleanFile("src/lanzamientos.csv");
		ArrayList<Double> lanzamientosAux = new ArrayList<Double>();
		for (int i = 0; i < 50; i++) {
			lanzamientosAux.add(tipoApuesta.pseudoaleatorios(0.0, 100.0));
		}
		fileMannager.writeNumber(lanzamientosAux,"src/lanzamientos.csv");
	}

	public ArrayList<Double> generarLanzamiento(){
		ArrayList<Double> lanzamientosAux = new ArrayList<Double>();
		for (int i = 0; i < 50; i++) {
			lanzamientosAux.add(tipoApuesta.pseudoaleatorios(0.0, 100.0));
		}
		return lanzamientosAux;
	}

	
	
	
	}

