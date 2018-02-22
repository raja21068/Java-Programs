
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DatabaseManager {
    private static Connection con;
    static {
        try{
            
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=data.mdb");
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection failed with database...");
        }
    }
    
// **** YEAR *****    
    public static ArrayList getYears()throws Exception{
        String sql = "SELECT * from years ORDER by year DESC";
        System.out.println(sql);
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);
        ArrayList<YearBean> list = new ArrayList();
        while(result.next()){
            YearBean bean = new YearBean();
            bean.setYearId(result.getInt("year_id"));
            bean.setYear(result.getInt("year"));
            bean.setCurrentAmount(result.getInt("current_amount"));
            bean.setRemarks(result.getString("remarks"));
            list.add(bean);
        }
        return list;
    }
    public static int addYear(int year, int currentAmount , String remarks)throws Exception{
        String sql = "INSERT into years (year , current_amount , remarks) values ( "+year+" , "+currentAmount+" , '"+remarks+"' ) ";
        System.out.println(sql);
        Statement st = con.createStatement();
        int result = st.executeUpdate(sql);
        
        return result;
    }
    public static int updateYear(int yearId ,int year, int currentAmount , String remarks)throws Exception{
        String sql = "Update years SET  year = "+year+" , current_amount = "+currentAmount+" , remarks = '"+remarks+"'  where year_id = "+yearId;
        System.out.println(sql);
        Statement st = con.createStatement();
        int result = st.executeUpdate(sql);
        return result;
    }
    public static int deleteYear(int id)throws Exception{
        String sql = "DELETE from years where year_id = "+id;
        System.out.println(sql);
        Statement st = con.createStatement();
        int result = st.executeUpdate(sql);
        return result;
    }

// **** ACCOUNTS *****    
    public static ArrayList getAccounts()throws Exception{
        String sql = "SELECT * from accounts Order by account_name ASC";
        System.out.println(sql);
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);
        ArrayList<AccountBean> list = new ArrayList();
        while(result.next()){
            AccountBean bean = new AccountBean();
            bean.setAccountId(result.getInt("account_id"));
            bean.setAccountName(result.getString("account_name"));
            bean.setAddress(result.getString("address"));
            bean.setAccountType(result.getInt("account_type"));
            bean.setRemarks(result.getString("remarks"));
            list.add(bean);
        }
        return list;
    }
    public static ArrayList getAccounts(int type)throws Exception{
        String sql = "SELECT * from accounts where account_type = "+type;
        System.out.println(sql);
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);
        ArrayList<AccountBean> list = new ArrayList();
        while(result.next()){
            AccountBean bean = new AccountBean();
            bean.setAccountId(result.getInt("account_id"));
            bean.setAccountName(result.getString("account_name"));
            bean.setAddress(result.getString("address"));
            bean.setAccountType(result.getInt("account_type"));
            bean.setRemarks(result.getString("remarks"));
            list.add(bean);
        }
        return list;
    }
    public static int addAccount(String account_name, String address , int account_type ,String remarks)throws Exception{
        String sql = "INSERT into accounts (account_name , address ,account_type ,remarks) values ( '"+account_name+"' , '"+address+"' ,"+account_type+"  ,'"+remarks+"' ) ";
        System.out.println(sql);
        Statement st = con.createStatement();
        int result = st.executeUpdate(sql);      
        return result;
    }
    public static int updateAccount(int accountId , String account_name, String address , int account_type ,String remarks)throws Exception{
        String sql = "Update accounts SET account_name = '"+account_name+"' ,address = '"+address+"' , account_type = "+account_type+" ,remarks = '"+remarks+"'  where account_id = "+accountId;
        System.out.println(sql);
        Statement st = con.createStatement();
        int result = st.executeUpdate(sql);
        return result;
    }
    public static int deleteAccount(int id)throws Exception{
        String sql = "DELETE from accounts where account_id = "+id;
        System.out.println(sql);
        Statement st = con.createStatement();
        int result = st.executeUpdate(sql);
        return result;
    }
    
