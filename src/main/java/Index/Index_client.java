package Index;

import Index.IndexGrpc.IndexStub;
import JmDNS.ServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.ServiceInfo;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Index_client {

    public static void main(String[] args) throws InterruptedException {
        //files based on class's files

        // JmDNS
        ServiceInfo serviceInfo;
        String service_type = "_IndexPollution._tcp.local.";
        String service_name = "GrpcServer";
        serviceInfo = ServiceDiscovery.run(service_type);

        // port & host
        int port = 8088;
        String host = "localhost";

        // build a channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host , port)
                .usePlaintext()
                .build();


        doBidirectionalCall(channel);

        System.out.println("Shutting down channel");
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }



    //Bidirectional
    public static void doBidirectionalCall(ManagedChannel channel) {
        System.out.println("Starting bidirectional streaming...");
        IndexStub stub = IndexGrpc.newStub(channel);
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<NumberKmRequest> requestObserver =
                stub.index(new StreamObserver<AnalysisResponse>() {
                    @Override
                    public void onNext(AnalysisResponse response) {
                        System.out.println("Response from server: "+response);
                    }

                    @Override
                    public void onError(Throwable t) {
                    }

                    @Override
                    public void onCompleted() {
                        latch.countDown();
                    }
                });

        for (int i=0; i<5; i++)
        {
            int number = createRandomNumber(60, 190);
            System.out.println("Sending Mileage "+number+" to server...");
            requestObserver.onNext(NumberKmRequest.newBuilder()
                    .setKm(number).build());
        }
        requestObserver.onCompleted();
        try {
            latch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        channel.shutdownNow();
    }

    public static int createRandomNumber(int min, int max) {
        Random random = new Random();
        int number = random.nextInt(max+1)+min;
        return number;
    }
}
