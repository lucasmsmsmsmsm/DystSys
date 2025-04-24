/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.recruitmentday;

import distsys.recruitmentday.time.Time;
import distsys.recruitmentday.time.WaitServiceGrpc;
import distsys.recruitmentday.turnstile.Turnstile;
import distsys.recruitmentday.turnstile.TurnstileServiceGrpc;
import distsys.recruitmentday.securetest.SecureTest;
import distsys.recruitmentday.securetest.SecureTestServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

/**
 *
 * @author Lucas
 */

// A blocking stub to synchronous call to the TurnstileService
// A non-blocking stub to make an asynchronous call to the WaitService
public class RecruitmentClient {
    private ManagedChannel channel;
    private TurnstileServiceGrpc.TurnstileServiceBlockingStub turnstileStub;
    private WaitServiceGrpc.WaitServiceStub waitStub;
    private SecureTestServiceGrpc.SecureTestServiceStub secureTestStub;
    private JmDNS jmdns;
    
    // Initializing the jmDNS
     public RecruitmentClient() {
        try {
            this.jmdns = JmDNS.create();
        } catch (IOException e) {
            System.err.println("Failed to initialize jmDNS: " + e.getMessage());
        }
    }

    // Shutdown method to end the call
    public void shutdown() throws InterruptedException {
        if (channel != null) {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
        if (jmdns != null) {
            try {
                jmdns.close();
            } catch (IOException e) {
                System.err.println("Failed to close jmDNS: " + e.getMessage());
            }
        }
    }

    // Method to discover the grpc server
    private void discoverServer() throws InterruptedException {
        CountDownLatch discoverLatch = new CountDownLatch(1);
        String serviceType = "_grpc._tcp.local."; // Change if needed
        jmdns.addServiceListener(serviceType, new ServiceListener() {
            @Override
            public void serviceAdded(ServiceEvent event) {
                System.out.println("Service added: " + event.getName());
                jmdns.requestServiceInfo(event.getType(), event.getName());
            }

            @Override
            public void serviceRemoved(ServiceEvent event) {
                System.out.println("Service removed: " + event.getName());
            }

            @Override
            public void serviceResolved(ServiceEvent event) {
                ServiceInfo info = event.getInfo();
                System.out.println("Service resolved: " + info.getName() + " at " + info.getHostAddress() + ":" + info.getPort());
                channel = ManagedChannelBuilder.forAddress(info.getHostAddress(), info.getPort()).usePlaintext().build();
                turnstileStub = TurnstileServiceGrpc.newBlockingStub(channel);
                waitStub = WaitServiceGrpc.newStub(channel);
                secureTestStub = SecureTestServiceGrpc.newStub(channel);
                discoverLatch.countDown();
            }
        });
        discoverLatch.await(10, TimeUnit.SECONDS);
        if (channel == null) {
            System.err.println("Failed to discover gRPC server, using default localhost:50051");
            channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            turnstileStub = TurnstileServiceGrpc.newBlockingStub(channel);
            waitStub = WaitServiceGrpc.newStub(channel);
            secureTestStub = SecureTestServiceGrpc.newStub(channel);
        }
    }
    
    //Main method
    public static void main(String[] args) throws InterruptedException {
        RecruitmentClient client = new RecruitmentClient();
            try {
                client.discoverServer();
                client.enterBuilding();
                client.waitForInterview();
                client.monitoringTest();
                client.takeTheTest();
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
    
    //Method for the monitored test
  private void monitoringTest() throws InterruptedException {
    System.out.println("Starting test monitoring...");
    CountDownLatch monitorLatch = new CountDownLatch(1);
    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    final StreamObserver<SecureTest.Video>[] monitorObserver = new StreamObserver[1];

    StreamObserver<SecureTest.MonitoringResponse> responseObserver = new StreamObserver<SecureTest.MonitoringResponse>() {
        @Override
        public void onNext(SecureTest.MonitoringResponse response) {
            System.out.println("Monitor: " + response.getWarning());

            if (response.getWarning().toLowerCase().contains("ended")) {
                scheduler.shutdown();
                monitorObserver[0].onCompleted();
            }
        }

        @Override
        public void onError(Throwable t) {
            System.err.println("Monitoring error: " + t.getMessage());
            scheduler.shutdown();
            monitorLatch.countDown();
        }

        @Override
        public void onCompleted() {
            System.out.println("Monitoring completed successfully");
            scheduler.shutdown();
            monitorLatch.countDown();
        }
    };

        monitorObserver[0] = secureTestStub.monitorTestSession(responseObserver);

        scheduler.scheduleAtFixedRate(() -> {
            boolean isLooking = Math.random() > 0.2;
            monitorObserver[0].onNext(SecureTest.Video.newBuilder().setCamera(isLooking).build());
        }, 0, 1, TimeUnit.SECONDS);

        monitorLatch.await();
    }


    //Method for the answers for the test
  private void takeTheTest() throws InterruptedException {
        System.out.println("\nStarting the test...");
        CountDownLatch testLatch = new CountDownLatch(1);
        Scanner scanner = new Scanner(System.in);

        StreamObserver<SecureTest.TestAnswer> answerObserver = secureTestStub.submitTestAnswers(
            new StreamObserver<SecureTest.TestResult>() {
                @Override
                public void onNext(SecureTest.TestResult result) {
                    System.out.println("\nTest Results:");
                    System.out.println(result.getMessage());
                    System.out.println("Your answers: " + result.getAnswersList());
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Test submission error: " + t.getMessage());
                    testLatch.countDown();
                }

                @Override
                public void onCompleted() {
                    testLatch.countDown();
                }
            });

        for (int i = 0; i < 5; i++) {
            String answer;
            do {
                System.out.print("\nEnter answer for question " + (i+1) + " (single letter): ");
                answer = scanner.nextLine().trim();
            } while (answer.length() != 1 || !Character.isLetter(answer.charAt(0)));

            answerObserver.onNext(
                SecureTest.TestAnswer.newBuilder()
                    .setAnswer(answer)
                    .build());
        }

        answerObserver.onCompleted();
        testLatch.await();
        scanner.close();
    }
}