package repositories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import services.StudentService;



public class StudentRepository implements StudentService {
    private final String CSV_FILE_PATH = "resources/databases/users.csv";

    @Override
    public boolean registerStudent(String username, String password, String role) {
        // Implement CSV writing logic to add a new student
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true))) {
            writer.write(username + "," + password + "," + role + "\n");
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
                if (parts.length == 3) {
                    String csvUsername = parts[0];
                    String csvPassword = parts[1];
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

    // Other methods implementation
}

