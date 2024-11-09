package form;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import model.ComplexSubject;
import dao.ComplexSubjectDao;

public class Form_3 extends javax.swing.JPanel {

    
    private ComplexSubjectDao complexSubjectDao;
    
    private JTextField txtHoTen;
    private JTextField txtNgaySinh;
    private JTextField txtNoio;
    private JTextField txtHoKhauThuongTru;
    private JTextField txtThanNhan;
    private JTextField txtLoaiDoiTuong;
    private JComboBox<String> txtGioiTinh;
    
    public Form_3() {
        initComponents();
        complexSubjectDao = new ComplexSubjectDao(); // Khởi tạo DAO
        showListComplexSubjects(complexSubjectDao.getListComplexSubjects()); // Hiển thị danh sách ban đầu
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new swing.complex.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jbcThemdoituong = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ tên", "Giới tính", "Ngày sinh", "Loại đối tượng", "Thân nhân", "Nơi ở", "Hộ khẩu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(6).setResizable(false);
            jTable2.getColumnModel().getColumn(7).setResizable(false);
        }

        jbcThemdoituong.setText("Thêm đối tượng");
        jbcThemdoituong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcThemdoituongActionPerformed(evt);
            }
        });

        jButton2.setText("Sort by Name");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Sort by Birth");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jButton2)
                .addGap(99, 99, 99)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                .addComponent(jbcThemdoituong)
                .addGap(142, 142, 142))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbcThemdoituong)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbcThemdoituongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcThemdoituongActionPerformed
        Form_2 form2 = new Form_2();
    // Tạo một JDialog để hiển thị Form_2
        JDialog dialog = new JDialog();
        dialog.setTitle("Thêm Đối Tượng");
        dialog.setContentPane(form2);
        dialog.setModal(true); // Để cửa sổ này là modal
        dialog.pack(); // Đặt kích thước cho dialog
        dialog.setLocationRelativeTo(this); // Đặt vị trí của dialog ở giữa Form_3
        dialog.setVisible(true); //
    showListComplexSubjects(complexSubjectDao.getListComplexSubjects());
    }//GEN-LAST:event_jbcThemdoituongActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Sắp xếp theo tên
        complexSubjectDao.sortComplexSubjectByName();
        showListComplexSubjects(complexSubjectDao.getListComplexSubjects());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Sắp xếp theo ngày sinh
        complexSubjectDao.sortComplexSubjectByBirthDate();
        showListComplexSubjects(complexSubjectDao.getListComplexSubjects());
    }//GEN-LAST:event_jButton3ActionPerformed
    
    public void addAddComplexSubjectListener(ActionListener listener) {
        jbcThemdoituong.addActionListener(listener);
    }

    // Phương thức để thêm listener cho nút "Chỉnh sửa"
//    public void addEditComplexSubjectListener(ActionListener listener) {
//        jButtonEdit.addActionListener(listener); // Giả sử bạn có nút chỉnh sửa
//    }
//
//    // Phương thức để thêm listener cho nút "Xóa"
//    public void addDeleteComplexSubjectListener(ActionListener listener) {
//        jButtonDelete.addActionListener(listener); // Giả sử bạn có nút xóa
//    }
//
//    // Phương thức để thêm listener cho nút "Làm sạch"
//    public void addClearListener(ActionListener listener) {
//        jButtonClear.addActionListener(listener); // Giả sử bạn có nút làm sạch
//    }

    // Phương thức để thêm listener cho nút "Sắp xếp theo tên"
    public void addSortComplexSubjectByNameListener(ActionListener listener) {
        jButton2.addActionListener(listener); // Giả sử bạn có nút sắp xếp theo tên
    }

    // Phương thức để thêm listener cho nút "Sắp xếp theo ngày sinh"
    public void addSortComplexSubjectByBirthDateListener(ActionListener listener) {
        jButton3.addActionListener(listener); // Giả sử bạn có nút sắp xếp theo ngày sinh
    }

    // Phương thức để thêm listener cho sự kiện chọn hàng trong bảng
    public void addListComplexSubjectSelectionListener(ListSelectionListener listener) {
        jTable2.getSelectionModel().addListSelectionListener(listener);
    }
    
    public ComplexSubject getComplexSubjectInfo() {
        ComplexSubject complexSubject = new ComplexSubject();
        complexSubject.setHoTen(txtHoTen.getText());
        complexSubject.setNgaySinh(txtNgaySinh.getText());
        complexSubject.setNoio(txtNoio.getText());
        complexSubject.setHoKhauThuongTru(txtHoKhauThuongTru.getText());
        complexSubject.setThanNhan(txtThanNhan.getText());
        complexSubject.setLoaiDoiTuong(txtLoaiDoiTuong.getText());      
        complexSubject.setGioiTinh((String) txtGioiTinh.getSelectedItem());
        return complexSubject;
    }
    
    public void showComplexSubject(ComplexSubject complexSubject) {
        txtHoTen.setText(complexSubject.getHoTen());
        txtNgaySinh.setText(complexSubject.getNgaySinh());
        txtNoio.setText(complexSubject.getNoio());
        txtHoKhauThuongTru.setText(complexSubject.getHoKhauThuongTru());
        txtThanNhan.setText(complexSubject.getThanNhan());
        txtLoaiDoiTuong.setText(complexSubject.getLoaiDoiTuong());
        txtGioiTinh = new JComboBox<>(new String[]{"Nam", "Nữ"}); // Nếu bạn có trường giới tính
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    public void clearComplexSubjectInfo() {
        txtHoTen.setText("");
        txtNgaySinh.setText("");
        txtNoio.setText("");
        txtHoKhauThuongTru.setText("");
        txtThanNhan.setText("");
        txtLoaiDoiTuong.setText("");
        txtGioiTinh.setSelectedIndex(0);
    }
    
    public void fillComplexSubjectFromSelectedRow() {
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow != -1) {
            ComplexSubject cs = complexSubjectDao.getListComplexSubjects().get(selectedRow);
            showComplexSubject(cs);
        }
    }

    public void showListComplexSubjects(List<ComplexSubject> complexSubjects) {
        // Cập nhật bảng với danh sách ComplexSubject
        String[] columnNames = {"ID", "Họ Tên", "Giới Tính", "Ngày Sinh", "Loại Đối Tượng", "Thân Nhân", "Nơi Ở", "Hộ Khẩu"};
        Object[][] data = new Object[complexSubjects.size()][8];

        for (int i = 0; i < complexSubjects.size(); i++) {
            ComplexSubject cs = complexSubjects.get(i);
            data[i][0] = cs.getId();
            data[i][1] = cs.getHoTen();
            data[i][2] = cs.getGioiTinh(); // Sử dụng phương thức getGioiTinh()
            data[i][3] = cs.getNgaySinh(); // Cần chuyển đổi nếu cần
            data[i][4] = cs.getLoaiDoiTuong();
            data[i][5] = cs.getThanNhan();
            data[i][6] = cs.getNoio();
            data[i][7] = cs.getHoKhauThuongTru();
        }

        jTable2.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbcThemdoituong;
    private swing.complex.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
