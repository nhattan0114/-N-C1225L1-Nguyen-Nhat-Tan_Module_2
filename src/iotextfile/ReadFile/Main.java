package iotextfile.ReadFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("===============Đọc File CSV===============");
        String path = "src/iotextfile/ReadFile/CountryData.csv";
        displayCountry(readTextFile(path));

    }

    public static ArrayList<Country> readTextFile(String path){
        ArrayList<Country> countries = new ArrayList<>();
        try(FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] data;
            Country country;
            while ((line= bufferedReader.readLine())!=null){
                if (line.trim().isEmpty()){
                    continue;
                }
                data=line.split(",");
                country=new Country(data[0],data[1],data[2]);
                countries.add(country);
            }

        }catch (FileNotFoundException e){
            System.out.println("Không tìm thấy file!");
        }catch (IOException e){
            System.out.println("Lỗi đọc file!");
        }
        return countries;
    }

    public static void displayCountry(List<Country> countries) {
        if (countries.isEmpty()){
            System.out.println("Không tồn tại");
            return;
        }
        System.out.println("+----+----------------------+------------+");
        System.out.printf("| %-10s | %-10s | %-10s |\n",
                "ID", "Code", "Name");
        System.out.println("+----+----------------------+------------+");
        for (Country country : countries){
            System.out.println(country);
        }
        System.out.println("+----+----------------------+------------+");
    }
}
