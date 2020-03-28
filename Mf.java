import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;

class Mf extends JFrame
{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete;

Mf()
{
c=getContentPane();
c.setLayout(null);

/*ImageIcon bg_img=new ImageIcon("C:\\Users\\SHRUSHTI\\Desktop\\bg\\ems1.jpg");
JLabel background =new JLabel(" ",bg_img,JLabel.CENTER);
Image img=bg_img.getImage();

Image t_img=img.getScaledInstance(640,600,Image.SCALE_SMOOTH);
bg_img=new ImageIcon(t_img);
background.setBounds(0,0,640,600);
add(background);*/

btnAdd =new JButton("Add");
btnView =new JButton("View");
btnUpdate =new JButton("Update");
btnDelete =new JButton("Delete");

btnAdd.setBounds(150,150,150,50);
btnView.setBounds(350,150,150,50);
btnUpdate.setBounds(150,250,150,50);
btnDelete.setBounds(350,250,150,50);

 btnAdd.setBackground(Color.BLUE   );
    btnAdd.setForeground(Color.WHITE);
btnAdd.setOpaque(true);

 btnView.setBackground(Color.BLUE   );
    btnView.setForeground(Color.WHITE);
 btnUpdate.setBackground(Color.BLUE   );
    btnUpdate.setForeground(Color.WHITE);
 btnDelete.setBackground(Color.BLUE   );
    btnDelete.setForeground(Color.WHITE);
Font f=new Font("TimesRoman",Font.BOLD,25);


btnAdd.setFont(f);
btnView.setFont(f);
btnUpdate.setFont(f);
btnDelete.setFont(f);

c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);

btnAdd.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){
Af a=new Af();
dispose();
}
});

btnView.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){
Vf v=new Vf();
dispose();
}
});

btnUpdate.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){
Uf u=new Uf();
dispose();
}
});

btnDelete.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){
Df d=new Df();
dispose();
}
});

setSize(640,600);
setTitle("E.M.S");
setBackground(Color.BLACK);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

public static void main(String args[])
{
Mf m=new Mf();
}
}
