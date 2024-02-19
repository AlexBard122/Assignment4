
package accidentpack;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author abard
 *
 */
public class program4 {

	/**
	 * @author abard
	 * calculates elapsed time and converts it to seconds
	 * @param time1
	 * @param time2
	 * @return String
	 */
	public static String convertTime(long time1, long time2) {
		long elapsedTime = time2 - time1;
		double elapsedTimeSeconds;
		elapsedTimeSeconds = elapsedTime / 1000000000;
		return String.valueOf(elapsedTimeSeconds);
	}
	/**
	 * @author abard
	 * @param args
	 */
	public static void main(String[] args) throws IOException{

		// user-generated arguments
        String filePath = args[0];
        String county = args[1];
        String state = args[2];
        
        //reading the csv file
        ArrayList<report> report = reportHelper.ReadCSVFile(filePath);
        
        //calculating the min number of counters needed and find the time it takes to calculate
        long time1 = System.nanoTime();
        ArrayDeque<Integer> countersNeeded = new ArrayDeque<>();
        countersNeeded = reportHelper.calculateCounters(report, county, state);
        long time2 = System.nanoTime();
        String processTime = convertTime(time1, time2);
        
        //outputs:
        int maxNum = reportHelper.findMax(countersNeeded);
        System.out.println("County: " + county + " State: " + state);
        System.out.println(processTime + " seconds to simulate the process");
        System.out.println("minimun number of counters needed: " + maxNum);
	}
}
