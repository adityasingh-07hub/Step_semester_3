public class PlacementRecordDemo {
    // Class representing placement details
    static class PlacementRecord {
        String studentName;
        String company;
        double packageLpa;
        // Constructor to initialize values
        PlacementRecord(String studentName, String company, double packageLpa) {
            this.studentName = studentName;
            this.company = company;
            this.packageLpa = packageLpa;
        }
        // Method to print placement record
        void printRecord() {
            System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
        }
    }

    public static void main(String[] args) {
        // Creating objects
        PlacementRecord p1 = new PlacementRecord("Ravi","TCS",4.5);
        PlacementRecord p2 = new PlacementRecord("Anitha","Zoho",6.2);
        PlacementRecord p3 = new PlacementRecord("Karthik","Infosys",4.0);
        // Storing objects in array
        PlacementRecord records[] = {p1,p2,p3};
        // Printing every record
        for(PlacementRecord record : records) {
            record.printRecord();
        }
    }
}