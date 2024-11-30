package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "D:/Ngoc_Hung/20241/Lập trình hướng đối tượng/20225635_OOPLab_20241/LAB03/OtherProjects/hust/soict/dsai/garbage/text.txt";
        byte[] inputBytes = new byte[0]; // Khai báo mảng byte
        long startTime, endTime;
        
        try {
            // Đọc toàn bộ nội dung của tệp vào một mảng byte
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();

            // Chuyển đổi byte thành chuỗi (nếu cần thiết) bằng toán tử "+"
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b; // Nối chuỗi bằng toán tử "+"
            }

            endTime = System.currentTimeMillis();
            System.out.println("Thời gian xử lý với String concatenation (sử dụng +): " + (endTime - startTime) + " ms");

            // Nếu muốn sử dụng StringBuffer, thay đổi đoạn mã sau:
            startTime = System.currentTimeMillis();

            StringBuffer sb = new StringBuffer();
            for (byte b : inputBytes) {
                sb.append((char) b); // Nối chuỗi bằng StringBuffer
            }
            outputString = sb.toString(); // Chuyển StringBuffer thành chuỗi

            endTime = System.currentTimeMillis();
            System.out.println("Thời gian xử lý với StringBuffer: " + (endTime - startTime) + " ms");

        } catch (IOException e) {
            System.out.println("Lỗi khi đọc tệp: " + e.getMessage());
        }
    }
}
