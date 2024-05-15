import java.util.Scanner;

class NewChannel {
    String programName;
    String anchor;
    int month;
    double trpRating;
    double business;

    public NewChannel(String programName, String anchor, int month, double trpRating, double business) {
        this.programName = programName;
        this.anchor = anchor;
        this.month = month;
        this.trpRating = trpRating;
        this.business = business;
    }

    public void display() {
        System.out.println("\nProgram name: " + programName +
                "\nAnchor: " + anchor +
                "\nMonth: " + month +
                "\nTRP rating: " + trpRating +
                "\nBusiness profit (in millions): " + business);
    }
}

public class MiniProject {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of programs:");
        int n = sc.nextInt();
        NewChannel[] programs = new NewChannel[n];

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

    private static void findMaxCollectionMonth(NewChannel[] programs) {
        double[] monthlyTotal = new double[12];

        for (NewChannel program : programs) {
            monthlyTotal[program.month - 1] += program.business;
        }

        double maxProfit = 0;
        int maxMonth = 0;

        for (int i = 0; i < monthlyTotal.length; i++) {
            if (monthlyTotal[i] > maxProfit) {
                maxProfit = monthlyTotal[i];
                maxMonth = i + 1;
            }
        }

        System.out.println("\nMonth with maximum collection: " + maxMonth + " (January optional)");
        System.out.println("Programs with their profits for the month:");
        double totalProfit = 0;
        for (NewChannel program : programs) {
            if (program.month == maxMonth) {
                System.out.println("Program name: " + program.programName + "\tProfit: " + program.business + " million");
                totalProfit += program.business;
            }
        }
        System.out.println("Total profit for the month: " + totalProfit + " million");
    }

    private static void findBusyAnchor(NewChannel[] programs) {
        String busiestAnchor = "";
        int maxCount = 0;

        for (NewChannel program : programs) {
            int count = 1;
            for (NewChannel otherProgram : programs) {
                if (otherProgram != program && otherProgram.anchor.equals(program.anchor)) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                busiestAnchor = program.anchor;
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
