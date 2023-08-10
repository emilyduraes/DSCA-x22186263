package ie.nci.PatientRegistrationService;

import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class PatientRegistrationService extends PatientRegistrationServiceGrpc.PatientRegistrationServiceImplBase {
    private static final Logger logger = Logger.getLogger(PatientRegistrationService.class.getName());
    /*
     * Unary RPCs where the client sends a single request to the server and gets a single response back
     * https://grpc.io/docs/what-is-grpc/core-concepts/
     */
    @Override
    public void register(PatientRequest patientRequest, StreamObserver<PatientResponse> patientResponseObserver){
        //prepare the value to be set back
        Patient patient = patientRequest.getPatient();

        //preparing the response message
        PatientResponse reply = PatientResponse.newBuilder().setPatient(patient).build();
        logger.info("Patient created!");

        patientResponseObserver.onNext(reply);
        patientResponseObserver.onCompleted();
    }
}
