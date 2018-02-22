package  tablesort;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SampleSortingTableModel extends AbstractTableModel implements TableModelListener {
  protected TableModel base;

  protected int sortColumn;

  protected int[] row;

  public SampleSortingTableModel(TableModel tm, int sortColumn) {
    this.base = tm;
    System.out.println("Base:"+base+" - tm:"+tm);
    this.sortColumn = sortColumn;
    tm.addTableModelListener(this);
    rebuild();
  }

  @Override
  public Class getColumnClass(int c) {
    return base.getColumnClass(c);
  }

  @Override
  public int getColumnCount() {
    return base.getColumnCount();
  }

  @Override
  public String getColumnName(int c) {
    return base.getColumnName(c);
  }

  @Override
  public int getRowCount() {
      return base.getRowCount();
  }

  @Override
  public Object getValueAt(int r, int c) {
    return base.getValueAt(row[r], c);
  }

  @Override
  public boolean isCellEditable(int r, int c) {
    return base.isCellEditable(row[r], c);
  }

  @Override
  public void setValueAt(Object value, int r, int c) {
    base.setValueAt(value, row[r], c); // Notification will cause re-sort
  }

  @Override
  public void tableChanged(TableModelEvent event) {
    rebuild();
  }

  protected void rebuild() {
    int size = base.getRowCount();
    row = new int[size];
    for (int i = 0; i < size; i++) {
      row[i] = i;
    }
    sort();
  }

  protected void sort() { // Sort and notify listeners
    for (int i = 1; i < row.length; i++) {
      int j = i;
      while (j > 0 && compare(j - 1, j) > 0) {
        int temp = row[j];
        row[j] = row[j - 1];
        row[j - 1] = temp;
        j--;
      }
    }
    fireTableStructureChanged();
  }

  protected int compare(int i, int j) {
    String s1 = base.getValueAt(row[i], sortColumn).toString();
    String s2 = base.getValueAt(row[j], sortColumn).toString();
    return s1.compareTo(s2);
  }
}