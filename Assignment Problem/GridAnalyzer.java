public class GridAnalyzer {
    // Helper method calculates average of one match row
    private static double rowAverage(int[] row) {
        int sum = 0;
        // Add all over runs
        for(int value : row) {
            sum += value;
        }
        // Return average
        return (double)sum / row.length;
    }
    // Classifies every match
    static String classifyMatches(int[][] runsPerOver, int threshold) {
        String result = "";
        // Process each match
        for(int i = 0; i < runsPerOver.length; i++) {
            // Get average using helper method
            double average = rowAverage(runsPerOver[i]);
            if(average >= threshold) {
                result += "Match " + i + ": Power Surge";
            }
            else {
                result += "Match " + i + ": Normal";
            }
            // Add separator except last item
            if(i != runsPerOver.length - 1)
                result += " | ";
        }
        return result;
    }

    public static void main(String[] args) {
        int runs[][] ={{4,6,8},{10,12,14},{2,3,1}};
        System.out.println(classifyMatches(runs,8));
    }
}