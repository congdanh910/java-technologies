package com.demo.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URISyntaxException;
import java.util.Date;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Student student = new Student(123, "Danh", "Ho", "Tien Giang", "congdanh910@gmail.com", new Date());
        Student student1 = new Student(456, "Khanh", "Dang", "Tien Giang", "congdanh910@gmail.com", new Date());
        Student student2 = new Student(789, "Ngan", "Ho", "Tien Giang", "congdanh910@gmail.com", new Date());
        Student student3 = new Student(012, "Ngoc", "Ho", "Tien Giang", "congdanh910@gmail.com", new Date());
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

            System.out.println("------------------------Marshaller one Object--------------------------");
            Marshaller marshaller = jaxbContext.createMarshaller();
            // set out-put printer
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // out-put to system.out
            //marshaller.marshal(student, System.out);

            // out-put to file
            String fileName = "xml/student.xml";
            marshaller.marshal(student, new File(fileName));


            System.out.println("------------------------Unmarshaller one Object--------------------------");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(App.class.getResource("/student.xml").getFile());
            Student studentUnmarshall = (Student) unmarshaller.unmarshal(file);
            System.out.println(studentUnmarshall);
            System.out.println("------------------------Unmarshaller list Object--------------------------");

            MyClass myClass = new MyClass(8910, "Class 1");
            myClass.setCreateDate(new Date());
            myClass.addStudent(student);
            myClass.addStudent(student1);
            myClass.addStudent(student2);
            myClass.addStudent(student3);

            JAXBContext jaxbContextClass = JAXBContext.newInstance(MyClass.class);

            // marshaller
            Marshaller marshallerClass = jaxbContextClass.createMarshaller();
            marshallerClass.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // marshall out-put System.out
            //marshallerClass.marshal(myClass, System.out);
            // marshall out-put file
            String fileNameClass = "xml/classes.xml";
            marshallerClass.marshal(myClass, new File(fileNameClass));


            // unmarshall list object from file
            Unmarshaller unmarshallerClass = jaxbContextClass.createUnmarshaller();
            MyClass myClassUnmarshall = (MyClass) unmarshallerClass.unmarshal(new File(App.class.getResource("/classes.xml").getFile()));
            System.out.println(myClassUnmarshall);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
