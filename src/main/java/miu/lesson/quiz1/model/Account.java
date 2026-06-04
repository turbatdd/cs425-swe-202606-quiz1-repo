package miu.lesson.quiz1.model;

import java.time.LocalDate;
import java.time.Period;

public class Account {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;

    public Account(int id, String fName, String lName, String phone, String email, String address) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }


}
