
package accidentpack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author abard
 *
 */
public class program4 {

	
	
	
	/**
	 * @author abard
	 * reads a CSV file and populates an ArrayList of report objects
	 * @param filePath
	 * @return Array List of report objects
	 * @throws IOException
	 */
	public static ArrayList<report> ReadCSVFile(String filePath) throws IOException
    {
        ArrayList<report> report = new ArrayList<report>();
        
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = null;
        
        reader.readLine();
        while ((line = reader.readLine()) != null) {
         
        readfile(report, line);
        }
        reader.close();
        return report;
    }
	/**
	 * @author abard
	 * sorts the contents of a csv file into and ArrayList<report>
	 * @param report
	 * @param line
	 */
	private static void readfile(ArrayList<report> report, String line) {
		String[] items = line.split(",");
		String ID = items[0];
		int Severity = Integer.parseInt(items[1]);
		String StartTime = (items[2]);
		String EndTime = (items[3]);
		String Street = items[4];
		String City = items[5];
		String County = items[6];
		String State = items[7];
		String Temp = (items[8]);
		String Humidity = (items[9]);
		double Visibility = Double.parseDouble(items[10]);
		String Weather = items[11];
		boolean Crossing = Boolean.parseBoolean(items[12]);
		String Daynight = items[13];
		report r = new report(ID, Severity, StartTime, EndTime, Street, City, County, State, Temp,
				Humidity, Visibility, Weather, Crossing, Daynight);
		
		sortfile(report, r);
		//report.add(r);
	}
	
	/**
	 * @author abard
	 * method for helping sort the ArrayList by start time in ascending order
	 * @param ArrayList<report>
	 * @param report
	 */
	private static void sortfile(ArrayList<report> reports, report r) {
		if(reports.size() == 0) {
			reports.add(r);
			return;
		}
		int index = 0;
		for(report reportlist: reports) {
			//if a start time in the list is greater than the provided start time, then add r before it
			if(reportlist.getStartTime().compareTo(r.getStartTime()) > 0) {
				reports.add(index, r);
				return;
			}
			index++;
		}
		reports.add(r);
	}
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
        ArrayList<report> report = ReadCSVFile(filePath);
        
        //loop used to print start times to show ArrayList is sorted properly. feel free to remove
        for(report reportlist: report) {
        	System.out.println(reportlist.getStartTime());
        }
        
        
        //calculateCounters(report, county, state);
	}

}
