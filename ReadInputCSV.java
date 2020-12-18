import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadInputCSV {

    BufferedReader readbuffer;
    String lineSeparator = "";
    String fieldDelimiter = ",";

    public ReadInputCSV(String filename) {

        try {
            this.readbuffer = new BufferedReader(new FileReader(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] readLine() throws IOException {

        String line;
        String[] fields;

        if ( (line = this.readbuffer.readLine() ) != null) {
            fields = line.split(fieldDelimiter);
            return fields;
        } else {
            return null;
        }
    }
}
