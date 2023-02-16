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
        Pattern p1 = new Pattern("V0 I[Piano] Eq Ch. | Eq Ch. | Dq Eq Dq Cq");
        Pattern p2 = new Pattern("V1 I[Flute] Rw     | Rw     | GmajQQQ  CmajQ");

        Player player = new Player();

        playNotes(DAG);
        playNotes(CDG);
        A4.setLength("w");
        player.play(A4.toJfugue());
        player.play(p1, p2);
    }
}
