import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TCPServer {
    public static void main(String[] args) throws Exception {

            readFromClient();

    }

    public static void readFromClient() throws Exception {
        ServerSocket sc = new ServerSocket(8080);

        Socket socket = sc.accept();
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        int mLength = dis.readInt();
        byte[] message = new byte[mLength];
        dis.readFully(message);
        Files.write(Paths.get("imrs.jpeg"), message);


    }
}
