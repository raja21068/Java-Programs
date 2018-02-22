/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablesort;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JAY KUMAR
 */
public class Handler {
    static Class[] classes;
    static boolean[] canEdit;
    public synchronized static void emptyTable(JTable table){
        int rows = table.getRowCount();
        if(rows<1)return;
        AbstractTableModel model = (AbstractTableModel)table.getModel();
        int columns = model.getColumnCount();
        classes = new Class[columns];
        canEdit = new boolean[columns];
        String[] names = new String[columns];
        for(int i=0;i<columns;i++){
            classes[i]=model.getColumnClass(i);
            canEdit[i] = model.isCellEditable(0, i);
            names[i] = model.getColumnName(i);
        }
        
        table.setModel(getDefaultTableModel(names, classes, canEdit));
    }
    
    public static DefaultTableModel getDefaultTableModel(String[] columns,Class[] classes,boolean[] canEditable){
        
        return new DefaultTableModel( new Object [][] {},columns) 
        {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
    } 
    
}
