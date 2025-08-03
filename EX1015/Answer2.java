package EX1015;

public class Answer2 {

    // Abstract superclass
    static abstract class Employee {
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

        public abstract double earnings(); // Abstract method
    }

    // SalariedEmployee subclass
    static class SalariedEmployee extends Employee {
        private double weeklySalary;

        public SalariedEmployee(String firstName, String lastName,
                                String ssn, double weeklySalary) {
            super(firstName, lastName, ssn);

            if (weeklySalary < 0.0) {
                throw new IllegalArgumentException("Weekly salary must be >= 0.0");
            }

            this.weeklySalary = weeklySalary;
        }

        public double getWeeklySalary() { return weeklySalary; }

        public void setWeeklySalary(double weeklySalary) {
            if (weeklySalary < 0.0) {
                throw new IllegalArgumentException("Weekly salary must be >= 0.0");
            }
            this.weeklySalary = weeklySalary;
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

    // PieceWorker subclass
    static class PieceWorker extends Employee {
        private double wagePerPiece;
        private int pieces;

        public PieceWorker(String firstName, String lastName, String ssn,
                           double wagePerPiece, int pieces) {
            super(firstName, lastName, ssn);

            if (wagePerPiece < 0.0) {
                throw new IllegalArgumentException("Wage per piece must be >= 0.0");
            }
            if (pieces < 0) {
                throw new IllegalArgumentException("Number of pieces must be >= 0");
            }

            this.wagePerPiece = wagePerPiece;
            this.pieces = pieces;
        }

        public double getWagePerPiece() { return wagePerPiece; }
        public int getPieces() { return pieces; }

        public void setWagePerPiece(double wagePerPiece) {
            if (wagePerPiece < 0.0) {
                throw new IllegalArgumentException("Wage per piece must be >= 0.0");
            }
            this.wagePerPiece = wagePerPiece;
        }

        public void setPieces(int pieces) {
            if (pieces < 0) {
                throw new IllegalArgumentException("Number of pieces must be >= 0");
            }
            this.pieces = pieces;
        }

        @Override
        public double earnings() {
            return getWagePerPiece() * getPieces();
        }

        @Override
        public String toString() {
            return String.format("piece worker: %s%nwage per piece: $%.2f; pieces produced: %d",
                    super.toString(), getWagePerPiece(), getPieces());
        }
    }

    // Main class to test payroll system
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        employees[0] = new SalariedEmployee(
                "Alice", "Walker", "111-11-1111", 1000.00);

        employees[1] = new PieceWorker(
                "Bob", "Miller", "222-22-2222", 15.50, 80); // $15.50 x 80 = $1240

        employees[2] = new PieceWorker(
                "Carol", "Nguyen", "333-33-3333", 12.75, 100); // $1275

        // Process each employee polymorphically
        for (Employee emp : employees) {
            System.out.println(emp);
            System.out.printf("earned: $%,.2f%n%n", emp.earnings());
        }
    }
}