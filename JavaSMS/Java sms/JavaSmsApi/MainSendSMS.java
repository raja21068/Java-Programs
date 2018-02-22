class MainSendSMS{
public static void main(String arg[])throws Exception{

        SerialToGsm stg = new SerialToGsm("COM19");

        String retStr = new String("");
        String sss = new String();
        String alarmNumber = new String("+923332836704");   // a real phone number here

      
        // send a message
        sss = stg.sendSms(alarmNumber,"Hello GSM World");
              

/*
        retStr = stg.checkSms();
        if (retStr.indexOf("ERROR") == -1) {
            System.out.println("Phone # of sender: " + stg.readSmsSender());
            System.out.println("Recv'd SMS message: " + stg.readSms());
        }
*/

  }//end main
}//end class
