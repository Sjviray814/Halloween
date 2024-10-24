/**
 * @author Stephen Viray.
 * @version 1.0 10/09/2024
 */
public class Ghost extends TrickOrTreater {
    private int robberiesConducted;

    /**
     * @param name name of the ghost
     * @param age age of the ghost
     * @param numCandy amount of candy that the ghost has
     */
    public Ghost(String name, int age, int numCandy) {
        super(name, age, numCandy);
        this.robberiesConducted = 0;
    }

    /** No argument constructor. */
    public Ghost() {
        this("Casper the Unfriendly Ghost", 12, 0);
    }

    /** The ghost gains 2 pieces of candy. */
    public void trickOrTreat() {
        System.out.println("Boo! Trick or treat!");
        gainCandy(2);
    }

    /**
     * @param victim the victim to be robbed
     */
    public void rob(TrickOrTreater victim) {
        if (victim instanceof Robbable) {
            int originalCandy = getNumCandy();
            Robbable robbableVictim = (Robbable) victim;
            gainCandy(robbableVictim.beRobbed());
            if (getNumCandy() > originalCandy) {
                robberiesConducted++;
            }
        }
    }

    /**
     * @return The name, age, amount of candy and number of robberies
     */
    public String toString() {
        return super.toString() + "/" + robberiesConducted;
    }

    /**
     * @param other the trickortreater to compare this to
     * @return a negative integer, zero, or a positive integer as this object is
     *         less than, equal to, or greater than the specified object.
     */
    public int compareTo(TrickOrTreater other) {
        if (super.compareTo(other) == 0) {
            if (other instanceof Ghost) {
                Ghost otherGhost = (Ghost) other;
                if (this.robberiesConducted > otherGhost.robberiesConducted) {
                    return 1;
                } else if (this.robberiesConducted < otherGhost.robberiesConducted) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return super.compareTo(other);
        }
    }
}
