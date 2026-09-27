import java.time.*;
import java.util.*;
public class StreamingRenewal {
    static abstract class Plan {
        String name;
        LocalDate startDate;
        Plan(String name,LocalDate startDate) {
            this.name=name;
            this.startDate=startDate;
        }
        abstract LocalDate renewalDate();
    }
    static class Basic extends Plan {
        Basic(String name,LocalDate date) {
            super(name,date);
        }
        LocalDate renewalDate() {
            return startDate.plusDays(30);
        }
    }
    static class Standard extends Plan {
        Standard(String name,LocalDate date) {
            super(name,date);
        }
        LocalDate renewalDate() {
            return startDate.plusDays(90);
        }
    }
    static class Premium extends Plan {
        Premium(String name,LocalDate date) {
            super(name,date);
        }
        LocalDate renewalDate() {
            return startDate.plusDays(365);
        }
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++) {
            String type=sc.next();
            String name=sc.next();
            LocalDate date = LocalDate.parse(sc.next());
            Plan plan;
            if(type.equals("BASIC"))
                plan=new Basic(name,date);
            else if(type.equals("STANDARD"))
                plan=new Standard(name,date);
            else
                plan=new Premium(name,date);
            System.out.println(name + ": " + plan.renewalDate());
        }
        sc.close();
    }
}