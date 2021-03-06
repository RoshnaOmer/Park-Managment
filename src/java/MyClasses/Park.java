/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClasses;

import java.text.SimpleDateFormat;
import java.util.Date;
import net.sourceforge.jtds.jdbc.DateTime;

public class Park {

    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    private int park_id, car_foreign_id, staff_foreign_id;
    private String time_form, time_to, created_on;
    private double amount_paid;

    public Park(int park_id, int car_foreign_id, int staff_foreign_id, String created_on, String time_form, String time_to, double amount_paid) {
        this.park_id = park_id;
        this.car_foreign_id = car_foreign_id;
        this.staff_foreign_id = staff_foreign_id;
        this.time_form = time_form;
        this.time_to = time_to;
        this.created_on = created_on;
        this.amount_paid = amount_paid;
    }

    public Park(int park_id, int car_foreign_id, int staff_foreign_id, String time_form, String time_to, double amount_paid) {
        this.park_id = park_id;
        this.car_foreign_id = car_foreign_id;
        this.staff_foreign_id = staff_foreign_id;
        this.time_form = time_form;
        this.time_to = time_to;
        Date date = new Date();
        this.created_on = sdf.format(date);
        this.amount_paid = amount_paid;
    }

    public Park(int car_foreign_id, int staff_foreign_id, String time_form, String time_to, double amount_paid) {
        this.car_foreign_id = car_foreign_id;
        this.staff_foreign_id = staff_foreign_id;
        this.time_form = time_form;
        this.time_to = time_to;
        Date date = new Date();
        this.created_on = sdf.format(date);
        this.amount_paid = amount_paid;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCar_foreign_id(int car_foreign_id) {
        this.car_foreign_id = car_foreign_id;
    }

    public int getCar_foreign_id() {
        return car_foreign_id;
    }

    public void setStaff_foreign_id(int staff_foreign_id) {
        this.staff_foreign_id = staff_foreign_id;
    }

    public int getStaff_foreign_id() {
        return staff_foreign_id;
    }

    public void setTime_to(String time_to) {
        this.time_to = time_to;
    }

    public String getTime_to() {
        return time_to;
    }

    public void setPark_id(int park_id) {
        this.park_id = park_id;
    }

    public int getPark_id() {
        return park_id;
    }

    public void setTime_form(String time_form) {
        this.time_form = time_form;
    }

    public String getTime_form() {
        return time_form;
    }

    public double getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(double amount_paid) {
        this.amount_paid = amount_paid;
    }

    @Override
    public String toString() {
        return "Park{" + " park_id=" + park_id + ", car_foreign_id=" + car_foreign_id + ", staff_foreign_id=" + staff_foreign_id + ", time_form=" + time_form + ", time_to=" + time_to + ", created_on=" + created_on + ", amount_paid=" + amount_paid + '}';
    }

}
