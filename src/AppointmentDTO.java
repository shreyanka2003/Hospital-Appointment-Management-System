/*************************************************************
- DTO is a POJO / Java Bean.
- It carries data between DAO, Service, and UI layers.
- No business logic, no JDBC code.
- One DTO object represents one row in the database table.
***************************************************************/

public class AppointmentDTO {

    // Represents appointment id from database
    private int id;

    // Represents patient name
    private String patientName;

    // Represents doctor name
    private String doctorName;

    // Represents appointment date (YYYY-MM-DD)
    private String appointmentDate;

    // Represents appointment time (HH:MM)
    private String appointmentTime;

    // Default constructor (required for flexibility & frameworks)
    public AppointmentDTO() {
    }

    // Parameterized constructor for easy object creation
    public AppointmentDTO(int id, String patientName, String doctorName,
                          String appointmentDate, String appointmentTime) {
        this.id = id;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    // Getter and Setter methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
