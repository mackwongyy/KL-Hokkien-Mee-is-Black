/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

/**
 *
 * @author User
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import services.EducatorService;

public class EducatorRepository implements EducatorService {
    private final String CSV_FILE_PATH = "C:/Users/lam zhuo yi/OneDrive/Desktop/Data Structure/KL-Hokkien-Mee-is-Black/src/resource/Educator.csv";
    
    @Override
    public boolean registerEducator(String email, String username, String password, String role, String coordinate) {
        // Implement CSV writing logic to add a new educator
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true))) {
            writer.write(email+ "," +username + "," + password + "," + role +","+ coordinate + "\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean getLogin(String username, String password) {
        // Implement CSV parsing logic to check login credentials
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String csvUsername = parts[1];
                    String csvPassword = parts[2];
                    if (username.equals(csvUsername) && password.equals(csvPassword)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
