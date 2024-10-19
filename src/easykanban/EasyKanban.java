package easykanban;

import javax.swing.JOptionPane;

public class EasyKanban
{
    // Static variables to keep track of total hours and task count
    static int totalHours = 0;
    static int taskCount = 0;

    public static void main(String[] args)
    {
        // Display welcome message
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // Perform user login
        login();

        // Show menu and process user choices
        int choice;
        do
        {
            choice = showMenu();
            switch (choice)
            {
                case 1 -> addTask();
                case 2 -> showReport();
                case 3 -> JOptionPane.showMessageDialog(null, "Exiting EasyKanban");
                default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    // Dummy login function
    static void login()
    {
        // For demonstration purposes, let's assume successful login
        JOptionPane.showMessageDialog(null, "Login successful!");
    }

    // Display the menu options and return the user's choice
    static int showMenu()
    {
        String menu = "Choose an option:\n"
                + "1. Add tasks\n"
                + "2. Show report\n"
                + "3. Quit";
        
        String input = JOptionPane.showInputDialog(menu);
        return Integer.parseInt(input);
    }

    // Method to add tasks and update total hours and task count
    static void addTask()
    {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
        
        for (int i = 0; i < numTasks; i++)
        {
            // Gather task details from user input
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            String taskDescription = JOptionPane.showInputDialog("Enter task description:");

            // Validate task description length
            if (taskDescription.length() > 50)
            {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                continue; // Skip to the next iteration if validation fails
            }

            String developerDetails = JOptionPane.showInputDialog("Enter developer details (First Name & Last Name):");
            double taskDuration = Double.parseDouble(JOptionPane.showInputDialog("Enter task duration in hours:"));

            // Generate a unique Task ID for the new task
            String taskID = createTaskID(taskName, developerDetails);
            String taskStatus = JOptionPane.showInputDialog("Enter task status (To Do, Done, Doing):");

            // Create a new Task object and update global statistics
            Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, taskID, taskStatus);
            totalHours += task.getTaskDuration();
            taskCount++;

            // Display the task details to the user
            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }
        
        // Show the total hours across all tasks
        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
    }

    // Generate a unique Task ID based on task name and developer details
    static String createTaskID(String taskName, String developerDetails)
    {
        String[] names = developerDetails.split(" ");
        String initials = taskName.substring(0, 2).toUpperCase() + ":" + taskCount + ":" + names[0].substring(0, 3).toUpperCase();
        return initials;
    }

    // Display a report (currently a placeholder)
    static void showReport()
    {
        JOptionPane.showMessageDialog(null, "Coming Soon");
    }
}

// Task class to represent individual tasks
class Task
{
    private final String taskName;
    private final String taskDescription;
    private final String developerDetails;
    private final double taskDuration;
    private final String taskID;
    private final String taskStatus;

    // Constructor to initialize a Task object
    public Task(String taskName, String taskDescription, String developerDetails, double taskDuration, String taskID, String taskStatus)
    {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

    // Method to print task details in a formatted manner
    public String printTaskDetails()
    {
        return "Task Status: " + taskStatus + "\n" +
                "Developer Details: " + developerDetails + "\n" +
                "Task Number: " + (EasyKanban.taskCount - 1) + "\n" +
                "Task Name: " + taskName + "\n" +
                "Task Description: " + taskDescription + "\n" +
                "Task ID: " + taskID + "\n" +
                "Duration: " + taskDuration + " hours";
    }

    // Getter for task duration
    public double getTaskDuration()
    {
        return taskDuration;
    }
}
