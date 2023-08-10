package ie.nci.RealTimeMonitoringService;

import io.grpc.stub.StreamObserver;

import java.util.Random;
import java.util.logging.Logger;

public class RealTimeMonitoringService extends RealTimeMonitoringServiceGrpc.RealTimeMonitoringServiceImplBase {
    private static final Logger logger = Logger.getLogger(RealTimeMonitoringService.class.getName());
    static Random rand = new Random();

    /*
     * Server streaming RPCs where the client sends a request to the server and gets a stream to
     * read a sequence of messages back
     * https://grpc.io/docs/what-is-grpc/core-concepts/
     */
    public void getVitalSigns(VitalSignsRequest req, StreamObserver<VitalSignsResponse> responseObserver) {
        logger.info("Calling gRPC server streaming type (from the server side)");
        VitalSignsResponse reply = VitalSignsResponse.newBuilder().setVitalSigns(VitalSigns.newBuilder()
                                            // logic to get a random number between two given values
                        .setBloodPressure((int)((Math.random() * (11 - 7)) + 7) + "/" + (int)((Math.random() * (16 - 11)) + 11))
                        .setBodyTemperature((int) ((Math.random() * (42 - 35)) + 35) + " Celsius")
                        .setBreathingRate((int)((Math.random() * (18 - 10)) + 10) + " per minute")
                        .setPulseRate((int)((Math.random() * (140 - 50)) + 50) + " per minute")
                        .build())
                .build();
        responseObserver.onNext(reply);

        // send a stream back to the client
        for (int i=0; i<rand.nextInt(10); i++){
            reply = VitalSignsResponse.newBuilder().setVitalSigns(VitalSigns.newBuilder()
                                                // logic to get a random number between two given values
                            .setBloodPressure((int)((Math.random() * (11 - 7)) + 7 )+ "/" + (int)((Math.random() * (16 - 11)) + 11))
                            .setBodyTemperature((int) ((Math.random() * (42 - 35)) + 35) + " Celsius")
                            .setBreathingRate((int)((Math.random() * (18 - 10)) + 10) + " per minute")
                            .setPulseRate((int)((Math.random() * (140 - 50)) + 50) + " per minute")
                            .build())
                    .build();
            responseObserver.onNext(reply);
        }

        // no more messages
        responseObserver.onCompleted();
    }
}
