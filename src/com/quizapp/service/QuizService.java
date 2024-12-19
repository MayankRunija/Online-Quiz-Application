package com.quizapp.service;

import com.quizapp.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizService {
    private final List<Question> questions;

    public QuizService() {
        questions = new ArrayList<>();
        // For simplicity, hardcoded questions
        questions.add(new Question(1, "Java is platform-independent because?", 
                "It's compiled into machine code", 
                "It runs on Windows only", 
                "It's compiled into bytecode", 
                "It uses Java VM", 
                "C"));
    }

    public List<Question> getAllQuestions() {
        return questions;
    }
}
