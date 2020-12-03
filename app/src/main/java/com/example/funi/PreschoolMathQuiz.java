package com.example.funi;

import java.util.ArrayList;
import java.util.Arrays;

public class PreschoolMathQuiz extends Quiz {
    public PreschoolMathQuiz() {
        setQuestions();
    }

    public void setQuestions() {
        //eventually set this to 30 for 30 questions
        //question 1
        super.addQuestion("A", new ArrayList<>(Arrays.asList("A", "B", "C", "D")), "Choose A");
        //question 2
        super.addQuestion("E", new ArrayList<>(Arrays.asList("E", "F", "G", "H")), "Choose E");
        //question 3
        super.addQuestion("I", new ArrayList<>(Arrays.asList("I", "J", "K", "L")), "Choose I");
    }
}
