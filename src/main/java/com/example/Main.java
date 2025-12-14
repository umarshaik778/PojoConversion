package com.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import com.example.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        SpringApplication.run(Main.class, args);

//        JSON ↔ POJO ↔ JSON conversion examples
        ObjectMapper jsonMapper1 = new ObjectMapper();
        Student student1 = jsonMapper1.readValue( new File("src/main/resources/student.json"), Student.class);
        System.out.println(student1);

        String json1 = jsonMapper1.writerWithDefaultPrettyPrinter().writeValueAsString(student1);
        System.out.println(json1);

//        XML ↔ POJO ↔ XML conversion examples
        XmlMapper xmlMapper1 = new XmlMapper();
        Student student2 = xmlMapper1.readValue( new File("src/main/resources/student.xml"), Student.class);
        System.out.println(student2);

        String xml1 = xmlMapper1.writerWithDefaultPrettyPrinter().writeValueAsString(student2);
        System.out.println(xml1);

//        JSON → POJO → XML conversion example
        ObjectMapper jsonMapper2 = new ObjectMapper();
        Student student3 = jsonMapper2.readValue( new File("src/main/resources/student.json"), Student.class);
        System.out.println(student3);

        XmlMapper xmlMapper2 = new XmlMapper();
        String xml2 = xmlMapper2.writerWithDefaultPrettyPrinter().writeValueAsString(student3);
        System.out.println(xml2);

//        XML -> POJO → JSON conversion example
        XmlMapper xmlMapper3 = new XmlMapper();
        Student student4 = xmlMapper3.readValue( new File("src/main/resources/student.xml"), Student.class);
        System.out.println(student4);

        ObjectMapper jsonMapper3 = new ObjectMapper();
        String json2 = jsonMapper3.writerWithDefaultPrettyPrinter().writeValueAsString(student4);
        System.out.println(json2);

    }
}