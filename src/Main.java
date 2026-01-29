/*************************************************************
- Main class is the user interface layer.
- It takes input using Scanner.
- It calls service layer, not DAO directly.
- This maintains separation of concerns.
- Menu-driven program helps test all CRUD operations.
***************************************************************/
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AppointmentService service = new AppointmentService();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Appointment");
            System.out.println("2. Get Appointment By ID");
            System.out.println("3. Get All Appointments");
            System.out.println("4. Update Appointment");
            System.out.println("5. Delete Appointment");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Patient Name: ");
                    String patientName = sc.next();

                    System.out.print("Enter Doctor Name: ");
                    String doctorName = sc.next();

                    System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
                    String date = sc.next();

                    System.out.print("Enter Appointment Time (HH:MM): ");
                    String time = sc.next();

                    service.addAppointment(
                            new AppointmentDTO(0, patientName, doctorName, date, time)
                    );
                    break;

                case 2:
                    System.out.print("Enter Appointment ID: ");
                    int id = sc.nextInt();

                    AppointmentDTO a = service.getAppointment(id);

                    if (a != null) {
                        System.out.println(
                                a.getId() + " " +
                                a.getPatientName() + " " +
                                a.getDoctorName() + " " +
                                a.getAppointmentDate() + " " +
                                a.getAppointmentTime()
                        );
                    } else {
                        System.out.println("Appointment not found");
                    }
                    break;

                case 3:
                    List<AppointmentDTO> list = service.getAllAppointments();

                    list.forEach(ap ->
                            System.out.println(
                                    ap.getId() + " " +
                                    ap.getPatientName() + " " +
                                    ap.getDoctorName() + " " +
                                    ap.getAppointmentDate() + " " +
                                    ap.getAppointmentTime()
                            )
                    );
                    break;

                case 4:
                    System.out.print("Enter Appointment ID: ");
                    int uid = sc.nextInt();

                    System.out.print("Enter New Patient Name: ");
                    String newPatient = sc.next();

                    System.out.print("Enter New Doctor Name: ");
                    String newDoctor = sc.next();

                    System.out.print("Enter New Appointment Date (YYYY-MM-DD): ");
                    String newDate = sc.next();

                    System.out.print("Enter New Appointment Time (HH:MM): ");
                    String newTime = sc.next();

                    service.updateAppointment(
                            new AppointmentDTO(uid, newPatient, newDoctor, newDate, newTime)
                    );
                    break;

                case 5:
                    System.out.print("Enter Appointment ID: ");
                    int did = sc.nextInt();
                    service.deleteAppointment(did);
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}
