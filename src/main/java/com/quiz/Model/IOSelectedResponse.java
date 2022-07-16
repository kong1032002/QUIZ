package com.quiz.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IOSelectedResponse implements IODatabase {
    @Override
    public ArrayList readQuestions() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int writeQuestion(ArrayList questions, int number, int userId) {
        return 0;
    }

    @Override
    public int deleteQuestion(int id, int userid) {
        return 0;
    }
}
