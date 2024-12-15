import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public abstract void display();
}

class NewChannel extends Channel {
    public NewChannel(String programName, String anchor, int month, double trpRating, double business) {
        super(programName, anchor, month, trpRating, business);
    }

    @Override
    public void display() {
        System.out.println("\nProgram name: " + getProgramName() +
                "\nAnchor: " + getAnchor() +
                "\nMonth: " + getMonth() +
                "\nTRP rating: " + getTrpRating() +
                "\nBusiness profit (in millions): " + getBusiness());
    }
}

public class OopsGUI {
    private JFrame frame;
    private JTextArea outputArea;
    private Channel[] programs;
    private int programCount = 0;

    public OopsGUI() {
        frame = new JFrame("News Channel Programs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JButton addProgramButton = new JButton("Add Program");
        addProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProgram();
            }
        });
        panel.add(addProgramButton);

        JButton maxCollectionButton = new JButton("Find Max Collection Month");
        maxCollectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findMaxCollectionMonth();
            }
        });
        panel.add(maxCollectionButton);

        JButton busyAnchorButton = new JButton("Find Busy Anchor");
        busyAnchorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findBusyAnchor();
            }
        });
        panel.add(busyAnchorButton);

        outputArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void addProgram() {
        String programName = JOptionPane.showInputDialog("Enter the program name:");
        String anchor = JOptionPane.showInputDialog("Enter the Anchor name:");
        int month = Integer.parseInt(JOptionPane.showInputDialog("Enter the month:"));
        double trpRating = Double.parseDouble(JOptionPane.showInputDialog("Enter the TRP Rating:"));
        double business = Double.parseDouble(JOptionPane.showInputDialog("Enter the Business profit (in millions):"));

        if (programs == null) {
            programs = new Channel[10]; // assuming a max of 10 programs
        }
        programs[programCount++] = new NewChannel(programName, anchor, month, trpRating, business);
        outputArea.append("Added program: " + programName + "\n");
    }

    private void findMaxCollectionMonth() {
        if (programs == null) return;
        double[] monthlyTotal = new double[12];

        for (int i = 0; i < programCount; i++) {
            monthlyTotal[programs[i].getMonth() - 1] += programs[i].getBusiness();
        }

        double maxProfit = 0;
        int maxMonth = 0;

        for (int i = 0; i < monthlyTotal.length; i++) {
            if (monthlyTotal[i] > maxProfit) {
                maxProfit = monthlyTotal[i];
                maxMonth = i + 1;
            }
        }

        outputArea.append("\nMonth with maximum collection: " + maxMonth + "\n");
        double totalProfit = 0;
        for (int i = 0; i < programCount; i++) {
            if (programs[i].getMonth() == maxMonth) {
                outputArea.append("Program name: " + programs[i].getProgramName() + "\tProfit: " + programs[i].getBusiness() + " million\n");
                totalProfit += programs[i].getBusiness();
            }
        }
        outputArea.append("Total profit for the month: " + totalProfit + " million\n");
    }

    private void findBusyAnchor() {
        if (programs == null) return;
        String busiestAnchor = "";
        int maxCount = 0;

        for (int i = 0; i < programCount; i++) {
            int count = 1;
            for (int j = 0; j < programCount; j++) {
                if (i != j && programs[j].getAnchor().equals(programs[i].getAnchor())) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                busiestAnchor = programs[i].getAnchor();
            }
        }

        if (maxCount <= 1) {
            outputArea.append("\nThere is no busy anchor\n");
        } else {
            outputArea.append("\nBusiest anchor: " + busiestAnchor + "\n");
            outputArea.append("Number of programs: " + maxCount + "\n");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    OopsGUI window = new OopsGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
