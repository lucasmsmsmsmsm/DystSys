/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.recruitmentday;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 *
 * @author Lucas
 */

// The creation of the server in the port 50051, followed by the registration of the services
public class RecruitmentServer {
    public static void main(String[] args) throws Exception{
        int port = 50051;
        Server server = ServerBuilder.forPort(port)
            .addService(new TurnstileService())
            .addService(new WaitService())
            .build()
            .start();

        System.out.println("***** Server started, listening on " + port);
        server.awaitTermination();
    }
}