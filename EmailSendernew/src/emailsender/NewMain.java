/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emailsender;

/**
 *
 * @author JAY KUMAR
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      	GMailSender mailsender = new GMailSender("perfectmaster123@gmail.com", "perfectmaster");
        
             	 String[] toArr = { "raja21068@facebook.com", "jay_tharwani1992@yahoo.com" };
                 
                mailsender.set_to(toArr);
                mailsender.set_from("perfectmaster123@gmail.com");
                mailsender.set_subject("This is an email sent using my Mail JavaMail wrapper from an Android device.");
                mailsender.setBody("Email body.");

                try {
                    mailsender.addAttachment("D:/raja.txt");

                    if (mailsender.send()) {
                        System.out.println("Email was  sent sucessfully");
                        
                    } else {
                        System.out.println("Email was not sent sucessfully");
                        
                    }
                } catch (Exception e) {
                    
                  System.out.println("Email was not sent sucessfully");
                        }
       
   }
}
