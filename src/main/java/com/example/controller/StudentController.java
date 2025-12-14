package com.example.controller;

import com.example.model.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/student")
public class StudentController {

    // JSON → POJO → JSON
    @PostMapping(
            value = "/JsonToJson",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Student JsonToJson(@RequestBody Student student) {
        return student;
    }

    // XML → POJO → XML
    @PostMapping(
            value = "/XmltoXml",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE
    )
    public Student XmlToXml(@RequestBody Student student) {
        return student;
    }

    // XML → POJO → JSON
    @PostMapping(
            value = "/XmltoJson",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Student XmlToJson(@RequestBody Student student) {
        return student;
    }

    // JSON → POJO → XML
    @PostMapping(
            value = "/JsontoXml",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE
    )
    public Student JsontoXml(@RequestBody Student student) {
        return student;
    }

    @PostMapping(
            value = "/customWithJson",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public StringBuffer customWithJson(@RequestBody Student student) {
        StringBuffer sb = new StringBuffer();

        LocalDateTime now = LocalDateTime.now();

        sb.append("Good ");;
        sb.append( now.getHour() < 12 ?
                "Morning" : now.getHour() > 11 && now.getHour() < 16 ?
                "Afternoon" : "Evening"
        );
        sb.append(" ");;
        sb.append(
                student.getGender().equals("Male")  ?
                        "Mr." : ( student.getGender().equals("Female" ) ) ?
                        "Ms." : "Unknown"
        );
        sb.append(student.getName());
        sb.append(".\n");
        sb.append("Good to know that you are a ");
        int age = student.getAge();
        sb.append(
                age < 30 ?
                "Developer" : ( age >= 30 && age < 50 ) ?
                "Senior Developer" : ( age >= 50 && age <= 65 ) ?
                "Manager" : "Retired Person"
        );
        sb.append(" now.");
        sb.append(" Have a nice day ");
        sb.append(
                student.getGender().equals("Male") ?
                        "Sir" : ( student.getGender().equals("Female") ) ?
                        "Ma'am" : "Unknown"
        );
        sb.append("!");
        System.out.println(sb.toString());
        return sb;
    }

    @PostMapping(
            value = "/customWithXml",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public StringBuffer customWithXml(@RequestBody Student student) {
        StringBuffer sb = new StringBuffer();

        LocalDateTime now = LocalDateTime.now();

        sb.append("Good ");;
        sb.append( now.getHour() < 12 ?
                "Morning" : now.getHour() > 11 && now.getHour() < 16 ?
                "Afternoon" : "Evening"
        );
        sb.append(" ");;
        sb.append(
                student.getGender().equals("Male")  ?
                        "Mr." : ( student.getGender().equals("Female" ) ) ?
                        "Ms." : "Unknown"
        );
        sb.append(student.getName());
        sb.append(".\n");
        sb.append("Good to know that you are a ");
        int age = student.getAge();
        sb.append(
                age < 30 ?
                        "Developer" : ( age >= 30 && age < 50 ) ?
                        "Senior Developer" : ( age >= 50 && age <= 65 ) ?
                        "Manager" : "Retired Person"
        );
        sb.append(" now.");
        sb.append(" Have a nice day ");
        sb.append(
                student.getGender().equals("Male") ?
                        "Sir" : ( student.getGender().equals("Female") ) ?
                        "Ma'am" : "Unknown"
        );
        sb.append("!");
        System.out.println(sb.toString());
        return sb;
    }

}
