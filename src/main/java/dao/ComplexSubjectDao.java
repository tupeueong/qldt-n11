package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import model.ComplexSubject;
import model.ComplexSubjectXML;
import utils.FileUtils;

public class ComplexSubjectDao {
    private static final String COMPLEX_SUBJECT_FILE_NAME = "D:/Download(D)/Documents/NetBeansProjects/login-ui/src/main/java/DB/complexSubject.xml";
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
        // Duyệt qua danh sách để tìm đối tượng cần sửa
        for (ComplexSubject subject : listComplexSubjects) {
            // Kiểm tra nếu tìm thấy đối tượng có id trùng khớp
            if (subject.getId() == complexSubject.getId()) {
                // Cập nhật tất cả các thuộc tính của đối tượng
                updateSubjectInfo(subject, complexSubject);
                
                // Ghi lại danh sách vào file sau khi cập nhật
                writeListComplexSubjects(listComplexSubjects);
                System.out.println("Đã cập nhật thông tin thành công cho đối tượng có id: " + complexSubject.getId());
                return; // Thoát khỏi phương thức sau khi cập nhật
            }
        }
        System.out.println("Không tìm thấy đối tượng với id: " + complexSubject.getId());

        try {
            // Mở file XML
            File xmlFile = new File("D:/Download(D)/Documents/NetBeansProjects/login-ui/src/main/java/DB/complexSubject.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Tìm đối tượng cần sửa
            NodeList nList = doc.getElementsByTagName("ComplexSubject");
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if (element.getAttribute("id").equals(complexSubject.getId())) { // Giả sử bạn có thuộc tính id
                        // Cập nhật thông tin
                        element.getElementsByTagName("hoTen").item(0).setTextContent(complexSubject.getHoTen());
                        element.getElementsByTagName("ngaySinh").item(0).setTextContent(complexSubject.getNgaySinh());
                        element.getElementsByTagName("gioiTinh").item(0).setTextContent(complexSubject.getGioiTinh());
                        element.getElementsByTagName("noiO").item(0).setTextContent(complexSubject.getNoio());
                        element.getElementsByTagName("hoKhau").item(0).setTextContent(complexSubject.getHoKhauThuongTru());
                        element.getElementsByTagName("thanNhan").item(0).setTextContent(complexSubject.getThanNhan());
                        element.getElementsByTagName("doiTuong").item(0).setTextContent(complexSubject.getLoaiDoiTuong());
                    }
                }
            }

            // Ghi lại file XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Phương thức cập nhật thông tin đối tượng
    private void updateSubjectInfo(ComplexSubject original, ComplexSubject updated) {
        original.setHoTen(updated.getHoTen());
        original.setNgaySinh(updated.getNgaySinh());
        original.setNoio(updated.getNoio());
        original.setHoKhauThuongTru(updated.getHoKhauThuongTru());
        original.setThanNhan(updated.getThanNhan());
        original.setLoaiDoiTuong(updated.getLoaiDoiTuong());
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

    public void deleteComplexSubject(ComplexSubject complexSubject) {
        listComplexSubjects.remove(complexSubject);
        writeListComplexSubjects(listComplexSubjects);
    }

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

    public List<ComplexSubject> searchComplexSubjects(String searchText) {
        List<ComplexSubject> results = new ArrayList<>();
        for (ComplexSubject subject : listComplexSubjects) {
            if (subject.getHoTen().contains(searchText) || subject.getLoaiDoiTuong().contains(searchText)) {
                results.add(subject);
            }
        }
        return results;
    }
}
