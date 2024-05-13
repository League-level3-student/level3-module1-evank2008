package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener{
	HashMap<String, WeatherData> weatherData;
    JFrame frame = new JFrame("Weather Searcher");
    JPanel panel = new JPanel();
    JButton findCW = new JButton("Weather of a City");
    JButton findWC = new JButton("Cities with Weather");
    JButton findCT = new JButton("Cities within a Temperature Range");
    void start() {
        weatherData = Utilities.getWeatherData();
        findCW.addActionListener(this);
        findWC.addActionListener(this);
        findCT.addActionListener(this);
        panel.add(findCW);
        panel.add(findWC);
        panel.add(findCT);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // All city keys have the first letter capitalized of each word
        String cityName = Utilities.capitalizeWords( "National City" );
        WeatherData datum = weatherData.get(cityName);
        
        if( datum == null ) {
            System.out.println("Unable to find weather data for: " + cityName);
        } else {
            System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==findCW) {
			String city = Utilities.capitalizeWords(JOptionPane.showInputDialog("Enter City Name"));
			if(findWeatherByCity(city)==null) {
				JOptionPane.showMessageDialog(null,"No weather data found for city: "+city);
			}
			JOptionPane.showMessageDialog(null, city + " is " + findWeatherByCity(city).weatherSummary + " and " + findWeatherByCity(city).temperatureF + "F");
		}
		if(e.getSource()==findWC) {
			String weather = Utilities.capitalizeWords(JOptionPane.showInputDialog("Enter Desired Weather Condition"));
			JOptionPane.showMessageDialog(null, findCitiesByWeather(weather));
		}
		if(e.getSource()==findCT) {
			int min = Integer.parseInt(JOptionPane.showInputDialog("Minimum Temperature:"));
			int max = Integer.parseInt(JOptionPane.showInputDialog("Maximum Temperature:"));
			if(min>max) {
				JOptionPane.showMessageDialog(null, "Minimum cannot exceed the maximum");
			} else {
			JOptionPane.showMessageDialog(null,findCitiesByTempRange(min,max));
			}
		}
	}
	WeatherData findWeatherByCity(String cityName) {
		if(weatherData.containsKey(cityName)) {
			return weatherData.get(cityName);
		} else {
			return null;
		}
	}
	String findCitiesByWeather(String weatherCondition) {
		String cities = "";
		boolean doesThisWeatherExist = false;
		String desiredWeather = Utilities.capitalizeWords(weatherCondition);
		for(String cityName : weatherData.keySet()) {
			if(weatherData.get(cityName).weatherSummary.equals(desiredWeather)) {
				doesThisWeatherExist=true;
				if(cities.length()==0) {
					cities+=cityName;
				} else {
					cities+=", "+cityName;
				}
			}
		}
		if(!doesThisWeatherExist) {
			return "No cities found with "+desiredWeather+" weather";
		} else {
		return cities;	
		}
	}
	String findCitiesByTempRange(int min, int max) {
		String cities = "";
		boolean areThereAny = false;
		for(String cityName : weatherData.keySet()) {
			double temp = weatherData.get(cityName).temperatureF;
			if(temp>=min&&temp<=max) {
				areThereAny=true;
				if(cities.length()==0) {
					cities+=cityName+" "+temp+"F";
				} else {
					cities+=", "+cityName+" "+temp+"F";
				}
			}
		}
		if(!areThereAny) {
			return "No cities within desired temperature range";
		} else {
			return cities;
		}
	}
}
