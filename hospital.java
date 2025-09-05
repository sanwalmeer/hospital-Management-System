import java.sql.*;
import java.util.Scanner;

public class hospital {
    private static Connection conn;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        conn = dbconnection.getConnection();
        if (conn == null) {
            System.out.println("Database connection failed!");
            return;
        }

        while (true) {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Add Doctor");
            System.out.println("6. View Doctors");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    updatePatient();
                    break;
                case 4:
                    deletePatient();
                    break;
                case 5:
                    addDoctor();
                    break;
                case 6:
                    viewDoctors();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addPatient() {
        try {
            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Patient Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Disease: ");
            String disease = sc.nextLine();

            String query = "INSERT INTO patients VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, disease);
            ps.executeUpdate();
            System.out.println("Patient added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void viewPatients() {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patients");
            System.out.println("\n--- Patients List ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", Disease: " + rs.getString("disease"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updatePatient() {
        try {
            System.out.print("Enter Patient ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter New Name: ");
            String name = sc.nextLine();
            System.out.print("Enter New Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter New Disease: ");
            String disease = sc.nextLine();

            String query = "UPDATE patients SET name=?, age=?, disease=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, disease);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("Patient updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deletePatient() {
        try {
            System.out.print("Enter Patient ID to delete: ");
            int id = sc.nextInt();

            String query = "DELETE FROM patients WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println(" Patient deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addDoctor() {
        try {
            System.out.print("Enter Doctor ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Doctor Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Specialization: ");
            String specialization = sc.nextLine();

            String query = "INSERT INTO doctors VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, specialization);
            ps.executeUpdate();
            System.out.println("Doctor added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void viewDoctors() {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM doctors");
            System.out.println("\n--- Doctors List ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("doctor_id") +
                        ", Name: " + rs.getString("name") +
                        ", Specialization: " + rs.getString("specialization"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
