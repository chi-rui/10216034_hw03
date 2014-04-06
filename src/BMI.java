import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;


public class BMI extends JFrame{
	
	JTextField jftName = new JTextField(8);
	JTextField jftAge = new JTextField(8);
	JTextField jftHeight = new JTextField(8);
	JTextField jftWeight = new JTextField(8);
	JTextField jftResult = new JTextField(15);
	JButton jbtBMI = new JButton("≠p∫‚BMI");
	
	public BMI(){
	
	// First compose.
	JPanel p1 = new JPanel(new GridLayout(5, 2));
	
	//new buttons and labels.
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
	
	// Second compose.
	JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	p2.add(jftResult);
	
	add(p1, BorderLayout.CENTER);
	add(p2, BorderLayout.SOUTH);
		
	jbtBMI.addActionListener(new ButtonListener());
	}
		
	// make button useful.
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			// get the information users import.
			String n = jftName.getText();
			int a =  Integer.parseInt(jftHeight.getText());
			double h = Double.parseDouble(jftHeight.getText());
			double w = Double.parseDouble(jftWeight.getText());
			
			MathBMI ans = new MathBMI(n, a, h, w);
			
			// compute BMI.	
			double bmi = ans.getBMI();
			// put out the result.
			jftResult.setText(String.format("Your BMI : %.2f",bmi));
		}
	}
	
	/** main method */
	public static void main(String[] args){
		JFrame frame = new BMI();
		frame.setTitle("BMI");
		frame.setSize(300, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class MathBMI{
	  private String name;
	  private int age;
	  private double weight;// in pound
	  private double height;// in inches
	  public static final double KILOGRAMS_PER_POUND = 0.45359237;
	  public static final double METERS_PER_INCH = 0.0254;
	  
	  public MathBMI(String name , int age , double weight, double height){
		this.name = name;
		this.age  = age;
		this.weight = weight;
		this.height = height;
	  }
	  
	  public MathBMI(String name , double weight , double height){
		this(name , 20 , weight , height);  
	  }
	  
	  public double getBMI(){
		double bmi = weight * KILOGRAMS_PER_POUND / ((height * METERS_PER_INCH) * (height * METERS_PER_INCH));
		return Math.round(bmi * 100)/100.0;
	  }
	  
	  public String getStatus(){
		double bmi = getBMI();
		if(bmi < 18.5)
			return "Underweght";
		else if (bmi<25)
			return "Normal";
		else if (bmi < 30)
			return "Overweight";
		else
			return "Obese";
		
	  }
	  
	  public String getName(){
		return name;
	  }
	  
	  public int getAge(){
	   return age;
	  }

	  public double getWeight(){
	   return weight;
	  }
	  
	  public double getHeight(){
	   return height;
	  }
	  
	}