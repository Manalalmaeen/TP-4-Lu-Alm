/**
 * File    : Log.java
 * Purpose : This class logs all the activities that are performed in log.txt file
 *
 *
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;


public class Log {
	
	/**
	 * 
	 * @param txt : The text to be written to the file
	 */
	public static void print(String txt){
		String filename ="log.txt";
		BufferedWriter bw = null;
		
        try {
            // APPEND MODE SET HERE
            bw = new BufferedWriter(new FileWriter(filename, true));
            bw.write(txt + "");
            bw.newLine();
            // flush all the text to the file
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
