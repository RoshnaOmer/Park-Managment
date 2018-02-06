/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClasses;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author roshn
 */
public class Person {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    int person_id, role_foreign_id;
    String person_full_name, person_email, person_username, person_password, person_phone_no;
    String person_birthday;

    public Person(String person_full_name, String person_email, String person_username, String person_password, String person_phone_no, String person_birthday) {
        this.role_foreign_id = 3;
        this.person_full_name = person_full_name;
        this.person_email = person_email;
        this.person_username = person_username;
        this.person_password = person_password;
        this.person_phone_no = person_phone_no;
            this.person_birthday = person_birthday;
    }

    public Person(int person_id, int role_foreign_id, String person_full_name, String person_email, String person_username, String person_password, String person_phone_no, String person_birthday) {
        this.role_foreign_id = role_foreign_id;
        this.person_id = person_id;

        this.person_full_name = person_full_name;
        this.person_email = person_email;
        this.person_username = person_username;
        this.person_password = person_password;
        this.person_phone_no = person_phone_no;
        this.person_birthday = person_birthday;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getRole_foreign_id() {
        return role_foreign_id;
    }

    public void setRole_foreign_id(int role_foreign_id) {
        this.role_foreign_id = role_foreign_id;
    }

    public String getPerson_full_name() {
        return person_full_name;
    }

    public void setPerson_full_name(String person_full_name) {
        this.person_full_name = person_full_name;
    }

    public String getPerson_email() {
        return person_email;
    }

    public void setPerson_email(String person_email) {
        this.person_email = person_email;
    }

    public String getPerson_username() {
        return person_username;
    }

    public void setPerson_username(String person_username) {
        this.person_username = person_username;
    }

    public String getPerson_password() {
        return person_password;
    }

    public void setPerson_password(String person_password) {
        this.person_password = person_password;
    }

    public String getPerson_phone_no() {
        return person_phone_no;
    }

    public void setPerson_phone_no(String person_phone_no) {
        this.person_phone_no = person_phone_no;
    }

    public String getPerson_birthday() {
        return person_birthday;
    }

    public void setPerson_birthday(String person_birthday) {
        this.person_birthday = person_birthday;
    }

    @Override
    public String toString() {
        return "Person{" + "person_id=" + person_id + ", role_foreign_id=" + role_foreign_id + ", person_full_name=" + person_full_name + ", person_email=" + person_email + ", person_username=" + person_username + ", person_password=" + person_password + ", person_phone_no=" + person_phone_no + ", person_birthday=" + person_birthday + '}';
    }

}
