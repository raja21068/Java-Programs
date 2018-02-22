package database;

import bean.Account;
import constant.Constant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import utility.BillInfo;
import utility.DateFormatter;
import utility.TypeDecoder;

/**
 *
 * @author Jay Kumar
 */
public class DataManager {

    public static Connection conn;
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/suresh_shop", "root", "root");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }
                
    }
    
    public static void setProductHistory(int productId , DefaultTableModel tableModel , int quantityColumn , int AmountColumn, int DateColumn, int billColumn, int accountCol)throws Exception{
        String query = "SELECT * FROM transaction t , day d, account ac WHERE ac.ACCOUNT_ID=t.ACCOUNT_ID AND t.DAY_ID = d.DAY_ID AND t.PRODUCT_ID="+productId+" AND TYPE="+Constant.PURCHASE;
        System.out.println(query);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        int row = tableModel.getRowCount();
        for(int i=0;i<row;i++){
            tableModel.removeRow(0);
        }
        
        while(rs.next()){
            row = tableModel.getRowCount();
            tableModel.insertRow(row, new Object[]{});
            tableModel.setValueAt(rs.getDouble("QUANTITY"), row, quantityColumn);
            tableModel.setValueAt(rs.getDouble("AMOUNT"), row, AmountColumn);
            tableModel.setValueAt(DateFormatter.dateToStringDMY(rs.getDate("DAY")), row, DateColumn);
            tableModel.setValueAt(rs.getInt("SALE_PURCHASE_ID"), row, billColumn);
            String s = rs.getString("ACCOUNT_NAME");
            System.out.println(">> "+s);
            tableModel.setValueAt(s, row, accountCol);
        }
        System.out.println("ResultSet: "+row);
    }
    
    
    
       public static void setSelectAccountOnList(int accountId , JList accountsList){
        ListModel model =  accountsList.getModel();
        for(int i=0;i<model.getSize();i++){
            Account ac = (Account)model.getElementAt(i);
            if(ac.getAccountId() == accountId){
                accountsList.setSelectedIndex(i);
                break;
            }
        }
    }
    
    public static ArrayList<BillInfo> setBillHistory(int salePurchaseId , DefaultTableModel tableModel ,int quantityColumn,int productNameColumn, int amountColumn ,JLabel day , JList accountList)throws Exception{
        String query = "SELECT * FROM transaction t , day d , product p WHERE p.PRODUCT_ID=t.PRODUCT_ID AND t.DAY_ID = d.DAY_ID AND t.SALE_PURCHASE_ID="+salePurchaseId;
        System.out.println(query);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<BillInfo> list = new ArrayList<BillInfo>(); 
        int accountID = 0;
        
        while(rs.next()){
            int row=tableModel.getRowCount();
            tableModel.insertRow(tableModel.getRowCount(),new Object[]{});
            tableModel.setValueAt(row+1, row, 0);
            double quantity = rs.getDouble("QUANTITY");
            tableModel.setValueAt(quantity, row, quantityColumn);
            
            double rate = rs.getDouble("AMOUNT");
            tableModel.setValueAt(rate, row, amountColumn);
            tableModel.setValueAt((rate*quantity), row, 4);
            day.setText(""+ DateFormatter.dateToStringDMY(rs.getDate("DAY")));
            
            String productName = rs.getString("PRODUCT_NAME");
            int productId = rs.getInt("PRODUCT_ID");
            int transactionId = rs.getInt("TRANSACTION_ID");
            accountID = rs.getInt("ACCOUNT_ID");
            tableModel.setValueAt(new BillInfo(transactionId,productId ,productName, quantity, rate), row, productNameColumn);
            list.add(new BillInfo(transactionId,productId ,productName, quantity, rate));
        }
        setSelectAccountOnList(accountID, accountList);
        return list;
    }
        
    public static void setAccountHistory(int accountId , DefaultTableModel tableModel, int typeColumn , int paidCoulumn, int dateColumn, int billNColumn, int totalColumn)throws Exception{
        String query = "SELECT * FROM sale_purchase sp, day d  WHERE d.DAY_ID=sp.DAY_ID AND sp.ACCOUNT_ID="+accountId+" ORDER BY DAY DESC";
        System.out.println(query);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            int type = rs.getInt("TYPE");
            tableModel.insertRow(tableModel.getRowCount(),new Object[]{});
            tableModel.setValueAt(TypeDecoder.decode(type),tableModel.getRowCount()-1, typeColumn);
            tableModel.setValueAt(rs.getDouble("PAID_AMOUNT"),tableModel.getRowCount()-1 , paidCoulumn);
            tableModel.setValueAt(DateFormatter.dateToStringDMY(rs.getDate("DAY")),tableModel.getRowCount()-1 , dateColumn);
            if(type != Constant.DEBIT && type != Constant.CREDIT ){
                tableModel.setValueAt(rs.getInt("SALE_PURCHASE_ID"),tableModel.getRowCount()-1 , billNColumn);
            }
            tableModel.setValueAt(rs.getDouble("TOTAL_AMOUNT"),tableModel.getRowCount()-1 , totalColumn);
        }
    }

    public static void setAccountHistory(int accountId , String fromDate , String toDate,DefaultTableModel tableModel, int typeColumn , int paidCoulumn, int dateColumn, int billNColumn, int totalColumn)throws Exception{
        String query = "SELECT * FROM sale_purchase sp, day d  WHERE d.DAY_ID=sp.DAY_ID AND sp.ACCOUNT_ID="+accountId+" AND DAY>='"+fromDate+"' AND DAY<='"+toDate+"' ORDER BY DAY DESC";
        System.out.println(query);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            int type = rs.getInt("TYPE");
            tableModel.insertRow(tableModel.getRowCount(),new Object[]{});
            tableModel.setValueAt(TypeDecoder.decode(type),tableModel.getRowCount()-1, typeColumn);
            tableModel.setValueAt(rs.getDouble("PAID_AMOUNT"),tableModel.getRowCount()-1 , paidCoulumn);
            tableModel.setValueAt(DateFormatter.dateToStringDMY(rs.getDate("DAY")),tableModel.getRowCount()-1 , dateColumn);
            if(type != Constant.DEBIT && type != Constant.CREDIT ){
                tableModel.setValueAt(rs.getInt("SALE_PURCHASE_ID"),tableModel.getRowCount()-1 , billNColumn);
            }
            tableModel.setValueAt(rs.getDouble("TOTAL_AMOUNT"),tableModel.getRowCount()-1 , totalColumn);
        }
    }
    
    
    public static void setDaySummary(String fromDate , String toDate , DefaultTableModel tableModel, int ACCOUNT_COLUMN, int DATE_COLUMN, int TYPE_COLUMN, int PAID_AMOUNT_COLUMN, int TOTAL_AMOUNT_COLUMN, int CHEQUE_COLUMN ,int BILL_NO ,JTextField sales , JTextField purchase, JTextField profitTextField )throws Exception{
        String query = "SELECT * FROM sale_purchase sp, day d, account ac WHERE sp.DAY_ID=d.DAY_ID AND ac.ACCOUNT_ID=sp.ACCOUNT_ID AND DAY >= '"+fromDate+"' AND DAY <= '"+toDate+"'";
        System.out.println(query);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        double totalsale = 0;
        double totalpurch = 0;
        double profit = 0;
        
        while(rs.next()){
            int row = tableModel.getRowCount();
            tableModel.insertRow(row, new Object[]{});
            tableModel.setValueAt(rs.getString("ACCOUNT_NAME"), row, ACCOUNT_COLUMN);
            tableModel.setValueAt(DateFormatter.dateToStringDMY(rs.getDate("DAY")), row, DATE_COLUMN);
            tableModel.setValueAt(TypeDecoder.decode(rs.getInt("TYPE")), row, TYPE_COLUMN);
            tableModel.setValueAt(rs.getDouble("PAID_AMOUNT"), row, PAID_AMOUNT_COLUMN);
            tableModel.setValueAt(rs.getDouble("TOTAL_AMOUNT"), row, TOTAL_AMOUNT_COLUMN);
            int salePurchaseId = rs.getInt("SALE_PURCHASE_ID");
            
            String q = "SELECT *  FROM cheque WHERE SALE_PURCHASE_ID="+salePurchaseId;
            System.out.println(q);
            Statement state = conn.createStatement();
            ResultSet set = state.executeQuery(q);
            if(set.next()){
                tableModel.setValueAt(set.getDate("CHEQUE_DATE"), row, CHEQUE_COLUMN);
            }
            
            q = "SELECT * FROM transaction WHERE SALE_PURCHASE_ID="+salePurchaseId;
            System.out.println(q);
            Statement stats = conn.createStatement();
            ResultSet rset = stats.executeQuery(q);
            while(rset.next()){
                double quan = rset.getDouble("QUANTITY");
                double am = rset.getDouble("AMOUNT");
                double orig = rset.getDouble("PRODUCT_ORIGINAL_RATE");
                
                if(orig !=0){
                    double sold = quan*am;
                    double pur = quan*orig;
                    double pr = sold - pur;
                    profit += pr;
                    totalsale+=sold;
                }
                else{
                    double p = quan*am;
                    totalpurch+=p;
                }
            }
            
            tableModel.setValueAt(salePurchaseId, row, BILL_NO);
            profitTextField.setText(""+profit);
            sales.setText(""+totalsale);
            purchase.setText(""+totalpurch);
        }
    }
    
    public static void updateTransaction(int transactionId , double quantity , double price)throws Exception{
        String query = "UPDATE transaction SET QUANTITY="+quantity+" , AMOUNT="+price+"  WHERE TRANSACTION_ID="+transactionId;
        System.out.println(query);
        Statement st = conn.createStatement();
        st.executeUpdate(query);
    }
    
    public static void deleteTransaction(int transactionId)throws Exception{
        String query = "DELETE FROM transaction WHERE TRANSACTION_ID="+transactionId;
        System.out.println(query);
        Statement st = conn.createStatement();
        st.executeUpdate(query);
    }
    
    public static void updateSaleProduct(int productId , double quantity)throws Exception{
        String query = "UPDATE product SET QUANTITY=QUANTITY+("+quantity+")  WHERE  PRODUCT_ID="+productId;
        System.out.println(query);
        Statement st = conn.createStatement();
        st.executeUpdate(query);
    }
    
    public static void updatePurchaseProduct(int productId , double quantity)throws Exception{
        String query = "UPDATE product SET QUANTITY=QUANTITY-("+quantity+") WHERE PRODUCT_ID="+productId;
        System.out.println(query);
        Statement st = conn.createStatement();
        st.executeUpdate(query);
    }
    
    
    public static void createUser(String user , String password)throws Exception{
        String query = "CREATE USER '"+user+"'@'%' IDENTIFIED BY '"+password+"';";
        System.out.println(query);
        Statement st = conn.createStatement();
        if(st.execute(query)){
            System.out.println("Succesfully..");
        }
        query = "GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, RELOAD, SHUTDOWN, PROCESS, FILE, REFERENCES, INDEX, ALTER, SHOW DATABASES, SUPER, CREATE TEMPORARY TABLES, LOCK TABLES, REPLICATION SLAVE, REPLICATION CLIENT, CREATE VIEW, EVENT, TRIGGER, SHOW VIEW, CREATE ROUTINE, ALTER ROUTINE, CREATE USER, EXECUTE ON *.* TO '"+user+"'@'%' IDENTIFIED BY '"+password+"' WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0";
        if(st.execute(query)){
            System.out.println("Succesfully..");
        }
        query = "GRANT ALL PRIVILEGES ON `"+user+"\\_%`.* TO '"+user+"'@'%'";
        if(st.execute(query)){
            System.out.println("Succesfullt");
        }
    }
}
