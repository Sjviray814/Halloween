/**
 * @author Stephen Viray.
 * @version 1.0 10/09/2024
 */
public class HalloweenNight {
    private TrickOrTreater[] cryptKickerFive;
    private TrickOrTreater[] ghoulGang;

    /**
     * @param cryptKickerFive first team of trickortreaters
     * @param ghoulGang second team of trickortreaters
     */
    public HalloweenNight(TrickOrTreater[] cryptKickerFive, TrickOrTreater[] ghoulGang) {
        this.cryptKickerFive = cryptKickerFive;
        this.ghoulGang = ghoulGang;
    }

    /**
     * @return a list of everyone in the 2 teams
     */
    public String toString() {
        String result = "cryptKickerFive:";
        for (int i = 0; i < cryptKickerFive.length; i++) {
            if (i == cryptKickerFive.length - 1) {
                result += String.format(" %s%n", cryptKickerFive[i].toString());
            } else {
                result += String.format(" %s,", cryptKickerFive[i].toString());
            }
        }

        result += "versus ghoulGang:";
        for (int i = 0; i < ghoulGang.length; i++) {
            if (i == ghoulGang.length - 1) {
                result += String.format(" %s", ghoulGang[i].toString());
            } else {
                result += String.format(" %s,", ghoulGang[i].toString());
            }
        }
        return result;
    }

    /** prints which team has the advantage before the battle. */
    public void compareTeams() {
        int cryptWins = 0;
        int ghoulWins = 0;

        for (int i = 0; i < cryptKickerFive.length; i++) {
            TrickOrTreater crypt = cryptKickerFive[i];
            TrickOrTreater ghoul = ghoulGang[i];

            if (crypt.compareTo(ghoul) > 0) {
                cryptWins++;
            } else if (crypt.compareTo(ghoul) < 0) {
                ghoulWins++;
            }
        }

        if (cryptWins > ghoulWins) {
            System.out.println("cryptKickerFive is favored.");
        } else if (ghoulWins > cryptWins) {
            System.out.println("ghoulGang is favored.");
        } else {
            System.out.println("Neither team is favored.");
        }
    }

    /**
     * @param threshold the amount of candy needed for a team to win the battle
     */
    public void battle(int threshold) {
        int cryptTotal = 0;
        int ghoulTotal = 0;
        if (threshold <= 0) {
            threshold = 60;
        }

        while (cryptTotal < threshold && ghoulTotal < threshold) {
            for (TrickOrTreater person : cryptKickerFive) {
                person.trickOrTreat();
            }
            for (int i = 0; i < cryptKickerFive.length; i++) {
                if (cryptKickerFive[i] instanceof Ghost) {
                    if (ghoulGang[i] instanceof Robbable) {
                        Ghost ghost = (Ghost) cryptKickerFive[i];
                        ghost.rob(ghoulGang[i]);
                    }
                }
            }

            for (TrickOrTreater person : ghoulGang) {
                person.trickOrTreat();
            }
            for (int i = 0; i < ghoulGang.length; i++) {
                if (ghoulGang[i] instanceof Ghost) {
                    if (cryptKickerFive[i] instanceof Robbable) {
                        Ghost ghost = (Ghost) ghoulGang[i];
                        ghost.rob(cryptKickerFive[i]);
                    }
                }
            }

            for (TrickOrTreater person : cryptKickerFive) {
                cryptTotal += person.getNumCandy();
            }
            for (TrickOrTreater person : ghoulGang) {
                ghoulTotal += person.getNumCandy();
            }
        }

        if (cryptTotal >= threshold && ghoulTotal >= threshold) {
            System.out.println("It is a tie!");
        } else if (cryptTotal >= threshold) {
            System.out.println("cryptKickerFive won!");
        } else if (ghoulTotal >= threshold) {
            System.out.println("ghoulGang won!");
        }
    }
}
