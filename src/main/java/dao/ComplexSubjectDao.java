/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author DTC
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.ComplexSubject;
import model.ComplexSubjectXML;
import utils.FileUtils;

public class ComplexSubjectDao {
    private static final String COMPLEX_SUBJECT_FILE_NAME = "/src/main/java/DB/complexSubject.xml";
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
                listComplexSubjects.get(i).setName(complexSubject.getName());
                listComplexSubjects.get(i).setBirthDate(complexSubject.getBirthDate());
                listComplexSubjects.get(i).setAddress(complexSubject.getAddress());
                listComplexSubjects.get(i).setPermanentAddress(complexSubject.getPermanentAddress());
                listComplexSubjects.get(i).setRelatives(complexSubject.getRelatives());
                listComplexSubjects.get(i).setSubjectType(complexSubject.getSubjectType());
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

    public void sortComplexSubjectByName() {
        Collections.sort(listComplexSubjects, new Comparator<ComplexSubject>() {
            public int compare(ComplexSubject cs1, ComplexSubject cs2) {
                return cs1.getName().compareTo(cs2.getName());
            }
        });
    }

    public void sortComplexSubjectByBirthDate() {
        Collections.sort(listComplexSubjects, new Comparator<ComplexSubject>() {
            public int compare(ComplexSubject cs1, ComplexSubject cs2) {
                return cs1.getBirthDate().compareTo(cs2.getBirthDate());
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

