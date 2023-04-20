package Index;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import Index.IndexGrpc.IndexImplBase;
import JmDNS.ServiceRegistration;

public class Index_server extends IndexImplBase{
    public static void main(String[] args) {
        Index_server server2 = new Index_server();

        System.out.println("Starting gRPC IndexPollution service server.");

        //Define the port
        int port = 8088;

        // jmDNS
        String service_type = "_Index._tcp.local.";
        String service_name = "GrpcServer";
        ServiceRegistration ssr = new ServiceRegistration();
        ssr.run(port, service_type, service_name);

        try {
            Server server = ServerBuilder.forPort(port)

                    //Implementing the interface
                    .addService(new Index_Impl())
                    .build()
                    .start();
            System.out.println("Server started, listening on " + port);
            server.awaitTermination();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
