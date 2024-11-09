/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package controller;
//
//import form.Form_2;
//import form.Form_3;
//import model.ComplexSubject;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//public class FormController {
//    private Form_2 form2;
//    private Form_3 form3;
//    private List<ComplexSubject> complexSubjects;
//
//    public FormController(Form_2 form2, Form_3 form3) {
//        this.form2 = form2;
//        this.form3 = form3;
//        this.complexSubjects = new ArrayList<>();
//    }
//
//    public void addComplexSubject() {
//        // Lấy thông tin từ Form_2
//        String hoTen = form2.getTxName().getText();
//        String ngaySinh = form2.getTxNgaySinh().getText(); // Giả sử bạn đã thêm trường này
//        String gioiTinh = form2.getSelectedGender(); // Phương thức để lấy giới tính đã chọn
//        String loaiDoiTuong = form2.getTxDoiTuong().getText();
//        String thanNhan = form2.getTxThanNhan().getText();
//        String diaChi = form2.getTxNoiO().getText();
//        String hoKhau = form2.getTxHoKhau().getText();
//
//        // Tạo đối tượng ComplexSubject mới
//        ComplexSubject newSubject = new ComplexSubject();
//        newSubject.setHoTen(hoTen);
//        newSubject.setNgaySinh(ngaySinh);
//        newSubject.setGioiTinh(gioiTinh);
//        newSubject.setLoaiDoiTuong(loaiDoiTuong);
//        newSubject.setThanNhan(thanNhan);
//        newSubject.setNoio(diaChi);
//        newSubject.setHoKhauThuongTru(hoKhau);
//
//        // Thêm đối tượng vào danh sách
//        complexSubjects.add(newSubject);
////        updateTable();
//         
//    }
//
////    public void updateTable() {
////        // Cập nhật bảng trong Form_3
////        form3.getTableModel().setRowCount(0); // Xóa dữ liệu cũ
////        for (ComplexSubject subject : complexSubjects) {
////            form3.getTableModel().addRow(new Object[]{
////                subject.getId(),
////                subject.getHoTen(),
////                subject.getGioiTinh(),
////                subject.getNgaySinh(),
////                subject.getLoaiDoiTuong(),
////                subject.getThanNhan(),
////                subject.getDiaChi(),
////                subject.getHoKhauThuongTru()
////            });
////        }
////    }
//
//    public void sortByName() {
//        Collections.sort(complexSubjects, new Comparator<ComplexSubject>() {
//            @Override
//            public int compare(ComplexSubject o1, ComplexSubject o2) {
//                return o1.getHoTen().compareTo(o2.getHoTen());
//            }
//        });
////        updateTable();
//    }
//
//    public void sortByBirthDate() {
//        Collections.sort(complexSubjects, new Comparator<ComplexSubject>() {
//            @Override
//            public int compare(ComplexSubject o1, ComplexSubject o2) {
//                return o1.getNgaySinh().compareTo(o2.getNgaySinh());
//            }
//        });
////        updateTable();
//    }
//}
