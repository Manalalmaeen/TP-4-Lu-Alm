
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;


public class Log {
	
	
	public static void print(String txt){
		String filename ="log.txt";
		BufferedWriter bw = null;
		

        try {
            // APPEND MODE SET HERE
            bw = new BufferedWriter(new FileWriter(filename, true));
            bw.write(txt + "");
            bw.newLine();
            bw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {                       // always close the file
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ioe2) {
                }
            }
        } // end try/catch/finally
	}

}
