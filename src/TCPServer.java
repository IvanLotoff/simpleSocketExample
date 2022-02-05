import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

class TCPServer {
    private final static int SERVER_PORT = 10000;
    public static void main(String[] args) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String clientMessage;
        String serverResponse;
        ServerSocket welcomeSocket = new ServerSocket(SERVER_PORT);
        Socket connectionSocket = welcomeSocket.accept();
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        LocalDateTime now;
        while (true) {
            clientMessage = inFromClient.readLine(); // никак не используется
            now = LocalDateTime.now();
            serverResponse = dtf.format(now) + '\n';
            outToClient.writeBytes(serverResponse);
        }
    }
}