// **** PRODUCTS *****    
    public static ArrayList getProducts()throws Exception{
        String sql = "SELECT * from products";
        System.out.println(sql);
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);
        ArrayList<ProductBean> list = new ArrayList();
        while(result.next()){
            ProductBean bean = new ProductBean();
            bean.setProductId(result.getInt("product_id"));
            bean.setProductName(result.getString("product_name"));
            bean.setQuantity(result.getInt("quantity"));
            bean.setRate(result.getInt("rate"));
            bean.setRemarks(result.getString("remarks"));
            list.add(bean);
        }
        return list;
    }
    public static int addProduct(String product_name, int quantity , int rate ,String remarks)throws Exception{
        String sql = "INSERT into products ( product_name , quantity ,rate ,remarks) values ( '"+product_name+"' , "+quantity+" ,"+rate+"  ,'"+remarks+"' ) ";
        System.out.println(sql);
        Statement st = con.createStatement();
        int result = st.executeUpdate(sql);      
        return result;
    }
    public static int updateProduct(int productId , String product_name, int quantity , int rate ,String remarks)throws Exception{
        String sql = "Update products SET product_name = '"+product_name+"' ,quantity = "+quantity+" , rate = "+rate+" ,remarks = '"+remarks+"' where product_id = "+productId;
        System.out.println(sql);
        Statement st = con.createStatement();
        int result = st.executeUpdate(sql);
        return result;
    }
    public static int deleteProduct(int id)throws Exception{
        String sql = "DELETE from products where product_id = "+id;
        System.out.println(sql);
        Statement st = con.createStatement();
        int result = st.executeUpdate(sql);
        return result;
    }
    
