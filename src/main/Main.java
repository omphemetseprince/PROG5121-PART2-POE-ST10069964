package main;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Login login = new Login();
        ArrayList<Task> tasks = new ArrayList<>();
        boolean registerCorrect = false;

        // User Registration
        String firstName = JOptionPane.showInputDialog("Please enter your First Name:");
        String lastName = JOptionPane.showInputDialog("Please enter your Last Name:");

        while (!registerCorrect) {
            String userName = JOptionPane.showInputDialog(
                "Create a username (5 characters, must contain an underscore):"
            );
            String passWord = JOptionPane.showInputDialog(
                "Create a password (8+ characters, must contain an uppercase, digit, and special character):"
            );

            login.setUserRegister(userName);
            login.setPassWordRegister(passWord);
            login.setFirstName(firstName);
            login.setLastName(lastName);

            JOptionPane.showMessageDialog(null, login.registerUser());
            if (login.checkPasswordComplexity() && login.checkUsername()) {
                registerCorrect = true;
            }
        }

        // User Login
        if (registerCorrect) {
            String usernameLogin = JOptionPane.showInputDialog("Enter username:");
            login.setUserLogin(usernameLogin);

            String passwordLogin = JOptionPane.showInputDialog("Enter password:");
            login.setUserPassword(passwordLogin);

            JOptionPane.showMessageDialog(null, login.returnLoginStatus());

            if (login.loginUser()) {
                JOptionPane.showMessageDialog(null,
                    login.getFirstName() + " " + login.getLastName() + ", it is great to see you! " +
                    "\nWelcome to EasyKanban."
                );

                // Kanban Features Menu
                showKanbanMenu(tasks);
            }
        }
    }
    //POE PART 2
    // Kanban Menu
    public static void showKanbanMenu(ArrayList<Task> tasks) {
        while (true) {
            String[] options = {"Add Tasks", "Show Report", "Quit"};
            int choice = JOptionPane.showOptionDialog(
                null, "Select an option:", "EasyKanban Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]
            );

            switch (choice) {
                case 0 -> addTasks(tasks);
                case 1 -> JOptionPane.showMessageDialog(null, "Coming Soon");
                case 2 -> {
                    JOptionPane.showMessageDialog(null, "Goodbye! Exiting the system.");
                    System.exit(0);  // Exit the program
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid option. Try again.");
            }
        }
    }

    // Add Tasks Functionality
    public static void addTasks(ArrayList<Task> tasks) {
        int taskCount = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks to add:"));

        for (int i = 0; i < taskCount; i++) {
            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            String taskDescription;

            // Ensure task description is under 50 characters
            while (true) {
                taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
                if (taskDescription.length() <= 50) {
                    JOptionPane.showMessageDialog(null, "Task successfully captured.");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, 
                        "Please enter a task description of less than 50 characters."
                    );
                }
            }

            String developerDetails = JOptionPane.showInputDialog("Enter Developer Details (First and Last Name):");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (hours):"));
            String taskID = generateTaskID(taskName, i, developerDetails);

            String[] statusOptions = {"To Do", "Doing", "Done"};
            int statusChoice = JOptionPane.showOptionDialog(
                null, "Select Task Status:", "Task Status",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, statusOptions, statusOptions[0]
            );

            String taskStatus = statusOptions[statusChoice];

            // Create a new Task and add it to the list
            Task task = new Task(taskName, i, taskDescription, developerDetails, taskDuration, taskID, taskStatus);
            tasks.add(task);
        }

        // Display all added tasks
        StringBuilder taskReport = new StringBuilder("All Tasks:\n");
        for (Task task : tasks) {
            taskReport.append(task).append("\n");
        }
        JOptionPane.showMessageDialog(null, taskReport.toString());
        
         int totalHours = Task.returnTotalHours(tasks);
    JOptionPane.showMessageDialog(null, "Total Hours Across All Tasks: " + totalHours + " hours");

    }

    // Generate Task ID
    public static String generateTaskID(String taskName, int taskNumber, String developerDetails) {
        return taskName.substring(0, 2).toUpperCase() + ":" +
               taskNumber + ":" +
               developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    }
}
