package ie.nci.Client;

import ie.nci.Authentication.BearerToken;
import ie.nci.Authentication.Constants;
import ie.nci.CollaborativeDiagnosisService.*;
import ie.nci.HealthBehaviorLoggingService.*;
import ie.nci.PatientRegistrationService.Patient;
import ie.nci.PatientRegistrationService.PatientRegistrationServiceGrpc;
import ie.nci.PatientRegistrationService.PatientRequest;
import ie.nci.PatientRegistrationService.PatientResponse;
import ie.nci.RealTimeMonitoringService.RealTimeMonitoringServiceGrpc;
import ie.nci.RealTimeMonitoringService.VitalSigns;
import ie.nci.RealTimeMonitoringService.VitalSignsRequest;
import ie.nci.RealTimeMonitoringService.VitalSignsResponse;
import ie.nci.Server.JmDnsServiceDiscovery;
import io.grpc.*;
import io.grpc.stub.StreamObserver;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerGUI implements ActionListener {
    private static final Logger logger = Logger.getLogger(ControllerGUI.class.getName());
    private final PatientRegistrationServiceGrpc.PatientRegistrationServiceBlockingStub blockingStubPatientRegistration;
    private final RealTimeMonitoringServiceGrpc.RealTimeMonitoringServiceBlockingStub blockingStubRealTimeMonitoring;

    private final HealthBehaviorLoggingServiceGrpc.HealthBehaviorLoggingServiceStub asyncHealthBehaviorLoggingServiceStub; //async stub
    private final CollaborativeDiagnosisServiceGrpc.CollaborativeDiagnosisServiceStub asyncCollaborativeDiagnosisServiceStub; //async stub
    static Random rand = new Random();
    static LocalDate date = LocalDate.now();
    static String[] ppsNumbers = {"7700225VH", "5452407DH", "1241125LH", "6993459TH", "4115381JA", "8268048MA", "4835734QA", "9857460SH"};

    private JTextField PatientRegistrationPPSEntry, PatientRegistrationNameEntry,
                       PatientRegistrationAgeEntry, PatientRegistrationAddressEntry,
                       PatientRegistrationReply;

    /** Construct client for accessing server using the existing channel. */
    public ControllerGUI(Channel channel) {
        String jwt = getJwt();
        BearerToken token = new BearerToken(jwt);

        // The sync calls (blocking)
        blockingStubPatientRegistration = PatientRegistrationServiceGrpc.newBlockingStub(channel)
                                                .withCallCredentials(token);
        blockingStubRealTimeMonitoring = RealTimeMonitoringServiceGrpc.newBlockingStub(channel)
                                                .withCallCredentials(token);

        // async calls (for client-streaming)
        asyncHealthBehaviorLoggingServiceStub = HealthBehaviorLoggingServiceGrpc.newStub(channel)
                                                    .withCallCredentials(token);
        asyncCollaborativeDiagnosisServiceStub = CollaborativeDiagnosisServiceGrpc.newStub(channel)
                                                    .withCallCredentials(token);
    }// end constructor

    //panel for the service Patient Registration
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

    }// end method

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        String label = button.getActionCommand();

        if (label.equals("Register Patient")) {
            logger.info("Calling gRPC unary type Patient Registration (from the client side)");

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
            PatientResponse response = blockingStubPatientRegistration.register(request);
            PatientRegistrationReply.setText(String.valueOf(response.getPatient()));

        }
    }// end method

    // Run register from PatientRegistrationService (unary RPC)
    private void build() {

        JFrame frame = new JFrame("Services Controller");
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
    }// end method

    // Run registerExercise from HealthBehaviorLoggingService (client streaming RPC)
    public void clientSideRegisterExercise() {
        logger.info("Calling gRPC client streaming type (from the client side)");

        ExercisesTypes randExercise = ExercisesTypes.randomExercisesTypes();

        StreamObserver<ExerciseResponse> responseObserver = new StreamObserver<ExerciseResponse>() {
            @Override
            public void onNext(ExerciseResponse value) {
                System.out.println("Received: " + value.getExercise());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Register Exercise Stream completed");
            }
        };

        // send a stream back to the server
        StreamObserver<ExerciseRequest> requestObserver = asyncHealthBehaviorLoggingServiceStub.registerExercise(responseObserver);
        requestObserver.onNext(ExerciseRequest.newBuilder().setExercise(Exercise.newBuilder()
                                                                                .setTime(rand.nextInt(60))
                                                                                .setType(randExercise.toString())
                                                                                .setDate(Date.newBuilder()
                                                                                        .setYear(date.getYear())
                                                                                        .setMonth(date.getMonthValue())
                                                                                        .setDay(date.getDayOfMonth())
                                                                                        .build())
                                                                                .build())
                                                                        .build());
        for (int i=0; i< rand.nextInt(10); i++){
            ExercisesTypes randExercise2 = ExercisesTypes.randomExercisesTypes();
            requestObserver.onNext(ExerciseRequest.newBuilder().setExercise(Exercise.newBuilder()
                                                                                    .setTime(rand.nextInt(60))
                                                                                    .setType(randExercise2.toString())
                                                                                    .setDate(Date.newBuilder()
                                                                                            .setYear(date.getYear())
                                                                                            .setMonth(date.getMonthValue())
                                                                                            .setDay(date.getDayOfMonth())
                                                                                            .build())
                                                                                    .build())
                                                                            .build());
        }

        requestObserver.onCompleted();
    }// end method

    // Run getVitalSigns from RealTimeMonitoringService (server streaming RPC)
    public void clientSideGetVitalSigns() {
        logger.info("Calling gRPC server streaming type (from the client side)");

        try {
            VitalSignsRequest request = VitalSignsRequest.newBuilder().setVitalSigns(VitalSigns.newBuilder().build()).build();
            Iterator<VitalSignsResponse> reply = blockingStubRealTimeMonitoring
                    .withDeadlineAfter(1, TimeUnit.SECONDS)
                    .getVitalSigns(request);
            while(reply.hasNext()) {
                System.out.println(reply.next());		// print all messages from the server
            }
            logger.info("End of server streaming");
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
    } // end method

    // Run getDiagnosis from CollaborativeDiagnosisService (Bi-directional streaming RPC)
    public void clientSideGetDiagnosis() {
        logger.info("Calling gRPC bi-directional streaming type (from the client side)");
        DiagnosisTypes randDiagnosis = DiagnosisTypes.randomDiagnosisTypes();
        HealthCareProviders randHealthCareProvider = HealthCareProviders.randomHealthCareProviders();

        StreamObserver<CollaborativeDiagnosisRequest> requestObserver =
                asyncCollaborativeDiagnosisServiceStub.getDiagnosis(new StreamObserver<CollaborativeDiagnosisResponse>() {
                    @Override
                    public void onNext(CollaborativeDiagnosisResponse value) {
                        System.out.println("Bi-di Client Received: " + value.getDiagnosis());
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Bi-di Client: Stream completed");
                    }
                });

        requestObserver.onNext(CollaborativeDiagnosisRequest.newBuilder().setDiagnosis(Diagnosis.newBuilder()
                        .setDiagnosis(randDiagnosis.toString())
                        .setHealthcareProvider(randHealthCareProvider.toString())
                        .setPatientPPS(PPSGenerator.getRandomPPS(ppsNumbers))
                        .build())
                .build());
        for (int i=0; i<rand.nextInt(10); i++){
            DiagnosisTypes randDiagnosis2 = DiagnosisTypes.randomDiagnosisTypes();
            HealthCareProviders randHealthCareProvider2 = HealthCareProviders.randomHealthCareProviders();

            requestObserver.onNext(CollaborativeDiagnosisRequest.newBuilder().setDiagnosis(Diagnosis.newBuilder()
                            .setDiagnosis(randDiagnosis2.toString())
                            .setHealthcareProvider(randHealthCareProvider2.toString())
                            .setPatientPPS(PPSGenerator.getRandomPPS(ppsNumbers))
                            .build())
                    .build());
        }

        requestObserver.onCompleted();
    } // end method

    private static String getJwt() {
        return Jwts.builder()
                .setSubject("GUI_Client") // client's identifier
                .signWith(SignatureAlgorithm.HS256, Constants.JWT_SIGNING_KEY)
                .compact();
    }

    public static void main(String[] args) throws InterruptedException {

        String target;
        int port;

        // Service discovery part
        JmDnsServiceDiscovery jmDnsServiceDiscovery = new JmDnsServiceDiscovery();
        JmDnsServiceDiscovery.find("_gRPCserver._tcp.local.");	// service name
        do {
            target = jmDnsServiceDiscovery.getLocGrpc();
            System.out.println("jmDnsServiceDiscovery: " + target);
        } while (target.length()<2);		// wait for the service to be discovered

        port = Integer.parseInt(target.substring(target.lastIndexOf(":")+1));

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port)
                                    .usePlaintext()
                                    .build();


//                Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
//                .build();

        ControllerGUI client = new ControllerGUI(channel);
        client.build();			// unary type
        client.clientSideRegisterExercise(); // client-streaming type
        client.clientSideGetVitalSigns(); // server-streaming type
        client.clientSideGetDiagnosis(); // bi-directional streaming type
    }// end main method
} // end class
