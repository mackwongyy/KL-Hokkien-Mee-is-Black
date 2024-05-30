package WIA1002GP;

import java.util.*;
import java.io.*;

class Student {
    private String id, name;
    private ArrayList<Event> registeredEvents;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredEvents = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Event> getRegisteredEvents() {
        return registeredEvents;
    }

    public void registerEvent(Event event) {
        this.registeredEvents.add(event);
    }
}

public class EventRegistration {
    private HashMap<String, Student> students;
    private ArrayList<Event> studentEvents;

    public EventRegistration() {
        this.students = new HashMap<>();
        this.studentEvents = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void createEvent(String title, String description, String venue, String date, String time) {
        Event event = new Event(title, description, venue, date, time);
        studentEvents.add(event);
    }

    public boolean registerStudentForEvent(String studentId, String eventTitle) {
        Student student = students.get(studentId);
        if(student != null) {
            for(Event event : studentEvents) {
                if(event.getTitle().equals(eventTitle)) {
                    for(Event registeredEvent : student.getRegisteredEvents()) {
                        if(registeredEvent.getDate().equals(event.getDate())) {
                            System.out.println("Event time clash.\nRegistration unsuccessful.");
                            return false;
                        }
                    }

                    student.registerEvent(event);
                    System.out.println("Registration successful!");
                    return true;
                }
            }
        }

        System.out.println("Student or Event not found!");
        return false;
    }

    public static void main(String[] args) throws IOException {
        EventRegistration eventManager = new EventRegistration();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        eventManager.addStudent(new Student("1", "Alice"));
        eventManager.addStudent(new Student("2", "Bob"));
        eventManager.createEvent("Math Workshop", "Math workshop for beginners", "Room 101", "2024-06-01", "10:00:00");
        eventManager.createEvent("Science Fair", "Annual science fair", "Hall 1", "2024-06-02", "12:00:00");

        System.out.println("Enter student ID:");
        String studentId = input.readLine();
        System.out.println("Enter event title:");
        String eventTitle = input.readLine();

        eventManager.registerStudentForEvent(studentId, eventTitle);
        input.close();
    }
}
