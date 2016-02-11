package hashcode2016;

public class Map {
	
	int columns;
	int rows;
	Cell[][] map;

	public Map(int columns, int rows){
		map = new Cell[columns][rows];
		
	}
	//initialiser la map a vide
	void initiMap() {
		for(int i = 0; i < columns; i++){
			for(int j = 0; j < rows; j++){
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
		for(int i = 0; i < columns; i++){
			for(int j = 0; j < rows; j++){
				ret+="|" + this.getCell(i, j).toString();
			}
			ret+="|\n";
			for (int a = 0; a < columns; a++){
				ret+="---";
			}
			ret+="\n";
		}
		return ret;
	}
}
