/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author HP
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author John Jimenez
 *
 */
public class Instructions extends JDialog {

	private static final long serialVersionUID = 1L;

	private JLabel jLTitle,jLinfo,jLTiposDeapuesta,jLInfoapuesta;

	public Instructions() {
		
		setSize(520, 420);
		getContentPane().setBackground(Color.decode("#F5F5F5"));
		setLocationRelativeTo(null);
		setLayout(null);
		setModal(true);
		setResizable(false);
		((JPanel) getContentPane()).setOpaque(false);
		initComponents();
	}

	private void initComponents() {

		jLTitle = new JLabel("Instrucciones");
		jLTitle.setForeground(Color.BLACK);
		jLTitle.setFont(new Font("Consolas", 1, 26));
		jLTitle.setBounds(180, 10, 300, 50);
		this.add(jLTitle);

		
		jLinfo= new JLabel("La manera correcta de ingresar las apuestas es la siguiente:");
		jLinfo.setForeground(Color.BLACK);
		//jLinfo.setFont(new Font("", 1, 18));
		jLinfo.setBounds(40, 70, 450, 15);
		this.add(jLinfo);
                
                jLinfo= new JLabel("Para apuesta sencilla, ingresar el numero al que se desea apostar.");
		jLinfo.setForeground(Color.BLACK);
		//jLinfo.setFont(new Font("", 1, 18));
		jLinfo.setBounds(40, 115, 450, 15);
		this.add(jLinfo);
                
                jLinfo= new JLabel("Ingresa cantidad a apostar, en información"
                        + " de la apuesta escribir el número.");
		jLinfo.setForeground(Color.BLACK);
		//jLinfo.setFont(new Font("", 1, 18));
		jLinfo.setBounds(40, 100, 450, 15);
		this.add(jLinfo);
                
                jLinfo= new JLabel("Para apuestas que tinen mas de un número, "
                        + "deben de ir separados por coma.");
		jLinfo.setForeground(Color.BLACK);
		//jLinfo.setFont(new Font("", 1, 18));
		jLinfo.setBounds(40, 130, 450, 15);
		this.add(jLinfo);

		
		jLTiposDeapuesta= new JLabel("Ejemplo: ");
		jLTiposDeapuesta.setForeground(Color.BLACK);
		jLTiposDeapuesta.setFont(new Font("Consolas", 1, 16));
		jLTiposDeapuesta.setBounds(40, 155, 300, 20);
		this.add(jLTiposDeapuesta);


		jLTiposDeapuesta= new JLabel("Apuesta dividida");
		jLTiposDeapuesta.setForeground(Color.BLACK);
		//jLTiposDeapuesta.setFont(new Font("Consolas", 1, 16));
		jLTiposDeapuesta.setBounds(40, 170, 200, 20);
		this.add(jLTiposDeapuesta);
                
                jLInfoapuesta= new JLabel("5,8");
		jLInfoapuesta.setForeground(Color.BLACK);
		//jLInfoapuesta.setFont(new Font("Consolas", 1, 16));
		jLInfoapuesta.setBounds(300, 170, 50, 20);
		this.add(jLInfoapuesta);

		jLTiposDeapuesta= new JLabel("Apuesta Cuadruple");
		jLTiposDeapuesta.setForeground(Color.BLACK);
		//jLTiposDeapuesta.setFont(new Font("Consolas", 1, 16));
		jLTiposDeapuesta.setBounds(40, 195, 200, 20);
		this.add(jLTiposDeapuesta);
		
                jLInfoapuesta= new JLabel("2,3,6,5");
		jLInfoapuesta.setForeground(Color.BLACK);
		//jLInfoapuesta.setFont(new Font("Consolas", 1, 16));
		jLInfoapuesta.setBounds(300, 195, 100, 20);
		this.add(jLInfoapuesta);
                
                jLTiposDeapuesta= new JLabel("Apuesta de línea");
		jLTiposDeapuesta.setForeground(Color.BLACK);
		//jLTiposDeapuesta.setFont(new Font("Consolas", 1, 16));
		jLTiposDeapuesta.setBounds(40, 225, 200, 20);
		this.add(jLTiposDeapuesta);
                
                jLInfoapuesta= new JLabel("15,14,13");
		jLInfoapuesta.setForeground(Color.BLACK);
		//jLInfoapuesta.setFont(new Font("Consolas", 1, 16));
		jLInfoapuesta.setBounds(300, 225, 100, 20);
		this.add(jLInfoapuesta);
                
                jLinfo= new JLabel("Para las docenas y columnas se especifica con un numero del 1 al 3.");
		jLinfo.setForeground(Color.BLACK);
		//jLinfo.setFont(new Font("", 1, 18));
		jLinfo.setBounds(40, 245, 450, 20);
		this.add(jLinfo);
                
                jLinfo= new JLabel("Para apuestas de altos o bajos se ingresa H para altos y L para bajos.");
		jLinfo.setForeground(Color.BLACK);
		//jLinfo.setFont(new Font("", 1, 18));
		jLinfo.setBounds(40, 275, 450, 20);
		this.add(jLinfo);
                
                jLinfo= new JLabel("Para apuestas de color se especifica con la inicial en minuscula, n o r.");
		jLinfo.setForeground(Color.BLACK);
		//jLinfo.setFont(new Font("", 1, 18));
		jLinfo.setBounds(40, 305, 450, 20);
		this.add(jLinfo);
                
                jLinfo= new JLabel("Para apuestas de Par se ingresa PAIR o impar ODD.");
		jLinfo.setForeground(Color.BLACK);
		//jLinfo.setFont(new Font("", 1, 18));
		jLinfo.setBounds(40, 335, 450, 20);
		this.add(jLinfo);

	}

}
