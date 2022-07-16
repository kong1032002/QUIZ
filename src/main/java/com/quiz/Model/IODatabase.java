package com.quiz.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IODatabase {
    public ArrayList readQuestions() throws SQLException, ClassNotFoundException;

    public int writeQuestion(ArrayList questions, int number, int userId);

    public int deleteQuestion(int id, int userid);
}
