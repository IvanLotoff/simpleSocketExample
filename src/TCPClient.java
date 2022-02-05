import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

class TCPClient {
    private final static int SERVER_PORT = 10000;
    public static void main(String[] args) throws Exception {
        String messageToServer;
        String messageFromServer;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", SERVER_PORT);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        messageToServer = inFromUser.readLine();
        while (true) {
            outToServer.writeBytes(messageToServer + '\n');
            messageFromServer = inFromServer.readLine();
            System.out.println("FROM SERVER: " + messageFromServer);
            Thread.sleep(1_000);
        }
        //clientSocket.close();
    }
}