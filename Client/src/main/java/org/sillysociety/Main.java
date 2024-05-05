package org.sillysociety;

import org.sillysociety.client.GrpcClientService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GrpcClientService grpcClient = new GrpcClientService("localhost", 9090);
        Scanner scanner = new Scanner(System.in);

        while (!grpcClient.isShutdown()) {
            System.out.println("What do you want to do?\n" +
                    "1) Get a stylist\n" +
                    "2) Get a client\n" +
                    "3) Exit");
            int choice = scanner.nextInt();
            int id;
            switch (choice) {
                case 1:
                    System.out.println("Enter id");
                    id = scanner.nextInt();
                    System.out.print(grpcClient.getStylist(id));
                    System.out.println("isDeleted = " + grpcClient.getStylist(id).getIsDeleted());
                    break;
                case 2:
                    System.out.println("Enter id");
                    id = scanner.nextInt();
                    System.out.print(grpcClient.getClient(id));
                    System.out.println("isDeleted = " + grpcClient.getClient(id).getIsDeleted());
                    break;
                case 3:
                    try {
                        grpcClient.shutdown();
                        System.exit(0);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
