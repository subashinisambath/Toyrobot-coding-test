Toy Robot Program - README

# Toy Robot Challenge

The Toy Robot Program is a command-line application that simulates a toy robot moving on a tabletop. You can control the robot by providing a series of commands through an input file.

# Prerequisites

To run the Toy Robot Program, ensure you have the following installed:

Java: Latest version (must be Java 8 or higher).

IDE (Optional): Any IDE of your choice to view or modify the source code.


# Installation

Download the program as a ZIP file.

Extract the ZIP file to your desired location.


# Execution

Please verify java is installed 

java -version 

Navigate to the project directory:

Open a terminal or PowerShell and change the directory to the ToyRobotExercise folder. 
For example: cd C:\Users\DELL\Desktop\Interview\ToyRobotExercise

Run the programe 

java -cp src toyRobotChallenge.ToyRobortMain src/toyRobotChallenge/commands.txt

here 

-cp src specifies the classpath.

toyRobotChallenge.ToyRobortMain is the main class of the program.

src/toyRobotChallenge/commands.txt is the input file containing the robot commands.

# Note: You can also execute the program from any terminal that supports Java.

# Modifying Input Commands

To modify the robot's commands:

Open the commands.txt file located in the src/toyRobotChallenge directory.

Edit the file using any text editor of your choice.

Save the changes.

Re-run the program using the same command as above to see the updated behavior.

# Notes 

Ensure your commands.txt file follows the correct format (e.g., PLACE, MOVE, LEFT, RIGHT, REPORT) and do not have any extra blank space which will give error when you execute the programe 

