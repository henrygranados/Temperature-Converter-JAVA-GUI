/**
 * Temperature Converter
 * Author: Henry Granados
 * Website: http://henrygranados.github.io/
 */
import javax.swing.JFrame;

public class Temperature {
	public static void main(String[] args) {

		TemperatureConverter temperatureConverter = new TemperatureConverter();
		temperatureConverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		temperatureConverter.setSize(500, 300);
		temperatureConverter.setLocation(500, 400);
		temperatureConverter.setVisible(true);
	}
}