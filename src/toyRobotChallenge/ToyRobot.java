package toyRobotChallenge;

public class ToyRobot {

    private final ToyRobotService robotService;

    public ToyRobot(ToyRobotService robotService) {
        this.robotService = robotService;
    }

    public void processCommand(String command) {
        String[] parts = command.trim().split(" ");
        try {
            switch (parts[0].toUpperCase()) {
                case "PLACE":
                    if (parts.length == 2) {
                        String[] args = parts[1].split(",");
                        int x = Integer.parseInt(args[0]);
                        int y = Integer.parseInt(args[1]);
                        Directions direction = Directions.valueOf(args[2].toUpperCase());
                        robotService.place(x, y, direction);
                    }
                    break;
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
                    System.out.println("Invalid command: " + command);
            }
        } catch (Exception e) {
            System.out.println("Error processing command: " + command + ". " + e.getMessage());
        }
    }
}
