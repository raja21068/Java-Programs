
public class TypeDecoder {
    public static String decode(int type){
         if(type==Constant.LEGAL)return "Legal";
         else if(type==Constant.PURPOSE_ADMIN)return "Admin";
         else if(type==Constant.PURPOSE_EXAM)return "Exam";
         else if(type==Constant.PURPOSE_SELF)return "Self";
         else if(type==Constant.SESSION_FALL)return "Fall";
         else if(type==Constant.SESSION_SPRING)return "Spring";
         else if(type==Constant.TEMPERARY)return "Temperary";
         else if(type==Constant.USED)return "Used";
         else if(type==Constant.PRE_ENGINEERING)return "Pre-Engineering";
         else if(type==Constant.PRE_MEDICAL)return "Pre-Medical";
         else if(type==Constant.COMMERCE)return "Commerce";
         else if(type==Constant.NO_GROUP)return "No Group";
         else if(type==Constant.MORNING)return "Morning";
         else if(type==Constant.EVENING)return "Evening";
         else if(type==Constant.NOON)return "Noon";
         return "";
    }
}
