/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import dao.UserDao;
import main.Login;
import model.User;
import view.ComplexSubjectFrame;


public class LoginController {
    
    private UserDao userDao;
    private Login view;

    public LoginController(Login view) {
        this.userDao = new UserDao();
        this.view = view;
    }

    public void login(String username, String password) {
        User user = new User(username, password);
        if (userDao.checkUser(user)) {
            ComplexSubjectFrame complexSubjectFrame = new ComplexSubjectFrame();  
            complexSubjectFrame.setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(view, "Username hoặc password không đúng.", "Lỗi Đăng Nhập", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showError(String message) {
        view.showMessage(message);
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            login(view.txUser(), new String(view.txPassword()));
        }
    } 
}
