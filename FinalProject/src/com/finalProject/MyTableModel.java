package com.finalProject;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	 /**
	 * 
	 */
	private static final long serialVersionUID = -6530966728014204008L;
	private String[] columnNames = {"First Name","Last Name","Address","City","State","zip","Country","Phone","Email"};
	private Object[][] data = {
	{null,null,null,null,null,null,null,null,null}
	};
	public MyTableModel(String[] columnNames) {
		this.columnNames = columnNames;
	}
	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}
	public String[] getColumnNames() {
		return this.columnNames;
	}
	public void setDataValues(Object[][] data) {
		this.data = data;
	}
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public int getRowCount() {
		return data.length;
	}
	
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	public void refresh(int row,int col) {
		fireTableCellUpdated(row, col);
	}
	/*
	public void setValueAt(Object value, int row, int col) {		
		data[row][col] = value;
		fireTableCellUpdated(row, col);
		
	}
	*/
	
}
