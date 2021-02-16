package me.pepe.appccounting;

import javax.swing.*;
import javax.swing.table.*;

public class Appccounting extends JFrame {

	public static final String VERSION = "1.0";

	// JFrame elements
	private JTable mainTable;
	private DefaultTableModel tableModel;
	private DefaultTableCellRenderer tableCellRenderer;
	private Object[][] tableData;
	private String[] tableHeadings;

	public Appccounting() {
		init();
		initUI();
	}

	private void init() {

		mainTable = new JTable();
	}

	private void initTable() {
		initTableModel(tableData, tableHeadings);
	}

	private void initTableModel(Object[][] tableData, Object[] tableHeadings) {
		tableModel = new DefaultTableModel(tableData, tableHeadings) {
			Class[] types = new Class[] { String.class, Integer.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		};
	}

	private void initUI() {
		initTable();

		setTitle("Appccounting - " + VERSION);
		setSize(500, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(mainTable);
	}

	public static void main(String[] args) {
		new Appccounting().setVisible(true);
	}

}
