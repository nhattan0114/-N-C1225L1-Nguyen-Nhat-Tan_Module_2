package thithuchanhmodule2.controller;

import thithuchanhmodule2.entity.BenhAn;
import thithuchanhmodule2.view.view;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Controller {
    public static final String FILE_PATH = "src/thithuchanhmodule2/data/medical_records.csv";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ArrayList<BenhAn> getBenhAnList(){
        ArrayList<BenhAn> benhAnList = new ArrayList<>();
        try(FileReader fileReader=new FileReader(FILE_PATH);
            BufferedReader bufferedReader=new BufferedReader(fileReader)) {
            String line;
            String[] data;
            BenhAn benhAn;
            while ((line=bufferedReader.readLine())!=null){
                if (line.trim().isEmpty()){
                    continue;
                }
                data=line.split(",");
                benhAn=new BenhAn(data[0],data[1],data[2], LocalDate.parse(data[3],DATE_FORMATTER),LocalDate.parse(data[4],DATE_FORMATTER),Integer.parseInt(data[5]),data[6]);
            }
        }catch (FileNotFoundException e){
            System.out.println("Không tìm thấy File");
        }catch (IOException e){
            System.out.println("Lỗi đọc file!");
        }
        return benhAnList;
    }


    public String converterBenhAnToString(BenhAn benhAn){
        String ngayNhapVien=benhAn.getNgayNhapVien().format(DATE_FORMATTER);
        String ngayXuatVien=benhAn.getNgayXuatVien().format(DATE_FORMATTER);
        return benhAn.getLiDoNhapVien()+","+benhAn.getMaBenhAn()+","+benhAn.getMaBenhNhan()+","+ngayNhapVien+","+ngayXuatVien+","+benhAn.getSoThuTu()+","+benhAn.getTenBenhNhan();
    }

    public boolean saveBenhAn(ArrayList<BenhAn> benhAnList){
        try(FileWriter fileWriter=new FileWriter(FILE_PATH,false);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter)) {
            for(BenhAn benhAn : benhAnList){
                bufferedWriter.write(converterBenhAnToString(benhAn));
                bufferedWriter.newLine();

            }
            return true;
        }catch (IOException e){
            System.out.println("Lỗi ghi file");
            return false;
        }
    }

    public boolean addBenhAn(BenhAn benhAn){
        try(FileWriter fileWriter=new FileWriter(FILE_PATH,true);
            BufferedWriter bufferedWriter =new BufferedWriter(fileWriter)){
            bufferedWriter.write(converterBenhAnToString(benhAn));
            bufferedWriter.newLine();
            return true;
        }catch (IOException e){
            System.out.println("Lỗi ghi file!");
            return false;
        }
    }

    public void deleteBenhAn(){
        view.xuLyXoa();
    }

    }


