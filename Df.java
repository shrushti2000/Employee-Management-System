import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class Df extends JFrame
{
Container c;
JLabel lblId;
JButton btnSave,btnBack;
JTextField txt1;
int id;

Df()
{
c=getContentPane();
c.setLayout(null);

lblId=new JLabel("Id :");
txt1=new JTextField();
btnSave=new JButton("Save");
btnBack=new JButton("Back");

/*ImageIcon bg_img=new ImageIcon("C:\\Users\\SHRUSHTI\\Desktop\\bg\\ems1.jpg");
JLabel background =new JLabel(" ",bg_img,JLabel.CENTER);
Image img=bg_img.getImage();

Image t_img=img.getScaledInstance(600,600,Image.SCALE_SMOOTH);
bg_img=new ImageIcon(t_img);
background.setBounds(0,0,600,600);
add(background);*/

lblId.setBounds(200,100,100,30);
txt1.setBounds(300,100,150,50);

btnSave.setBounds(150,250,100,50);
btnBack.setBounds(300,250,100,50);

Font f=new Font("TimesRoman",Font.BOLD,30);
lblId.setForeground(Color.black);
lblId.setFont(f);
txt1.setFont(f);


btnSave.setFont(f);
btnBack.setFont(f);

c.add(lblId);
c.add(txt1);

c.add(btnSave);
c.add(btnBack);

btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){
Mf m=new Mf();
dispose();
}
});

btnSave.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact=cfg.buildSessionFactory();

Session session=sfact.openSession();

Transaction t=null;
try{
t=session.beginTransaction();

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


Employee s=(Employee)session.get(Employee.class,id);
if(s!=null) {
	session.delete(s);
	t.commit();
	JOptionPane.showMessageDialog(new JDialog(),"record deleted!");
	txt1.setText("");

	txt1.requestFocus();

	}
else
{
JOptionPane.showMessageDialog(new JDialog(),"record does not exists!");
txt1.setText("");
txt1.requestFocus();
//System.out.println("end");
}

}
catch(Exception e){
	t.rollback();
JOptionPane.showMessageDialog(new JDialog(),"Some error!");
 }
finally{
session.close();
}
}
}
);





setSize(600,600);
setTitle("Delete Employee");
setBackground(Color.red);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}







