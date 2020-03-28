import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;

class Af extends JFrame
{
Container c;
JLabel lblId,lblName,lblSal;
JButton btnSave,btnBack;
JTextField txt1,txt2,txt3;
int id;
double salary;
String name;
int flag=0;


Af()
{
c=getContentPane();
//c.setSize(600,600);
c.setLayout(null);
//JLabel background;
/*ImageIcon bg_img=new ImageIcon("C:\\Users\\SHRUSHTI\\Desktop\\bg\\ems1.jpg");
JLabel background =new JLabel(" ",bg_img,JLabel.CENTER);
Image img=bg_img.getImage();

Image t_img=img.getScaledInstance(640,600,Image.SCALE_SMOOTH);
bg_img=new ImageIcon(t_img);
background.setBounds(0,0,640,600);
add(background);*/

lblId=new JLabel("Id :");
lblName=new JLabel("Name :");
lblSal=new JLabel("Salary :");
txt1=new JTextField();
txt2=new JTextField();
txt3=new JTextField();
btnSave=new JButton("Save");
btnBack=new JButton("Back");

lblId.setBounds(150,100,100,30);
txt1.setBounds(300,100,150,50);
lblName.setBounds(150,200,100,30);
txt2.setBounds(300,200,150,50);
lblSal.setBounds(150,300,100,30);
txt3.setBounds(300,300,150,50);
btnSave.setBounds(150,400,100,50);
btnBack.setBounds(300,400,100,50);


    lblId.setBackground(Color.green);

Font f=new Font("TimesRoman",Font.BOLD,25);
//lblId.setBackground(Color.green);
lblId.setFont(f);

lblName.setFont(f);
lblSal.setFont(f);
btnSave.setFont(f);
btnBack.setFont(f);
txt1.setFont(f);
txt2.setFont(f);
txt3.setFont(f);

c.add(lblId);
c.add(txt1);
c.add(lblName);
c.add(txt2);
c.add(lblSal);
c.add(txt3);
c.add(btnSave);
c.add(btnBack);


btnSave.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){

Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact=cfg.buildSessionFactory();

Session session=sfact.openSession();
	
Transaction t=null;
try
{
t=session.beginTransaction();
Employee s=new Employee();

try{
id=Integer.parseInt(txt1.getText());
if (id<0)
	throw new IllegalAccessException();
}
catch(NumberFormatException nfe){
JOptionPane.showMessageDialog(new JDialog(),"Please Enter Valid Employee ID");
txt1.setText("");
txt1.requestFocus();
return;
}
catch(IllegalAccessException iae){
JOptionPane.showMessageDialog(new JDialog(),"ID should be greater than 0");
txt1.setText("");
txt1.requestFocus();
return;
}

try{
name=txt2.getText();
if(name.matches(".*\\d+.*"))
	throw new NullPointerException();
if (name.length()<2)
	throw new IllegalAccessException();
}
catch(NullPointerException npe){
JOptionPane.showMessageDialog(new JDialog(),"Name should have only alphabets");
txt2.setText("");
txt2.requestFocus();
return;
}
catch(IllegalAccessException iae){
JOptionPane.showMessageDialog(new JDialog(),"Name should have atleast two charachters");
txt2.setText("");
txt2.requestFocus();
return;
}
try{
salary=Double.parseDouble(txt3.getText());
if(salary<8000)
	throw new NullPointerException();
}
catch(NumberFormatException nfe){
JOptionPane.showMessageDialog(new JDialog(),"Please enter valid salary!");
txt3.setText("");
txt3.requestFocus();
return;
}
catch(NullPointerException npe){
JOptionPane.showMessageDialog(new JDialog(),"Minimum salary should be 8000!");
txt3.setText("");
txt3.requestFocus();
return;
}


s.setId(id);			  
s.setName(name);
s.setSalary(salary);
session.save(s);
t.commit();
JOptionPane.showMessageDialog(new JDialog(),"Record inserted");
txt1.setText("");
txt2.setText("");
txt3.setText("");
txt1.requestFocus();
}
catch(org.hibernate.exception.ConstraintViolationException cve){
JOptionPane.showMessageDialog(new JDialog(),"Record already exists ! Use different Id");
txt1.setText("");
txt1.requestFocus();
}
catch(Exception e){
t.rollback();
JOptionPane.showMessageDialog(new JDialog(),"Error :" +e);
}
//System.out.println(e); 
finally{
session.close();
}
}
}
);

btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){
Mf m=new Mf();
dispose();
}
});




setSize(600,600);
setTitle("Add Employee");
setBackground(Color.red);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}







