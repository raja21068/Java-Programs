
public class BooleanConvert {
    public static boolean toBoolean(String b){
        if(b.equals("yes")){
            return true;
        }
        else if(b.equals("no")){
            return false;
        }
        return false;
    }
}
