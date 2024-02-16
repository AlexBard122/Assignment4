
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

		/**
		 * I have provided the methods main, convertTime (to count time between tasks)
		 * 	ReadCSVFile (to read the file), readfile (converts contents of file into reports and
		 * 	adds them to an ArrayList) and sortfile (sorts the arraylist by start time as reports are added)
		 * 
		 * I am using my report constructor class because I know it works with my sorting methods, but I can change
		 * 	aspects of it if needed
		 * 
		 * Program needs arguments in order to run. make sure to set run configurations arguments to ${string_prompt}
		 * 	and use the input: accidents_small_sample.csv county state
		 */
		
		// user-generated arguments
        String filePath = args[0];
        String county = args[1];
        String state = args[2];
        
        // reading the csv file
        ArrayList<report> report = reportHelper.ReadCSVFile(filePath);
        
        //loop used to print start times to show ArrayList is sorted properly. feel free to remove
        for(report reportlist: report) {
        	System.out.println(reportlist.getStartTime() + "\t" + reportlist.getCounty());
        }
        
        ArrayList<report> filtered = reportHelper.getReportByCountyAndState(report, county, state);
        for(report reports: filtered) {
            System.out.println(reports.getCounty() + " " + reports.getState());
        }
        
        //NOT WORKING
        //calculateCounters(report, county, state);
        ArrayDeque<Integer> countersNeeded = new ArrayDeque<>();
        countersNeeded = reportHelper.calculateCounters(report, county, state);
        
        for(Integer counters: countersNeeded) {
            System.out.println(counters);
        }
	}

}
