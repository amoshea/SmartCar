package TrackServer;

import Track.TrackGrpc.TrackImplBase;
import Track.TrackRequest;
import Track.TrackResponse;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.Random;

public class TrackImpl extends TrackImplBase{

    @Override
    public void track (TrackRequest request, StreamObserver<TrackResponse> responseObserver) {
        System.out.println("Receiving unary request from Client");
        String message = generateReplyMessage();
        TrackResponse reply = TrackResponse.newBuilder().setTrackingStatus(message).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    private static String generateReplyMessage() {
        String message = "";

        /*Simulate the moment when the car is started,
        the tracker is turned on within one minute when starting the car.
        The tracker disabled if the car doesn't move for long time
         */
        Random rand = new Random();
        int minutes = rand.nextInt(1440);

        LocalDateTime now = LocalDateTime.now();

        // Sleeping time
        if (now.getHour() > 22 && now.getHour() < 6) {
            message = "Tracker is disabled!";
        } else {
            if (minutes > 60) {
                message = "Tracker activated!";
            } else {
                message = "The car is "+minutes+" minutes stopped. Tracker is shutting down.";
            }
        }

        return message;
    }
}