// **** DAY *****
     public static ArrayList getDays(int yearId)throws Exception{
        String sql = "SELECT * from days where year_id ="+yearId+" ORDER by day DESC";
        System.out.println(sql);
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);
        ArrayList<DayBean> list = new ArrayList();
        while(result.next()){
            DayBean bean = new DayBean();
            bean.setYearId(result.getInt("year_id"));
            bean.setDayId(result.getInt("day_id"));
            bean.setDay(result.getDate("day"));
            bean.setClosingBalance(result.getInt("closing_balance"));
            bean.setClosed(result.getBoolean("closed"));
            bean.setRemarks(result.getString("remarks"));
            list.add(bean);
        }
        return list;
    }
     public static DayBean getLastDay(int yearId)throws Exception{
         String sql = " SELECT * from days where year_id = "+yearId+" ORDER by day DESC ";
        System.out.println(sql);
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);
        ArrayList<DayBean> list = new ArrayList<DayBean>();
        while(result.next()){
            DayBean bean = new DayBean();
            bean.setYearId(result.getInt("year_id"));
            bean.setDayId(result.getInt("day_id"));
            bean.setDay(result.getDate("day"));
            bean.setClosingBalance(result.getInt("closing_balance"));
            bean.setClosed(result.getBoolean("closed"));
            bean.setRemarks(result.getString("remarks"));
            list.add(bean);
        }
        if(list.size()>0)
        return list.get(0);
        else return null;
     }
     public static DayBean getLastDay()throws Exception{
        String sql = " SELECT * from days ORDER by day DESC";
        System.out.println(sql);
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);
        DayBean bean = new DayBean();
        if(result.next()){
            bean.setYearId(result.getInt("year_id"));
            bean.setDayId(result.getInt("day_id"));
            bean.setDay(result.getDate("day"));
            bean.setClosingBalance(result.getInt("closing_balance"));
            bean.setClosed(result.getBoolean("closed"));
            bean.setRemarks(result.getString("remarks"));
        }
        return bean;
     }
    public static int addDay(int year_id ,String day, int closing_balance ,String remarks)throws Exception{
        String sql = "INSERT INTO days ( year_id, [day], closing_balance, remarks ) values ( "+year_id +" , #"+day+"# ,"+closing_balance+"  ,'"+remarks+"' ) ";
        System.out.println(sql);
        Statement st = con.createStatement();
        int result = st.executeUpdate(sql);      
        return result;
    }
    public static int updateDay(int year_id, int dayId ,String day, int closing_balance ,boolean close,String remarks)throws Exception{
        String sql = "Update days SET year_id = "+year_id +" , [day] = #"+day+"# , closing_balance = "+closing_balance+",closed = "+close+" ,remarks = '"+remarks+"' where day_id = "+dayId;
        System.out.println(sql);
        Statement st = con.createStatement();
        int result = st.executeUpdate(sql);
        return result;
    }
    public static int deleteDay(int id)throws Exception{
        String sql = "DELETE from days where day_id = "+id;
        System.out.println(sql);
        Statement st = con.createStatement();
        int result = st.executeUpdate(sql);
        return result;
    }

    public static boolean isBillNumberExist(String billNo)throws Exception {
        String sql = "SELECT bill_no from sale_purchase";
        System.out.println(sql);
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);
        while(result.next()){
            if(result.getString("bill_no").equals(billNo)){
                return true;
            }
        }
        return false;
    }
    public static int addSalePurchase(int dayId, int accountId ,String billNo, int totalAmount , int type , String remarks)throws Exception{
        String sql="INSERT into sale_purchase ( day_id , account_id , bill_no , total_amount , type , remarks) values ("+dayId+" , "+accountId+" , '"+billNo+"', "+totalAmount+" , "+type+" , '"+remarks+"' )";
        System.out.println(sql);
        Statement st = con.createStatement();
        int i = st.executeUpdate(sql);
        sql = "SELECT MAX(sale_purchase_id) AS id FROM sale_purchase";
        System.out.println(sql);
        i=0;
        ResultSet result = st.executeQuery(sql);
        if(result.next()){
           i = result.getInt("id");
        }
        return i;   
    }
       
    public static int addTranction(int salePurchaseId, int productId ,int quantity , int amount ,int type )throws Exception{
        String sql="INSERT into transactions (sale_purchase_id , product_id , quantity ,amount , type ) values ( "+salePurchaseId+", "+productId+" , "+quantity+" , "+amount+" , "+type+")";
        System.out.println(sql);
        int i=0;
        Statement st = con.createStatement();
        int r = st.executeUpdate(sql);
            return r;
    }
    public static int updateProductQuantity(int productId , int quantity)throws Exception{
        String sql="UPDATE products SET quantity = "+quantity+" where product_id = "+productId+" ";
        System.out.println(sql);
        Statement st = con.createStatement();
        int r = st.executeUpdate(sql);
        return r;
    }
    public static int updateCurrentAmount(int yearId , int amount)throws Exception{
        String sql="UPDATE years SET current_amount = "+amount+" where year_id = "+yearId+" ";
        System.out.println(sql);
        Statement st = con.createStatement();
        int r = st.executeUpdate(sql);
        return r;
    }
    public static int addCashTransaction(int dayId , int accountId , int salePurchaseId ,int amount ,int type )throws Exception{
        String sql="INSERT into transactions (day_id , account_id , sale_purchase_id, amount , type ) values ( "+dayId+" , "+accountId+" , "+salePurchaseId+" , "+amount+" , "+type+" )";
        System.out.println(sql);
        Statement st = con.createStatement();
        int r = st.executeUpdate(sql);
        return r;
    }
    public static SalePurchaseBean getSalePurchase(String billNo)throws Exception{
        String sql = "SELECT * from sale_purchase where bill_no = '"+billNo+"'";
        System.out.println(sql);
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);

        SalePurchaseBean bean = new SalePurchaseBean(); 
        if(result.next()){
            bean.setSalePuchaseId(result.getInt("sale_purchase_id"));
            bean.setAccountId(result.getInt("account_id"));
            bean.setDayId(result.getInt("day_id"));
            bean.setTotalAmount(result.getInt("total_amount"));
        }
        if(bean.getSalePuchaseId()!=0){
            sql = "SELECT day from days where day_id = "+bean.getDayId();
            result = st.executeQuery(sql);
            if(result.next()){
                bean.setDay(result.getDate("day"));
            }
        }
        return bean;
    }
    public static java.util.ArrayList<TransactionBean> getTransactions(int salePurchaseId)throws Exception{
        String sql = "SELECT * from transactions where sale_purchase_id ="+salePurchaseId;
        System.out.println(sql);
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);
        
        java.util.ArrayList<TransactionBean> list = new java.util.ArrayList<TransactionBean>();
        while(result.next()){
            TransactionBean bean = new TransactionBean();
            bean.setAccountId(result.getInt("account_id"));
            bean.setAmount(result.getInt("amount"));
            bean.setDayId(result.getInt("day_id"));
            bean.setProductId(result.getInt("product_id"));
            bean.setQuantity(result.getInt("quantity"));
            bean.setType(result.getInt("type"));
            list.add(bean);
        }
        return list;
    }
    public static java.util.ArrayList getSalePurchases(int dayId)throws Exception{
        String sql = "SELECT * from sale_purchase where day_id = "+dayId;
        System.out.println(sql);
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);
        java.util.ArrayList list = new java.util.ArrayList();
        while(result.next()){
            SalePurchaseBean bean = new SalePurchaseBean();
            bean.setAccountId(result.getInt("account_id"));
            bean.setBillNo(result.getString("bill_no"));
            bean.setTotalAmount(result.getInt("total_amount"));
            bean.setType(result.getInt("type"));
            bean.setRemarks(result.getString("remarks"));
            list.add(bean);
        }
        return list;
    }
    public static DayBean getPreviousDayOf(String day)throws Exception{
        String sql = " SELECT * from days where day<#"+day+"# ORDER by day DESC";
        System.out.println(sql);
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);
        DayBean bean = new DayBean();
        if(result.next()){
            bean.setYearId(result.getInt("year_id"));
            bean.setDayId(result.getInt("day_id"));
            bean.setDay(result.getDate("day"));
            bean.setClosingBalance(result.getInt("closing_balance"));
            bean.setClosed(result.getBoolean("closed"));
            bean.setRemarks(result.getString("remarks"));
        }
        return bean;
     }
    public static java.util.ArrayList getAccountDetailDatewise(int accountId, String fromDate, String toDate)throws Exception{
        String sql = "SELECT * from days d, transactions t where d.day>=#"+fromDate+"# AND d.day<=#"+toDate+"# AND d.day_id=t.day_id AND t.account_id="+accountId;
        System.out.println(sql);
        java.util.ArrayList v = new java.util.ArrayList();
        
            Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                TransactionBean bean = new TransactionBean();
                
                bean.setDate(rs.getDate("day"));
                bean.setAmount(rs.getInt("amount"));
                bean.setType(rs.getInt("type"));
                
                v.add(bean);
            
        }
        
        return v;
    }
    public static java.util.ArrayList getAccountYearlyTransactions(int accountId , int yearId)throws Exception{
        String sql = "SELECT * from days d, transactions t where d.year_id="+yearId+" AND d.day_id=t.day_id AND t.account_id="+accountId;
        System.out.println(sql);
        java.util.ArrayList v = new java.util.ArrayList();
        
            Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                TransactionBean bean = new TransactionBean();
                
                bean.setDate(rs.getDate("day"));
                bean.setAmount(rs.getInt("amount"));
                bean.setType(rs.getInt("type"));
                
                v.add(bean);
            
        }
        
        return v;
    }
