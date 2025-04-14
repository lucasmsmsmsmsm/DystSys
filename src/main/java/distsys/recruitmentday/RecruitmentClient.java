/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.recruitmentday;

import distsys.recruitmentday.time.Time;
import distsys.recruitmentday.time.WaitServiceGrpc;
import distsys.recruitmentday.turnstile.Turnstile;
import distsys.recruitmentday.turnstile.TurnstileServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Lucas
 */

// A blocking stub to synchronous call to the TurnstileService
// A non-blocking stub to make an asynchronous call to the WaitService
public class RecruitmentClient {
    private final ManagedChannel channel;
    private final TurnstileServiceGrpc.TurnstileServiceBlockingStub turnstileStub;
    private final WaitServiceGrpc.WaitServiceStub waitStub;

    //A channel to connect to the server
    public RecruitmentClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        this.turnstileStub = TurnstileServiceGrpc.newBlockingStub(channel);
        this.waitStub = WaitServiceGrpc.newStub(channel);
    }
    
    // Shutdown method to end the call
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
    //Main method
    public static void main(String[] args) throws InterruptedException {
        RecruitmentClient client = new RecruitmentClient("localhost", 50051);
            try {
                client.enterBuilding();
                client.waitForInterview();
            } finally {
                client.shutdown();
            }
    }
    
    //Method for the turnstile
    private void enterBuilding() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the PIN: ");
        int pin = scanner.nextInt();
        
        Turnstile.CheckPinResponse response = turnstileStub.checkPin(
            Turnstile.CheckPinRequest.newBuilder().setPin(pin).build());
        
        if (response.getAccessGranted()) {
            System.out.println("Access granted");
            System.out.println("Please collect the pager from the box.");
        } else {
            System.out.println("Access denied: " + response.getMessage());
            System.exit(0);
        }
    }

    //Method for the pager
    private void waitForInterview() throws InterruptedException {
        System.out.println("Someone will be with you shortly");
        
        CountDownLatch latch = new CountDownLatch(1);
        
        waitStub.streamWaitTime(
            Time.WaitTimeRequest.newBuilder().setDeviceId("pager-1").build(),
            new StreamObserver<Time.WaitTimeUpdate>() {
                @Override
                public void onNext(Time.WaitTimeUpdate update) {
                    System.out.println(update.getTimeRemaining());
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error in wait time update: " + t.getMessage());
                    latch.countDown();
                }

                @Override
                public void onCompleted() {
                    System.out.println("Your interviewer is ready to see you.");
                    latch.countDown();
                }
            });
        
        latch.await();
    }
}