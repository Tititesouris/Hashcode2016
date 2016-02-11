package hashcode2016;

import java.util.List;

public class Map {

    int rows;

	int columns;

	Cell[][] map;

    List<Drone> drones;

	public Map(int columns, int rows){
		map = new Cell[columns][rows];
        for(int column = 0; column < columns; column++){
            for(int row = 0; row < rows; row++){
                map[column][row] = new Cell(row, column);
            }
        }
	}

	public Cell getCell(int row, int column){
		return map[column][row];
	}

	public void setCell(int row, int column, Cell cell){
		map[column][row] = cell;
	}

    public List<Drone> getDrones() {
        return drones;
    }

    public void setDrones(List<Drone> drones) {
        this.drones = drones;
    }

    public String toString(){
		String map = "";
		for(int column = 0; column < columns; column++){
			for(int row = 0; row < rows; row++) {
				map += "|" + getCell(row, column).toString();
			}
			map += "|\n";
			for (int a = 0; a < columns; a++){
				map += "---";
			}
			map += "\n";
		}
		return map;
	}
}
