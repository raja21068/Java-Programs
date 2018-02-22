
public class QuestionsBean{
    private int questionId;
    private int subId;
    private String questions;
    private String remarks;


    /*Setter Methods*/
    public void setQuestionId(int questionId){
        this.questionId = questionId;
    }
    public void setSubId(int subId){
        this.subId = subId;
    }
    public void setQuestions(String questions){
        this.questions = questions;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    /*Getter Methods*/
    public int getQuestionId(){
        return this.questionId;
    }
    public int getSubId(){
        return this.subId;
    }
    public String getQuestions(){
        return this.questions;
    }
    public String getRemarks(){
        return this.remarks;
    }

    //@Override
    public String toString(){
        return "";
    }
}
