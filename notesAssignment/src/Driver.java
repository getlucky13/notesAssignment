import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;
import java.util.*;


public class Driver {
 
    /** Uses a for loop to convert an array of Notes into a pattern for JFugue
     * @param measure Array of Note objects
     * @return pattern for playing through JFugue
     */
    
    public static Pattern toPattern(ArrayList<Note> measure) {
        Pattern output = new Pattern();
        for(Note note : measure) {
            output.add(note.toJfugue());
        }
        output.add("|");
        return output;
    }
    
   
    public static void main(String[] args) throws Exception {
        /*
         * Creates a seven different Note objects for use in testing
         */
        Note C3 = new Note("q", -21);
        Note A3 = new Note("q", -12);
        Note G3 = new Note("q", -14);
        Note B3 = new Note("q", -10);
        Note C4 = new Note("q", -9);
        Note D3 = new Note("q", -19);
        Note F3 = new Note("q", -16);
        Note E3 = new Note("q", -17);
    
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
         * Creates a player object
         */
        Player player = new Player();

        /*
         * Sorts c3Scale, demonstrating correct implementation of Comparable interface
         */
        Collections.sort(c3Scale);

        /*
         * Uses compareTo to output a string to user
         */
        if(C3.compareTo(E3) < 0) {
            System.out.println("E3 is less than C3");
        } else if (C3.compareTo(E3) > 0) {
            System.out.println("C3 is greater than E3");
        }

        /*
         * Feeds the c3Scale ArrayList into a Pattern object, and plays the pattern,
         * correctly playing the C scale from C3 to C4.
         */
        Pattern scale = toPattern(c3Scale).setVoice(1).setInstrument("Piano");
        player.play(scale);
        
        /*
         * Creates two arrays of Note objects
        
        Note[] DAG = {D3, A3, G3};
        Note[] CDG = {C4, D4, G3};

        /*
         * Creates a player object
        
        Player player = new Player();
        
        /*
         * Tests isSharp method
         
        Note Bb6 = new Note("h", 25);
        Boolean toTest = Bb6.isSharp(Bb6.getVal());
        if(toTest == true) {
            player.play(Bb6.toJfugue());
        }
        /*
         * Sets length of Note A4 to a whole note, or w
         
        A4.setLength("w");

        /*
         * Uses the toPattern method to create patterns from each array, as well as sets the
         * voice and instrument for said patterns
         
        Pattern p3 = toPattern(DAG).setVoice(3).setInstrument("Guitar");
        Pattern p4 = toPattern(CDG).setVoice(3).setInstrument("Guitar");
        
        /*
         * Adds the patterns together to make one single pattern
         
        Pattern p5 = p3.add(p4);

        /*
         * Plays created pattern
         
        player.play(p5);

        /*
         * Tests declaring an instrument through JFugue in combination with
         * toJfugue method.
         
        player.play("I[Guitar] "+ A4.toJfugue());*/
    }
}
