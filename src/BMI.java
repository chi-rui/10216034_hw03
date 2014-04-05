import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;


public class BMI extends JFrame{
	//
	JTextField jftName = new JTextField(8);
	JTextField jftAge = new JTextField(8);
	JTextField jftHeight = new JTextField(8);
	JTextField jftWeight = new JTextField(8);
	JTextField jftResult = new JTextField(15);
	JButton jbtBMI = new JButton("­pºâBMI");
	
	public BMI(){
	
	JPanel p1 = new JPanel(new GridLayout(5, 2));
	
	p1.add(new JLabel("Name :"));
	p1.add(jftName);
	p1.add(new JLabel("Age :"));
	p1.add(jftAge);
	p1.add(new JLabel("Height :"));
	p1.add(jftHeight);
	p1.add(new JLabel("Weight :"));
	p1.add(jftWeight);
	p1.add(new JLabel("        "));
	p1.add(jbtBMI);
	p1.setBorder(new TitledBorder("Enter your name, age, height and weight.\n"));
	
	JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	p2.add(jftResult);
	
	add(p1, BorderLayout.CENTER);
	add(p2, BorderLayout.SOUTH);
		
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
			jftResult.setText(String.format("Your BMI : %.2f",bmi));
		}
	}
	
	
	public static void main(String[] args){
		JFrame frame = new BMI();
		frame.setTitle("BMI");
		frame.setSize(300, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
