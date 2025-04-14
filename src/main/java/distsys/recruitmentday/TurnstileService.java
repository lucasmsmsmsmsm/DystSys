/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.recruitmentday;

import distsys.recruitmentday.turnstile.Turnstile;
import distsys.recruitmentday.turnstile.TurnstileServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 *
 * @author Lucas
 */

public class TurnstileService extends TurnstileServiceGrpc.TurnstileServiceImplBase {
    @Override
    public void checkPin(Turnstile.CheckPinRequest request, StreamObserver<Turnstile.CheckPinResponse> responseObserver) {
        boolean accessGranted = request.getPin() == 1991;
        
        Turnstile.CheckPinResponse response = Turnstile.CheckPinResponse.newBuilder()
            .setAccessGranted(accessGranted)
            .setMessage(accessGranted ? "Access granted" : "Invalid PIN")
            .build();
        
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}