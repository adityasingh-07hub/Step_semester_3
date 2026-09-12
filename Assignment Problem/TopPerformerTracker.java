public class TopPerformerTracker {

    // Finds minimum, maximum and difference
    static String findMinMaxSpread(int[] scores) {

        // Assume first value is min and max
        int min = scores[0];
        int max = scores[0];

        // Single pass through array
        for(int i = 1; i < scores.length; i++) {

            // Update minimum
            if(scores[i] < min)
                min = scores[i];

            // Update maximum
            if(scores[i] > max)
                max = scores[i];
        }
        // Calculate difference
        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        int scores[] = {45,82,79,90,33,90,61};
        System.out.println(findMinMaxSpread(scores));
    }
}