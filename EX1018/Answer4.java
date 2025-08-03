package EX1018;

import java.util.ArrayList;

public class Answer4 {
    public static void main(String[] args) {
        ArrayList<Payable> payables = new ArrayList<>();

        payables.add(new Invoice("1234", "Pen", 10, 1.5));
        payables.add(new Invoice("5678", "Notebook", 5, 2.0));
        payables.add(new Employee("Alice", "Johnson", "111-22-3333", 800.0));

        for (Payable p : payables) {
            System.out.println(p);
            System.out.printf("Payment due: $%.2f%n%n", p.getPaymentAmount());
        }
    }
}

interface Payable {
    double getPaymentAmount();
}

class Invoice implements Payable {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }

    @Override
    public String toString() {
        return String.format("Invoice: %s (%s) %nQuantity: %d, Price per item: %.2f",
                partNumber, partDescription, quantity, pricePerItem);
    }
}

class Employee implements Payable {
    private String firstName;
    private String lastName;
    private String ssn;
    private double weeklySalary;

    public Employee(String firstName, String lastName, String ssn, double weeklySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getPaymentAmount() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s %s%nSSN: %s%nWeekly Salary: %.2f",
                firstName, lastName, ssn, weeklySalary);
    }
}