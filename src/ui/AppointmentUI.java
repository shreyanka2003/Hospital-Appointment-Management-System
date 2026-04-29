package ui;
import dto.AppointmentDTO;
import javax.swing.*;
import service.AppointmentService;

public class AppointmentUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Hospital Appointment System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel heading = new JLabel("Appointment Management");
        heading.setBounds(140, 20, 250, 30);

        JButton addBtn = new JButton("Add Appointment");
        addBtn.setBounds(150, 80, 200, 30);

        JButton viewBtn = new JButton("View Appointments");
        viewBtn.setBounds(150, 130, 200, 30);

        JButton deleteBtn = new JButton("Delete Appointment");
        deleteBtn.setBounds(150, 180, 200, 30);

        frame.add(heading);
        frame.add(addBtn);
        frame.add(viewBtn);
        frame.add(deleteBtn);

        frame.setVisible(true);
      
        AppointmentService service = new AppointmentService();

        addBtn.addActionListener(e -> {

    JFrame addFrame = new JFrame("Add Appointment");
    addFrame.setSize(400, 350);
    addFrame.setLayout(null);

    JLabel p = new JLabel("Patient Name:");
    p.setBounds(50, 30, 120, 30);
    JTextField pField = new JTextField();
    pField.setBounds(180, 30, 150, 30);

    JLabel d = new JLabel("Doctor Name:");
    d.setBounds(50, 80, 120, 30);
    JTextField dField = new JTextField();
    dField.setBounds(180, 80, 150, 30);

    JLabel date = new JLabel("Date (YYYY-MM-DD):");
    date.setBounds(50, 130, 150, 30);
    JTextField dateField = new JTextField();
    dateField.setBounds(200, 130, 130, 30);

    JLabel time = new JLabel("Time (HH:MM):");
    time.setBounds(50, 180, 150, 30);
    JTextField timeField = new JTextField();
    timeField.setBounds(200, 180, 130, 30);

    JButton submit = new JButton("Submit");
    submit.setBounds(150, 240, 100, 30);

    addFrame.add(p); addFrame.add(pField);
    addFrame.add(d); addFrame.add(dField);
    addFrame.add(date); addFrame.add(dateField);
    addFrame.add(time); addFrame.add(timeField);
    addFrame.add(submit);

    addFrame.setVisible(true);

    submit.addActionListener(ev -> {
        try {
            service.addAppointment(
                new AppointmentDTO(0,
                    pField.getText(),
                    dField.getText(),
                    dateField.getText(),
                    timeField.getText()
                )
            );

            JOptionPane.showMessageDialog(addFrame, "Appointment Added!");
            addFrame.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(addFrame, "Error!");
        }
    });
});

      viewBtn.addActionListener(e -> {

    JFrame viewFrame = new JFrame("Appointments");
    viewFrame.setSize(700, 400);
    viewFrame.setLayout(new java.awt.BorderLayout());

    String[] cols = {"ID", "Patient", "Doctor", "Date", "Time"};

    java.util.List<AppointmentDTO> list = service.getAllAppointments();

    String[][] data = new String[list.size()][5];

    for (int i = 0; i < list.size(); i++) {
        AppointmentDTO a = list.get(i);

        data[i][0] = String.valueOf(a.getId());
        data[i][1] = a.getPatientName();
        data[i][2] = a.getDoctorName();
        data[i][3] = a.getAppointmentDate();
        data[i][4] = a.getAppointmentTime();
    }

    JTable table = new JTable(data, cols);
    JScrollPane sp = new JScrollPane(table);

    viewFrame.add(sp, java.awt.BorderLayout.CENTER);
    viewFrame.setVisible(true);
});

      deleteBtn.addActionListener(e -> {

    String input = JOptionPane.showInputDialog("Enter Appointment ID:");

    try {
        int id = Integer.parseInt(input);
        service.deleteAppointment(id);

        JOptionPane.showMessageDialog(null, "Deleted!");

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Invalid ID!");
    }
});
    }
}
