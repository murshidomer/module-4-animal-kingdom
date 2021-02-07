import java.awt.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Tiger extends Critter {
    static int infectCount=0;
    public Tiger(){
    }

    public Color getColor() {
        //Randomly picks one of three colors (Color.RED, Color.GREEN, Color.BLUE) and uses that color for three moves,
        // then randomly picks one of those colors again for the next three moves,
        // then randomly picks another one of those colors for the next three moves, and so on.
        Color color;
        int colornumber = ThreadLocalRandom.current().nextInt(1, 4);
        switch (colornumber) {
            case 1:
                color = Color.RED;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.BLUE;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + colornumber);
        }
        return color;
    }

    public String toString() {
        return "TGR";
    }

    public Action getMove(CritterInfo info) {
        //always infect if an enemy is in front,
        // otherwise if a wall is in front or to the right, then turn left,
        // otherwise if a fellow Tiger is in front, then turn right, otherwise hop.
        if (info.frontThreat()) {
            infectCount++;
            return Action.INFECT;
        } else if (info.getFront().equals(Neighbor.WALL) || info.getRight().equals(Neighbor.WALL)) {
            return Action.LEFT;
        } else if (info.getFront().equals(Neighbor.SAME))
            return Action.RIGHT;
        else
            return Action.HOP;
    }
}
