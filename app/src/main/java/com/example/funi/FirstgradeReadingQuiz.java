package com.example.funi;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstgradeReadingQuiz extends Quiz {
    public FirstgradeReadingQuiz() {
        setQuestions();
    }

    public void setQuestions() {
        //eventually set this to 30 for 30 questions
        //question 1
        super.addQuestion("ball", new ArrayList<>(Arrays.asList("ball", "mall", "yall", "tall")), "ball");
        //question 2
        super.addQuestion("cat", new ArrayList<>(Arrays.asList("mat", "bat", "hat", "rat")), "cat");
        //question 3
        super.addQuestion("key", new ArrayList<>(Arrays.asList("toy", "key", "roy", "wey")), "key");
    }
}
