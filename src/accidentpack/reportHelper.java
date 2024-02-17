/**
 * Class containing helper methods for operating upon report objects.
 * @author Alex Bard & Devin Chamberlain
 * @version 16 February, 2024
 */
package accidentpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class reportHelper {
    
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
     * @author Devin
     * Provides an ArrayList of Report objects that took place in specified County 
     * and State from given ArrayList
     * @param reports, an Arraylist of Report objects
     * @param county, The County to match
     * @param state, The State to match
     * @return result, The ArrayList of Reports that match <code>county</code> and <code>state</code> 
     */
    public static ArrayList<report> getReportByCountyAndState(ArrayList<report> reports, String county, String state) {
        ArrayList<report> result = new ArrayList<>();
        for (report report: reports) {
            if (report.getCounty().equals(county) && report.getState().equals(state)) {
                result.add(report);
            }
        }
        return result;
    }
    
    /**
     * @author Devin
     * Calculates the number of counters needed to process reports in given <code>county</code> 
     * and <code>state</code> for each individual day and puts them in a queue.
     * @param reports The list of reports to be filtered and processed
     * @param county The County to filter reports by
     * @param state The State to filter reports by
     * @return a queue in the form of an ArrayDeque of the number of counters needed for each day
     */
    public static ArrayDeque<Integer> calculateCounters(ArrayList<report> reports, String county, String state) {
        //call helper method to get arraylist of reports filtered 
        //by County and State, and sorted in ascending order
        ArrayList<report> filteredList = getReportByCountyAndState(reports, county, state);
        //create an ArrayList to hold each day's counters
        ArrayDeque<Integer> numCounters = new ArrayDeque<>();
        String currentDate = filteredList.get(0).getStartTime().substring(0, 10);
        ArrayDeque<report> dayCounter = new ArrayDeque<>();        
        
        for (report r: filteredList) {
            String reportDate = r.getStartTime().substring(0, 10);
            
            if (reportDate.equals(currentDate)) {
                dayCounter.addLast(r);
            } else {
                processQueue(numCounters, dayCounter);
                // reset dayCounter
                dayCounter.clear();
                // add the current report to the new dayCounter
                dayCounter.addLast(r);
                currentDate = reportDate;                
            }
        }
        // Calculate and add counters for the last day
        processQueue(numCounters, dayCounter);
        
        return numCounters;
    }
    
    /**
     * @author Devin
     * helper method to process the queue and calculate number of counters needed
     * @param numCounters The queue of counters to add to
     * @param dayCounter The queue of accidents to process
     */
    private static void processQueue(ArrayDeque<Integer> numCounters, ArrayDeque<report> dayCounter) {
        int minutes = 0;
        for (report x: dayCounter) {
            minutes += (x.getSeverity()*60);
        }
        int counters = (int) Math.ceil(minutes / 1440.0);
        numCounters.addLast(counters);
    }
}
