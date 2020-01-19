package ru.testtask.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "role_authorities")
public class RoleAction implements Serializable {
    private String role;
    private String action;

    @Id
    private int id;

    @Column(name = "action", length = 1024, insertable = false, updatable = false)
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Column(name = "role", length = 128, insertable = false, updatable = false)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
