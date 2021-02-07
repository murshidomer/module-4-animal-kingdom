import java.awt.*;

public class Bear extends Critter {
    private boolean polar;
    private int counter;

    public Bear(boolean polar){
        this.polar=polar;
        getColor();
    }

    public Color getColor() {
        //Color.WHITE for a polar bear (when polar is true),
        // Color.BLACK otherwise (when polar is false)
        if (polar) return Color.WHITE;
        else return Color.BLACK;
    }

    public String toString(){
        //Should alternate on each different move between a slash character (/)
        // and a backslash character () starting with a slash.
        if (counter % 2 == 0) {
            return "\\";
        } else {
            return "/";
        }

    }

    public Action getMove(CritterInfo info){
        //always infect if an enemy is in front, otherwise hop if possible, otherwise turn left.
        counter++;
        if (info.frontThreat()) {
            return Action.INFECT;
        } else if (!(info.backThreat() || info.rightThreat() || info.leftThreat())) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }

}
