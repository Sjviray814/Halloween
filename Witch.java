/**
 * @author Stephen Viray.
 * @version 1.0 10/09/2024
 */
public class Witch extends TrickOrTreater implements Robbable {
    private String signatureCackle;

    /**
     * @param name name of the witch
     * @param age age of the witch
     * @param numCandy amount of candy that the witch has
     * @param signatureCackle the witch's signature cackle
     */
    public Witch(String name, int age, int numCandy, String signatureCackle) {
        super(name, age, numCandy);
        if (signatureCackle == null || signatureCackle.equals("") || signatureCackle.isBlank()) {
            signatureCackle = "Bwahaha";
        } else {
            this.signatureCackle = signatureCackle;
        }
    }

    /** No argument constructor. */
    public Witch() {
        this("Maleficent", 7, 0, "Bwahaha");
    }

    /** Witch gains 3 pieces of candy. */
    public void trickOrTreat() {
        System.out.printf("%s! I'll get you my pretty!%n", signatureCackle);
        gainCandy(3);
    }

    /**
     * @param other The TrickOrTreater object to compare with.
     * @return a negative integer, zero, or a positive integer as this object is
     *         less than, equal to, or greater than the specified object.
     */
    public int compareTo(TrickOrTreater other) {
        if (super.compareTo(other) == 0) {
            if (other instanceof Witch) {
                Witch otherWitch = (Witch) other;
                if (this.signatureCackle.length() > otherWitch.signatureCackle.length()) {
                    return 1;
                } else if (this.signatureCackle.length() < otherWitch.signatureCackle.length()) {
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

    /**
     * @return the amount of candy lost in the robbery
     */
    public int beRobbed() {
        if (this.getNumCandy() <= 6) {
            int lostCandy = getNumCandy();
            this.loseCandy(getNumCandy());
            return lostCandy;
        } else {
            this.loseCandy(6);
            return 6;
        }
    }
}
