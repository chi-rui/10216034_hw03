import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;


public class BMI extends JFrame{
	
	JTextField jftName = new JTextField(8);
	JTextField jftAge = new JTextField(8);
	JTextField jftHeight = new JTextField(8);
	JTextField jftWeight = new JTextField(8);
	JTextField jftResult = new JTextField(8);
	JButton jbtBMI = new JButton("­pºâBMI");
	
	public BMI(){
		
	setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
	
	add(new JLabel("Name :"));
	add(jftName);
	add(new JLabel("Age :"));
	add(jftAge);
	add(new JLabel("Height :"));
	add(jftHeight);
	add(new JLabel("Weight :"));
	add(jftWeight);
	add(jbtBMI);
	add(new JLabel("BMI :"));
	add(jftResult);
	
	jbtBMI.addActionListener(new ButtonListener());
	}
		
	
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			
			String n = jftName.getText();
			String a = jftAge.getText();
			double h = Double.parseDouble(jftHeight.getText());
			double w = Double.parseDouble(jftWeight.getText());
			
			if(h >= 100)
				h = h/100;
				
			double bmi = w / (h * h);
			jftResult.setText(String.format("Name : " + n +"\nAge : " + a + "\nBMI : %.2f",bmi));
		}
	}
	
	public static void main(String[] args){
		JFrame frame = new BMI();
		frame.setTitle("BMI");
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
