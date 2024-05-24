package services;

import java.util.List;
import java.util.Map;

public interface StudentService {
    boolean registerStudent(String username, String password, String role);
    boolean getLogin(String username, String password);
    // Other methods as needed
}
