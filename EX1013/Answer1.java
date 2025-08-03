package EX1013;

import java.util.Calendar;

public class Answer1 {

    // Date class
    static class Date {
        private int month;
        private int day;
        private int year;

        private static final int[] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public Date(int month, int day, int year) {
            if (month <= 0 || month > 12) {
                throw new IllegalArgumentException("Month must be 1-12");
            }

            if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
                throw new IllegalArgumentException("Invalid day for month");
            }

            if (month == 2 && day == 29 &&
                !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
                throw new IllegalArgumentException("Invalid leap year date");
            }

            this.month = month;
            this.day = day;
            this.year = year;
        }

        public int getMonth() { return month; }
        public int getDay() { return day; }
        public int getYear() { return year; }

        public String toString() {
            return String.format("%d/%d/%d", month, day, year);
        }
    }

    // Abstract Employee class
    static abstract class Employee {
        private final String firstName;
        private final String lastName;
        private final String ssn;
        private final Date birthDate;

        public Employee(String firstName, String lastName, String ssn, Date birthDate) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.ssn = ssn;
            this.birthDate = birthDate;
        }

        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getSSN() { return ssn; }
        public Date getBirthDate() { return birthDate; }

        @Override
        public String toString() {
            return String.format("%s %s%nsocial security number: %s%nbirth date: %s",
                    getFirstName(), getLastName(), getSSN(), getBirthDate());
        }

        public abstract double earnings();
    }

    // SalariedEmployee subclass
    static class SalariedEmployee extends Employee {
        private double weeklySalary;

        public SalariedEmployee(String firstName, String lastName, String ssn,
                                double weeklySalary, Date birthDate) {
            super(firstName, lastName, ssn, birthDate);
            if (weeklySalary < 0.0) {
                throw new IllegalArgumentException("Weekly salary must be >= 0.0");
            }
            this.weeklySalary = weeklySalary;
        }

        public void setWeeklySalary(double weeklySalary) {
            if (weeklySalary < 0.0) {
                throw new IllegalArgumentException("Weekly salary must be >= 0.0");
            }
            this.weeklySalary = weeklySalary;
        }

        public double getWeeklySalary() {
            return weeklySalary;
        }

        @Override
        public double earnings() {
            return getWeeklySalary();
        }

        @Override
        public String toString() {
            return String.format("salaried employee: %s%nweekly salary: $%,.2f",
                    super.toString(), getWeeklySalary());
        }
    }

    // Main payroll processing method
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH is 0-based

        Employee[] employees = new Employee[2];

        employees[0] = new SalariedEmployee("John", "Smith", "111-11-1111",
                800.00, new Date(8, 3, 1990)); // August birthday
        employees[1] = new SalariedEmployee("Karen", "Price", "222-22-2222",
                1200.00, new Date(5, 15, 1985)); // May birthday

        for (Employee emp : employees) {
            System.out.println(emp);
            double basePay = emp.earnings();

            if (emp.getBirthDate().getMonth() == currentMonth) {
                System.out.println("Happy Birthday! $100 bonus added.");
                basePay += 100.00;
            }

            System.out.printf("Total pay: $%,.2f%n%n", basePay);
        }
    }
}