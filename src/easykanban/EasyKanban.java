package easykanban;
import javax.swing.JOptionPane;

public class EasyKanban {
    static int totalHours = 0;
    static int taskCount = 0;

    public static void main(String[] args) {
        // Display welcome message
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // Login
        login();

        // Menu
        int choice;
        do {
            choice = showMenu();
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    showReport();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Exiting EasyKanban");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    static void login() {
        // Dummy login function
        // For demonstration purposes, let's assume successful login
        JOptionPane.showMessageDialog(null, "Login successful!");
    }

    static int showMenu() {
        String menu = "Choose an option:\n"
                + "1. Add tasks\n"
                + "2. Show report\n"
                + "3. Quit";
        String input = JOptionPane.showInputDialog(menu);
        return Integer.parseInt(input);
    }

    static void addTask() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            String taskDescription = JOptionPane.showInputDialog("Enter task description:");
            if (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                continue;
            }
            String developerDetails = JOptionPane.showInputDialog("Enter developer details (First Name & Last Name):");
            double taskDuration = Double.parseDouble(JOptionPane.showInputDialog("Enter task duration in hours:"));
            String taskID = createTaskID(taskName, developerDetails);
            String taskStatus = JOptionPane.showInputDialog("Enter task status (To Do, Done, Doing):");

            Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, taskID, taskStatus);
            totalHours += task.getTaskDuration();
            taskCount++;

            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }
        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
    }

    static String createTaskID(String taskName, String developerDetails) {
        String[] names = developerDetails.split(" ");
        String initials = taskName.substring(0, 2).toUpperCase() + ":" + taskCount + ":" + names[0].substring(0, 3).toUpperCase();
        return initials;
    }

    static void showReport() {
        JOptionPane.showMessageDialog(null, "Coming Soon");
    }
}

class Task {
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private double taskDuration;
    private String taskID;
    private String taskStatus;

    public Task(String taskName, String taskDescription, String developerDetails, double taskDuration, String taskID, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
                "Developer Details: " + developerDetails + "\n" +
                "Task Number: " + (EasyKanban.taskCount - 1) + "\n" +
                "Task Name: " + taskName + "\n" +
                "Task Description: " + taskDescription + "\n" +
                "Task ID: " + taskID + "\n" +
                "Duration: " + taskDuration + " hours";
    }

    public double getTaskDuration() {
        return taskDuration;
    }
}
