package EX1016;

public class Answer3 {
    
    // Payable interface
    public interface Payable {
        double getPaymentAmount();
    }

    // Invoice class implementing Payable
    static class Invoice implements Payable {
        private final String partNumber;
        private final String partDescription;
        private final int quantity;
        private final double pricePerItem;

        public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
            if (quantity < 0) throw new IllegalArgumentException("Quantity >= 0 required");
            if (pricePerItem < 0.0) throw new IllegalArgumentException("Price per item >= 0 required");
            this.partNumber = partNumber;
            this.partDescription = partDescription;
            this.quantity = quantity;
            this.pricePerItem = pricePerItem;
        }

        @Override
        public double getPaymentAmount() {
            return getQuantity() * getPricePerItem();
        }

        public String getPartNumber() { return partNumber; }
        public String getPartDescription() { return partDescription; }
        public int getQuantity() { return quantity; }
        public double getPricePerItem() { return pricePerItem; }

        @Override
        public String toString() {
            return String.format("invoice:%npart number: %s (%s)%nquantity: %d%nprice per item: $%,.2f",
                    getPartNumber(), getPartDescription(), getQuantity(), getPricePerItem());
        }
    }

    // Employee abstract class implementing Payable
    static abstract class Employee implements Payable {
        private final String firstName;
        private final String lastName;
        private final String ssn;

        public Employee(String firstName, String lastName, String ssn) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.ssn = ssn;
        }

        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getSSN() { return ssn; }

        @Override
        public String toString() {
            return String.format("%s %s%nsocial security number: %s",
                    getFirstName(), getLastName(), getSSN());
        }

        public abstract double earnings();

        @Override
        public double getPaymentAmount() {
            return earnings();
        }
    }

    // SalariedEmployee subclass
    static class SalariedEmployee extends Employee {
        private double weeklySalary;

        public SalariedEmployee(String firstName, String lastName, String ssn, double weeklySalary) {
            super(firstName, lastName, ssn);
            if (weeklySalary < 0.0) throw new IllegalArgumentException("Weekly salary >= 0 required");
            this.weeklySalary = weeklySalary;
        }

        @Override
        public double earnings() {
            return weeklySalary;
        }

        @Override
        public String toString() {
            return String.format("salaried employee: %s%nweekly salary: $%,.2f",
                    super.toString(), weeklySalary);
        }
    }

    // HourlyEmployee subclass
    static class HourlyEmployee extends Employee {
        private double wage;
        private double hours;

        public HourlyEmployee(String firstName, String lastName, String ssn, double wage, double hours) {
            super(firstName, lastName, ssn);
            if (wage < 0.0) throw new IllegalArgumentException("Wage >= 0 required");
            if (hours < 0.0 || hours > 168.0) throw new IllegalArgumentException("Hours 0-168 required");
            this.wage = wage;
            this.hours = hours;
        }

        @Override
        public double earnings() {
            return hours <= 40 ? wage * hours : 40 * wage + (hours - 40) * wage * 1.5;
        }

        @Override
        public String toString() {
            return String.format("hourly employee: %s%nhourly wage: $%.2f; hours worked: %.2f",
                    super.toString(), wage, hours);
        }
    }

    // CommissionEmployee subclass
    static class CommissionEmployee extends Employee {
        private double grossSales;
        private double commissionRate;

        public CommissionEmployee(String firstName, String lastName, String ssn,
                                  double grossSales, double commissionRate) {
            super(firstName, lastName, ssn);
            if (grossSales < 0.0) throw new IllegalArgumentException("Gross sales >= 0 required");
            if (commissionRate <= 0.0 || commissionRate >= 1.0) throw new IllegalArgumentException("Rate 0-1 required");
            this.grossSales = grossSales;
            this.commissionRate = commissionRate;
        }

        @Override
        public double earnings() {
            return commissionRate * grossSales;
        }

        @Override
        public String toString() {
            return String.format("commission employee: %s%ngross sales: $%.2f; commission rate: %.2f",
                    super.toString(), grossSales, commissionRate);
        }
    }

    // BasePlusCommissionEmployee subclass
    static class BasePlusCommissionEmployee extends CommissionEmployee {
        private double baseSalary;

        public BasePlusCommissionEmployee(String firstName, String lastName, String ssn,
                                          double grossSales, double commissionRate, double baseSalary) {
            super(firstName, lastName, ssn, grossSales, commissionRate);
            if (baseSalary < 0.0) throw new IllegalArgumentException("Base salary >= 0 required");
            this.baseSalary = baseSalary;
        }

        public double getBaseSalary() { return baseSalary; }
        public void setBaseSalary(double baseSalary) {
            if (baseSalary < 0.0) throw new IllegalArgumentException("Base salary >= 0 required");
            this.baseSalary = baseSalary;
        }

        @Override
        public double earnings() {
            return super.earnings() + baseSalary;
        }

        @Override
        public String toString() {
            return String.format("base-salaried %s;base salary: $%,.2f",
                    super.toString(), baseSalary);
        }
    }

    // Test driver
    public static void main(String[] args) {
        Payable[] payables = new Payable[6];

        // 2 invoices
        payables[0] = new Invoice("01234", "seat", 2, 375.00);
        payables[1] = new Invoice("56789", "tire", 4, 79.95);

        // 4 employees
        payables[2] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
        payables[3] = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
        payables[4] = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, 0.06);
        payables[5] = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, 0.04, 300);

        System.out.printf("%nProcessing Payables polymorphically:%n%n");

        for (Payable currentPayable : payables) {
            System.out.println(currentPayable);

            if (currentPayable instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentPayable;
                employee.setBaseSalary(employee.getBaseSalary() * 1.10);
                System.out.printf("new base salary with 10%% increase is: $%,.2f%n",
                        employee.getBaseSalary());
            }

            System.out.printf("payment due: $%,.2f%n%n", currentPayable.getPaymentAmount());
        }
    }
}