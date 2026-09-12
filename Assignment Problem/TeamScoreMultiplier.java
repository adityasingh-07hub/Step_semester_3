import java.util.Arrays;

public class TeamScoreMultiplier {

    // Method modifies the original array directly
    // Captain gets 2x points
    // Vice Captain gets 1.5x points
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {

        // Double captain score
        playerScores[captainIndex] = playerScores[captainIndex] * 2;

        // Multiply vice captain score by 1.5
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * 1.5;
    }

    public static void main(String[] args) {

        double scores[] = {40,55,30,62};

        // Apply multipliers
        applyMultipliers(scores,1,3);

        // Print updated array
        System.out.println(Arrays.toString(scores));
    }
}