package main;

import java.util.ArrayList;

public class Task {
    // Fields
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    // Constructor
    public Task(String taskName, int taskNumber, String taskDescription, 
                String developerDetails, int taskDuration, 
                String taskID, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

    // Method to check if the task description is within 50 characters
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Method to return the total hours of all tasks (used externally)
    public static int returnTotalHours(ArrayList<Task> tasks) {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.taskDuration;
        }
        return totalHours;
    }

    // Method to print full task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Duration: " + taskDuration + " hours\n";
    }

    // Static method to create a unique Task ID
    public static String createTaskID(String taskName, int taskNumber, String developerDetails) {
        return taskName.substring(0, 2).toUpperCase() + ":" +
               taskNumber + ":" +
               developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    }

    // Getter for taskID
    public String getTaskID() {
        return this.taskID;
    }

    // Getter for taskDuration
    public int getTaskDuration() {
        return this.taskDuration;
    }

    // Override toString to use printTaskDetails() for easy display
    @Override
    public String toString() {
        return printTaskDetails();
    }
}
