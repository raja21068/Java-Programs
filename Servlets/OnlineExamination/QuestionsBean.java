/*
* QuestionsBean.java
*
* Created on 17-Mar-2013 12:17:26 PM
*
*
* @author Raja Kumar
*/

public class QuestionsBean{
    private int subId;
    private int quesId;
    private String question;
    private String remarks;

    /*Constructor*/
    public QuestionsBean() {}

    /*Setter Methods*/
    public void setSubId(int subId){
        this.subId = subId;
    }
    public void setQuesId(int quesId){
        this.quesId = quesId;
    }
    public void setQuestion(String question){
        this.question = question;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    /*Getter Methods*/
    public int getSubId(){
        return this.subId;
    }
    public int getQuesId(){
        return this.quesId;
    }
    public String getQuestion(){
        return this.question;
    }
    public String getRemarks(){
        return this.remarks;
    }

    //@Override
    public String toString(){
        return "";
    }
}
