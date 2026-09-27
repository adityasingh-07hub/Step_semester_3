import java.util.*;
public class HostelElectricity {
    static abstract class Room {
        int units;
        Room(int units) {
            this.units = units;
        }
        abstract double calculateBill();
    }
    static class SingleRoom extends Room {
        SingleRoom(int units) {
            super(units);
        }
        double calculateBill() {
            return units * 8;
        }
    }
    static class SharedRoom extends Room {
        int occupants;
        SharedRoom(int units,int occupants) {
            super(units);
            this.occupants = occupants;
        }
        double calculateBill() {
            return (units * 6) / occupants;
        }
    }
    static class ACRoom extends Room {
        ACRoom(int units) {
            super(units);
        }
        double calculateBill() {
            return (units * 10) + 200;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        double total=0;
        for(int i=0;i<n;i++) {
            String type=sc.next();
            Room room;
            if(type.equals("SINGLE")) {
                int units=sc.nextInt();
                room=new SingleRoom(units);
            }
            else if(type.equals("SHARED")) {
                int units=sc.nextInt();
                int occupants=sc.nextInt();
                room=new SharedRoom(units, occupants);
            }
            else {
                int units=sc.nextInt();
                room=new ACRoom(units);
            }
            double bill = room.calculateBill();
            total+=bill;
            System.out.printf("%s: %.2f\n", type, bill);
        }
        System.out.printf("Total: %.2f", total);
        sc.close();
    }
}