package TrackServer;

import JmDNS.ServiceRegistration;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class TrackServer {
    public static void main(String[] args) throws IOException, InterruptedException {


        //Defining a port
        int port = 8080;

        // jmDNS
        String service_type = "_Tracker._tcp.local.";
        String service_name = "GrpcServer";
        ServiceRegistration ssr = new ServiceRegistration();
        ssr.run(port, service_type, service_name);

        try {
            Server server = ServerBuilder.forPort(port)
                    .addService(new TrackImpl())
                    .build()
                    .start();
            System.out.println("Server started, listening on " + port);
            server.awaitTermination();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
