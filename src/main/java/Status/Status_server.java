package Status;


import JmDNS.ServiceRegistration;
import Status.StatusGrpc.StatusImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Status_server extends StatusImplBase {

    public static void main(String[] args) {
        Status_server server3 = new Status_server();

        System.out.println("Starting gRPC FilterStatusService service server.");

        //Define the port
        int port = 8089;

        // jmDNS
        String service_type = "_FilterStatusService._tcp.local.";
        String service_name = "GrpcServer";
        ServiceRegistration ssr = new ServiceRegistration();
        ssr.run(port, service_type, service_name);

        try {
            Server server = ServerBuilder.forPort(port)

                    //Implementing the interface
                    .addService(new Status_Impl())
                    .build()
                    .start();
            System.out.println("Server started, listening on " + port);
            server.awaitTermination();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
