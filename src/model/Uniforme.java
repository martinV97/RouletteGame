package model;

public class Uniforme {

	public Uniforme() {
		super();
	}
	public double pseudoaleatorios( Double a, Double b) {
		double pseudoaleatorio = Math.random()*(b-a)+a;
		return pseudoaleatorio;
	}
}






