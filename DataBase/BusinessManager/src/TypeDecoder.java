public class TypeDecoder {
    public static String typeDecode(int i){
        if(i == Constant.CREDIT){
            return "Credit";
        }
        if(i == Constant.DEBIT){
            return "Debit";
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
