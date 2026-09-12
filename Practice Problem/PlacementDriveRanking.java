import java.util.Arrays;
public class PlacementDriveRanking {
    // Candidate class implements Comparable
    // so Arrays.sort() can rank candidates
    static class Candidate implements Comparable<Candidate> {
        // Private variables (Encapsulation)
        private String name;
        private double cgpa;
        private int codingScore;
        // Constructor
        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }
        // Calculate composite score
        // Formula:
        // CGPA * 10 + Coding Score
        double getCompositeScore() {
            return (cgpa * 10) + codingScore;
        }
        // Getter for name
        String getName() {
            return name;
        }
        // Eligibility Rule 1:
        // Strong CGPA candidates qualify directly
        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }
        // Eligibility Rule 2:
        // Borderline CGPA candidates qualify
        // if coding score is strong
        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }
        // compareTo method for Arrays.sort()
        // Sort by composite score descending
        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }
    }
    // Method filters eligible candidates
    // and ranks them
    static String shortlistAndRank(Candidate[] candidates) {
        // Temporary array
        Candidate shortlisted[] = new Candidate[candidates.length];
        int count = 0;
        // Check eligibility of every candidate
        for(Candidate candidate : candidates) {
            if(Candidate.isEligible(candidate.cgpa) || Candidate.isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlisted[count] = candidate;
                count++;
            }
        }
        // Create exact size array
        Candidate result[] = new Candidate[count];
        for(int i = 0; i < count; i++) {
            result[i] = shortlisted[i];
        }
        // Sort using compareTo()
        Arrays.sort(result);
        // Prepare output
        String output = "";
        for(int i = 0; i < result.length; i++) {
            output += (i + 1) + ". " + result[i].getName() + " (" + result[i].getCompositeScore() + ")";
            if(i != result.length - 1) {
                output += " | ";
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Candidate candidates[] = 
        {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}