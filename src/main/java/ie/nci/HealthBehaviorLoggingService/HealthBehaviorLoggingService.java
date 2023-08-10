package ie.nci.HealthBehaviorLoggingService;

import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class HealthBehaviorLoggingService extends HealthBehaviorLoggingServiceGrpc.HealthBehaviorLoggingServiceImplBase {
    private static final Logger logger = Logger.getLogger(HealthBehaviorLoggingService.class.getName());
    /*
     * Client streaming RPCs where the client writes a sequence of messages and sends them to the server,
     * again using a provided stream
     * https://grpc.io/docs/what-is-grpc/core-concepts/
     */
    @Override
    public StreamObserver<ExerciseRequest> registerExercise(StreamObserver<ExerciseResponse> responseObserver) {

        logger.info("Calling gRPC client streaming type (from the server side)");

        return new StreamObserver<ExerciseRequest>() {

            @Override
            public void onNext(ExerciseRequest value) {
                System.out.println("Server received: " + value.getExercise());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                ExerciseResponse reply = ExerciseResponse.newBuilder()
                        .setExercise(Exercise.newBuilder()
                                .setTime(1)
                                .setType("Various")
                                .build())
                        .build();
                responseObserver.onNext(reply);
                responseObserver.onCompleted();
            }
        };
    }
}