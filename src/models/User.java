/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private String password;
    private String locationCoordinate;
    private String parent; // each student can have only one parent
    private List<String> students;
    private Role role;
    private int currentPoints;

    public User(String email, String username, String password, Role role, String parent, List<String> student, String locationCoordinate, int currentPoints) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.parent = parent;
        this.students = students;
        this.locationCoordinate = locationCoordinate;
        this.currentPoints = currentPoints;
    }

public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getParent() {
        return parent;
    }

    public List<String> getStudents() {
        return students;
    }

    public String getLocationCoordinate() {
        return locationCoordinate;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    // Methods
    /*public void addParent(User parent) {
        parent.add(parent);
    }

    public void addChild(User child) {
        students.add(child);
    }

    private String generateRandomCoordinate() {
        // Generate random coordinates here
        return "(x, y)";
    }*/
}
