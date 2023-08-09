package ie.nci.PatientRegistrationService;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class PatientRegistrationService extends PatientRegistrationServiceGrpc.PatientRegistrationServiceImplBase {

    public static void main(String[] args) throws InterruptedException, IOException {
        PatientRegistrationService PRservice = new PatientRegistrationService();

        int port = 50051;

        Server server = ServerBuilder.forPort(port)
                .addService(PRservice)
                .build()
                .start();

        System.out.println("Patient Registration Service started, listening on " + port);

        server.awaitTermination();
    }

    @Override
    public void register(PatientRequest patientRequest, StreamObserver<PatientResponse> patientResponseObserver){
        //prepare the value to be set back
        Patient patient = patientRequest.getPatient();

        //preparing the response message
        PatientResponse reply = PatientResponse.newBuilder().setPatient(patient).build();

        patientResponseObserver.onNext(reply);

        patientResponseObserver.onCompleted();
    }
}
