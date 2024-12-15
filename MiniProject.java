import java.util.Scanner;

// Abstraction and Inheritance
abstract class Channel {
    private String programName;
    private String anchor;
    private int month;
    private double trpRating;
    private double business;

    public Channel(String programName, String anchor, int month, double trpRating, double business) {
        this.programName = programName;
        this.anchor = anchor;
        this.month = month;
        this.trpRating = trpRating;
        this.business = business;
    }

    // Encapsulation
    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getAnchor() {
        return anchor;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getTrpRating() {
        return trpRating;
    }

    public void setTrpRating(double trpRating) {
        this.trpRating = trpRating;
    }

    public double getBusiness() {
        return business;
    }

    public void setBusiness(double business) {
        this.business = business;
    }

    // Abstract method
    public abstract void display();
}

class NewChannel extends Channel {

    public NewChannel(String programName, String anchor, int month, double trpRating, double business) {
        super(programName, anchor, month, trpRating, business);
    }

    // Polymorphism (Method Overriding)
    @Override
    public void display() {
        System.out.println("\nProgram name: " + getProgramName() +
                "\nAnchor: " + getAnchor() +
                "\nMonth: " + getMonth() +
                "\nTRP rating: " + getTrpRating() +
                "\nBusiness profit (in millions): " + getBusiness());
    }
}

public class Oops {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of programs:");
        int n = sc.nextInt();
        Channel[] programs = new Channel[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n----------Enter details for program " + (i + 1) + "----------- ");
            System.out.println("\nEnter the program name:");
            String programName = sc.next();
            System.out.println("\nEnter the Anchor name:");
            String anchor = sc.next();
            System.out.println("\nEnter the month:");
            int month = sc.nextInt();
            System.out.println("\nEnter the TRP Rating:");
            double trpRating = sc.nextDouble();
            System.out.println("\nEnter the Business profit (in millions):");
            double business = sc.nextDouble();
            programs[i] = new NewChannel(programName, anchor, month, trpRating, business);
        }

        System.out.println("*********************************************");

        findMaxCollectionMonth(programs);
        findBusyAnchor(programs);
    }

    private static void findMaxCollectionMonth(Channel[] programs) {
        double[] monthlyTotal = new double[12];

        for (Channel program : programs) {
            monthlyTotal[program.getMonth() - 1] += program.getBusiness();
        }

        double maxProfit = 0;
        int maxMonth = 0;

        for (int i = 0; i < monthlyTotal.length; i++) {
            if (monthlyTotal[i] > maxProfit) {
                maxProfit = monthlyTotal[i];
                maxMonth = i + 1;
            }
        }

        System.out.println("\nMonth with maximum collection: " + maxMonth );
	System.out.println("---------------------------------------------------------------");

        System.out.println("Programs with their profits for the month:");
        double totalProfit = 0;
        for (Channel program : programs) {
            if (program.getMonth() == maxMonth) {
                System.out.println("Program name: " + program.getProgramName() +"\t"+ "\tProfit: " + program.getBusiness() + " million");
                totalProfit += program.getBusiness();
            }
        }
	System.out.println("---------------------------------------------------------------");
        System.out.println("Total profit for the month: " + totalProfit + " million");
    }

    private static void findBusyAnchor(Channel[] programs) {
        String busiestAnchor = "";
        int maxCount = 0;

        for (Channel program : programs) {
            int count = 1;
            for (Channel otherProgram : programs) {
                if (otherProgram != program && otherProgram.getAnchor().equals(program.getAnchor())) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                busiestAnchor = program.getAnchor();
            }
        }

        if (maxCount == 1) {
            System.out.println("\nThere is no busy anchor");
        } else {
            System.out.println("\nBusiest anchor: " + busiestAnchor);
            System.out.println("Number of programs: " + maxCount);
        }
    }
}
