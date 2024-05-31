/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

/**
 *
 * @author User
 */
public interface EducatorService {
    boolean registerEducator(String email, String username, String password, String role, String coordinate);
    boolean getLogin(String username, String password);
}
