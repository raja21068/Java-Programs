/*
* OptionsBean.java
*
* Created on 17-Mar-2013 12:17:25 PM
*
*
* @author Raja Kumar
*/

public class OptionsBean{
    private int quesId;
    private int opId;
    private String opName;
    private String correct;
    private String remarks;

    /*Constructor*/
    public OptionsBean() {}

    /*Setter Methods*/
    public void setQuesId(int quesId){
        this.quesId = quesId;
    }
    public void setOpId(int opId){
        this.opId = opId;
    }
    public void setOpName(String opName){
        this.opName = opName;
    }
    public void setCorrect(String correct){
        this.correct = correct;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    /*Getter Methods*/
    public int getQuesId(){
        return this.quesId;
    }
    public int getOpId(){
        return this.opId;
    }
    public String getOpName(){
        return this.opName;
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
