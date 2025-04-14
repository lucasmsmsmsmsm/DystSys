/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.recruitmentday;

import distsys.recruitmentday.time.Time;
import distsys.recruitmentday.time.WaitServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 *
 * @author Lucas
 */

public class WaitService extends WaitServiceGrpc.WaitServiceImplBase {
    @Override
    public void streamWaitTime(Time.WaitTimeRequest request, StreamObserver<Time.WaitTimeUpdate> responseObserver) {
        try {
            for (int i = 10; i >= 0; i--) {
                Time.WaitTimeUpdate update = Time.WaitTimeUpdate.newBuilder()
                    .setTimeRemaining(i + " minutes remaining")
                    .build();
                responseObserver.onNext(update);
                Thread.sleep(1000);
            }
            responseObserver.onCompleted();
        } catch (InterruptedException e) {
            responseObserver.onError(e);
        }
    }
}