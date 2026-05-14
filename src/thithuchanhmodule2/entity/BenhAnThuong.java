package thithuchanhmodule2.entity;

import java.time.LocalDate;

public class BenhAnThuong extends BenhAn{
    private double phiNamVien;

    public double getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    public BenhAnThuong(int stt, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String liDoNhapVien, double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    public BenhAnThuong(int soThuTu, String maBenhAn, String maBenhNhan, String tenBenhNhan,
                        LocalDate ngayNhapVien, LocalDate ngayXuatVien, String liDoNhapVien,
                        double phiNamVien) {
        super(liDoNhapVien, maBenhAn, maBenhNhan, ngayNhapVien, ngayXuatVien, soThuTu, tenBenhNhan);
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-25s | %-20s | %-10s | %-10s | %-10s | %-10.2f |", this.getSoThuTu(),this.getMaBenhAn(), this.getMaBenhNhan(), this.getNgayNhapVien(), this.getNgayXuatVien(), this.getTenBenhNhan(), this.getPhiNamVien());
    }
}
