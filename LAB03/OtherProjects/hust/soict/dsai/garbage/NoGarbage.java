package hust.soict.dsai.garbage;

import java.io.*;

public class NoGarbage {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        try {
            // Đọc tệp "largefile.txt" sử dụng StringBuffer để nối chuỗi
            FileInputStream fileInputStream = new FileInputStream("D:/Ngoc_Hung/20241/Lập trình hướng đối tượng/20225635_OOPLab_20241/LAB03/OtherProjects/hust/soict/dsai/garbage/text.txt");
            int content;
            while ((content = fileInputStream.read()) != -1) {
                sb.append((char) content); // Dùng StringBuffer để nối chuỗi
            }
            fileInputStream.close();
            // Chuyển StringBuffer thành String cuối cùng
            String result = sb.toString();
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc tệp: " + e.getMessage());
        }
    }
}
