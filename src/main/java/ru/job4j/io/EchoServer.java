package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    do {
                        str = in.readLine();
                        System.out.println(str);
                        if (str.contains("Bye")) {
                            server.close();
                        }
                    } while (!str.isEmpty());
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                } catch (IOException e) {
                    System.out.println("Stop");
                }
            }
        }
    }
}