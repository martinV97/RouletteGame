package model;

import java.util.ArrayList;

import utils.Constants;


public class PseudoRandom {

	public static ArrayList<String> Xi;
	public static ArrayList<String> XiSquare;
	public static ArrayList<String> extraction;
	public static ArrayList<Integer> list_xo;
	public static ArrayList<Integer> list_xi;
	public static ArrayList<Double> list_ri;
	public static ArrayList<Double> Ri;
	public static ArrayList<Integer> list_xoM;
	public static ArrayList<Integer> list_xiM;
	public static ArrayList<Double> list_riM;
	public static ArrayList<Double> list_riU;
	public static ArrayList<Double> list_NiU;
	public static ArrayList<Double> RiM;
	private RandomTest randomTest;
	public PseudoRandom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void squareMeans(){
		
		Xi = new ArrayList<String>();
		XiSquare = new ArrayList<String>();
		extraction = new ArrayList<String>();
		Ri = new ArrayList<Double>();
		
		for (int i = 0; i < Constants.NUMBERS; i++) {
			int AuxnumberSquare = Integer.parseInt(Xi.get(i))*Integer.parseInt(Xi.get(i));
			String numberSquare = String.valueOf(AuxnumberSquare);
			int digits = numberSquare.length();
			
			switch (digits) {
			case 7:
				numberSquare= "0"+AuxnumberSquare;
				XiSquare.add(numberSquare);
				extraction.add(numberSquare.substring(2,6));
				Xi.add(extraction.get(i));
				Ri.add((Double.parseDouble(extraction.get(i)))/10000);
				break;
			case 6:
				numberSquare= "00"+AuxnumberSquare;
				XiSquare.add(numberSquare);
				extraction.add(numberSquare.substring(2,6));
				Xi.add(extraction.get(i));
				Ri.add((Double.parseDouble(extraction.get(i)))/10000);
				break;

			case 5:
				numberSquare= "000"+AuxnumberSquare;
				XiSquare.add(numberSquare);
				extraction.add(numberSquare.substring(2,6));
				Xi.add(extraction.get(i));
				Ri.add((Double.parseDouble(extraction.get(i)))/10000);
				break;
			default :
				XiSquare.add(numberSquare);
				extraction.add(numberSquare.substring(2,6));
				Xi.add(extraction.get(i));
				Ri.add((Double.parseDouble(extraction.get(i)))/10000);
				break;
			}
		}
	}
	
	public void uniform(int A,int B){
		this.list_NiU = new ArrayList<Double>();
		this.list_riU = new ArrayList<Double>();
		int a = A;
		int b = B;
		for (int i = 0; i < Constants.NUMBERS; i++) {
			double ri= Math.random();
			this.list_riU.add(ri);
			double ni = a+(b-a)*ri;
			this.list_NiU.add(ni);
		}
	}
	public ArrayList<Double> uniform1(int A,int B){
		this.list_NiU = new ArrayList<Double>();
		this.list_riU = new ArrayList<Double>();
		int a = A;
		int b = B;
		for (int i = 0; i < Constants.NUMBERS; i++) {
			double ri= Math.random();
			this.list_riU.add(ri);
			double ni = a+(b-a)*ri;
			this.list_NiU.add(ni);
		}
		return this.list_NiU;
	}

	public static ArrayList<String> getXi() {
		return Xi;
	}

	public static void setXi(ArrayList<String> xi) {
		Xi = xi;
	}

	public static ArrayList<String> getXiSquare() {
		return XiSquare;
	}

	public static void setXiSquare(ArrayList<String> xiSquare) {
		XiSquare = xiSquare;
	}

	public static ArrayList<String> getExtraction() {
		return extraction;
	}

	public static void setExtraction(ArrayList<String> extraction) {
		PseudoRandom.extraction = extraction;
	}

	public static ArrayList<Integer> getList_xo() {
		return list_xo;
	}

	public static void setList_xo(ArrayList<Integer> list_xo) {
		PseudoRandom.list_xo = list_xo;
	}

	public static ArrayList<Integer> getList_xi() {
		return list_xi;
	}

	public static void setList_xi(ArrayList<Integer> list_xi) {
		PseudoRandom.list_xi = list_xi;
	}

	public static ArrayList<Double> getList_ri() {
		return list_ri;
	}

	public static void setList_ri(ArrayList<Double> list_ri) {
		PseudoRandom.list_ri = list_ri;
	}

	public static ArrayList<Double> getRi() {
		return Ri;
	}

	public static void setRi(ArrayList<Double> ri) {
		Ri = ri;
	}
	
	
}
