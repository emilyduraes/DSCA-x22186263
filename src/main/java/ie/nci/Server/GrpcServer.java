package ie.nci.Server;

import ie.nci.Authentication.AuthorizationServerInterceptor;
import ie.nci.CollaborativeDiagnosisService.CollaborativeDiagnosisService;
import ie.nci.HealthBehaviorLoggingService.HealthBehaviorLoggingService;
import ie.nci.PatientRegistrationService.PatientRegistrationService;
import ie.nci.RealTimeMonitoringService.RealTimeMonitoringService;
import io.grpc.Grpc;
import io.grpc.Server;
import io.grpc.InsecureServerCredentials;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class GrpcServer {
    private static final Logger logger = Logger.getLogger(GrpcServer.class.getName());
    private Server server;

    private void start() throws IOException, InterruptedException {
        /* Grpc will find a suitable port to run the services (see "0" below) */
        server = ServerBuilder.forPort(0)
                    .addService(new PatientRegistrationService()) //unary service
                    .addService(new HealthBehaviorLoggingService()) //client-stream service
                    .addService(new RealTimeMonitoringService()) //server-stream service
                    .addService(new CollaborativeDiagnosisService()) //bidirectional-stream service
                    .intercept(new AuthorizationServerInterceptor())
                    .build()
                    .start();


//                Grpc.newServerBuilderForPort(0, InsecureServerCredentials.create())
//                .addService(new PatientRegistrationService()) //unary service
//                .addService(new HealthBehaviorLoggingService()) //client-stream service
//                .addService(new RealTimeMonitoringService()) //server-stream service
//                .addService(new CollaborativeDiagnosisService()) //bidirectional-stream service
//                .build()
//                .start();
        JmDnsServiceRegistration.register("_gRPCserver._tcp.local.", server.getPort());
        logger.info("Server started, listening on " + server.getPort());
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    GrpcServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final GrpcServer server = new GrpcServer();
        server.start();
        server.blockUntilShutdown();
    }
}
