/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

/**
 *
 * @author User
 */
public interface ParentService {
        public boolean getLogin(String username, String password);
        boolean registerParent(String username, String password, String child, String role);
}
