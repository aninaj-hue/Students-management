package com.developer.studentsmanagement;

import jakarta.persistence.*;
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence")

    @Column(name= "StudentID")
    private Long id;
    @Column(name="Nume")
    private String firstName;
    @Column(name="Prenume")
    private String lastName;
    @Column(name="Data_nasterii")
    private String dateOfBirth;
    @Column(name="Adresa")
    private String address;
    @Column(name="Email")
    private String mail;
    @Column(name="Numar_telefon")
    private String phone;
    public Student(Long id, String firstName, String lastName, String dateOfBirth, String address, String mail, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.mail = mail;
        this.phone = phone;
    }
    public Student() {
    }
    public String getLastName() {
        return lastName;
    }
    public String getMail() {
        return mail;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
}
