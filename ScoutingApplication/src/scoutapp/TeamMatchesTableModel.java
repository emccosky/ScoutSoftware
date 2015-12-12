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
public class TeamMatchesTableModel extends AbstractTableModel{
    
    private String[] headings = {"Match", "Competition", "B1", "B2", "BScore", "R1", "R2", "RScore"};
    private String[][]  data;
    
    public TeamMatchesTableModel (String[][] tableData){
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
