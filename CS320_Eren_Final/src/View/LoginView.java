package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import System.Room;

public class LoginView extends AbstractView{
	private MainView mainView;
	
	protected JTextField loginField;
	protected JPasswordField passwordField;
	
	private static int X_START_LOCATION = (int) (MainView.DEFAULT_X_SIZE/3.5);
	private static int X_WIDTH = (int) (MainView.DEFAULT_X_SIZE/2.5);
	
	private static int Y_START_LOCATION = MainView.DEFAULT_Y_SIZE/6;
	private static int Y_WIDTH = MainView.DEFAULT_Y_SIZE/20;
	
	private static int Y_INTERVAL = MainView.DEFAULT_Y_SIZE/9;
	private static int TEXT_DISTANCE = 10;
	
	public LoginView(MainView view){
		this.mainView = view;
		initializeUserNameTextField();
		initializePasswordTextField();
		initializeLoginButton();
	}
	
	private void initializeUserNameTextField(){
		loginField = new JTextField();
		loginField.setBackground(Color.CYAN);
		loginField.setLocation(X_START_LOCATION, Y_START_LOCATION);
		loginField.setSize(X_WIDTH,Y_WIDTH);
	}
	
	private void initializePasswordTextField(){
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.CYAN);
		passwordField.setLocation(X_START_LOCATION, Y_START_LOCATION+Y_INTERVAL);
		passwordField.setSize(X_WIDTH, Y_WIDTH);
	}
	
	private void initializeLoginButton(){
		LoginButton button = new LoginButton((int)(X_START_LOCATION+X_WIDTH/3.5)
				,(int)(Y_START_LOCATION+Y_INTERVAL*1.8)
				,X_WIDTH/2
				,Y_WIDTH);
		button.attachLoginView(this);
		this.buttons.add(button);
	}
	
	protected void login(){
		String username = loginField.getText().trim();
		String password = new String(passwordField.getPassword()).trim();
		
		
		boolean isLoginSuccesful = this.mainView.controller.login(username, password);
		
		if(isLoginSuccesful){
			mainView.detachTextFields();
			mainView.switchToReservationScreen();
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(new Font("Courier",Font.BOLD,20));
		g.setColor(Color.DARK_GRAY);
		
		g.drawString("Username", X_START_LOCATION, Y_START_LOCATION-TEXT_DISTANCE);
		g.drawString("Password", X_START_LOCATION, Y_START_LOCATION+Y_INTERVAL-TEXT_DISTANCE);
	}

	public void mouseMoved(int x, int y) {
		super.mouseMoved(x, y);
	}

	public void mousePressed(int x, int y) {
		super.mousePressed(x, y);
	}

}
