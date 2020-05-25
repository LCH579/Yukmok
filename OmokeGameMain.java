package Omoke;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class OmokeGameMain extends JFrame {

    public OmokeGameMain() {
    	setTitle("Do you want to quit?");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel MainContainer = new JPanel(); 

        setContentPane(MainContainer); 
        
        JButton OpenWindow = new JButton("No");
        
        JButton CloseWindow = new JButton("Yes");
        
        OpenWindow.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
               
                new newWindow(); 
                dispose(); 
            }
            
        });
        
        CloseWindow.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) { 
            	System.exit(0); 
            }  
            
        });
        
        MainContainer.add(OpenWindow); 
        
        MainContainer.add(CloseWindow);
        setLocation(330,350);
        setSize(400,70); 
        setResizable(false); 
        setVisible(true);
    }
    





	public static void main(String[] args) { 
			new GUI("Java Programming 13");
			
		}

}

class newWindow extends JFrame {
	private Omoke.MouseEventHandler MEH;
	
    newWindow() {
    	new GUI("exit");
    	MEH.count_click=0;
    }
}

