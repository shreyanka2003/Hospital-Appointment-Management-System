/*************************************************************
- DAO stands for Data Access Object.
- DAO contains only database-related method declarations.
- It hides JDBC logic from other layers.
- Using an interface ensures loose coupling.
- Multiple implementations are possible without changing service layer.
***************************************************************/

import java.util.List;

public interface AppointmentDAO {

    // Insert appointment into database
    void addAppointment(AppointmentDTO appointment);

    // Fetch single appointment by id
    AppointmentDTO getAppointmentById(int id);

    // Fetch all appointments
    List<AppointmentDTO> getAllAppointments();

    // Update appointment data
    void updateAppointment(AppointmentDTO appointment);

    // Delete appointment by id
    void deleteAppointment(int id);
}
