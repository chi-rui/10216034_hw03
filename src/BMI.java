import javax.swing.*;
import java.awt.*;

public class BMI extends JFrame{
	public BMI(){
	setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
	
	add(new JLabel("Name :"));
	add(new JTextField(8));
	add(new JLabel("Age :"));
	add(new JTextField(8));
	add(new JLabel("BMI"));
	add(new JTextField(8));
	}
	
	public static void main(String[] args){
		BMI frame = new BMI();
		frame.setTitle("BMI");
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
