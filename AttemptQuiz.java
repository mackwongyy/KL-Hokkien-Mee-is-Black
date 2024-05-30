package WIA1002GP;

import java.util.*;
import java.io.*;

public class AttemptQuiz {
    private static Set<String> completedQuizzes = new HashSet<>();

    public static void viewQuizzes(List<String> selectedThemes) {
        ArrayList<Quiz> quizzes = EventQuiz.getCreatedQuizzes();

        System.out.println("Available Quizzes:");
        for(Quiz quiz : quizzes) {
            if(selectedThemes.contains(quiz.getTheme())) {
                System.out.println(quiz.getTitle() + " - " + quiz.getTheme() + "\n" + quiz.getDescription());
            }
        }
    }

    public static void attemptQuiz(String quizTitle) throws IOException {
        ArrayList<Quiz> quizzes = EventQuiz.getCreatedQuizzes();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        Quiz selectedQuiz = null;
        for(Quiz quiz : quizzes) {
            if(quiz.getTitle().equalsIgnoreCase(quizTitle)) {
                selectedQuiz = quiz;
                break;
            }
        }

        if(selectedQuiz == null) {
            System.out.println("Quiz not found.");
            return;
        }

        if(completedQuizzes.contains(quizTitle)) {
            System.out.println("You have already completed this quiz.");
            return;
        }

        System.out.println("Quiz Content: " + selectedQuiz.getContent());
        System.out.println("Enter any key when you have completed the quiz...");
        input.readLine();

        completedQuizzes.add(quizTitle);
        System.out.println("You have successfully completed the quiz: " + quizTitle + " and gained 2 points.");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<String> selectedThemes = new ArrayList<>();
        System.out.println("\n++++++++++++\nATTEMPT QUIZ\n++++++++++++");
        System.out.println("Select the themes you want to filter quizzes by (Science, Technology, Engineering, Mathematics).");
        System.out.println("Enter the themes separated by commas or type 'all' to view all quizzes.");
        String themeInput = input.readLine();

        if (themeInput.equalsIgnoreCase("all")) {
            selectedThemes = Arrays.asList("Science", "Technology", "Engineering", "Mathematics");
        } else {
            String[] themes = themeInput.split(",");
            for (String theme : themes) {
                selectedThemes.add(theme.trim());
            }
        }

        viewQuizzes(selectedThemes);

        String response;
        do {
            System.out.println("\nDo you want to attempt a quiz? Enter 'Yes' or 'No' only.");
            response = input.readLine();
        } while(!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no"));

        if(response.equalsIgnoreCase("yes")) {
            System.out.println("Enter the title of the quiz you want to attempt:");
            String quizTitle = input.readLine();
            attemptQuiz(quizTitle);
        }

        input.close();
    }
}