# EasyKanban

## Description
EasyKanban is a simple task management application that allows users to add tasks, track their durations, and generate reports. It features a graphical user interface (GUI) using dialog boxes to facilitate user interactions.

## Features
- **User Login**: Dummy login functionality for demonstration purposes.
- **Add Tasks**: Users can input multiple tasks, along with their details, and track the total hours.
- **Task Details**: Each task has a unique ID, name, description, developer details, duration, and status.
- **Report Generation**: Placeholder for future report features.

## Code Overview
- **EasyKanban Class**: Contains the main application logic, including user interaction and task management.
- **Task Class**: Represents individual tasks with their details.

## Usage
1. Clone or download the repository.
2. Open the project in your preferred Java IDE.
3. Compile and run the `EasyKanban` class to start the application.
4. Follow the prompts in the dialog boxes to add tasks and view the total hours.

## Example Workflow
1. Launch the application to see the welcome message.
2. Log in (currently a dummy implementation).
3. Choose to add tasks and enter the required information.
4. View the total hours for all tasks added.

## Task ID Generation
Task IDs are generated based on the task name, developer's initials, and a task count, ensuring uniqueness.

## Validation
- Task descriptions must be less than 50 characters.
- The application currently provides basic input validation and error messages.

## Future Enhancements
- Implement a proper login system with user authentication.
- Add more comprehensive reporting features.
- Enable data persistence to save tasks between sessions.

## Requirements
- Java Development Kit (JDK) 8 or higher
- A Java IDE (e.g., IntelliJ IDEA, Eclipse)
