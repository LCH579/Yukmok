package Omoke;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;


public class MouseEventHandler extends MouseAdapter{
	
	private Map map;
	private MapSize ms;
	//private winCheck wincheck;
	private DrawBorad d;
	private GUI main;
	public static int count_click=0;
	int[][] position = new int[400][2];
	int count = 0;
	
	public MouseEventHandler(Map m, MapSize ms, DrawBorad d2 , GUI main) {
		map = m;
		this.ms = ms;
		this.d = d2;
		this.main = main;
	}
	public void newGame(){
		String workingDir = System.getProperty("user.dir")+"\\LoadGame.txt";
		try {
			PrintWriter writer = new PrintWriter(workingDir);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void saveData(int x, int y){
		String workingDir = System.getProperty("user.dir")+"\\LoadGame.txt";
		File f = new File(workingDir);
		FileWriter myWriter = null;
		try {
			myWriter = new FileWriter(f,true);
			BufferedWriter writer = new BufferedWriter(myWriter);
			writer.append(x + " " +  y + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadData(){
		count_click = 0;
		BufferedReader reader;
		try {

			reader = new BufferedReader(new FileReader("LoadGame.txt"));
			String line;

			while((line = reader.readLine()) != null){
				String[] splitted = line.split(" ");
				int x = 0;
				int y = 1;

				map.setMap(Integer.parseInt(splitted[y]),Integer.parseInt(splitted[x]));
				count_click++;
				map.changeCheck();
				d.repaint();
				x += 1;
				y += 1;

			}
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void mousePressed(MouseEvent arg0) {
		super.mousePressed(arg0);
		int x = (int) Math.round(arg0.getX() / (double) ms.getCell()) -1;
		int y = (int) Math.round(arg0.getY() / (double) ms.getCell()) -2;
		
		System.out.println("Count of Click: " + count_click);
		
		if(x<0 || x>19 || y<0 || y>19) {
			return ;
		}
		
		for(int i = 0 ; i < count ; i++) {
			if(position[i][0]==x && position[i][1]==y)
				return ;
		}
		position[count][0] = x;
		position[count][1] = y;
		count++;
		
		System.out.println(x+" "+y);
		count_click ++;
		saveData(x,y);
		map.setMap(y, x);
		map.changeCheck();
		d.repaint();
		
		if(map.winCheck(x, y)) {
			if(map.getCheck()==true) {
				main.showPopUp("White win!");
			}
			else {
				(main).showPopUp("Black win!");
			}
		}
	}

}
