import java.lang.Comparable;
/**
 * Class to model a musical Note
 */
public class Note implements Comparable<Note> {

    private String noteName;
    private int value;
    private double length, frequency;

    /**
     * NoArg contstructor, sets length to a quarter note, value to 0, frequency to 440.0,
     * and runs the setName method for the given value.
     */
    public Note() {
        length = 0.25;
        value = 0;
        frequency = 440.0;
        setName(value);
    }

    /**Constructor to create a Note object while providing a length and value for the desired note
     * @param noteLength Double value corresponding to desired note length
     * @param noteVal Value of Note object
     */
    public Note(double noteLength, int noteVal) {
        length = noteLength;
        value = noteVal;
        setName(noteVal);
        setFreq(noteVal);
    }

    /** Gets value stored in length field
     * @return Double stored in length field
     */
    public double getLength() {
        return length;
    } 

    /**Gets value stored in value field
     * @return int stored in value field
     */
    public int getVal() {
        return value;
    }

    /**Gets string stored in noteNAme field
     * @return String containing the value stored in noteName field
     */
    public String getName() {
        return noteName;
    }

    /**
     * Gets value stored in frequency field
     * @return double value stored in frequency
     */
    public double getFrequency() {
            return frequency;
    }

    /**Setter method for length field
     * @param noteLength Double containing desired length of note
     */
    public void setLength(double noteLength) {
        length = noteLength;
    }

    /**Setter method for value field
     * @param noteVal int to set value field to
     */
    public void setVal(int noteVal) {
        value = noteVal;
    }

    /**Method to set the name and octave of the note based on the given value.
     * By dividiing the value by 12 and adding 4, the octave of the note is found.
     * The remainder of that division yeilds the note name itself using a switch statement.
     * When noteVal is between 0 and -12, special if-elseif handling is used to output
     * the correct octave value.
     * @param noteVal int value of the note to set the name from
     */
    public void setName(int noteVal) {
        int formattedVal, octave;
        if (noteVal < 0 && noteVal >= -9) {
            octave = 4;
        } else if (noteVal < -9 && noteVal >=-12){
            octave = 3;
        } else {
            octave = (noteVal/12) + 4;
        }

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

    /**Method to calculate the frequency of the note from the value, stored into the 
     * frequency field
     * @param noteVal int value of note to calculate frequency from
     */
    public void setFreq(double noteVal) {
        frequency = 440 * Math.pow(2.0, (noteVal/12));
    }

    /**Method to determine if a note is sharpe or not by taking the remainder of the
     * notes value when divided by 12. Uses a switch statement to return true or false
     * @param noteVal int value of note to be checked
     * @return boolean depending on whether note is false or not
     */
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

    /**Method to format noteName and length for inputing into JFugue player
     * @return String containing noteName and length, formatted for JFugue
     */
    /*public String toJfugue() {
        return noteName + length;
    }*/

    /**
     * Implements compareTo method of Comparable interface, comparing first the length
     * field of both objects, than the frequency field.
     * @param input Note object to compare
     * @return pos value if calling object is greater than, negative value if it is less 
     * than, and 0 if objects are equal
     */
    public int compareTo(Note input) {
        if(this.getLength() > input.getLength()){
            return 1;
        } else if (this.getLength() < input.getLength()) {
            return -1;
        } else if (this.getFrequency() > input.getFrequency()){
            return 1;
        } else if (this.getFrequency() < input.getFrequency()) {
            return -1;
        } else {
            return 0;
        }
    }
}
