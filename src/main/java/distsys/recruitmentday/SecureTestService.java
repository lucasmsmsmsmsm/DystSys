/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.recruitmentday;

import distsys.recruitmentday.securetest.SecureTest;
import distsys.recruitmentday.securetest.SecureTestServiceGrpc;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class SecureTestService extends SecureTestServiceGrpc.SecureTestServiceImplBase{

    
    @Override
    public StreamObserver<SecureTest.Video> monitorTestSession(
        StreamObserver<SecureTest.MonitoringResponse> responseObserver) {

    return new StreamObserver<SecureTest.Video>() {
        private int warnings = 0;
        private final int MAX_WARNINGS = 3;

        @Override
        public void onNext(SecureTest.Video video) {
            if (!video.getCamera()) {
                warnings++;
                responseObserver.onNext(SecureTest.MonitoringResponse.newBuilder()
                    .setWarning("Warning " + warnings + ": Please look at the screen!")
                    .build());

                if (warnings >= MAX_WARNINGS) {
                    responseObserver.onNext(SecureTest.MonitoringResponse.newBuilder()
                        .setWarning("The test has ended due to multiple violations.")
                        .build());
                    responseObserver.onCompleted();
                }
            }
        }

        @Override
        public void onError(Throwable t) {
            System.err.println("Monitoring error: " + t.getMessage());
        }

        @Override
        public void onCompleted() {
            responseObserver.onNext(SecureTest.MonitoringResponse.newBuilder()
                .setWarning("Monitoring session complete.")
                .build());
            responseObserver.onCompleted();
        }
    };
} 


    @Override
    public StreamObserver<SecureTest.TestAnswer> submitTestAnswers(
        StreamObserver<SecureTest.TestResult> responseObserver) {

        return new StreamObserver<SecureTest.TestAnswer>() {
            private final List<String> answers = new ArrayList<>();

            @Override
            public void onNext(SecureTest.TestAnswer answer) {
                System.out.println("Received answer: " + answer.getAnswer());
                answers.add(answer.getAnswer());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error while receiving test answers: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                String resultMessage = "Test completed. You submitted " + answers.size() + " answers.";

                SecureTest.TestResult result = SecureTest.TestResult.newBuilder()
                    .setMessage(resultMessage)
                    .addAllAnswers(answers)
                    .build();

                responseObserver.onNext(result);
                responseObserver.onCompleted();
            }
        };
    }

}
