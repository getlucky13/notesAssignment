import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;

public class Driver {
    
    /** Uses a for loop to convert an array of Notes into a pattern for JFugue
     * @param measure Array of Note objects
     * @return pattern for playing through JFugue
     */
    public static Pattern toPattern(Note[] measure) {
        Pattern output = new Pattern();
        for(int i = 0; i < measure.length; i++) {
            output.add(measure[i].toJfugue());
        }
        output.add("|");
        return output;
    }
   
    public static void main(String[] args) throws Exception {
        /*
         * Creates a seven different Note objects for use in testing
         */
        Note D3 = new Note("h", -19);
        Note A3 = new Note("q", -12);
        Note G3 = new Note("q", -14);
        Note C4 = new Note("h", -9);
        Note D4 = new Note("q", -7);
        Note A4 = new Note();
        
        /*
         * Creates two arrays of Note objects
         */
        Note[] DAG = {D3, A3, G3};
        Note[] CDG = {C4, D4, G3};

        /*
         * Creates a player object
         */
        Player player = new Player();
        
        /*
         * Tests isSharp method
         */
        Note Bb6 = new Note("h", 25);
        Boolean toTest = Bb6.isSharp(Bb6.getVal());
        if(toTest == true) {
            player.play(Bb6.toJfugue());
        }
        /*
         * Sets length of Note A4 to a whole note, or w
         */
        A4.setLength("w");

        /*
         * Uses the toPattern method to create patterns from each array, as well as sets the
         * voice and instrument for said patterns
         */
        Pattern p3 = toPattern(DAG).setVoice(3).setInstrument("Guitar");
        Pattern p4 = toPattern(CDG).setVoice(3).setInstrument("Guitar");
        
        /*
         * Adds the patterns together to make one single pattern
         */
        Pattern p5 = p3.add(p4);

        /*
         * Plays created pattern
         */
        player.play(p5);

        /*
         * Tests declaring an instrument through JFugue in combination with
         * toJfugue method.
         */
        player.play("I[Guitar] "+ A4.toJfugue());
    }
}
