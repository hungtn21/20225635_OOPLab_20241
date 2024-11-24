package hust.soict.dsai.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        // Khởi tạo đối tượng Random để tạo các số ngẫu nhiên
        Random r = new Random(123);

        // Test với String (sử dụng toán tử + để nối chuỗi)
        long start = System.currentTimeMillis(); // Ghi nhận thời gian bắt đầu
        String s = ""; // Chuỗi rỗng ban đầu
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2); // Nối chuỗi với một số ngẫu nhiên
        }
        System.out.println(System.currentTimeMillis() - start); // In thời gian thực thi

        // Test với StringBuilder (sử dụng append để nối chuỗi)
        r = new Random(123); // Khởi tạo lại đối tượng Random
        start = System.currentTimeMillis(); // Ghi nhận lại thời gian bắt đầu
        StringBuilder sb = new StringBuilder(); // Sử dụng StringBuilder để tối ưu việc nối chuỗi
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2)); // Nối số ngẫu nhiên vào StringBuilder
        }
        s = sb.toString(); // Chuyển StringBuilder thành String
        System.out.println(System.currentTimeMillis() - start); // In thời gian thực thi
    }
}