//    public static java.util.ArrayList getAccountDetailYearly(int accountId , int yearId)throws Exception{
//        String sql = "SELECT * from years y, days d, transactions t where y.year_id=d.year_id AND d.day_id=t.day_id AND t.account_id="+accountId+" AND y.year_id ="+yearId;
//        System.out.println(sql);
//        java.util.ArrayList v = new java.util.ArrayList();
//        
//            Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql);
//            while(rs.next()){
//                TransactionBean bean = new TransactionBean();
//                
//                bean.setDate(rs.getDate("day"));
//                bean.setAmount(rs.getInt("amount"));
//                bean.setType(rs.getInt("type"));
//                
//                v.add(bean);
//            
//        }
//        
//        return v;
//    }
    public static java.util.ArrayList getYearlySalePurchase(int yearId)throws Exception{
        String sql = "SELECT * from sale_purchase s , days d , years y where y.year_id=d.year_id AND d.day_id=s.day_id AND y.year_id="+yearId;
        System.out.println(sql);
        java.util.ArrayList v = new java.util.ArrayList();
        
            Statement st = con.createStatement(); 
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                SalePurchaseBean bean = new SalePurchaseBean();
                
                bean.setDay(rs.getDate("day"));
                bean.setTotalAmount(rs.getInt("total_amount"));
                bean.setType(rs.getInt("type"));
                
                v.add(bean);
            
        }
        
        return v;
    }
    public static java.util.ArrayList getDatewiseSalePurchase(String fromDate , String toDate)throws Exception{
        String sql = "SELECT * from sale_purchase s , days d where d.day>=#"+fromDate+"# AND d.day<=#"+toDate+"# AND d.day_id=s.day_id";
        System.out.println(sql);
         java.util.ArrayList v = new java.util.ArrayList();
        
         Statement st = con.createStatement(); 
         ResultSet rs = st.executeQuery(sql);
         while(rs.next()){
             SalePurchaseBean bean = new SalePurchaseBean();
             bean.setTotalAmount(rs.getInt("total_amount"));
             bean.setType(rs.getInt("type"));
             bean.setDay(rs.getDate("day"));
             v.add(bean);
         }
         return v;
    }
    public static int addAccounSummary(int yearId,int accountId, int amount, int type , String remarks)throws Exception{
        String sql = "INSERT into account_summary (year_id, account_id, amount, type, remarks) values ("+yearId+" ,"+accountId+" ,"+amount+"  ,"+type+"  ,'"+remarks+"')";
        System.out.println(sql);
        Statement st = con.createStatement();
        int i = st.executeUpdate(sql);
        return i;
    }
    public static java.util.ArrayList getSalePurchase(int accountId , int yearId)throws Exception{
        String sql = "SELECT * from sale_purchase s , days  d  where d.year_id="+yearId+" AND d.day_id =s.day_id AND s.account_id = "+accountId;
        System.out.println(sql);
        
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);
        
        java.util.ArrayList list = new java.util.ArrayList();
        while(result.next()){
            SalePurchaseBean bean = new SalePurchaseBean();
            bean.setDay(result.getDate("day"));
            bean.setTotalAmount(result.getInt("total_amount"));
            bean.setType(result.getInt("type"));
            list.add(bean);
        }
        
        return list;
    }
    public static AccountSummaryBean getAccountSummary(int accountId , int yearId)throws Exception{
        String sql = "SELECT * from account_summary where account_id = "+accountId+" AND year_id ="+ yearId;
        System.out.println(sql);
        AccountSummaryBean bean = new AccountSummaryBean();
        int i=0;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            i=rs.getInt("amount");
            i++;
            bean.setType(rs.getInt("type"));
        }
        bean.setAmount(i);
        return bean;
    }
    public static int updateAccountSummary(int yearId,int accountId, int amount, int type , String remarks)throws Exception{
        String sql = "UPDATE account_summary SET  amount = "+amount+" , type = "+type+" , remarks = '"+remarks+"' where year_id = "+yearId+" AND account_id = "+accountId;
        System.out.println(sql);
        Statement st = con.createStatement();
        int i = st.executeUpdate(sql);
        return i;
    }
}

