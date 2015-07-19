package com.demo.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.net.URISyntaxException;
import java.util.Date;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Student student = new Student(123, "Danh", "Ho", "Tien Giang", "congdanh910@gmail.com", new Date());
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            // set out-put printer
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // out-put to system.out
            marshaller.marshal(student, System.out);

            // out-put to file
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            String fileName = "student.xml";
            marshaller.marshal(student, new File(fileName));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
