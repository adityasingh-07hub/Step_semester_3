public class IDCardDemo {
    static class IdCard {
        String name;
        int booksIssued;
        // Constructor
        IdCard(String name,int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }
    public static void main(String[] args) {
        // Creating Ravi's card
        IdCard ravi = new IdCard("Ravi",0);
        // Second reference pointing to same object
        IdCard duplicate = ravi;
        // Changing through second reference
        duplicate.booksIssued = 3;
        // First reference sees the change
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        // Both references point to same object
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        // Separate object with same values
        IdCard separate = new IdCard("Ravi",3);
        // Different objects
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}