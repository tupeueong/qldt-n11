
package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.ComplexSubject;
import model.ComplexSubjectXML;
import utils.FileUtils;

public class ComplexSubjectDao {
    private static final String COMPLEX_SUBJECT_FILE_NAME = "D:/Download(D)/Documents/NetbeansProjects/login-ui/src/main/java/DB/complexSubject.xml";
    private List<ComplexSubject> listComplexSubjects;

    public ComplexSubjectDao() {
        this.listComplexSubjects = readListComplexSubjects();
        if (listComplexSubjects == null) {
            listComplexSubjects = new ArrayList<ComplexSubject>();
        }
    }

    public void writeListComplexSubjects(List<ComplexSubject> complexSubjects) {
        ComplexSubjectXML complexSubjectXML = new ComplexSubjectXML();
        complexSubjectXML.setComplexSubjects(complexSubjects);
        FileUtils.writeXMLtoFile(COMPLEX_SUBJECT_FILE_NAME, complexSubjectXML);
    }

    public List<ComplexSubject> readListComplexSubjects() {
        List<ComplexSubject> list = new ArrayList<ComplexSubject>();
        ComplexSubjectXML complexSubjectXML = (ComplexSubjectXML) FileUtils.readXMLFile(
                COMPLEX_SUBJECT_FILE_NAME, ComplexSubjectXML.class);
        if (complexSubjectXML != null) {
            list = complexSubjectXML.getComplexSubjects();
        }
        return list;
    }

    public void add(ComplexSubject complexSubject) {
        int id = 1;
        if (listComplexSubjects != null && listComplexSubjects.size() > 0) {
            id = listComplexSubjects.size() + 1;
        }
        complexSubject.setId(id);
        listComplexSubjects.add(complexSubject);
        writeListComplexSubjects(listComplexSubjects);
    }

    public void edit(ComplexSubject complexSubject) {
        int size = listComplexSubjects.size();
        for (int i = 0; i < size; i++) {
            if (listComplexSubjects.get(i).getId() == complexSubject.getId()) {
                listComplexSubjects.get(i).setHoTen(complexSubject.getHoTen());
                listComplexSubjects.get(i).setNgaySinh(complexSubject.getNgaySinh());
                listComplexSubjects.get(i).setNoio(complexSubject.getNoio());
                listComplexSubjects.get(i).setHoKhauThuongTru(complexSubject.getHoKhauThuongTru());
                listComplexSubjects.get(i).setThanNhan(complexSubject.getThanNhan());
                listComplexSubjects.get(i).setLoaiDoiTuong(complexSubject.getLoaiDoiTuong());
                writeListComplexSubjects(listComplexSubjects);
                break;
            }
        }
    }

    public boolean delete(ComplexSubject complexSubject) {
        boolean isFound = false;
        int size = listComplexSubjects.size();
        for (int i = 0; i < size; i++) {
            if (listComplexSubjects.get(i).getId() == complexSubject.getId()) {
                complexSubject = listComplexSubjects.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listComplexSubjects.remove(complexSubject);
            writeListComplexSubjects(listComplexSubjects);
            return true;
        }
        return false;
    }

//    public void sortComplexSubjectByName() {
//        Collections.sort(listComplexSubjects, new Comparator<ComplexSubject>() {
//            public int compare(ComplexSubject cs1, ComplexSubject cs2) {
//                return cs1.getHoTen().compareTo(cs2.getHoTen());
//            }
//        });
//    }
    public void sortComplexSubjectByName() {
    Collections.sort(listComplexSubjects, new Comparator<ComplexSubject>() {
        public int compare(ComplexSubject cs1, ComplexSubject cs2) {
            String name1 = cs1.getHoTen();
            String name2 = cs2.getHoTen();

            // Kiểm tra giá trị null
            if (name1 == null && name2 == null) return 0; // Cả hai đều null
            if (name1 == null) return 1; // name1 là null, coi nó lớn hơn
            if (name2 == null) return -1; // name2 là null, coi nó nhỏ hơn

            return name1.compareTo(name2); // So sánh nếu cả hai đều không null
        }
    });
}

//    public void sortComplexSubjectByBirthDate() {
//        Collections.sort(listComplexSubjects, new Comparator<ComplexSubject>() {
//            public int compare(ComplexSubject cs1, ComplexSubject cs2) {
//                return cs1.getNgaySinh().compareTo(cs2.getNgaySinh());
//            }
//        });
//    }
    public void sortComplexSubjectByBirthDate() {
    Collections.sort(listComplexSubjects, new Comparator<ComplexSubject>() {
        public int compare(ComplexSubject cs1, ComplexSubject cs2) {
            String date1 = cs1.getNgaySinh();
            String date2 = cs2.getNgaySinh();

            // Kiểm tra giá trị null
            if (date1 == null && date2 == null) return 0; // Cả hai đều null
            if (date1 == null) return 1; // date1 là null, coi nó lớn hơn
            if (date2 == null) return -1; // date2 là null, coi nó nhỏ hơn

            return date1.compareTo(date2); // So sánh nếu cả hai đều không null
        }
    });
}

    public List<ComplexSubject> getListComplexSubjects() {
        return listComplexSubjects;
    }

    public void setListComplexSubjects(List<ComplexSubject> listComplexSubjects) {
        this.listComplexSubjects = listComplexSubjects;
    }
}
