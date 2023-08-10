package ie.nci.CollaborativeDiagnosisService;

import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class CollaborativeDiagnosisService extends CollaborativeDiagnosisServiceGrpc.CollaborativeDiagnosisServiceImplBase {
    private static final Logger logger = Logger.getLogger(CollaborativeDiagnosisService.class.getName());
    /*
     * Bidirectional streaming RPCs where both sides send a sequence of messages using a read-write stream
     * https://grpc.io/docs/what-is-grpc/core-concepts/
     */
    public StreamObserver<CollaborativeDiagnosisRequest> getDiagnosis(StreamObserver<CollaborativeDiagnosisResponse> responseObserver) {
        logger.info("Calling gRPC bi-directional streaming type (from the server side)");
        return new StreamObserver<CollaborativeDiagnosisRequest>() {
            @Override
            public void onNext(CollaborativeDiagnosisRequest value) {
                System.out.println("(Bi-di Server Received: " + value.getDiagnosis() + ")");
                CollaborativeDiagnosisResponse reply = CollaborativeDiagnosisResponse.newBuilder()
                                                            .setDiagnosis(Diagnosis.newBuilder()
                                                                    .setDiagnosis("")
                                                                    .setHealthcareProvider("")
                                                                    .setPatientPPS("")
                                                                    .build())
                                                            .build();
                responseObserver.onNext(reply);

                reply = CollaborativeDiagnosisResponse.newBuilder()
                        .setDiagnosis(Diagnosis.newBuilder()
                                .setDiagnosis("")
                                .setHealthcareProvider("")
                                .setPatientPPS("")
                                .build())
                        .build();
                responseObserver.onNext(reply);
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}