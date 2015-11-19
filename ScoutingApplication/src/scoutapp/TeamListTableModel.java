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
public class TeamListTableModel extends AbstractTableModel{
    
    private String[] headings = {"Number", "Name"};
    private String[][]  data;
    
    public TeamListTableModel (String[][] tableData){
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
    
    //MOVE OUT OF HERE! 
    /*public void addMatch(String[] matchData) {
        for (int i = 0; i < getColumnCount(); i++){
            data[getRowCount()][i] = matchData[i];
        }
    }*/

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       return data[rowIndex][columnIndex];
    }
}

