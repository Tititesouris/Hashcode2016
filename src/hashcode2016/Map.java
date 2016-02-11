package hashcode2016;

public class Map {
	
	int length;
	int width;
	Cell[][] map;
	public Map(int length,int width){
		map = new Cell[length][width];
		
		
	}
	//initialiser la map a vide
	void initiMap(){
		for(int i = 0; i < length; i++){
			for(int j = 0; j < width ; j++){
				map[i][j] = new Cell(i, j);				
			}
		}
	}
}
