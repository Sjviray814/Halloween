/**
 * @author Stephen Viray.
 * @version 1.0 10/09/2024
 */
public abstract class TrickOrTreater implements Comparable<TrickOrTreater> {
    private String name;
    private int age;
    private int numCandy;

    /**
     * @param name name of the trick or treater
     * @param age age of the trick or treater
     * @param numCandy amount of candy that the trick or treater has
     */
    public TrickOrTreater(String name, int age, int numCandy) {
        if (name == null || name.length() == 0 || name.isBlank()) {
            this.name = "Chowder";
        } else {
            this.name = name;
        }

        if (age < 0 || age > 12) {
            this.age = 8;
        } else {
            this.age = age;
        }

        if (numCandy < 0) {
            this.numCandy = 0;
        } else {
            this.numCandy = numCandy;
        }
    }

    /** Increases the amount of candy for the trickortreater. */
    public abstract void trickOrTreat();

    /**
     * @param candy the amount of candy gained by the trick or treater
     */
    protected void gainCandy(int candy) {
        if (candy > 0) {
            numCandy += candy;
        }
    }

    /**
     * @param candy The amount of candy lost by the trick or treater
     */
    protected int loseCandy(int candy) {
        if (candy > 0) {
            numCandy -= candy;
        }
        return candy;
    }

    /**
     * @return the name, age and amount of candy of the trick or treater
     */
    public String toString() {
        return String.format("%s/%d/%d", name, age, numCandy);
    }

    /**
     * @param other The TrickOrTreater object to compare with.
     * @return a negative integer, zero, or a positive integer as this object is
     *         less than, equal to, or greater than the specified object.
     */
    public int compareTo(TrickOrTreater other) {
        if (this.numCandy > other.numCandy) {
            return 1;
        } else if (this.numCandy < other.numCandy) {
            return -1;
        } else {
            if (this.age > other.age) {
                return 1;
            } else if (this.age < other.age) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**
     * @return the amount of candy that this trickortreater has
     */
    public int getNumCandy() {
        return numCandy;
    }
}