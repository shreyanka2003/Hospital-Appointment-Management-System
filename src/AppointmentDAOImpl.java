/*************************************************************
- This class implements DAO interface.
- All JDBC logic is inside DAO implementation.
- PreparedStatement is used to prevent SQL Injection.
- Each method corresponds to one CRUD operation.
- DTO object maps one database row to Java object.
***************************************************************/

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/rnsitdb";
    private static final String USER = "root";
    private static final String PASS = "Banni@123";

    // INSERT operation
    @Override
    public void addAppointment(AppointmentDTO a) {
        try {
            // Step 1: Establish connection
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            // Step 2: SQL query
            String sql = "INSERT INTO appointments(patient_name, doctor_name, appointment_date, appointment_time) VALUES(?, ?, ?, ?)";

            // Step 3: Prepare statement
            PreparedStatement pst = con.prepareStatement(sql);

            // Step 4: Set values
            pst.setString(1, a.getPatientName());
            pst.setString(2, a.getDoctorName());
            pst.setString(3, a.getAppointmentDate());
            pst.setString(4, a.getAppointmentTime());

            // Step 5: Execute query
            pst.executeUpdate();

            // Step 6: Close connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT by ID
    @Override
    public AppointmentDTO getAppointmentById(int id) {
        AppointmentDTO a = null;
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "SELECT * FROM appointments WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            // If record exists
            if (rs.next()) {
                a = new AppointmentDTO(
                        rs.getInt("id"),
                        rs.getString("patient_name"),
                        rs.getString("doctor_name"),
                        rs.getString("appointment_date"),
                        rs.getString("appointment_time")
                );
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    // SELECT ALL
    @Override
    public List<AppointmentDTO> getAllAppointments() {
        List<AppointmentDTO> list = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "SELECT * FROM appointments";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                AppointmentDTO a = new AppointmentDTO(
                        rs.getInt("id"),
                        rs.getString("patient_name"),
                        rs.getString("doctor_name"),
                        rs.getString("appointment_date"),
                        rs.getString("appointment_time")
                );
                list.add(a);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // UPDATE
    @Override
    public void updateAppointment(AppointmentDTO a) {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "UPDATE appointments SET patient_name=?, doctor_name=?, appointment_date=?, appointment_time=? WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, a.getPatientName());
            pst.setString(2, a.getDoctorName());
            pst.setString(3, a.getAppointmentDate());
            pst.setString(4, a.getAppointmentTime());
            pst.setInt(5, a.getId());

            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    @Override
    public void deleteAppointment(int id) {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "DELETE FROM appointments WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
