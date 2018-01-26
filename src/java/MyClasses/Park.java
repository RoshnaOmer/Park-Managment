/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Park {
    
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
     
     int park_id,car_foreign_id,staff_foreign_id;
     Date time_form,time_to,created_on;

    public Park(int park_id, int car_foreign_id, int staff_foreign_id, Date time_form, Date time_to, Date created_on) {
        this.park_id = park_id;
        this.car_foreign_id = car_foreign_id;
        this.staff_foreign_id = staff_foreign_id;
        this.time_form = time_form;
        this.time_to = time_to;
        this.created_on = created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public Date getCreated_on() {
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

    public void setTime_to(Date time_to) {
        this.time_to = time_to;
    }

    public Date getTime_to() {
        return time_to;
    }

    public void setPark_id(int park_id) {
        this.park_id = park_id;
    }

    public int getPark_id() {
        return park_id;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setTime_form(Date time_form) {
        this.time_form = time_form;
    }

    public Date getTime_form() {
        return time_form;
    }
      

    
    @Override
    public String toString() {
        return "Park{" + "park_id=" + park_id + ", car_foreign_id=" + car_foreign_id + ", staff_foreign_id=" + staff_foreign_id + ", time_form=" + time_form + ", time_to=" + time_to + ", created_on=" + created_on +'}';
    }
}
