package guis;

import java.awt.Color;

import javax.swing.*;

import db_objs.User;

public abstract class BaseFrame extends JFrame {
	protected User user;

	public BaseFrame(String title) {initialize(title);}
	public BaseFrame(String title,User user) {
		this.user=user;
		initialize(title);
	
	}
	public void initialize(String title) {
		
		setTitle(title);
		setSize( 420, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setBackground(Color.BLACK);
			
		addGuiComponents();
			}
	
	protected abstract void addGuiComponents();
	
}
