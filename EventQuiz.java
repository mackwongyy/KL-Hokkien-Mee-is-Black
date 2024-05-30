package WIA1002GP;

import java.util.*;
import java.io.*;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

public class EventQuiz {
    public static String title, description, venue, date, time, theme, content;
    private static ArrayList<Event> createdEvents = new ArrayList<>();
    private static ArrayList<Quiz> createdQuizzes = new ArrayList<>();

    private static boolean isValidDate(int year, int month, int day) {
        if(year < 0 || year > 9999 || month < 1 || month > 12) {
            return false;
        }
        int[] daysInMonth = {31, (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return day > 0 && day <= daysInMonth[month - 1];
    }

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

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean validDate = false, validTime = false;

        System.out.println("Select whether you want to create an event or a quiz. Type 'E' for event and 'Q' for quiz, else you will be prompted to select again, until your response is valid.");
        char selection = input.readLine().charAt(0);

        if(selection == 'E') {
            System.out.println("Enter the title of your event.");
            title = input.readLine();

            System.out.println("Enter the description of your event.");
            description = input.readLine();

            System.out.println("Enter the venue of your event.");
            venue = input.readLine();

            do {
                System.out.println("Enter the date of your event, in YYYY-MM-DD format:");
                date = input.readLine();
                String[] dateParts = date.split("-");
        
                if(dateParts.length == 3) {
                    try {
                        int year = Integer.parseInt(dateParts[0]);
                        int month = Integer.parseInt(dateParts[1]);
                        int day = Integer.parseInt(dateParts[2]);
                        validDate = isValidDate(year, month, day);
                    } catch(NumberFormatException e) {
                        validDate = false;
                    }
                }
        
                if(!validDate) {
                    System.out.println("Invalid date format or invalid date. Please try again.");
                }
            } while(!validDate);
            
            do {
                System.out.println("Enter the time of your event, in HH:MM:SS format:");
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
                    System.out.println("Invalid time format. Please try again.");
                }
            } while(!validTime);

            createEvent(title, description, venue, date, time);
        } else if(selection == 'Q') {
            System.out.println("Enter the title of your quiz.");
            title = input.readLine();
    
            System.out.println("Enter the description of your quiz.");
            description = input.readLine();

            do {
                System.out.println("Enter the theme of your quiz.");
                theme = input.readLine();
            } while(!theme.equalsIgnoreCase("Science") && !theme.equalsIgnoreCase("Technology") && !theme.equalsIgnoreCase("Engineering") && !theme.equalsIgnoreCase("Mathematics"));
        
            System.out.println("Enter the content of your quiz.");
            content = input.readLine();

            createQuiz(title, description, theme, content);
        }

        input.close();
    }
}
