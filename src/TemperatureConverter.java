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
import javax.swing.JButton;

public class TemperatureConverter extends JFrame {

	JButton FahToCelButton;
	JButton CelToFahButton;
	JLabel labelFahrenheit;
	JLabel labelCelsius;
	JTextField FahrTextField;
	JTextField CelsTextField;

	public TemperatureConverter() {

		super("Temperature Converter");
		setLayout(new FlowLayout());
		labelFahrenheit = new JLabel("Temperature in °F");
		add(labelFahrenheit);
		FahrTextField = new JTextField(14);
		add(FahrTextField);

		labelCelsius = new JLabel("Temperature in °C");
		add(labelCelsius);
		CelsTextField = new JTextField(14);
		add(CelsTextField);

		FahToCelButton = new JButton("Convert °F to °C");
		FahToCelButton.setForeground(Color.BLACK);
		FahToCelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(FahToCelButton);
		CelToFahButton = new JButton("Convert °C to °F");
		CelToFahButton.setForeground(Color.BLACK);
		CelToFahButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
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

	private class fahrenheitConverterListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			double degrees = 0;
			if (event.getSource() == FahToCelButton) {
				if (isUsersInputANumber(FahrTextField.getText()) == true) {
					degrees = Double.parseDouble(FahrTextField.getText());
					int conFahToCel = (int) ((5.0 / 9.0 * (degrees - 32)));
					CelsTextField.setText(conFahToCel + " °C");
					FahrTextField.requestFocus();
					FahrTextField.selectAll();
				}

				else if (isUsersInputANumber(FahrTextField.getText()) == false) {
					FahrTextField.setText("Error: Only numbers");
				}
			}
		}
	}

	private class celsConverterListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			double degrees = 0;
			if (event.getSource() == CelToFahButton) {
				if (isUsersInputANumber(CelsTextField.getText()) == true) {
					degrees = Double.parseDouble(CelsTextField.getText());
					int conCelToFah = (int) ((9.0 / 5.0 * (degrees + 32)));
					FahrTextField.setText(conCelToFah + " °F");
					CelsTextField.requestFocus();
					CelsTextField.selectAll();
				} else if (isUsersInputANumber(CelsTextField.getText()) == false) {
					CelsTextField.setText("Error: Only numbers");
				}
			}
		}
	}

	/**
	 * Method that checks if user's input is a number or not
	 * 
	 * @param degrees
	 * @return
	 */
	public static boolean isUsersInputANumber(String degrees) {
		try {
			double d = Double.parseDouble(degrees);
		} catch (NumberFormatException ex) {
			System.out.println(ex.toString());
			return false;
		}
		return true;
	}
}