/**
 * This class models a report object
 * 
 * @author Devin Chamberlain
 * @version 23 January, 2024
 */
package accidentpack;

public class Report implements Comparable<Report> {    
    //columns 
    private String id;
    private double severity;
    private String startTime;
    private String endTime;
    private String street;
    private String city;
    private String county;
    private String state;
    private double temperature; //in Fahrenheit
    private double humidity; //in percentage
    private double visibility; //in miles
    private String weatherCondition;
    private String crossing;
    private String sunriseSunset;
    
    /**
     * Parameterized constructor for report object
     * 
     * @param id
     * @param severity
     * @param startTime
     * @param endTime
     * @param street
     * @param city
     * @param county
     * @param state
     * @param temperature
     * @param humidity
     * @param visibility
     * @param weatherCondition
     * @param crossing
     * @param sunriseSunset
     */
    public Report(String id, double severity, String startTime, String endTime, String street, String city, String county,
            String state, double temperature, double humidity, double visibility, String weatherCondition, String crossing,
            String sunriseSunset) {
        this.id = id;
        this.severity = severity;
        this.startTime = startTime;
        this.endTime = endTime;
        this.street = street;
        this.city = city;
        this.county = county;
        this.state = state;
        this.temperature = temperature;
        this.humidity = humidity;
        this.visibility = visibility;
        this.weatherCondition = weatherCondition;
        this.crossing = crossing;
        this.sunriseSunset = sunriseSunset;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the severity
     */
    public double getSeverity() {
        return severity;
    }

    /**
     * @param severity the severity to set
     */
    public void setSeverity(double severity) {
        this.severity = severity;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the county
     */
    public String getCounty() {
        return county;
    }

    /**
     * @param county the county to set
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the temperature
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the humidity
     */
    public double getHumidity() {
        return humidity;
    }

    /**
     * @param humidity the humidity to set
     */
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    /**
     * @return the visibility
     */
    public double getVisibility() {
        return visibility;
    }

    /**
     * @param visibility the visibility to set
     */
    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    /**
     * @return the weatherCondition
     */
    public String getWeatherCondition() {
        return weatherCondition;
    }

    /**
     * @param weatherCondition the weatherCondition to set
     */
    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    /**
     * @return the crossing
     */
    public String getCrossing() {
        return crossing;
    }

    /**
     * @param crossing the crossing to set
     */
    public void setCrossing(String crossing) {
        this.crossing = crossing;
    }

    /**
     * @return the sunriseSunset
     */
    public String getSunriseSunset() {
        return sunriseSunset;
    }

    /**
     * @param sunriseSunset the sunriseSunset to set
     */
    public void setSunriseSunset(String sunriseSunset) {
        this.sunriseSunset = sunriseSunset;
    }

    @Override
    public int compareTo(Report otherReport) {
//        return (int) (this.getVisibility()-otherReport.getVisibility()); //initial attempt
        //Utilized chatGPT to resolve error
        return -(Double.toString(this.getVisibility()).compareTo(Double.toString(otherReport.getVisibility())));
    }

}
