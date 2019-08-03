package model;

import java.util.ArrayList;

public class Partida {
	
	private int idPartida;
	private ArrayList<Double> lanzamientos;
	public Partida(int idPartida) {
		super();
		this.idPartida = idPartida;
		this.lanzamientos = new ArrayList<Double>();
	}
	
	public void addLanzamiento(double numero) {
		lanzamientos.add(numero);
	}

	public int getIdPartida() {
		return idPartida;
	}

	public ArrayList<Double> getLanzamientos() {
		return lanzamientos;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	public void setLanzamientos(ArrayList<Double> lanzamientos) {
		this.lanzamientos = lanzamientos;
	}
	
	

}
