

public class OptionsBean{
    private int optionId;
    private int questionId;
    private String optionName;
    private String correct;
    private String remarks;

   
    /*Setter Methods*/
    public void setOptionId(int optionId){
        this.optionId = optionId;
    }
    public void setQuestionId(int questionId){
        this.questionId = questionId;
    }
    public void setOptionName(String optionName){
        this.optionName = optionName;
    }
    public void setCorrect(String correct){
        this.correct = correct;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    /*Getter Methods*/
    public int getOptionId(){
        return this.optionId;
    }
    public int getQuestionId(){
        return this.questionId;
    }
    public String getOptionName(){
        return this.optionName;
    }
    public String getCorrect(){
        return this.correct;
    }
    public String getRemarks(){
        return this.remarks;
    }

    //@Override
    public String toString(){
        return "";
    }
}
