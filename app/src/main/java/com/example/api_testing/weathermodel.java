package com.example.api_testing;

public class weathermodel {
    private int id;
    String weather_state_name;
    private String weather_state_abbr;
    private String wind_direction_compass;
    private String created;
    private String applicable_date;
    private double min_temp;
    private double max_temp;
    private double the_temp;
    private double wind_speed;
    private double wind_directon;
    private double air_pressure;
    private int humidity;
    private double visibility;
    private int predict;

    public weathermodel(int id, String weather_state_name, String weather_state_abbr, String wind_direction_compass, String created, String applicable_date, double min_temp, double max_temp, double the_temp, double wind_speed, double wind_directon, double air_pressure, int humidity, double visibility, int predict) {
        this.id = id;
        this.weather_state_name = weather_state_name;
        this.weather_state_abbr = weather_state_abbr;
        this.wind_direction_compass = wind_direction_compass;
        this.created = created;
        this.applicable_date = applicable_date;
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.the_temp = the_temp;
        this.wind_speed = wind_speed;
        this.wind_directon = wind_directon;
        this.air_pressure = air_pressure;
        this.humidity = humidity;
        this.visibility = visibility;
        this.predict = predict;
    }

    public weathermodel() {
    }

    @Override
    public String toString() {
        return

                  weather_state_name + '\n' +

                "date = " + applicable_date + '\n' +
                "min_temp = " + min_temp +'\n' +
                "max_temp = " + max_temp +'\n' +
                "the_temp = " + the_temp +'\n' ;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeather_state_name() {
        return weather_state_name;
    }

    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }

    public String getWeather_state_abbr() {
        return weather_state_abbr;
    }

    public void setWeather_state_abbr(String weather_state_abbr) {
        this.weather_state_abbr = weather_state_abbr;
    }

    public String getWind_direction_compass() {
        return wind_direction_compass;
    }

    public void setWind_direction_compass(String wind_direction_compass) {
        this.wind_direction_compass = wind_direction_compass;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getApplicable_date() {
        return applicable_date;
    }

    public void setApplicable_date(String applicable_date) {
        this.applicable_date = applicable_date;
    }

    public double getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(double min_temp) {
        this.min_temp = min_temp;
    }

    public double getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(double max_temp) {
        this.max_temp = max_temp;
    }

    public double getThe_temp() {
        return the_temp;
    }

    public void setThe_temp(double the_temp) {
        this.the_temp = the_temp;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public double getWind_directon() {
        return wind_directon;
    }

    public void setWind_directon(double wind_directon) {
        this.wind_directon = wind_directon;
    }

    public double getAir_pressure() {
        return air_pressure;
    }

    public void setAir_pressure(double air_pressure) {
        this.air_pressure = air_pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public int getPredict() {
        return predict;
    }

    public void setPredict(int predict) {
        this.predict = predict;
    }
}
