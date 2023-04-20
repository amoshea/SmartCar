package Status;

import Status.StatusGrpc.StatusImplBase;
import io.grpc.stub.StreamObserver;

public class Status_Impl extends StatusImplBase{

    //Server Streaming
    public void CheckFilterStatus(FilterStatusRequest request, StreamObserver<FilterStatusResponse> responseObserver)
    {       try
    {   int filterStatus = request.getFilterStatus();

        for(int i = 0; i < filterStatus; i++)
        {   FilterStatusResponse response = FilterStatusResponse.newBuilder().setFilterStatusCurr(randomRate(20, 220)).build();
            responseObserver.onNext(response);
            Thread.sleep(filterStatus * 1000L);
        }
    } catch (InterruptedException e)
    {  e.printStackTrace(); }
    finally {
        responseObserver.onCompleted();
    }
    }
    //Random method to generate filter status.
    public static double randomRate(double min, double max)
    {   double FilterStatusCurr = (Math.random()*((max-min)+1))+min;
        return FilterStatusCurr;
    }
}
