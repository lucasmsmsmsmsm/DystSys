/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.recruitmentday;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import java.net.InetAddress;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;


/**
 *
 * @author Lucas
 */

// The creation of the server in the port 50051 followed by the registration of the services
public class RecruitmentServer {
    private static final String SERVICE_TYPE = "_grpc._tcp.local.";
    private static final String SERVICE_NAME = "RecruitmentService";

    public static void main(String[] args) throws Exception{
        int port = 50051;
        Server server = ServerBuilder.forPort(port)
            .addService(new TurnstileService())
            .addService(new WaitService())
            .addService(new SecureTestService())
            .build()
            .start();

        System.out.println("***** Server started, listening on " + port);
        registerService(port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            if (!server.isShutdown()) {
                server.shutdown();
            }
            unregisterService();
            System.err.println("*** server shut down");
        }));

        server.awaitTermination();
    }

    private static JmDNS jmdnsInstance;
    private static ServiceInfo serviceInfo;

    private static void registerService(int port) throws IOException {
        try {
            jmdnsInstance = JmDNS.create(InetAddress.getLocalHost()); // Use local host
            serviceInfo = ServiceInfo.create(SERVICE_TYPE, SERVICE_NAME, port, "Recruitment gRPC Service");
            jmdnsInstance.registerService(serviceInfo);
            System.out.println("Service registered with jmDNS: " + SERVICE_NAME + " at port " + port);
        } catch (IOException e) {
            System.err.println("Error registering service with jmDNS: " + e.getMessage());
            throw e;
        }
    }

    private static void unregisterService() {
        if (jmdnsInstance != null) {
            if (serviceInfo != null) {
                jmdnsInstance.unregisterService(serviceInfo);
                System.out.println("Service unregistered from jmDNS: " + SERVICE_NAME);
            }
            try {
                jmdnsInstance.close();
            } catch (IOException e) {
                System.err.println("Error closing jmDNS: " + e.getMessage());
            }
        }
    }
}