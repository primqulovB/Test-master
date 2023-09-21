package uz.gita.testmaster.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uz.gita.testmaster.data.QuestionData;

public class AppRepository {
    private ArrayList<QuestionData> elementary;
    private ArrayList<QuestionData> preIntermediate;
    private ArrayList<QuestionData> intermediate;
    private ArrayList<QuestionData> upperIntermediate;

    private static AppRepository instance;

    private AppRepository() {
        loadTest();
    }

    public static AppRepository getInstance() {
        if (instance == null) instance = new AppRepository();
        return instance;
    }

    private void loadTest() {
        elementary = new ArrayList<>(10);
        elementary.add(new QuestionData(
                "A- Hello, what ______ your name?",
                "is",
                "are",
                "am",
                "be",
                "is"
        ));
        elementary.add(new QuestionData(
                "______ name is John. And my ______ is Johnson.",
                "Your / surname",
                "My / surname",
                "I / surname",
                "I / name",
                "My / surname"
        ));
        elementary.add(new QuestionData(
                "My name is Lisa. ______ Lisa Peterson.",
                "My am",
                "I is",
                "I am",
                "I",
                "I am"
        ));
        elementary.add(new QuestionData(
                "______ name is Apple. ______ Ann Apple.",
                "His / She",
                "His / He’s",
                "Her / She’s",
                "His / His",
                "Her / She’s"
        ));
        elementary.add(new QuestionData(
                "“Where ______ John from?” “______ from the US.”",
                "is / He’s",
                "is / His",
                "am / He’s",
                "is / She’s",
                "is / He’s"
        ));
        elementary.add(new QuestionData(
                "______ are you from? Japan",
                "What",
                "Who",
                "Where",
                "When",
                "Where"
        ));
        elementary.add(new QuestionData(
                "Where ______ you ______ ?",
                "is / from",
                "are / in",
                "are / is",
                "are / from",
                "are / from"
        ));
        elementary.add(new QuestionData(
                "______ from Spain. I’m Rodriguez .",
                "I’m",
                "He’s",
                "You’re",
                "She’s",
                "I’m"
        ));
        elementary.add(new QuestionData(
                "Pierre is a French boy. ______ from ______ .",
                "He’s / France",
                "His’s / French",
                "His / France",
                "He / France",
                "He’s / France"
        ));
        elementary.add(new QuestionData(
                "Lisa and Max are Americans. ______ from U.S.A.",
                "There",
                "Their",
                "They’re",
                "Their’re",
                "They’re"
        ));



        //other tests
    }

    public List<QuestionData> getElementarTest() {
        Collections.shuffle(elementary);
        return elementary;
    }

    public List<QuestionData> getPreIntermediateTest() {
        Collections.shuffle(preIntermediate);
        return preIntermediate;
    }

    public List<QuestionData> getIntermediateTest() {
        Collections.shuffle(intermediate);
        return intermediate;
    }

    public List<QuestionData> getUpperIntermediateTest() {
        Collections.shuffle(upperIntermediate);
        return upperIntermediate;
    }
}
