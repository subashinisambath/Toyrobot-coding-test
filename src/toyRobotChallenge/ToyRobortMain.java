package toyRobotChallenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ToyRobortMain {
    public static void main(String[] args) {
        
        // Check if the argument for file is provided
        if (args.length != 1) {
            System.out.println("Please provide a file containing the commands.");
            return;
        }

        String fileName = args[0];  // This is the file path passed to the program
        ToyRobotService robotService = new ToyRobotService();
        boolean placed = false;  // Flag to track if the robot is placed on the table

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String command;
            boolean placedMessagePrinted = false;  // Flag to track if the "place the robot" message has been printed.

            while ((command = br.readLine()) != null) {
                // Split the command into parts based on space
                String[] cmdParts = command.split(" ");
                String action = cmdParts[0];  // The action is the first part (e.g., "PLACE", "MOVE")

                if (action.equals("PLACE")) {
                    // Parse the place coordinates (x, y) and direction (NORTH, EAST, etc.)
                    String[] placeDetails = cmdParts[1].split(",");
                    int x = Integer.parseInt(placeDetails[0]);
                    int y = Integer.parseInt(placeDetails[1]);
                    Directions direction = Directions.valueOf(placeDetails[2]);

                    // Place the robot at the given coordinates and direction
                    robotService.place(x, y, direction);
                    placed = true;
                } else if (placed) {
                    // If the robot is placed, execute other commands (MOVE, LEFT, RIGHT, REPORT)
                    switch (action) {
                        case "MOVE":
                            robotService.move();
                            break;
                        case "LEFT":
                            robotService.left();
                            break;
                        case "RIGHT":
                            robotService.right();
                            break;
                        case "REPORT":
                            robotService.report();
                            break;
                        default:
                            System.out.println("Invalid command: " + action);
                            break;
                    }
                } else {
                    // Print the message only once before any valid PLACE command is encountered
                    if (!placedMessagePrinted) {
                        System.out.println("Please place the robot on the table before issuing commands.");
                        placedMessagePrinted = true;  // Ensure the message is printed only once
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
