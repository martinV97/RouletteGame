package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerView;
import logic.entities.Player;
import logic.entities.Round;

public class PanelResult extends JPanel{
	private static final long serialVersionUID = 1L;
	private DefaultTableModel roundResultModel;
	private JTable resultTable;
	public static Font typeFont = new Font("Arial", Font.ITALIC, 20);

	public PanelResult(ControllerView controller) {
		setLayout(new BorderLayout());
		roundResultModel = new DefaultTableModel();
		roundResultModel.setColumnIdentifiers(new Object[]{"Número", "Color"});
		resultTable = new JTable(roundResultModel);
		add(new JScrollPane(resultTable), BorderLayout.CENTER);
	}
	
	public int getSelectedPlaceId(){
		return (int) resultTable.getValueAt(resultTable.getSelectedRow(), 0);
	}
	
	public void fillRoundList(ArrayList<Round> roundList){
		roundResultModel.setRowCount(0);
		for (Round round: roundList) {
			roundResultModel.addRow(round.toVector());
		}
	}
}
