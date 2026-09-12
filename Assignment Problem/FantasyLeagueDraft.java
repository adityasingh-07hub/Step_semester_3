import java.util.Arrays;

public class FantasyLeagueDraft {
    static class Player implements Comparable<Player> {
        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;
        // Constructor
        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }
        // Rule 1:
        // Experienced players qualify automatically
        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }
        // Rule 2:
        // New players need fitness and minimum matches
        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 &&
                    injured == false;
        }
        // Sort players by batting average descending
        @Override
        public int compareTo(Player other) {
            return Double.compare(
                    other.battingAverage,
                    this.battingAverage
            );
        }
    }

    static String draftAndRank(Player[] players) {
        Player draftable[] = new Player[players.length];
        int count = 0;
        // Select draftable players
        for(Player p : players) {
            if(Player.isDraftable(p.matchesPlayed) || Player.isDraftable(p.matchesPlayed, p.injured)) {
                draftable[count] = p;
                count++;
            }
        }
        // Create exact size array
        Player finalList[] = new Player[count];
        for(int i = 0; i < count; i++) {
            finalList[i] = draftable[i];
        }
        // Sort using compareTo()
        Arrays.sort(finalList);
        String result = "";
        // Create ranking output
        for(int i = 0; i < finalList.length; i++) {
            result += (i+1) + ". " + finalList[i].name;
            if(i != finalList.length-1)
                result += " | ";
        }
        return result;
    }
    public static void main(String[] args) {
        Player players[] =
        {
            new Player("Virat",15,48.0,false),
            new Player("Rahul",7,55.0,false),
            new Player("Sameer",3,60.0,false),
            new Player("Dev",12,20.0,true)
        };
        System.out.println(draftAndRank(players));
    }
}