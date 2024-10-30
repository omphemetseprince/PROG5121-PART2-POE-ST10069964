package main;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class TaskTest {
    private Task task1, task2, task3;
    private ArrayList<Task> tasks;

    @Before
    public void setUp() { 
        tasks = new ArrayList<>();
        
        // Initialize Task instances
        task1 = new Task("Login", 1, "User login functionality", "Mike Smith", 5, Task.createTaskID("Login", 1, "Mike Smith"), "To Do");
        task2 = new Task("AddFeature", 2, "Database setup and initial data insertion", "Edward Harrington", 8, Task.createTaskID("AddFeature", 2, "Edward Harrington"), "Doing");
        task3 = new Task("Report", 3, "Create detailed report generation", "Samantha Paulson", 3, Task.createTaskID("Report", 3, "Samantha Paulson"), "Done");
        
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
    }

    // Test for task description length validation
    @Test
    public void testCheckTaskDescriptionTrue() {
        Task validTask = new Task("ShortDesc", 4, "This description fits within limit", "John Doe", 2, "SD:4:DOE", "To Do");
        assertTrue("Task description should be valid (within 50 characters)", validTask.checkTaskDescription());
        System.out.println("testCheckTaskDescriptionTrue passed: Task successfully captured.");
    }

    @Test
    public void testCheckTaskDescriptionFalse() {
        Task invalidTask = new Task("LongDesc", 5, "This description is definitely too long and exceeds the 50 character limit imposed by the system", "John Doe", 3, "LD:5:DOE", "Doing");
        assertFalse("Task description should be invalid (exceeds 50 characters)", invalidTask.checkTaskDescription());
        System.out.println("testCheckTaskDescriptionFalse passed: Description exceeds 50 characters.");
    }

    // Test for total hours calculation across multiple tasks
    @Test
    public void testReturnTotalHours() {
        int expectedTotalHours = 16; // 5 + 8 + 3
        int actualTotalHours = Task.returnTotalHours(tasks);
        assertEquals("Total hours across all tasks should match expected value", expectedTotalHours, actualTotalHours);
        System.out.println("testReturnTotalHours passed: Expected " + expectedTotalHours + ", got " + actualTotalHours);
    }

    // Test for unique Task ID generation
    @Test
    public void testCreateTaskID() {
        String expectedID = "LO:1:ITH";
        String actualID = Task.createTaskID("Login", 1, "Mike Smith");
        assertEquals("Task ID should match expected format", expectedID, actualID);
        System.out.println("testCreateTaskID passed: Expected " + expectedID + ", got " + actualID);
    }

    // Test for printTaskDetails output format
    @Test
    public void testPrintTaskDetails() {
        String expectedOutput = "Task Status: To Do\n" +
                                "Developer Details: Mike Smith\n" +
                                "Task Number: 1\n" +
                                "Task Name: Login\n" +
                                "Task Description: User login functionality\n" +
                                "Task ID: LO:1:ITH\n" +
                                "Duration: 5 hours\n";
        String actualOutput = task1.printTaskDetails();
        assertEquals("Task details output should match expected format", expectedOutput, actualOutput);
        System.out.println("testPrintTaskDetails passed: Output matches expected format.");
    }

    // Test toString method override, which calls printTaskDetails()
    @Test
    public void testToString() {
        String expectedOutput = "Task Status: Doing\n" +
                                "Developer Details: Edward Harrington\n" +
                                "Task Number: 2\n" +
                                "Task Name: AddFeature\n" +
                                "Task Description: Database setup and initial data insertion\n" +
                                "Task ID: AD:2:TON\n" +
                                "Duration: 8 hours\n";
        String actualOutput = task2.toString();
        assertEquals("toString() output should match expected format", expectedOutput, actualOutput);
        System.out.println("testToString passed: Output matches expected format.");
    }
}
