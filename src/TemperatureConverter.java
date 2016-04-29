/**
 * Temperature Converter
 * Author: Henry Granados
 * Website: http://henrygranados.github.io/
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JButton;

public class TemperatureConverter extends JFrame {

	JButton FahToCelButton; // Fahrenheit converter button
	JButton CelToFahButton; // Celsius converter button
	JLabel labelFahrenheit; // Fahrenheit label
	JLabel labelCelsius;    // Celsius label
	JTextField FahrTextField;// Fahrenheit textfield
	JTextField CelsTextField;// Celsius textfield

	/**
	 * Constructor of TemperatureConverter class
	 */
	public TemperatureConverter() {

		super("Temperature Converter"); // Sets the title of the GUI
		setLayout(new FlowLayout());
		labelFahrenheit = new JLabel("Temperature in °F");// Sets Fahrenheit label
		add(labelFahrenheit);
		FahrTextField = new JTextField(10);
		add(FahrTextField);

		labelCelsius = new JLabel("Temperature in °C");// Sets Celsius label
		add(labelCelsius);
		CelsTextField = new JTextField(10);
		add(CelsTextField);

		FahToCelButton = new JButton("Convert °F to °C");// Text on Fahrenheit button
		FahToCelButton.setForeground(Color.BLACK);
		FahToCelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(FahToCelButton);
		CelToFahButton = new JButton("Convert °C to °F");// Text on Celsius button
		CelToFahButton.setForeground(Color.BLACK);
		CelToFahButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // cursor to button
		add(CelToFahButton);		

		JPanel panel = new JPanel(new GridLayout(2, 2, 20, 20));
		panel.add(labelFahrenheit);
		panel.add(labelCelsius);
		panel.add(FahrTextField);
		panel.add(CelsTextField);
		add(panel, BorderLayout.WEST);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(FahToCelButton);
		buttonPanel.add(CelToFahButton);
		add(buttonPanel, BorderLayout.EAST);

		FahToCelButton.addActionListener(new fahrenheitConverterListener());
		CelToFahButton.addActionListener(new celsConverterListener());
	}
		
	/**
	 * fahrenheitConverterListener Class
	 * Here we add actual functionality to the fahrenheit button
	 *
	 */
	private class fahrenheitConverterListener implements ActionListener {
		
		/**
		 * This method will validate user's input and ensure input is 
		 * an valid number otherwise the isUsersInputANumber method will catch it
		 * by outputting a message on the console and the actual GUI.
		 * This method will also process user's input and do a math conversion to Celsius degrees
		 */
		public void actionPerformed(ActionEvent event) {
			double degrees = 0;
			if (event.getSource() == FahToCelButton) {
				if (isUsersInputANumber(FahrTextField.getText())) {
					degrees = Double.parseDouble(FahrTextField.getText());
					int conFahToCel = (int) ((5.0 / 9.0 * (degrees - 32)));
					CelsTextField.setText(String.valueOf(conFahToCel));
					FahrTextField.requestFocus();
					FahrTextField.selectAll();
					String firstText = FahrTextField.getText();
					String secondText = CelsTextField.getText();
					writingToFile(firstText, secondText);
				}

				else if (!isUsersInputANumber(FahrTextField.getText())) {
					FahrTextField.setText("Error: Only numbers");
				}
			}
		}
	}

	/**
	 * This method will validate user's input and ensure input is 
	 * an valid number otherwise the isUsersInputANumber method will catch it
	 * by outputting a message on the console and the actual GUI.
	 * This method will also process user's input and do a math conversion to fahrenheit degrees
	 */
	private class celsConverterListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			double degrees = 0;
			if (event.getSource() == CelToFahButton) {
				if (isUsersInputANumber(CelsTextField.getText())) {
					degrees = Double.parseDouble(CelsTextField.getText());
					int conCelToFah = (int) ((9.0 / 5.0 * (degrees + 32)));
					FahrTextField.setText(String.valueOf(conCelToFah));
					CelsTextField.requestFocus();
					CelsTextField.selectAll();
					String firstText = FahrTextField.getText();
					String secondText = CelsTextField.getText();
					writingToFile(firstText, secondText);
				} else if (!isUsersInputANumber(CelsTextField.getText())) {
					CelsTextField.setText("Error: Only numbers");
				}
			}
		}
	}

	/**
	 * This method checks if user's input is a valid number or not
	 * 
	 * @param degrees degrees entered by user
	 * @return true if degrees is a valid number otherwise returns false if it's not
	 */
	public static boolean isUsersInputANumber(String degrees) {
		try {
			double d = Double.parseDouble(degrees);
		} catch (NumberFormatException ex) {
			System.out.println("Error: Only numbers");
			return false;
		}
		return true;
	}
	
	/**
	 * This method will write user's input to file
	 * @param firstText
	 * @param secondText
	 */
	public static void writingToFile(String firstText, String secondText){
		
		try {
			String myString = firstText + " °F" + "..........." + secondText + " °C";
			String filename = "file.txt";
			FileWriter myfile = new FileWriter(filename, true); // the true will append the new data
			myfile.write(myString + "\t\t\t\t\n");// appends the string to the file
			myfile.close();
		} catch (Exception ex) {
			System.out.println("An error has occurred writing to the file");
		}
	}	
	
}