package hust.soict.dsai.garbage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
     // Đường dẫn tới file
        String filename = "D:/Ngoc_Hung/20241/Lập trình hướng đối tượng/20225635_OOPLab_20241/LAB03/OtherProjects/hust/soict/dsai/garbage/text.txt";
        // Sử dụng StringBuffer để xử lý chuỗi
        StringBuffer outputBuffer = new StringBuffer();
        byte[] inputBytes = null;
        long startTime, endTime;

        try {
            // Đọc tất cả các byte từ file
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
            return; // Thoát nếu gặp lỗi
        }

        // Đo thời gian xử lý với StringBuffer
        startTime = System.currentTimeMillis();
        for (byte b : inputBytes) {
            outputBuffer.append((char) b); // Chuyển byte sang ký tự và thêm vào StringBuffer
        }
        endTime = System.currentTimeMillis();

        // In ra thời gian xử lý
        System.out.println("Thời gian sử dụng StringBuffer: " + (endTime - startTime) + " ms");
    }
}
