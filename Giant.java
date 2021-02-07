import java.awt.*;

public class Giant extends Critter{
    private int moves;
    static double counter = 0;
    static double temp = 0;
    static int i;
    private final String[] giantNames = {"fee", "fie", "foe", "fum"};
    private int count;
    private String previousName;
    private int giantIndex;

    public Giant(){
        getColor();
    }

    public Color getColor (){
        return Color.GRAY;
    }


    public String toString() {
        //"fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 moves, then "fum" for 6 moves, then repeat.
        this.count = this.count + 1;
        if ((this.count - 1) % 6 == 0) {
            if (this.giantIndex == 4) {
                this.giantIndex = 0;
            }
            this.giantIndex = this.giantIndex + 1;
            return giantNames[giantIndex - 1].toString();
        } else {
            this.previousName = giantNames[giantIndex - 1];
        }
        return this.previousName;
    }

    public Action getMove(CritterInfo info) {
        //always infect if an enemy is in front, otherwise hop if possible, otherwise turn right
        //track moves
        if (info.frontThreat()) {
//            moves++;
            return Action.INFECT;
        } else if (!(info.backThreat() || info.rightThreat() || info.leftThreat())) {
//            moves++;
            return Action.HOP;
        } else {
//            moves++;
            return Action.RIGHT;
        }
    }

//    public void countMoves(){
//        if (moves==24){
//            moves=1;
//        } else {
//            moves++;
//        }
//    }
}
