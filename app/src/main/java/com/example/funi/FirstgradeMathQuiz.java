package com.example.funi;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstgradeMathQuiz extends Quiz {

    public FirstgradeMathQuiz() {
        setQuestions();
    }

    public void setQuestions() {
        //eventually set this to 30 for 30 questions
        //question 1
        super.addQuestion("12", new ArrayList<>(Arrays.asList("9", "10", "11", "12")), "10+2");
        //question 2
        super.addQuestion("8", new ArrayList<>(Arrays.asList("6", "7", "8", "9")), "4+4");
        //question 3
        super.addQuestion("5", new ArrayList<>(Arrays.asList("5", "4", "3", "2")), "7-2");
    }
}
