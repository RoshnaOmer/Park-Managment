/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClasses;

import java.util.*;

/**
 *
 * @author roshn
 */
public class Admin extends Person {

    private int id;
    private boolean can_add;
    private boolean can_edit;
    private boolean can_delete;
    private boolean full_permission;

    public Admin(int id, boolean can_add, boolean can_edit, boolean can_delete, boolean full_permission, int person_id, int role_foreign_id, String person_full_name, String person_email, String person_username, String person_password, String person_phone_no, String person_birthday) {
        super(person_id, role_foreign_id, person_full_name, person_email, person_username, person_password, person_phone_no, person_birthday);
        this.id = id;
        this.can_add = can_add;
        this.can_edit = can_edit;
        this.can_delete = can_delete;
        this.full_permission = full_permission;
    }

    public int getId() {
        return id;
    }

    public boolean isCan_add() {
        return can_add;
    }

    public boolean isCan_edit() {
        return can_edit;
    }

    public boolean isCan_delete() {
        return can_delete;
    }

    public boolean isFull_permission() {
        return full_permission;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCan_add(boolean can_add) {
        this.can_add = can_add;
    }

    public void setCan_edit(boolean can_edit) {
        this.can_edit = can_edit;
    }

    public void setCan_delete(boolean can_delete) {
        this.can_delete = can_delete;
    }

    public void setFull_permission(boolean full_permission) {
        this.full_permission = full_permission;
    }

}
