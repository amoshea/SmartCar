package Index;

import Index.IndexGrpc.IndexImplBase;
import io.grpc.stub.StreamObserver;

public class Index_Impl extends IndexImplBase {

    @Override
    public StreamObserver<NumberKmRequest> index(StreamObserver<AnalysisResponse> responseObserver) {
        return new StreamObserver<NumberKmRequest>() {
            @Override
            public void onNext(NumberKmRequest request) {
                double kilometer = request.getKm();
                String rate = getStatusKm(kilometer);
                AnalysisResponse response = AnalysisResponse.newBuilder()
                        .setTotal(rate).build();
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
    public static String getStatusKm(double km)
    {

        if (km < 1000)
        {	return " Very low pollution index";
        } else if (km < 2000)
        {	return "Low pollution index";
        } else if (km < 5000)
        {	return "Acceptable pollution index";
        } else if (km < 10000)
        {	return "Pollution index in state of attention";
        } else if (km < 15000)
        {	return "Attention, high pollution index";
        } else
        {	return "Problem!";
        }
    }
}
