/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scoutapp;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mccosky_890578
 */
public class MatchTableModel extends AbstractTableModel{
    
    private String[] headings = {"Match", "Competition", "Date", "Blue 1", "Blue 2", "Penalties", "Blue Score", "Red 1", "Red 2", "Penalties", "Red Score"};
    private String[][]  data;
    
    public MatchTableModel (String[][] tableData){
       data = tableData; 
    }
    
    @Override
    public String getColumnName(int col) {
        return headings[col];
    }
   
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return data[0].length;    
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       return data[rowIndex][columnIndex];
    }
}
