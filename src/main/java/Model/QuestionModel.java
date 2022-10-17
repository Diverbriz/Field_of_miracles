package Model;

public class QuestionModel {
    private String question;
    private String hint;
    private String[] answer;
    private String tmp;

    public QuestionModel(String question, String answer){
        this.question = question;
        tmp = answer;
        this.answer = answer.split("");
    }
    public QuestionModel(String question, String answer, String hint){
        this.question = question;
        tmp = answer;
        this.answer = answer.split("");
        this.hint = hint;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }
}
