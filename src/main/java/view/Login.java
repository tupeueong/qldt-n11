package view;

import javax.swing.JPasswordField; // Đảm bảo bạn đã nhập khẩu các thư viện cần thiết
import javax.swing.JTextField;

public class Login {
    // ... existing code ...
    private JTextField txUser; // Khai báo txUser là một JTextField
    private JPasswordField txPassword; // Nếu bạn cũng cần trường mật khẩu

    public Login() {
        txUser = new JTextField(); // Khởi tạo txUser
        txPassword = new JPasswordField(); // Khởi tạo txPassword
        // ... thêm các thành phần giao diện khác ...
    }

    public String getTxUser() {
        return txUser.getText(); // Phương thức getter cho txUser
    }

    public String getTxPassword() {
        return new String(txPassword.getPassword()); // Phương thức getter cho txPassword
    }
    // ... existing code ...
} 