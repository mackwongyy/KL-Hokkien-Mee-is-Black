import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Event {
    protected String title, description, venue, date, time;

    public Event(String title, String description, String venue, String date, String time) {
        this.title = title;
        this.description = description;
        this.venue = venue;
        this.date = date;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getVenue() {
        return venue;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}

class Quiz {
    protected String title, description, theme, content;

    public Quiz(String title, String description, String theme, String content) {
        this.title = title;
        this.description = description;
        this.theme = theme;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTheme() {
        return theme;
    }

    public String getContent() {
        return content;
    }
}

class Parent {
    protected String id, name;
    protected ArrayList<Event> registeredEvents;

    public Parent(String id, String name) {
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

class Student {
    protected String id, name;
    protected ArrayList<Quiz> attemptedQuizzes;
    protected ArrayList<Event> registeredEvents;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.attemptedQuizzes = new ArrayList<>();
        this.registeredEvents = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Quiz> getAttemptedQuizzes() {
        return attemptedQuizzes;
    }

    public ArrayList<Event> getRegisteredEvents() {
        return registeredEvents;
    }

    public void attemptQuiz(Quiz quiz) {
        this.attemptedQuizzes.add(quiz);
    }

    public void registerEvent(Event event) {
        this.registeredEvents.add(event);
    }
}

public class EventQuiz {
    public static String title, description, venue, date, time, theme, content;
    public static ArrayList<Event> createdEvents = new ArrayList<>();
    public static ArrayList<Quiz> createdQuizzes = new ArrayList<>();
    public static List<Character> selectedThemes = new ArrayList<>();
    public static long studentPoints = 0;

    public static void createEvent(String title, String description, String venue, String date, String time) {
        Event event = new Event(title, description, venue, date, time);
        createdEvents.add(event);
    }

    public static void createQuiz(String title, String description, String theme, String content) {
        Quiz quiz = new Quiz(title, description, theme, content);
        createdQuizzes.add(quiz);
    }

    public static ArrayList<Event> getCreatedEvents() {
        return createdEvents;
    }

    public static ArrayList<Quiz> getCreatedQuizzes() {
        return createdQuizzes;
    }

    public static void registerEvent(Student student, String eventTitle, PrintWriter output) {
        for(Event event : createdEvents) {
            if(event.getTitle().equals(eventTitle)) {
                for(Event registeredEvent : student.getRegisteredEvents()) {
                    if(registeredEvent.getDate().equals(event.getDate())) {
                        output.println("Event time clash.\nRegistration unsuccessful.");
                        return;
                    }
                }

                student.registerEvent(event);
                studentPoints += 5;
                output.println("Registration successful! You have gained 5 points. Your total tally of points is " + studentPoints + '.');
                return;
            }
        }

        output.println("Event not found!");
    }

    public static void viewQuizzes(PrintWriter output, List<Character> selectedThemes) {
        for(Quiz quiz : createdQuizzes) {
            for(char theme : selectedThemes) {
                if(quiz.getTheme().charAt(0) == theme) {
                    output.println("Quiz Title: " + quiz.getTitle() + "\nQuiz Theme: " + quiz.getTheme());
                }
            }
        }
    }

    public static void attemptQuiz(Student student, String quizTitle, BufferedReader input, PrintWriter output) throws IOException {
        Quiz selectedQuiz = null;
        for(Quiz quiz : createdQuizzes) {
            if(quiz.getTitle().equalsIgnoreCase(quizTitle)) {
                selectedQuiz = quiz;
                break;
            }
        }

        if(selectedQuiz == null) {
            output.println("Quiz not found.");
            return;
        }

        if(student.getAttemptedQuizzes().contains(selectedQuiz)) {
            output.println("You have already completed this quiz.");
            return;
        }

        output.println("Quiz Content: " + selectedQuiz.getContent());
        output.println("Enter any key when you have completed the quiz...");
        input.readLine();

        student.attemptQuiz(selectedQuiz);
        studentPoints += 2;
        output.println("You have successfully completed the quiz: " + quizTitle + " and gained 2 points.\nYour total tally of points is " + studentPoints + '.');
    }

    public static void createOccurrences(BufferedReader input, PrintWriter output) throws IOException {
        output.println("\n+++++++++++++++++++++++\nEVENT AND QUIZ CREATION\n+++++++++++++++++++++++"); 
        output.println("Select whether you want to create an event or a quiz.");
        char selection;
        do {
            output.println("Type 'E' for event or 'Q' for quiz, else you will be prompted to select again, until your response is valid.");
            selection = input.readLine().charAt(0);
        } while(selection != 'E' && selection != 'Q');

        if(selection == 'E') {
            output.println("Enter the title of your event.");
            title = input.readLine();

            output.println("Enter the description of your event.");
            description = input.readLine();

            output.println("Enter the venue of your event.");
            venue = input.readLine();

            boolean validDate = false;
            do {
                output.println("Enter the date of your event, in YYYY-MM-DD format:");
                date = input.readLine();
                try {
                    LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    validDate = true;
                } catch(DateTimeParseException e) {
                    output.println("Invalid date format or invalid date. Please try again.");
                }
            } while(!validDate);
            
            boolean validTime = false;
            do {
                output.println("Enter the time of your event, in HH:MM:SS format:");
                time = input.readLine();
                String[] timeParts = time.split(":");
                if(timeParts.length == 3) {
                    try {
                        int hour = Integer.parseInt(timeParts[0]);
                        int minute = Integer.parseInt(timeParts[1]);
                        int second = Integer.parseInt(timeParts[2]);
                        validTime = (hour >= 0 && hour <= 23) && (minute >= 0 && minute <= 59) && (second >= 0 && second <= 59);
                    } catch(NumberFormatException e) {
                        validTime = false;
                    }
                }

                if(!validTime) {
                    output.println("Invalid time format. Please try again.");
                }
            } while(!validTime);

            createEvent(title, description, venue, date, time);
        } else {
            output.println("Enter the title of your quiz.");
            title = input.readLine();
    
            output.println("Enter the description of your quiz.");
            description = input.readLine();

            output.println("Enter the theme of your quiz (Science, Technology, Engineering, Mathematics).\nChoose one that is the most relevant.");
            theme = input.readLine();
        
            output.println("Enter the content of your quiz.");
            content = input.readLine();

            createQuiz(title, description, theme, content);
        }
    }

    public static void participateOccurrences(Student student, BufferedReader input, PrintWriter output) throws IOException {
        output.println("\n++++++++++++++++++++++++\nOCCURRENCE PARTICIPATION\n++++++++++++++++++++++++");
        char selection;
        do {
            output.println("\nWelcome to the part where you will register for an event and/or attempt a quiz.\nType 'E' to register for an event, 'Q' to attempt a quiz, or 'A' to do both.");
            selection = input.readLine().charAt(0);
        } while(selection != 'E' && selection != 'Q' && selection != 'A');
    
        if(selection == 'E') {
            output.println("\nEnter the event title you would like to register for.");
            String eventTitle = input.readLine();
            registerEvent(student, eventTitle, output);
        } else if(selection == 'Q') {
            output.println("\nSelect the themes you want to filter quizzes by (Science, Technology, Engineering, Mathematics).\nType 'S' for Science, 'T' for Technology, 'E' for Engineering, 'M' for Mathematics, or 'A' for all.\nYou will be prompted again until you type in the correct character to the corresponding selection.");
            char themeInput = input.readLine().charAt(0);

            if(themeInput == 'A') {
                selectedThemes = Arrays.asList('S', 'T', 'E', 'M');
            } else {
                selectedThemes = Arrays.asList(themeInput);
            }
    
            output.println("\nHere are all the quizzes with the themes you selected as the filter.");
            viewQuizzes(output, selectedThemes);

            output.println("\nEnter the quiz title you would like to attempt.");
            String quizTitle = input.readLine();
            attemptQuiz(student, quizTitle, input, output);
        } else {
            // Register Event
            output.println("\nEnter the event title you would like to register for.");
            String eventTitle = input.readLine();
            registerEvent(student, eventTitle, output);

            // Attempt Quiz
            output.println("\nSelect the themes you want to filter quizzes by (Science, Technology, Engineering, Mathematics).\nType 'S' for Science, 'T' for Technology, 'E' for Engineering, 'M' for Mathematics, or 'A' for all.\nYou will be prompted again until you type in the correct character to the corresponding selection.");
            char themeInput = input.readLine().charAt(0);

            if(themeInput == 'A') {
                selectedThemes = Arrays.asList('S', 'T', 'E', 'M');
            } else {
                selectedThemes = Arrays.asList(themeInput);
            }
    
            output.println("\nHere are all the quizzes with the themes you selected as the filter.");
            viewQuizzes(output, selectedThemes);

            output.println("\nEnter the quiz title you would like to attempt.");
            String quizTitle = input.readLine();
            attemptQuiz(student, quizTitle, input, output);
        }
    }

    public static void viewEvents(PrintWriter output) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ArrayList<Event> events = getCreatedEvents();
        ArrayList<Event> liveEvents = new ArrayList<>(), upcomingEvents = new ArrayList<>();
    
        for(Event event : events) {
            LocalDate eventDate = LocalDate.parse(event.getDate(), dateFormatter);
                
            if(eventDate.equals(today)) {
                liveEvents.add(event);
            } else if(eventDate.isAfter(today)) {
                upcomingEvents.add(event);
            }
        }
    
        Collections.sort(upcomingEvents, (e1, e2) -> {
            LocalDate date1 = LocalDate.parse(e1.getDate(), dateFormatter);
            LocalDate date2 = LocalDate.parse(e2.getDate(), dateFormatter);
            return date1.compareTo(date2);
        });
    
        output.println("Live Events:");
        for (Event event : liveEvents) {
            output.println(event.getTitle() + " - " + event.getDate() + " " + event.getTime());
        }
    
        output.println("\nClosest " + Math.min(3, upcomingEvents.size()) + " Upcoming Events:");
        for(int i = 0; i < Math.min(3, upcomingEvents.size()); i++) {
            Event event = upcomingEvents.get(i);
            output.println(event.getTitle() + " - " + event.getDate() + " " + event.getTime());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(new OutputStreamWriter(System.out), true);
        char role, view;
        output.println("\n++++++++++++++++++++++++++++++++\nEVENT AND QUIZ MANAGEMENT SYSTEM\n++++++++++++++++++++++++++++++++"); 
        do {
            output.println("\nSelect your role.\nType 'E' for 'Educator', 'P' for 'Parent', 'S' for 'Student'.\nType 'X' to exit the system.\nAny other entries will result in repetitive prompts until one of the three roles are selected.");
            role = input.readLine().charAt(0);
    
            if(role == 'E') {
                createOccurrences(input, output);
            } else if(role == 'S') {
                // Dummy entry for Student
                Student student = new Student("1", "Wong Yoong Yee");
                participateOccurrences(student, input, output);
            } else if(role == 'X') {
                output.println("Exiting the system...");
                break;
            }
    
            if(role == 'E' || role == 'P' || role == 'S') {
                do {
                    output.println("\nDo you wish to view events?\nType 'Y' if so, else 'N' if not.");
                    view = input.readLine().charAt(0);
                } while(view != 'Y' && view != 'N');
        
                if(view == 'Y') {
                    viewEvents(output);
                }
            }
        } while(role != 'X');
    
        input.close();
        output.close();
    }
}