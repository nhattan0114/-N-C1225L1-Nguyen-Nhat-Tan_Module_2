package thithuchanhmodule2.entity;

import java.time.LocalDate;

public class BenhAnVip extends BenhAn{
    private String loaiVip;
    private String thoiHanVip;

    public BenhAnVip(String liDoNhapVien, String maBenhAn, String maBenhNhan, String ngayNhapVien, String ngayRaVien, int stt, String tenBenhNhan, String loaiVip, String thoiHanVip) {
        this.loaiVip = loaiVip;
        this.thoiHanVip = thoiHanVip;
    }

    public BenhAnVip(String liDoNhapVien, String maBenhAn, String maBenhNhan, LocalDate ngayNhapVien, LocalDate ngayXuatVien, int soThuTu, String tenBenhNhan, String loaiVip, String thoiHanVip) {
        super(liDoNhapVien, maBenhAn, maBenhNhan, ngayNhapVien, ngayXuatVien, soThuTu, tenBenhNhan);
        this.loaiVip = loaiVip;
        this.thoiHanVip = thoiHanVip;
    }

    public String getLoaiVip() {
        return loaiVip;
    }

    public void setLoaiVip(String loaiVip) {
        this.loaiVip = loaiVip;
    }

    public String getThoiHanVip() {
        return thoiHanVip;
    }

    public void setThoiHanVip(String thoiHanVip) {
        this.thoiHanVip = thoiHanVip;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| %-20s | %-20s |", this.getLoaiVip(), this.getThoiHanVip());
    }
}
