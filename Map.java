package Omoke;


public class Map{

	private short[][] map; //���� �迭 1�� �� ��, -1�� �� ��, 0�� �� ���� �ȳ�����

	private final short BLACK=1; 

	private final short WHITE=-1;

	private boolean checkBNW=true; //������ ������ Ȯ��
	
	private Omoke.MouseEventHandler MEH;

	

	public Map(MapSize ms){

		// TODO Auto-generated constructor stub

		//�迭 �ʱ�ȭ

		map=new short[ms.getSize()][];

		for(int i=0;i<map.length;i++)

			map[i]=new short[ms.getSize()];



	}

	public short getBlack() {

		return BLACK;

	}

	public short getWhite() {

		return WHITE;

	}

	public short getXY(int y,int x) {

		return map[y][x];

	}

	public boolean getCheck() {

		return checkBNW;

	}

	public void changeCheck() {

		if(MEH.count_click==1) {

			checkBNW=false;
		}

		else {
			for(int n =1 ; n <= 100; n++) {
				if (MEH.count_click == (4*n)-2 || MEH.count_click == (4*n)-3) {
					checkBNW = false;
				}
				
				else if (MEH.count_click == (4*n)-1 || MEH.count_click == 4*n) {
					checkBNW = true;
				}
				
			}
		
		}

	}
	
/*	
	public void changeCheck() {
		boolean pcheck;
		if(checkBNW) {
			pcheck = checkBNW;
			checkBNW = false;
				if(checkBNW)
		}

	}
**/
	public void setMap(int y,int x) {

		//checkBNW�� Ȯ���� true�� �� map�� BLACK, false�� �� WHITE����

		if(checkBNW)

			map[y][x]=BLACK;

		else

			map[y][x]=WHITE;

	}

	

	//�¸�Ȯ��

	

	public boolean winCheck(int x,int y){

		if(winCheckL(x, y)||winCheckLD(x, y)||winCheckLU(x, y)||winCheckR(x, y)

		||winCheckRD(x, y)||winCheckRU(x, y)||winCheckUp(x, y)||winCheckDown(x, y)

		||winCheckOneDown(x, y)||winCheckOneL(x, y)||winCheckOneLD(x, y)||winCheckOneLU(x, y)

		||winCheckOneR(x, y)||winCheckOneRD(x, y)||winCheckOneUp(x, y)||winCheckOneRU(x, y)

		||winCheckCenterLU(x, y)||winCheckCenterRL(x, y)||winCheckCenterRU(x, y)||winCheckCenterUD(x, y))

			return true;

		else

			return false;

	}

	

	

	//����

	public boolean winCheckUp(int x,int y) {

		try{

			for(int i=y;i<y+6;i++){

				if(map[y][x]!=map[i][x])

					return false;

			}	

		}catch(ArrayIndexOutOfBoundsException e){

			return false;

		}

		

		return true;

	}

	//�Ʒ���

	public boolean winCheckDown(int x,int y) {

		try {

			for(int i=y;i>y-6;i--){

				if(map[y][x]!=map[i][x])

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

	//������ �� �밢��

	public boolean winCheckRU(int x,int y) {

		try {

			for(int i=y, z=x;i>y-6;i--,z++){

				if(map[y][x]!=map[i][z])

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

	

	//���� �� �밢��

	public boolean winCheckLU(int x,int y) {

		try {

			for(int i=y, z=x;i>y-6;i--,z--){

				if(map[y][x]!=map[i][z])

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

	

	//������

	public boolean winCheckR(int x,int y) {

		try {

			for(int z=x;z<x+6;z++){

				if(map[y][x]!=map[y][z])

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

	

	//����

	public boolean winCheckL(int x,int y) {

		try {

			for(int z=x;z>x-6;z--){

				if(map[y][x]!=map[y][z])

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

	

	//������ �Ʒ� �밢��

	public boolean winCheckRD(int x,int y) {

		try {

			for(int i=y, z=x;i<y+6;i++,z++){

				if(map[y][x]!=map[i][z]||i>19||z>19||i<0||z<0)

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

	

	//���� �Ʒ� �밢��

	public boolean winCheckLD(int x,int y) {

		try {

			for(int i=y, z=x;i<y+6;i++,z--){

				if(map[y][x]!=map[i][z])

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

	//��ĭ ����

	public boolean winCheckOneUp(int x,int y) {

		try{

			for(int i=y-1;i<y+5;i++){

				if(map[y][x]!=map[i][x])

					return false;

			}	

		}catch(ArrayIndexOutOfBoundsException e){

			return false;

		}

		

		return true;

	}

	//��ĭ �Ʒ���

	public boolean winCheckOneDown(int x,int y) {

		try {

			for(int i=y+1;i>y-5;i--){

				if(map[y][x]!=map[i][x])

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

	//��ĭ ������ �� �밢��

	public boolean winCheckOneRU(int x,int y) {

		try {

			for(int i=y+1, z=x-1;i>y-5;i--,z++){

				if(map[y][x]!=map[i][z])

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

	

	//��ĭ ���� �� �밢��

	public boolean winCheckOneLU(int x,int y) {

		try {

			for(int i=y+1, z=x+1;i>y-5;i--,z--){

				if(map[y][x]!=map[i][z])

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

	

	//��ĭ ������

	public boolean winCheckOneR(int x,int y) {

		try {

			for(int z=x-1;z<x+5;z++){

				if(map[y][x]!=map[y][z])

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

	

	//��ĭ ����

	public boolean winCheckOneL(int x,int y) {

		try {

			for(int z=x+1;z>x-5;z--){

				if(map[y][x]!=map[y][z])

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

	

	//��ĭ ������ �Ʒ� �밢��

	public boolean winCheckOneRD(int x,int y) {

		try {

			for(int i=y-1, z=x-1;i<y+5;i++,z++){

				if(map[y][x]!=map[i][z]||i>19||z>19||i<0||z<0)

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

	

	//��ĭ ���� �Ʒ� �밢��

	public boolean winCheckOneLD(int x,int y) {

		try {

			for(int i=y-1, z=x+1;i<y+5;i++,z--){

				if(map[y][x]!=map[i][z])

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

	//���� ���ٿ�

	public boolean winCheckCenterUD(int x,int y) {

		try{

			for(int i=y-2;i<y+4;i++){

				if(map[y][x]!=map[i][x])

					return false;

			}	

		}catch(ArrayIndexOutOfBoundsException e){

			return false;

		}

		

		return true;

	}

	//���� ����Ʈ ����Ʈ

	public boolean winCheckCenterRL(int x,int y) {

		try {

			for(int z=x-2;z<x+4;z++){

				if(map[y][x]!=map[y][z])

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

	//���� ����Ʈ �밢��

	public boolean winCheckCenterRU(int x,int y) {

		try {

			for(int i=y+2, z=x-2;i>y-4;i--,z++){

				if(map[y][x]!=map[i][z])

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

	//���� ����Ʈ �밢��

	public boolean winCheckCenterLU(int x,int y) {

		try {

			for(int i=y+2, z=x+2;i>y-5;i--,z--){

				if(map[y][x]!=map[i][z])

					return false;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			// TODO: handle exception

			return false;

		}

		

		return true;

	}

}
