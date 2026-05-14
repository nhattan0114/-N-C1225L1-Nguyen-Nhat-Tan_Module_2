package thithuchanhmodule2.entity;

import java.time.LocalDate;

public class BenhAn {
    private int soThuTu;
    private String maBenhAn;
    private String maBenhNhan;
    private String tenBenhNhan;
    private LocalDate ngayNhapVien;
    private LocalDate ngayXuatVien;
    private String liDoNhapVien;

    public BenhAn() {
    }
    public BenhAn(String liDoNhapVien, String maBenhAn, String maBenhNhan, LocalDate ngayNhapVien, LocalDate ngayXuatVien, int soThuTu, String tenBenhNhan) {
        this.liDoNhapVien = liDoNhapVien;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayXuatVien = ngayXuatVien;
        this.soThuTu = soThuTu;
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getLiDoNhapVien() {
        return liDoNhapVien;
    }

    public void setLiDoNhapVien(String liDoNhapVien) {
        this.liDoNhapVien = liDoNhapVien;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public LocalDate getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(LocalDate ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public LocalDate getNgayXuatVien() {
        return ngayXuatVien;
    }

    public void setNgayXuatVien(LocalDate ngayXuatVien) {
        this.ngayXuatVien = ngayXuatVien;
    }

    public int getSoThuTu() {
        return soThuTu;
    }

    public void setSoThuTu(int soThuTu) {
        this.soThuTu = soThuTu;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-25s | %-20s | %-10s | %-10s | %-10s |", this.getSoThuTu(),this.getMaBenhAn(), this.getMaBenhNhan(), this.getNgayNhapVien(), this.getNgayXuatVien(), this.getTenBenhNhan());
    }
}
