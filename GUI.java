package Omoke;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUI extends JFrame {
	private Container c;
	MapSize size = new MapSize();
	
	public GUI(String title) {
		super.setTitle(title);
		c= getContentPane();
		setBounds(200,20,650,720);
		final Map map = new Map(size);
		final DrawBorad d = new DrawBorad(size,map);
		setContentPane(d);
		
		JButton newgame = new JButton(new AbstractAction("Delete Save") {
			@Override
			public void actionPerformed(ActionEvent e){
				MouseEventHandler meh1 = new MouseEventHandler(map, size, d, null);
				meh1.newGame();
			}
		});
		
		JButton load = new JButton(new AbstractAction("Load") {
			@Override
			public void actionPerformed(ActionEvent e){
				MouseEventHandler meh2 = new MouseEventHandler(map, size, d, null);
				meh2.loadData();
			}
		});
		
		d.add(newgame);
		newgame.setSize(200, 50);
		newgame.setLocation(20, 616);
		newgame.setVisible(true);
		
		d.add(load);
		load.setSize(200, 50);
		load.setLocation(230, 616);
		load.setVisible(true);
		
		addMouseListener(new MouseEventHandler(map,size,d,this));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void showPopUp(String message) {
		JOptionPane.showMessageDialog(this, message,"",JOptionPane.INFORMATION_MESSAGE);
		new OmokeGameMain();
		//System.exit(0);
	}
}
