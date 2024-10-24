/**
 * @author Stephen Viray.
 * @version 1.0 10/09/2024
 */
public class Driver {
    /** main.
     * @param args arg.
     */
    public static void main(String[] args) {
        TrickOrTreater[] team1 = new TrickOrTreater[]{new Ghost(), new Witch(), new Ghost()};
        TrickOrTreater[] team2 = new TrickOrTreater[]{new Witch(), new Witch(), new Ghost()};
        HalloweenNight h = new HalloweenNight(team1, team2);

        for (TrickOrTreater person : team1) {
            System.out.println(person.toString());
        }
        for (TrickOrTreater person : team2) {
            System.out.println(person.toString());
        }

        System.out.println(h);

        h.compareTeams();
        h.battle(60);
    }
}
