package toyRobotChallenge;

public class ToyRobotService {
    private Coordinates currentPosition;
    private Directions currentDirection;
    private boolean isPlaced = false;

    public boolean isPlaced() {
        return isPlaced;
    }

    public void place(int x, int y, Directions direction) {
        if (x >= 0 && x < 5 && y >= 0 && y < 5) {
            this.currentPosition = new Coordinates(x, y);
            this.currentDirection = direction;
            this.isPlaced = true;
        }
    }

    public void move() {
        if (isPlaced) {
            Coordinates newPosition = currentDirection.moveForward(currentPosition);
            if (newPosition.getX() >= 0 && newPosition.getX() < 5 &&
                newPosition.getY() >= 0 && newPosition.getY() < 5) {
                currentPosition = newPosition;
            }
        }
    }

    public void left() {
        if (isPlaced) {
            currentDirection = currentDirection.left();
        }
    }

    public void right() {
        if (isPlaced) {
            currentDirection = currentDirection.right();
        }
    }

    public void report() {
        if (isPlaced) {
            System.out.println("Position: " + currentPosition + ", Facing: " + currentDirection);
        } else {
            System.out.println("Robot is not placed on the table.");
        }
    }
}
