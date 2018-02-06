/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClasses;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author roshn
 */
public class Car {
    int car_id,car_driver_foreign_id;
    String car_color,car_model,car_licence_number;

    public Car(int car_driver_foreign_id, String car_color, String car_model, String car_licence_number) {
        this.car_driver_foreign_id = car_driver_foreign_id;
        this.car_color = car_color;
        this.car_model = car_model;
        this.car_licence_number = car_licence_number;
    }

    public Car(int car_id, int car_driver_foreign_id, String car_color, String car_model, String car_licence_number) {
        this.car_id = car_id;
        this.car_driver_foreign_id = car_driver_foreign_id;
        this.car_color = car_color;
        this.car_model = car_model;
        this.car_licence_number = car_licence_number;
    }

    public Car() {
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getCar_driver_foreign_id() {
        return car_driver_foreign_id;
    }

    public void setCar_driver_foreign_id(int car_driver_foreign_id) {
        this.car_driver_foreign_id = car_driver_foreign_id;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }


    public String getCar_licence_number() {
        return car_licence_number;
    }

    public void setCar_licence_number(String car_licence_number) {
        this.car_licence_number = car_licence_number;
    }
    
}
