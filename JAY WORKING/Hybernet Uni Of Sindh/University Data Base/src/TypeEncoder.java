
public class TypeEncoder {
    public static int encode(String type){
     if(type.equals("Legal"))return Constant.LEGAL;
     else if(type.equals("Admin"))return Constant.PURPOSE_ADMIN;
     else if(type.equals("Exam"))return Constant.PURPOSE_EXAM;
     else if(type.equals("Self"))return Constant.PURPOSE_SELF;
     else if(type.equals("Fall"))return Constant.SESSION_FALL;
     else if(type.equals("Spring"))return Constant.SESSION_SPRING;
     else if(type.equals("Temperary"))return Constant.TEMPERARY;
     else if(type.equals("Used"))return Constant.USED;
     else if(type.equals("Pre-Engineering"))return Constant.PRE_ENGINEERING;
     else if(type.equals("Pre-Medical"))return Constant.PRE_MEDICAL;
     else if(type.equals("Commerce"))return Constant.COMMERCE;
     else if(type.equals("No Group"))return Constant.NO_GROUP;
     else if(type.equals("Morning"))return Constant.MORNING;
     else if(type.equals("Evening"))return Constant.EVENING;
     else if(type.equals("Noon"))return Constant.NOON;
     
     return 0;
   }
}
