import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;
import java.util.*;

public class Driver {
 
    /** Uses a for loop to convert an array of Notes into a pattern for JFugue
     * @param measure Array of Note objects
     * @return pattern for playing through JFugue
     */
    /*public static Pattern toPattern(ArrayList<Note> measure) {
        Pattern output = new Pattern();
        for(Note note : measure) {
            output.add(note.toJfugue());
        }
        output.add("|");
        return output;
    }*/
    
   
    public static void main(String[] args) throws Exception {
        /*
         * Creates a seven different Note objects for use in testing
         */
        Note C3 = new Note(.25, -21);
        Note A3 = new Note(.25, -12);
        Note G3 = new Note(.5, -14);
        Note B3 = new Note(.75, -10);
        Note C4 = new Note(1, -9);
        Note D3 = new Note(.25, -19);
        Note F3 = new Note(.75, -16);
        Note E3 = new Note(.0625, -17);
    
        /*
         * Creates an ArrayList of Note objs and adds previously created objs to list
         */
        ArrayList<Note> c3Scale = new ArrayList<>();
        c3Scale.add(C3);
        c3Scale.add(G3);
        c3Scale.add(A3);
        c3Scale.add(F3);
        c3Scale.add(C4);
        c3Scale.add(E3);
        c3Scale.add(D3);
        c3Scale.add(B3);
        
        /*
         * Sorts c3Scale, demonstrating correct implementation of Comparable interface
         */
        Collections.sort(c3Scale);
        
        /*
         * Uses compareTo to output a string to user
         */
        int compareToTest = A3.compareTo(E3);

        /*
         * Creates a player object
         */
        //Player player = new Player();

        /*
         * Feeds the c3Scale ArrayList into a Pattern object, and plays the pattern,
         * correctly playing the C scale from C3 to C4.
         */
        /*Pattern scale = toPattern(c3Scale).setVoice(1).setInstrument("Piano");
        player.play(scale);*/
    }
}
