package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerView;
import logic.entities.Player;
import utils.Constants;

public class PanelPlayers extends JPanel {

	private static final long serialVersionUID = 1L;
	public DefaultTableModel playersTableModel;
	public JTable playersTable;
	public static Font typeFont = new Font("Arial", Font.ITALIC, 20);
	private JButton startSimulationBtn;

	public PanelPlayers(ControllerView controllerView) {
		setLayout(new BorderLayout());
		playersTableModel = new DefaultTableModel();
		playersTableModel.setColumnIdentifiers(new Object[]{"Nombre", "Dinero",});
		playersTable = new JTable(playersTableModel);
		add(new JScrollPane(playersTable), BorderLayout.CENTER);
		this.startSimulationBtn = new JButton("Iniciar Simulación");
		this.startSimulationBtn.addActionListener(controllerView);
		this.startSimulationBtn.setActionCommand(Constants.START_SIMULATION);
		add(this.startSimulationBtn, BorderLayout.SOUTH);
	}
	
	public int getSelectedPlaceId(){
		return (int) playersTable.getValueAt(playersTable.getSelectedRow(), 0);
	}
	
	public void fillPlayerList(ArrayList<Player> players){
		playersTableModel.setRowCount(0);
		for (Player player: players) {
			playersTableModel.addRow(player.toVector());
		}
	}

	public JButton getStartSimulationBtn() {
		return startSimulationBtn;
	}

	public void setStartSimulationBtn(JButton startSimulationBtn) {
		this.startSimulationBtn = startSimulationBtn;
	}
	
	
}
