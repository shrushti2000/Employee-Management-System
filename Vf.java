import javax.swing.*;
import java.awt.*;
//import java.util.ArrayList;
//import java.awt.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class Vf extends JFrame
{
Container c;
TextArea ta;
JButton btnBack;


Vf()
{
c=getContentPane();
c.setLayout(null);
ta=new TextArea(5,30);
 JScrollPane sp = new JScrollPane(ta);
btnBack=new JButton("Back");

/*ImageIcon bg_img=new ImageIcon("C:\\Users\\SHRUSHTI\\Desktop\\bg\\ems1.jpg");
JLabel background =new JLabel(" ",bg_img,JLabel.CENTER);
Image img=bg_img.getImage();

Image t_img=img.getScaledInstance(600,600,Image.SCALE_SMOOTH);
bg_img=new ImageIcon(t_img);
background.setBounds(0,0,600,600);
add(background);*/


ta.setBounds(150,100,300,200);
btnBack.setBounds(250,350,100,50);

Font f=new Font("TimesRoman",Font.BOLD,30);
btnBack.setFont(f);
ta.setFont(f);



c.add(ta);
c.add(btnBack);

Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact=cfg.buildSessionFactory();

Session session=sfact.openSession();

try{
//System.out.println("begin");
//CRUD operations

java.util.List<Employee> stu=new ArrayList<>();
stu=session.createQuery("from Employee").list();
for(Employee s:stu)
	ta.append(s.getId()+"  "+s.getName()+"  "+s.getSalary()+" " +"\n");
//System.out.println("end");
}
catch(Exception e){
System.out.println(e); }
finally{
session.close();
} 



btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
Mf m=new Mf();
dispose();
}
});

setSize(600,600);
setTitle("View Employee");
setBackground(Color.red);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}







