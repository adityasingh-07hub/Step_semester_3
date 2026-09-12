public class PlayerPickChecker {

    // Checks duplicate player names using nested loops
    static String findDuplicatePick(String[] playerNames) {
        // Compare every name with names after it
        for(int i = 0; i < playerNames.length; i++) {
            for(int j = i + 1; j < playerNames.length; j++) {
                // If same name found
                if(playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        // No duplicate found
        return "No Duplicates Found";
    }

    public static void main(String[] args) {

        String players[] = {"Kohli","Bumrah","Kohli","Rohit"};
        System.out.println(findDuplicatePick(players));
    }
}