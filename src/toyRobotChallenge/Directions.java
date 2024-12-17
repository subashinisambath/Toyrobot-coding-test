package toyRobotChallenge;

public enum Directions {
    NORTH, EAST, SOUTH, WEST;

    private static final int[][] DELTAS = {
        {0, 2},  // NORTH
        {2, 0},  // EAST
        {0, -2}, // SOUTH
        {-2, 0}  // WEST
    };

    public Directions left() {
        switch (this) {
            case NORTH: return WEST;
            case EAST: return NORTH;
            case SOUTH: return EAST;
            case WEST: return SOUTH;
            default: throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    public Directions right() {
        switch (this) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            default: throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    public Coordinates moveForward(Coordinates currentPosition) {
        int[] delta = DELTAS[this.ordinal()];
        return new Coordinates(currentPosition.getX() + delta[0], currentPosition.getY() + delta[1]);
    }
}
