import java.awt.*;

public class NinjaCat extends Tiger {


    public NinjaCat (){

    }

    public Color getColor() {
            return Color.MAGENTA;
    }


    public String toString() {
        final String ninjaString = "ninja";
        return ninjaString;

    }

    public Action getMove(CritterInfo info) {
        //simply hops
        return Action.HOP;
    }
}
