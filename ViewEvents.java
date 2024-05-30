package WIA1002GP;

import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ViewEvents {
    private static ArrayList<Event> registeredEvents = new ArrayList<>();

    public static void viewEvents() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ArrayList<Event> events = EventQuiz.getCreatedEvents();
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

        System.out.println("Live Events:");
        for(Event event : liveEvents) {
            System.out.println(event.getTitle() + " - " + event.getDate() + " " + event.getTime());
        }

        System.out.println("\nClosest 3 Upcoming Events:");
        for(int i = 0; i < Math.min(3, upcomingEvents.size()); i++) {
            Event event = upcomingEvents.get(i);
            System.out.println(event.getTitle() + " - " + event.getDate() + " " + event.getTime());
        }
    }

    public static void registerForEvent(String eventName) {
        Event eventToRegister = null;

        for(Event event : EventQuiz.getCreatedEvents()) {
            if(event.getTitle().equals(eventName)) {
                eventToRegister = event;
                break;
            }
        }

        if(eventToRegister == null) {
            System.out.println("Event not found.");
            return;
        }

        LocalDate eventDate = LocalDate.parse(eventToRegister.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        for(Event registeredEvent : registeredEvents) {
            LocalDate registeredDate = LocalDate.parse(registeredEvent.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
            if(eventDate.equals(registeredDate)) {
                System.out.println("You have already registered for an event on the date " + registeredDate + '.');
                return;
            }
        }

        registeredEvents.add(eventToRegister);
        System.out.println("You have successfully registered for the event: " + eventName + " and gained 5 points.");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        viewEvents();
        System.out.println("\nDo you want to register for an event? Enter 'Yes' or 'No' only.");
        String response = "";
        do {
            response = input.readLine();
        } while(!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no"));

        if(response.equalsIgnoreCase("yes")) {
            System.out.println("Enter the name of the event you want to register for:");
            String eventName = input.readLine();
            registerForEvent(eventName);
        }

        input.close();
    }
}