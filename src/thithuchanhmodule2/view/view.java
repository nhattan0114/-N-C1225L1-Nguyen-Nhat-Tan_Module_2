package thithuchanhmodule2.view;

import thithuchanhmodule2.controller.Controller;
import thithuchanhmodule2.entity.BenhAn;
import thithuchanhmodule2.entity.BenhAnThuong;
import thithuchanhmodule2.entity.BenhAnVip;
import thithuchanhmodule2.exception.DuplicateMedicalRecordException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class view {
    public static Scanner sc = new Scanner(System.in);
    public static Controller controller = new Controller();
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static int inputInterger(String mes){
        while (true){
            try{
                System.out.print(mes+": ");
                return Integer.parseInt(sc.nextLine());

            }catch (NumberFormatException e){
                System.out.println("Vui lòng nhập số!");
            }
        }

    }
    public static void kiemTraTrungMa(String maBenhAn) throws DuplicateMedicalRecordException {
        ArrayList<BenhAn> danhSachBenhAn = controller.getBenhAnList();
        for (BenhAn ba : danhSachBenhAn) {
            if (ba.getMaBenhAn().equalsIgnoreCase(maBenhAn)) {
                throw new DuplicateMedicalRecordException("Bệnh án đã tồn tại.");
            }
        }
    }

    public static int laySttTiepTheo() {
        ArrayList<BenhAn> danhSachBenhAn= controller.getBenhAnList();
        if (danhSachBenhAn.isEmpty()) {
            return 1;
        }
        return danhSachBenhAn.get(danhSachBenhAn.size() - 1).getSoThuTu() + 1;
    }
    public static BenhAn addBenhAn() {
        System.out.println("\n---Thêm mới bệnh án---");
        int stt = laySttTiepTheo();
        System.out.println("STT: " + stt);

        String maBenhAn;
        while (true) {
            System.out.print("Nhập mã bệnh án(BA-XXX): ");
            maBenhAn = sc.nextLine().trim();
            if (!maBenhAn.matches("^BA-\\d{3}$")) {
                System.out.println("Lỗi: Mã bệnh án phải đúng định dạng BA-XXX(với XXX là kí tự số!)");
                continue;
            }
            try {
                kiemTraTrungMa(maBenhAn);
                break;
            } catch (DuplicateMedicalRecordException e) {
                System.out.println(e.getMessage() + " Vui lòng nhập lại!");
            }
        }

        String maBenhNhan;
        while (true) {
            System.out.print("Nhập mã bệnh nhân (BN-XXX): ");
            maBenhNhan = sc.nextLine().trim();
            if (maBenhNhan.matches("^BN-\\d{3}$")) {
                break;
            }
            System.out.println("Lỗi: Mã bệnh nhân phải đúng định dạng BN-XXX (với X là kí tự số)!");
        }

        String tenBenhNhan;
        while (true) {
            System.out.print("Nhập tên bệnh nhân: ");
            tenBenhNhan = sc.nextLine().trim();
            if (!tenBenhNhan.isEmpty()) break;
            System.out.println("Lỗi: Tên bệnh nhân không được để trống!");
        }
        String ngayNhapVien, ngayRaVien;
        while (true) {
            System.out.print("Nhập ngày nhập viện (dd/MM/yyyy): ");
            ngayNhapVien = sc.nextLine().trim();
            System.out.print("Nhập ngày ra viện (dd/MM/yyyy): ");
            ngayRaVien = sc.nextLine().trim();

            try {
                LocalDate dateNhap = LocalDate.parse(ngayNhapVien,DATE_FORMATTER);
                LocalDate dateRa = LocalDate.parse(ngayRaVien,DATE_FORMATTER);

                if (dateNhap.isAfter(dateRa)) {
                    System.out.println("Lỗi: Ngày nhập viện phải trước hoặc bằng ngày ra viện!");
                    continue;
                }
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi: Ngày tháng nhập vào không tồn tại hoặc sai định dạng dd/MM/yyyy!");
            }

        }
        System.out.print("Nhập lí do nhập viện: ");
        String liDoNhapVien = sc.nextLine().trim();

        int phanLoaiBenhAn = 0;
        while (phanLoaiBenhAn != 1 && phanLoaiBenhAn != 2) {
            System.out.print("Chọn loại bệnh án(1.Thường| 2.Vip ):");
            try {
                phanLoaiBenhAn = Integer.parseInt(sc.nextLine().trim());
                if (phanLoaiBenhAn != 1 && phanLoaiBenhAn != 2) {
                    System.out.println("Lỗi: chỉ chọn số 1 hoặc 2");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi vui lòng nhập số");
            }
        }

        if (phanLoaiBenhAn == 1) {
            double phiNamVien = -1;
            while (phiNamVien < 0) {
                System.out.print("Nhập phí nằm viện(VNĐ): ");
                try {
                    phiNamVien = Double.parseDouble(sc.nextLine().trim());
                    if (phiNamVien < 0) {
                        System.out.println("Lỗi:Chi phí không được bé hơn 0 ");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi:Chi phí phải là một số thực hợp lệ! ");
                }
            }
            return new BenhAnThuong(stt, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, liDoNhapVien, phiNamVien);
        }
        else {
            String loaiVip;
            while (true) {
                System.out.print("Nhập gói VIP (VIP I, VIP II, VIP III): ");
                loaiVip = sc.nextLine().trim().toUpperCase();
                if (loaiVip.equals("VIP I") || loaiVip.equals("VIP II") || loaiVip.equals("VIP III")) {
                    break;
                }
                System.out.println("Lỗi: Gói VIP bắt buộc phải chọn 1 trong 3 gói: VIP I, VIP II hoặc VIP III!");
            }

            String thoiHanVip;
                System.out.print("Nhập thời hạn VIP (dd/MM/yyyy): ");
                thoiHanVip = sc.nextLine().trim();
                return new BenhAnVip(liDoNhapVien,maBenhAn,maBenhNhan,ngayNhapVien,ngayRaVien,stt,tenBenhNhan,loaiVip,thoiHanVip);
        }
    }
    public static void printBenhAn(ArrayList<BenhAn> benhAnList){

        if (benhAnList.isEmpty()){
            System.out.println("Danh sách rỗng!");
        }
        for (BenhAn benhAn : benhAnList){
            System.out.println(benhAn);
        }

    }

    public static void xuLyXoa() {
        System.out.println("\n--- XÓA BỆNH ÁN ---");
        System.out.print("Nhập Mã bệnh án cần xóa: ");
        String maXoa = sc.nextLine().trim();

        boolean tonTai = false;
        for (BenhAn ba : controller.getBenhAnList()) {
            if (ba.getMaBenhAn().equalsIgnoreCase(maXoa)) {
                tonTai = true;
                break;
            }
        }

        if (!tonTai) {
            System.out.println("-> Thao tác thất bại: Không tìm thấy Mã bệnh án '" + maXoa + "' trong danh sách.");
            return;
        }

        while (true) {
            System.out.print("Bạn có chắc chắn muốn xóa bệnh án này không? (Có / Không): ");
            String xacNhan = sc.nextLine().trim();

            if (xacNhan.equalsIgnoreCase("Có") || xacNhan.equalsIgnoreCase("Co")) {
                xoaBenhAn(maXoa);
                System.out.println("-> Xóa dữ liệu thành công!");
                System.out.println("\nDanh sách sau khi cập nhật lại:");
                printBenhAn(controller.getBenhAnList());
                break;
            } else if (xacNhan.equalsIgnoreCase("Không") || xacNhan.equalsIgnoreCase("Khong")) {
                System.out.println("-> Đã hủy thao tác xóa. Quay lại menu chính.");
                break;
            } else {
                System.out.println("Lỗi: Vui lòng chỉ nhập đúng chữ 'Có' hoặc 'Không'.");
            }
        }
    }

    public static boolean xoaBenhAn(String maBenhAn) {
        ArrayList<BenhAn> danhSachBenhAn = controller.getBenhAnList();
        BenhAn target = null;
        for (BenhAn ba : danhSachBenhAn) {
            if (ba.getMaBenhAn().equalsIgnoreCase(maBenhAn)) {
                target = ba;
                break;
            }
        }
        if (target != null) {
            danhSachBenhAn.remove(target);
            for (int i = 0; i < danhSachBenhAn.size(); i++) {
                danhSachBenhAn.get(i).setSoThuTu(i + 1);
            }
            controller.saveBenhAn( danhSachBenhAn);
            return true;
        }
        return false;
    }

}
