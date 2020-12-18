import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

    List<ConnectHandle> connections;

    public void createConnectionsFromCSV(String filename) throws Exception {
        connections = new ArrayList<>();
        ReadInputCSV csv = new ReadInputCSV(filename);
        String[] fields;

        while (!( (fields = csv.readLine()) == null) ) {
            connections.add( new ConnectHandle(fields[0], fields[1], fields[2]) );
        }
    }


    public static void main(String[] args) {
        try {
            Executor e = new Executor();
            e.createConnectionsFromCSV("/Volumes/GoogleDrive/My Drive/Projects/Dev/MultiConnectionExecutor/src/test.csv");

            ExecutorService executor = Executors.newCachedThreadPool();

            int threadId = 0;

            for (ConnectHandle ch : e.connections) {
                ch.connect();
                executor.execute(new RunWorkloadThread(ch, 1000, threadId++));
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
     }
}
