import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 23437);
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("\nЧисло Фиббоначчи\nВведите число:");
            String msg = scanner.nextLine();
            out.println(msg);

            System.out.println();
            for (int i = 0; i < Integer.parseInt(msg); ++i) {
                System.out.println(in.readLine());
            }
        }
    }
}

// Blocking так как объекты очень малы и разницы не увидим.