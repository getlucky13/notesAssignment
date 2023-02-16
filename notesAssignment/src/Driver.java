import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;

public class Driver {

    public static void playNotes(Note[] notes) {
        /*
         * If time allows, look into feeding array into pattern instead of 
         * playing each address of the array individually
         */
        Player player = new Player();
        for(int i = 0; i< notes.length;i++){
            player.play(notes[i].toJfugue());
        }
    }

    public static Pattern toPattern(Note[] measure) {
        Pattern output = new Pattern();
        for(int i = 0; i < measure.length; i++) {
            output.add(measure[i].toJfugue());
        }
        output.add("|");
        return output;
    }
   
    public static void main(String[] args) throws Exception {
        Note D3 = new Note("h", -19);
        Note A3 = new Note("q", -12);
        Note G3 = new Note("q", -14);
        Note C4 = new Note("h", -9);
        Note D4 = new Note("q", -7);
        Note A4 = new Note();

        Note[] DAG = {D3, A3, G3};
        Note[] CDG = {C4, D4, G3};

        Player player = new Player();
        A4.setLength("w");

        Pattern p3 = toPattern(DAG).setVoice(3).setInstrument("Guitar");
        Pattern p4 = toPattern(CDG).setVoice(3).setInstrument("Guitar");
        Pattern p5 = p3.add(p4);
        player.play(p5);
        player.play("I[Guitar] "+ A4.toJfugue());
    }
}
