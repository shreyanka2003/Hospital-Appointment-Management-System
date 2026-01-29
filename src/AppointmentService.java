/*************************************************************
- Service layer contains business rules and validations.
- DAO layer is kept clean and reusable.
- Service layer controls application flow.
- Validation like `quantity >= 0` is done before database access.
- This improves maintainability and scalability.
***************************************************************/

import java.util.List;

public class AppointmentService {

    // DAO reference
    private AppointmentDAO dao = new AppointmentDAOImpl();

    // Validation before insert
    public void addAppointment(AppointmentDTO a) {

        // Basic business validations
        if (a.getPatientName() == null || a.getPatientName().isEmpty()) {
            System.out.println("Patient name cannot be empty");
            return;
        }

        if (a.getDoctorName() == null || a.getDoctorName().isEmpty()) {
            System.out.println("Doctor name cannot be empty");
            return;
        }

        if (a.getAppointmentDate() == null || a.getAppointmentDate().isEmpty()) {
            System.out.println("Appointment date cannot be empty");
            return;
        }

        if (a.getAppointmentTime() == null || a.getAppointmentTime().isEmpty()) {
            System.out.println("Appointment time cannot be empty");
            return;
        }

        dao.addAppointment(a);
    }

    // Fetch appointment by id
    public AppointmentDTO getAppointment(int id) {
        return dao.getAppointmentById(id);
    }

    // Fetch all appointments
    public List<AppointmentDTO> getAllAppointments() {
        return dao.getAllAppointments();
    }

    // Update appointment details
    public void updateAppointment(AppointmentDTO a) {
        dao.updateAppointment(a);
    }

    // Delete appointment by id
    public void deleteAppointment(int id) {
        dao.deleteAppointment(id);
    }
}
