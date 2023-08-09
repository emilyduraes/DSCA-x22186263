package ie.nci.Client;

import ie.nci.PatientRegistrationService.Patient;
import ie.nci.PatientRegistrationService.PatientRegistrationServiceGrpc;
import ie.nci.PatientRegistrationService.PatientRequest;
import ie.nci.PatientRegistrationService.PatientResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerGUI implements ActionListener {

    private JTextField PatientRegistrationPPSEntry, PatientRegistrationNameEntry,
                       PatientRegistrationAgeEntry, PatientRegistrationAddressEntry,
                       PatientRegistrationReply;

    private JPanel getPatientRegistrationJPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        JLabel label = new JLabel("Enter the PPS number");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        PatientRegistrationPPSEntry = new JTextField("",10);
        panel.add(PatientRegistrationPPSEntry);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JLabel label2 = new JLabel("Enter the patient's name");
        panel.add(label2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        PatientRegistrationNameEntry = new JTextField("",10);
        panel.add(PatientRegistrationNameEntry);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JLabel label3 = new JLabel("Enter the patient's age");
        panel.add(label3);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        PatientRegistrationAgeEntry = new JTextField("",10);
        panel.add(PatientRegistrationAgeEntry);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JLabel label4 = new JLabel("Enter the patient's address");
        panel.add(label4);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        PatientRegistrationAddressEntry = new JTextField("",10);
        panel.add(PatientRegistrationAddressEntry);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Register Patient");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        PatientRegistrationReply = new JTextField("", 100);
        PatientRegistrationReply.setEditable(false);
        panel.add(PatientRegistrationReply);

        panel.setLayout(boxlayout);

        return panel;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        String label = button.getActionCommand();

        if (label.equals("Register Patient")) {
            System.out.println("Patient Registration to be invoked ...");


            /*
             *
             */
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            PatientRegistrationServiceGrpc.PatientRegistrationServiceBlockingStub blockingStub = PatientRegistrationServiceGrpc.newBlockingStub(channel);

            //preparing message to send
            String pps = PatientRegistrationPPSEntry.getText();
            String name = PatientRegistrationNameEntry.getText();
            String age = PatientRegistrationAgeEntry.getText();
            String address = PatientRegistrationAddressEntry.getText();

            PatientRequest request = PatientRequest.newBuilder()
                                                        .setPatient(Patient.newBuilder()
                                                                           .setPps(pps)
                                                                           .setName(name)
                                                                           .setAge(Integer.parseInt(age))
                                                                           .setAddress(address)
                                                                           .build())
                                                        .build();


            //retrieving reply from service
            PatientResponse response = blockingStub.register(request);
            System.out.println("Patient created!");
            PatientRegistrationReply.setText(String.valueOf(response.getPatient()));

        }
    }

    public static void main(String[] args) {

        ControllerGUI gui = new ControllerGUI();

        gui.build();
    }

    private void build() {

        JFrame frame = new JFrame("Service Controller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the panel to add buttons
        JPanel panel = new JPanel();

        // Set the BoxLayout to be Y_AXIS: from top to bottom
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        // Set border for the panel
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

        panel.add(getPatientRegistrationJPanel());

        // Set size for the frame
        frame.setSize(300, 300);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
