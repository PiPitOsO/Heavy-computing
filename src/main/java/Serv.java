import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Serv {
    public static void main(String[] args) throws IOException {
        ServerSocket servSocket = new ServerSocket(23437);

        while (true) {
            try (Socket socket = servSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {

//                    out.println(line);

                    int[] arr = new int[Integer.parseInt(line)];
                    arr[0] = 0;
                    arr[1] = 1;
                    for (int i = 2; i < arr.length; ++i) {
                        arr[i] = arr[i - 1] + arr[i - 2];
                    }

                    for (int i = 0; i < arr.length; ++i) {
                        out.println(arr[i]);
                    }

                    if (line.equals("end")) {
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

}