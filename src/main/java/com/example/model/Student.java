package com.example.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JsonIgnoreProperties(ignoreUnknown = true)     // ignore extra JSON fields
@JsonInclude(JsonInclude.Include.NON_NULL)     // exclude null fields in JSON output
@JsonPropertyOrder({"id", "student_name", "branch", "age"})
@JacksonXmlRootElement(localName = "student")
public class Student {

    // getters & setters (explicit)
    @JsonProperty("id")
    @JacksonXmlProperty(localName = "id")
    private int id;

    @JsonProperty("student_name")
    @JacksonXmlProperty(localName = "student_name")
    private String name;

    @JsonProperty("branch")
    @JacksonXmlProperty(localName = "branch")
    private String branch;

    @JsonProperty("age")
    @JacksonXmlProperty(localName = "age")
    private int age;

    @JsonProperty("gender")
    @JacksonXmlProperty(localName = "gender")
    private String gender;


    // Mandatory no-arg constructor
    public Student() {
    }

    public Student(int id, String name, String branch, int age, String gender) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.age = age;
        this.gender = gender;
    }

    // getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{id=" + id +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", age=" + age + '}';
    }
}
