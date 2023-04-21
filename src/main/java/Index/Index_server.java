package Index;

import JmDNS.ServiceRegistration;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Index_server{
    public static void main(String[] args) throws IOException, InterruptedException {



        System.out.println("Starting gRPC IndexPollution Service server...");

        //Defining port
        int port = 50052;

        // JmDNS
        String service_type = "_Index._tcp.local.";
        String service_name = "GrpcServer";
        ServiceRegistration ssr = new ServiceRegistration();
        ssr.run(port, service_type, service_name);

        // Build and start the server
        try {
            Server server = ServerBuilder.forPort(port)
                    //Implementing the interface
                    .addService(new Index_Impl())
                    .build();
            server.start();
            System.out.println("Server started, listening on " + port);
            // Wait for the server to shut down
            server.awaitTermination();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
