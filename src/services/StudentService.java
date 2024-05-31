package services;

import java.util.List;
import java.util.Map;
import models.User;
import repositories.StudentRepository;

public interface StudentService {
    boolean registerStudent(String email, String username, String password, String role, String parent, String coordinate, int CurrentPoint);
    boolean getLogin(String username, String password);
    // Other methods as needed
}
