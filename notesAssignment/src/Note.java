public class Note {

    private String length, noteName;
    private int value;
    private double frequency;

    public Note() {
        length = "q";
        value = 0;
        frequency = 440.0;
        setName(value);
    }

    public Note(String noteLength, int noteVal) {
        length = noteLength;
        value = noteVal;
        setName(noteVal);
        setFreq(noteVal);
    }

    public String getLength() {
        return length;
    } 

    public int getVal() {
        return value;
    }

    public String getName() {
        return noteName;
    }

    public void setLength(String noteLength) {
        length = noteLength;
    }

    public void setVal(int noteVal) {
        value = noteVal;
    }

    public void setName(int noteVal) {
        int formattedVal, octave;
        octave = (noteVal/12) + 4;
        if(noteVal < 0){
            formattedVal = (noteVal % 12) + 12;
        } else {
            formattedVal = noteVal % 12;
        }
        switch (formattedVal) {
            case 0:
                noteName = "A";
                break;
            case 1:
                noteName = "Bb";
                break;
            case 2:
                noteName = "B";
                break;
            case 3:
                noteName = "C";
                break;
            case 4:
                noteName = "Db";
                break;
            case 5:
                noteName = "D";
                break;
            case 6:
                noteName = "Eb";
                break;
            case 7:
                noteName = "E";
                break;
            case 8:
                noteName = "F";
                break;
            case 9:
                noteName = "Gb";
                break;
            case 10:
                noteName = "G";
                break;
            case 11:
                noteName = "Ab";
                break;
            case 12:
                noteName = "A";
                break;
        }
        noteName += octave;
    }

    public void setFreq(double noteVal) {
        frequency = 440 * Math.pow(2.0, (noteVal/12));
    }

    public boolean isSharp(int noteVal) {
        int formattedVal;
        if(noteVal < 0){
            formattedVal = (noteVal % 12) + 12;
        } else {
            formattedVal = noteVal % 12;
        }
        switch (formattedVal) {
            case 1:
            case 4:
            case 6:
            case 9:
            case 11:
                return true;
            default:
                return false;
        }
    }

    public String toJfugue() {
        return noteName + length;
    }


    public static void main(String[] args) throws Exception {
        Note Db = new Note("q", -8);
        boolean sharp = Db.isSharp(Db.getVal());
        System.out.println(Db.toJfugue());
    }
}
