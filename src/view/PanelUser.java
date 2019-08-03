package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControllerView;
import utils.Constants;

public class PanelUser extends JPanel {
	private JLabel nameLbl;
	private JTextField nameTxt;
	private JLabel initialMoneyLbl;
	private JTextField initialMoneyTxt;
	private JButton enterRouletteBtn;
	private JLabel betTypeLbl;
	private JComboBox<String> betTypeBox;
	private JLabel betMoneyLbl;
	private JTextField betMoneyTxt;
	private JLabel informationBetLbl;
	private JTextField informationBetTxt;
	private JButton sendBet;
	private ControllerView controllerView;
	
	public PanelUser(ControllerView controllerView){
		this.setLayout(new GridLayout(4, 4));
		this.controllerView = controllerView;
		startComponents();
	}

	private void startComponents() {
		this.nameLbl = new JLabel("Nombre jugador:");
		this.add(this.nameLbl);
		this.nameTxt = new JTextField();
		this.add(this.nameTxt);
		this.initialMoneyLbl = new JLabel("Cantidad de dinero:");
		this.add(this.initialMoneyLbl);
		this.initialMoneyTxt = new JTextField();
		this.add(this.initialMoneyTxt);
		this.enterRouletteBtn = new JButton("Entrar");
		this.enterRouletteBtn.addActionListener(controllerView);
		this.enterRouletteBtn.setActionCommand(Constants.ENTER_PLAYER);
		this.add(this.enterRouletteBtn);
		this.betTypeLbl = new JLabel("Tipo de Apuesta:");
		this.add(this.betTypeLbl);
		this.betTypeBox = new JComboBox<>();
		setBetTypesToComboBox();
		this.betTypeBox.setEnabled(false);
		this.add(this.betTypeBox);
		this.add(new JLabel());
		this.betMoneyLbl = new JLabel("Cantidad a apostar:");
		this.add(this.betMoneyLbl);
		this.betMoneyTxt = new JTextField();
		this.betMoneyTxt.setEnabled(false);
		this.add(this.betMoneyTxt);
		this.informationBetLbl = new JLabel("Información adicional de la apuesta:");
		this.add(this.informationBetLbl);
		this.informationBetTxt = new JTextField();
		this.informationBetTxt.setEnabled(false);
		this.add(this.informationBetTxt);
		this.sendBet = new JButton("Apostar");
		this.sendBet.setEnabled(false);
		this.sendBet.addActionListener(this.controllerView);
		this.sendBet.setActionCommand(Constants.SEND_BET);
		this.add(this.sendBet);
	}

	private void setBetTypesToComboBox() {
		this.betTypeBox.addItem("Color");
		this.betTypeBox.addItem("Par o Impar");
		this.betTypeBox.addItem("Columna");
		this.betTypeBox.addItem("Docena");
		this.betTypeBox.addItem("Altos y Bajos");
		this.betTypeBox.addItem("Apuesta Sencilla");
		this.betTypeBox.addItem("Apuesta Dividida");
		this.betTypeBox.addItem("Apuesta cuádruple");
		this.betTypeBox.addItem("Apuesta de línea");
	}

	public void updateFields(){
		this.initialMoneyTxt.setEnabled(false);
		this.nameTxt.setEnabled(false);
		this.betTypeBox.setEnabled(true);
		this.betMoneyTxt.setEnabled(true);
		this.informationBetTxt.setEnabled(true);
		this.sendBet.setEnabled(true);
	}
	
	public void clearBetFields() {
		this.betMoneyTxt.setText("");
		this.informationBetTxt.setText("");
		this.informationBetTxt.setText("");
		this.sendBet.setEnabled(false);
	}

	public JLabel getNameLbl() {
		return nameLbl;
	}

	public void setNameLbl(JLabel nameLbl) {
		this.nameLbl = nameLbl;
	}

	public JTextField getNameTxt() {
		return nameTxt;
	}

	public void setNameTxt(JTextField nameTxt) {
		this.nameTxt = nameTxt;
	}

	public JLabel getInitialMoneyLbl() {
		return initialMoneyLbl;
	}

	public void setInitialMoneyLbl(JLabel initialMoneyLbl) {
		this.initialMoneyLbl = initialMoneyLbl;
	}

	public JTextField getInitialMoneyTxt() {
		return initialMoneyTxt;
	}

	public void setInitialMoneyTxt(JTextField initialMoneyTxt) {
		this.initialMoneyTxt = initialMoneyTxt;
	}

	public JLabel getBetTypeLbl() {
		return betTypeLbl;
	}

	public void setBetTypeLbl(JLabel betTypeLbl) {
		this.betTypeLbl = betTypeLbl;
	}

	public JComboBox<String> getBetTypeBox() {
		return betTypeBox;
	}

	public void setBetTypeBox(JComboBox<String> betTypeBox) {
		this.betTypeBox = betTypeBox;
	}

	public JLabel getBetMoneyLbl() {
		return betMoneyLbl;
	}

	public void setBetMoneyLbl(JLabel betMoneyLbl) {
		this.betMoneyLbl = betMoneyLbl;
	}

	public JTextField getBetMoneyTxt() {
		return betMoneyTxt;
	}

	public void setBetMoneyTxt(JTextField betMoneyTxt) {
		this.betMoneyTxt = betMoneyTxt;
	}

	public JLabel getInformationBetLbl() {
		return informationBetLbl;
	}

	public void setInformationBetLbl(JLabel informationBetLbl) {
		this.informationBetLbl = informationBetLbl;
	}

	public JTextField getInformationBetTxt() {
		return informationBetTxt;
	}

	public void setInformationBetTxt(JTextField informationBetTxt) {
		this.informationBetTxt = informationBetTxt;
	}

	public JButton getSendBet() {
		return sendBet;
	}

	public void setSendBet(JButton sendBet) {
		this.sendBet = sendBet;
	}

	public ControllerView getControllerView() {
		return controllerView;
	}

	public void setControllerView(ControllerView controllerView) {
		this.controllerView = controllerView;
	}

	public JButton getEnterRouletteBtn() {
		return enterRouletteBtn;
	}

	public void setEnterRouletteBtn(JButton enterRouletteBtn) {
		this.enterRouletteBtn = enterRouletteBtn;
	}
	
	
}
