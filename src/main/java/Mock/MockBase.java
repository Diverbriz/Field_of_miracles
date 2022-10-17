package Mock;

import Model.QuestionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MockBase {
    private List<QuestionModel> questionList;
    private QuestionModel currentQuestion;
    public MockBase(){
        questionList = new ArrayList<>();

        questionList.add(new QuestionModel(
                "У этих животных, считающихся в некоторых странах деликатесом, зубы расположены на языке",
                "Улитка"));

        questionList.add(new QuestionModel(
                "В Чили находится самое крупное сооружение подобного типа. Его длина – 1 километр.",
                "Бассейн"
        ));

        questionList.add(new QuestionModel(
                "Это вкусное изделие появилось в средневековой Германии, а приобрело современный вид в начале 19 века",
                "Сосиска"
        ));
    }

    public void randomQuestion(){
        Random random = new Random();
        int randomNum = ThreadLocalRandom.current().nextInt(0, questionList.size());
        currentQuestion = questionList.get(randomNum);
    }

    public List<QuestionModel> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionModel> questionList) {
        this.questionList = questionList;
    }

    public QuestionModel getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(QuestionModel currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}
