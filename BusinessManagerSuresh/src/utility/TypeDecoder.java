package utility;

import constant.Constant;

public class TypeDecoder {
    public static String decode(int i){
        if(i == Constant.CREDIT){
            return "Credit";
        }
        if(i == Constant.DEBIT){
            return "Debit";
        }
        if(i == Constant.DEBIT){
            return "Cash";
        }
        if(i == Constant.EXPANSE){
            return "Expanse";
        }
        if(i == Constant.PURCHASE){
            return "Purchase";
        }
        if(i == Constant.SALE){
            return "Sale";
        }
        if(i == Constant.PRODUCT){
            return "Product";
        }
        return null;
    }
}
