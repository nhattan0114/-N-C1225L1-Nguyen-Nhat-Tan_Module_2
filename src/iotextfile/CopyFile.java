package iotextfile;

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String sourcePath ="src/iotextfile/source.txt";
        File sourceFile = new File(sourcePath);

        if (!sourceFile.exists()) {
            System.out.println("Cảnh báo: Tệp nguồn không tồn tại. Chương trình kết thúc!");
            scanner.close();
            return;
        }

        String targetPath = "src/iotextfile/target.txt";
        File targetFile = new File(targetPath);

        if (!targetFile.exists()) {
            System.out.println("Cảnh báo: Tệp đích không tồn tại. Chương trình kết thúc !");
            scanner.close();
            return;
        }

        int charCount = 0;

        try (Reader reader = new FileReader(sourceFile);
             Writer writer = new FileWriter(targetFile)) {

            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
                charCount++;
            }

            System.out.println("---");
            System.out.println("Sao chép thành công!");
            System.out.println("Tổng số ký tự đã sao chép: " + charCount);

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi I/O trong quá trình đọc/ghi tệp: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
