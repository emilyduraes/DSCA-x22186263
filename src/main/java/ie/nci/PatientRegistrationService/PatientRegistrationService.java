package ie.nci.PatientRegistrationService;

import io.grpc.stub.StreamObserver;

public class PatientRegistrationService extends PatientRegistrationServiceGrpc.PatientRegistrationServiceImplBase {

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
