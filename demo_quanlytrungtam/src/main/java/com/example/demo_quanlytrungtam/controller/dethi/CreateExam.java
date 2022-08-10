package com.example.demo_quanlytrungtam.controller.dethi;

import com.example.demo_quanlytrungtam.model.MultiChoiceQuest;
import com.example.demo_quanlytrungtam.model.TuLuan;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateExam {
    protected XWPFDocument document = new XWPFDocument();

    public XWPFDocument createHeader(){


        //Bước 2: Tạo tiêu đề bài viết
        XWPFParagraph titleGraph = document.createParagraph();

        titleGraph.setAlignment(ParagraphAlignment.CENTER);

        String title = "ĐỀ KIỂM TRA";

        XWPFRun titleRun = titleGraph.createRun();

        titleRun.setBold(true);

        titleRun.setText(title);

        XWPFParagraph para1 = document.createParagraph();
        para1.setAlignment(ParagraphAlignment.CENTER);
        String dataPara1 = "Không sử dụng tài liệu dưới mọi hình thức \n";
        dataPara1 += "---------------------------------------------------------";
        XWPFRun para0Run = para1.createRun();
        para0Run.setText(dataPara1);

        // Tao khoang trong giua 2 doan
        XWPFParagraph paraBreak0 = document.createParagraph();
        XWPFRun paraBreak0Run = paraBreak0.createRun();
        paraBreak0Run.addBreak();
        return document;
    }
    protected void createFooter(XWPFDocument document){
        // Tao khoang trong giua 2 doan
        XWPFParagraph paraBreak0 = document.createParagraph();
        XWPFRun paraBreak0Run = paraBreak0.createRun();
        paraBreak0Run.addBreak();

        // Tao thong bao
        XWPFParagraph para3 = document.createParagraph();
        para3.setAlignment(ParagraphAlignment.CENTER);

        String dataPara3 = "-------------Hết-------------";

        XWPFRun para3Run = para3.createRun();
        para3Run.setText(dataPara3);
    }

    public boolean create(List<MultiChoiceQuest> listTest){
        // Tao tieu de cho bai kiem tra

        for(int i = 0; i <listTest.size();i ++){
            // tao cau
            XWPFParagraph para = document.createParagraph();
            String cau = "Câu "+(i+1)+": ";
            XWPFRun pararun = para.createRun();
            pararun.setBold(true);
            pararun.setText(cau);
            // Tao de bai
            XWPFParagraph para1 = document.createParagraph();
            para1.setAlignment(ParagraphAlignment.LEFT);
            String dataPara1 = listTest.get(i).getQuest();
            XWPFRun pararun1 = para1.createRun();
            pararun1.setText(dataPara1);
            // Phuong an
            for (int j = 1; j <= 4; j++) {
                XWPFParagraph para2 = document.createParagraph();
                para2.setAlignment(ParagraphAlignment.BOTH);
                String dataPara2 = null;
                switch (j) {
                    case 1:
                        dataPara2 = "A. ";
                        dataPara2 += listTest.get(i).getA();
                        break;
                    case 2:
                        dataPara2 = "B. ";
                        dataPara2 += listTest.get(i).getB();
                        break;
                    case 3:
                        dataPara2 = "C. ";
                        dataPara2 += listTest.get(i).getC();
                        break;
                    default:
                        dataPara2 = "D. ";
                        dataPara2 += listTest.get(i).getD();
                        break;
                }

                XWPFRun pararun2 = para2.createRun();
                pararun2.setText(dataPara2);
            }

        }

        // Tao cuoi trang
        createFooter(document);

        //Bước 4: Ghi dữ liệu ra file word
        try {
            FileOutputStream out = new FileOutputStream("src/test/data.docx");

            document.write(out);

            out.close();

            document.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public boolean sinhDeTL (ArrayList<TuLuan> listTest){
        return false;
    }
    public boolean sinhDeTLVaTN (ArrayList<MultiChoiceQuest> listTest, ArrayList<TuLuan> listTest1){
        return false;
    }
}
