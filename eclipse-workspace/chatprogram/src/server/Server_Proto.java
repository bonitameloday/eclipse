package server;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Server_Proto extends JFrame implements ActionListener{
   private JFrame frame;
   private JTextField port_tf;
   JTextArea textArea; //11-13
   JButton stop_btn; //11-13
   JButton start_btn; //11-13
   
   public Server_Proto() {
      init_GUI();
      connectListener(); //11-13
   }

   void connectListener() { //11-13
	   start_btn.addActionListener(this);
	   stop_btn.addActionListener(this);
   }
   public void init_GUI() {

      setBounds(100, 100, 330, 365);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getContentPane().setLayout(null);

      textArea = new JTextArea(); //11-13
      textArea.setBounds(22, 18, 272, 191);
      getContentPane().add(textArea);

      JLabel lblNewLabel = new JLabel("Port No");
      lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
      lblNewLabel.setBounds(22, 240, 71, 23);
      getContentPane().add(lblNewLabel);

      port_tf = new JTextField();
      port_tf.setBounds(96, 237, 198, 26);
      getContentPane().add(port_tf);
      port_tf.setColumns(10);

      stop_btn = new JButton("Stop button"); //11-13
      stop_btn.setFont(new Font("굴림", Font.PLAIN, 15));
      stop_btn.setBounds(164, 287, 130, 26);
      getContentPane().add(stop_btn);

      start_btn = new JButton("Start button"); //11-13
      start_btn.setFont(new Font("굴림", Font.PLAIN, 15));
      start_btn.setBounds(22, 287, 130, 26);
      getContentPane().add(start_btn);
      setVisible(true);
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new Server_Proto();

   }

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==start_btn) {
		System.out.println("start button clicked");
	} else if(e.getSource()==stop_btn) {
		System.out.println("stop button clicked");
		
	}
	
}

}