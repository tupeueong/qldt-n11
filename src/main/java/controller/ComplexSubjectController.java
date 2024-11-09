///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//import dao.ComplexSubjectDao;
//import model.ComplexSubject;
//import view.ComplexSubjectFrame;
//
//public class ComplexSubjectController {
//    private ComplexSubjectDao complexSubjectDao;
//    private ComplexSubjectFrame complexSubjectFrame;
//
//    public ComplexSubjectController(ComplexSubjectFrame view) {
//        this.complexSubjectFrame = view;
//        complexSubjectDao = new ComplexSubjectDao();
//
//        view.addAddComplexSubjectListener(new AddComplexSubjectListener());
//        view.addEditComplexSubjectListener(new EditComplexSubjectListener());
//        view.addDeleteComplexSubjectListener(new DeleteComplexSubjectListener());
//        view.addClearListener(new ClearComplexSubjectListener());
//        view.addSortComplexSubjectByNameListener(new SortComplexSubjectByNameListener());
//        view.addSortComplexSubjectByBirthDateListener(new SortComplexSubjectByBirthDateListener());
//        view.addListComplexSubjectSelectionListener(new ListComplexSubjectSelectionListener());
//    }
//
//    public void showComplexSubjectView() {
//        List<ComplexSubject> complexSubjectList = complexSubjectDao.getListComplexSubjects();
//        complexSubjectFrame.setVisible(true);
//        complexSubjectFrame.showListComplexSubjects(complexSubjectList);
//    }
//
//    class AddComplexSubjectListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            ComplexSubject complexSubject = complexSubjectView.getComplexSubjectInfo();
//            if (complexSubject != null) {
//                complexSubjectDao.add(complexSubject);
//                complexSubjectView.showComplexSubject(complexSubject);
//                complexSubjectView.showListComplexSubjects(complexSubjectDao.getListComplexSubjects());
//                complexSubjectView.showMessage("Thêm thành công!");
//            }
//        }
//    }
//
//    class EditComplexSubjectListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            ComplexSubject complexSubject = complexSubjectView.getComplexSubjectInfo();
//            if (complexSubject != null) {
//                complexSubjectDao.edit(complexSubject);
//                complexSubjectView.showComplexSubject(complexSubject);
//                complexSubjectView.showListComplexSubjects(complexSubjectDao.getListComplexSubjects());
//                complexSubjectView.showMessage("Cập nhật thành công!");
//            }
//        }
//    }
//
//    class DeleteComplexSubjectListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            ComplexSubject complexSubject = complexSubjectView.getComplexSubjectInfo();
//            if (complexSubject != null) {
//                complexSubjectDao.delete(complexSubject);
//                complexSubjectView.clearComplexSubjectInfo();
//                complexSubjectView.showListComplexSubjects(complexSubjectDao.getListComplexSubjects());
//                complexSubjectView.showMessage("Xóa thành công!");
//            }
//        }
//    }
//
//    class ClearComplexSubjectListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            complexSubjectView.clearComplexSubjectInfo();
//        }
//    }
//
//    class SortComplexSubjectByNameListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            complexSubjectDao.sortComplexSubjectByName();
//            complexSubjectView.showListComplexSubjects(complexSubjectDao.getListComplexSubjects());
//        }
//    }
//
//    class SortComplexSubjectByBirthDateListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            complexSubjectDao.sortComplexSubjectByBirthDate();
//            complexSubjectView.showListComplexSubjects(complexSubjectDao.getListComplexSubjects());
//        }
//    }
//
//    class ListComplexSubjectSelectionListener implements ListSelectionListener {
//        public void valueChanged(ListSelectionEvent e) {
//            complexSubjectView.fillComplexSubjectFromSelectedRow();
//        }
//    }
//}
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import dao.ComplexSubjectDao;
import model.ComplexSubject;
import view.ComplexSubjectFrame;
import form.Form_3;

public class ComplexSubjectController {
    private ComplexSubjectDao complexSubjectDao;
    private Form_3 form_3;

    public ComplexSubjectController(Form_3 view) {
        this.form_3 = view;
        complexSubjectDao = new ComplexSubjectDao();

        form_3.addAddComplexSubjectListener(new AddComplexSubjectListener());
//        form_3.addEditComplexSubjectListener(new EditComplexSubjectListener());
//        form_3.addDeleteComplexSubjectListener(new DeleteComplexSubjectListener());
//        form_3.addClearListener(new ClearComplexSubjectListener());
        form_3.addSortComplexSubjectByNameListener(new SortComplexSubjectByNameListener());
        form_3.addSortComplexSubjectByBirthDateListener(new SortComplexSubjectByBirthDateListener());
        form_3.addListComplexSubjectSelectionListener(new ListComplexSubjectSelectionListener());
    }

    public void showComplexSubjectView() {
        List<ComplexSubject> complexSubjectList = complexSubjectDao.getListComplexSubjects();
        form_3.setVisible(true);
        form_3.showListComplexSubjects(complexSubjectList);
    }

    class AddComplexSubjectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ComplexSubject complexSubject = form_3.getComplexSubjectInfo(); // Sửa ở đây
            if (complexSubject != null) {
                complexSubjectDao.add(complexSubject);
                form_3.showComplexSubject(complexSubject); // Sửa ở đây
                form_3.showListComplexSubjects(complexSubjectDao.getListComplexSubjects());
                form_3.showMessage("Thêm thành công!");
            }
        }
    }

    class EditComplexSubjectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ComplexSubject complexSubject = form_3.getComplexSubjectInfo(); // Sửa ở đây
            if (complexSubject != null) {
                complexSubjectDao.edit(complexSubject);
                form_3.showComplexSubject(complexSubject); // Sửa ở đây
                form_3.showListComplexSubjects(complexSubjectDao.getListComplexSubjects());
                form_3.showMessage("Cập nhật thành công!");
            }
        }
    }

    class DeleteComplexSubjectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ComplexSubject complexSubject = form_3.getComplexSubjectInfo(); // Sửa ở đây
            if (complexSubject != null) {
//                complexSubjectDao.delete(form_3);
                form_3.clearComplexSubjectInfo(); // Sửa ở đây
                form_3.showListComplexSubjects(complexSubjectDao.getListComplexSubjects());
                form_3.showMessage("Xóa thành công!");
            }
        }
    }

    class ClearComplexSubjectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            form_3.clearComplexSubjectInfo(); // Sửa ở đây
        }
    }

    class SortComplexSubjectByNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            complexSubjectDao.sortComplexSubjectByName();
            form_3.showListComplexSubjects(complexSubjectDao.getListComplexSubjects());
        }
    }

    class SortComplexSubjectByBirthDateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            complexSubjectDao.sortComplexSubjectByBirthDate();
            form_3.showListComplexSubjects(complexSubjectDao.getListComplexSubjects());
        }
    }

    class ListComplexSubjectSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            form_3.fillComplexSubjectFromSelectedRow(); // Sửa ở đây
        }
    }
}