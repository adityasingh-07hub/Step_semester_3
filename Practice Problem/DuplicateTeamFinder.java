public class DuplicateTeamFinder {
    public static void main(String[] args) {

        String[] teams = {"ByteForce", "CodeCrafters", "ByteForce"};
        String result = findDuplicateTeams(teams);
        System.out.println(result);
    }

    private static String findDuplicateTeams(String[] teams) {

        for (int i = 0; i < teams.length; i++) {

            for (int j = i + 1; j < teams.length; j++) {
                if (teams[i].equals(teams[j])) {
                    return "Duplicate found : " + teams[i];
                }
            }
        }
        return "No duplicates found";
    }
}