package Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionModelTest {

    @Test
    public void getEqualsStringToCharAnswer() {
        QuestionModel questionModel = new QuestionModel("1",
                "12345");
        String[] str = questionModel.getTmp().split("");
        assertEquals(str, questionModel.getAnswer());
    }

    @Test
    public void setQuestion() {
    }

    @Test
    public void getAnswer() {
    }

    @Test
    public void setAnswer() {
    }

    @Test
    public void getTmp() {

    }

    @Test
    public void setTmp() {
    }
}