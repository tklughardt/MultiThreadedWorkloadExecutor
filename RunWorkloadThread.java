import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Thread.sleep;

public class RunWorkloadThread implements Runnable {

    ConnectHandle c;
    int scheduleMillis;
    int threadId;

    public RunWorkloadThread(ConnectHandle c, int scheduleMillis, int threadId) {
        this.c = c;
        this.scheduleMillis = scheduleMillis;
        this.threadId = threadId;
    }

    @Override
    public void run() {

        try {
            c.connect();

            while (true) {
                Connection conn = c.getConnection();
                RandomJSONGenerator r = new RandomJSONGenerator();

                PreparedStatement sql = conn.prepareStatement("INSERT INTO JSON_LAB_STAGE select parse_json(?), parse_json(?);");
                sql.setString(1, r.generateRecordMetadata());
                sql.setString(2, r.generateRecordContent());

                try {
                    sql.executeQuery();
                    System.out.println("Thread " + this.threadId + " --> Sending Query against " + this.c.url + " as user " + c.username);
                } catch (SQLException se) {
                    System.err.println("Table Lock detected --> " + se.getMessage());
                }

                sleep(scheduleMillis);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
