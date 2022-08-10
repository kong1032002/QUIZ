package com.example.demo_quanlytrungtam.controller.export;

import com.example.demo_quanlytrungtam.database.ExamDB;
import com.example.demo_quanlytrungtam.model.Exam;
import com.example.demo_quanlytrungtam.model.MultiChoiceQuest;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ApachePOIWrite {

    public void writeDethi(String path,int id) {
        XWPFDocument document = new XWPFDocument();

        //Bước 2: Tạo tiêu đề bài viết

        XWPFParagraph titleGraph = document.createParagraph();

        titleGraph.setAlignment(ParagraphAlignment.CENTER);

        Exam exam = ExamDB.getExam(id);

        String title = exam.getTitle();

        XWPFRun titleRun = titleGraph.createRun();

        titleRun.setBold(true);

        titleRun.setText(title);


        //Bước 3: Tạo đoạn văn bản 1 trong tài liệu


        for (int i = 0; i < exam.getQuestionList().size(); i++) {
            MultiChoiceQuest quest = exam.getQuestionList().get(i);
            XWPFParagraph para1 = document.createParagraph();
            para1.setAlignment(ParagraphAlignment.BOTH);
            String dataPara1 = "Câu " + (i + 1) + ": " + quest.getQuest();
            XWPFRun para1Run = para1.createRun();
            para1Run.setText(dataPara1);

            XWPFParagraph para2 = document.createParagraph();
            para2.setAlignment(ParagraphAlignment.BOTH);
            String dataPara2 = "A- " + quest.getA();
            XWPFRun para2Run = para2.createRun();
            para2Run.setText(dataPara2);

            XWPFParagraph para3 = document.createParagraph();
            para3.setAlignment(ParagraphAlignment.BOTH);
            String dataPara3 = "B- " + quest.getB();
            XWPFRun para3Run = para3.createRun();
            para3Run.setText(dataPara3);

            XWPFParagraph para4 = document.createParagraph();
            para4.setAlignment(ParagraphAlignment.BOTH);
            String dataPara4 = "C- " + quest.getC();
            XWPFRun para4Run = para4.createRun();
            para4Run.setText(dataPara4);

            XWPFParagraph para5 = document.createParagraph();
            para5.setAlignment(ParagraphAlignment.BOTH);
            String dataPara5 = "D- " + quest.getD();
            XWPFRun para5Run = para5.createRun();
            para5Run.setText(dataPara5);

        }
        try {
            FileOutputStream file = new FileOutputStream(path);
            document.write(file);
            file.close();
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
