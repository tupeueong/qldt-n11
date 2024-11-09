package model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "complexSubject")
@XmlAccessorType(XmlAccessType.FIELD)
public class ComplexSubject implements Serializable {
    private int id;
    private String hoTen; // Họ tên
    private String ngaySinh; // Ngày tháng năm sinh
    private String gioiTinh; // Giới tính
    private String noio; // Nơi ở
    private String hoKhauThuongTru; // Hộ khẩu thường trú
    private String thanNhan; // Thân nhân
    private String loaiDoiTuong; // Loại đối tượng (Tiền án, tiền sự, đối tượng nghiện, v.v..)

    // Constructor với tất cả các tham số
    public ComplexSubject(int id, String hoTen, String ngaySinh, String gioiTinh, String noio, String hoKhauThuongTru, String thanNhan, String loaiDoiTuong) {
    this.id = id;
    this.hoTen = hoTen;
    this.ngaySinh = ngaySinh;
    this.gioiTinh = gioiTinh; // Khởi tạo giới tính
    this.noio = noio; // Khởi tạo nơi ở
    this.hoKhauThuongTru = hoKhauThuongTru;
    this.thanNhan = thanNhan;
    this.loaiDoiTuong = loaiDoiTuong;
}

    // Constructor mặc định
    public ComplexSubject() {   
    }

    public ComplexSubject(String hoTen, String ngaySinh, String gioiTinh, String noio, String hoKhauThuongTru, String thanNhan, String loaiDoiTuong) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.noio = noio;
        this.hoKhauThuongTru = hoKhauThuongTru;
        this.thanNhan = thanNhan;
        this.loaiDoiTuong = loaiDoiTuong;
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNoio() {
        return noio;
    }

    public void setNoio(String noio) {
        this.noio = noio; // Sửa lại để sử dụng tham số đúng
    }

    public String getHoKhauThuongTru() {
        return hoKhauThuongTru;
    }

    public void setHoKhauThuongTru(String hoKhauThuongTru) {
        this.hoKhauThuongTru = hoKhauThuongTru;
    }

    public String getThanNhan() {
        return thanNhan;
    }

    public void setThanNhan(String thanNhan) {
        this.thanNhan = thanNhan;
    }

    public String getLoaiDoiTuong() {
        return loaiDoiTuong;
    }

    public void setLoaiDoiTuong(String loaiDoiTuong) {
        this.loaiDoiTuong = loaiDoiTuong;
    }

    public String getGioiTinh() {
        return gioiTinh; // Phương thức get
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh; // Phương thức set
    }
}