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
	public Cell getCell(int x,int y){
		return map[x][y];
	}
	public void setCell(int x,int y,Cell c){
		map[x][y] = c;
	}
	
	public String toString(){
		String ret = "";
		for(int i = 0; i < length; i++){
			for(int j = 0; j < width ; j++){
				ret+="|"this.getCell(i, j).toString();		
			}
			ret+="|\n";
			for (int a = 0 ; a < length; a++){
				ret+="---";
			}
			ret+="\n";
		}
		return ret;
	}
}
