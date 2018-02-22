package utility;

import constant.Constant;


public class TypeEncoder {
    public static int encode(String s){
        if(s.equals("Purchase")){
            return Constant.PURCHASE;
        }
        if(s.equals("Sale")){
            return Constant.SALE;
        }
        if(s.equals("Expanse")){
            return Constant.EXPANSE;
        }
        if(s.equals("Cash")){
            return Constant.DEBIT;
        }
        if(s.equals("Credit")){
            return Constant.CREDIT;
        }
        if(s.equals("Product")){
            return Constant.PRODUCT;
        }
        
        return 0;
    }
}
