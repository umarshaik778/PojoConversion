package com.example.controller;

import com.example.model.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


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

  // JSON -> POJO -> Text
    @PostMapping(
            value = "/customWithJson",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public StringBuffer customWithJson(@RequestBody Student student) {
        return generateText(student);
    }

    // XML -> POJO -> Text
    @PostMapping(
            value = "/customWithXml",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public StringBuffer customWithXml(@RequestBody Student student) {
        return generateText(student);
    }

    public StringBuffer generateText(Student student) {
        StringBuffer sb = new StringBuffer();

        LocalDateTime now = LocalDateTime.now();
        String Greeting = "Good ";
        String TimeOfDay = now.getHour() < 12 ? "Morning" : now.getHour() < 16 ? "Afternoon" : "Evening";
        String Title = student.getGender().equals("Male") ? "Mr." : (student.getGender().equals("Female")) ? "Ms." : "Unknown";
        String Name = student.getName();
        String goodToKnow = "Good to know that you are a ";
        int age = student.getAge();
        String Profession = age < 30 ? "Developer" : age < 50 ? "Senior Developer" : age <= 65 ? "Manager" : "Retired Person";
        String secondGreeting = "Have a nice day ";
        String Salutation = student.getGender().equals("Male") ? "Sir" : (student.getGender().equals("Female")) ? "Ma'am" : "Unknown";
        String FinalString = Greeting + TimeOfDay + " " + Title + Name + ".\n" + goodToKnow + Profession + " now. " + secondGreeting + Salutation + "!";
        sb.append(FinalString);
        System.out.println(sb);
        return sb;
    }

}
