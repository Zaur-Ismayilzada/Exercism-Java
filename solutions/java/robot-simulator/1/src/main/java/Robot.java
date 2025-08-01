public class Robot{
	
	private Orientation  ort;
	private GridPosition pos;
	
	public Robot(GridPosition pos, Orientation ort){
		this.ort = ort;
		this.pos = pos;
	}
	
	public Orientation getOrientation(){
		return this.ort;
	}
	
	public GridPosition getGridPosition(){
		return this.pos;
	}
	
	public void turnRight(){
		switch(this.ort){
			case NORTH: this.ort = Orientation.EAST;  break;
			case EAST : this.ort = Orientation.SOUTH; break;
			case SOUTH: this.ort = Orientation.WEST;  break;
			case WEST : this.ort = Orientation.NORTH; break;
		}
	}
	
	public void turnLeft(){
		switch(this.ort){
			case NORTH: this.ort = Orientation.WEST;  break;
			case WEST : this.ort = Orientation.SOUTH; break;
			case SOUTH: this.ort = Orientation.EAST;  break;
			case EAST : this.ort = Orientation.NORTH; break;
		}		
	}
	
	public void advance(){
		switch(this.ort){
			case NORTH: this.pos = new GridPosition(this.pos.x, this.pos.y + 1);  break;
			case SOUTH: this.pos = new GridPosition(this.pos.x, this.pos.y - 1);  break;
			case WEST : this.pos = new GridPosition(this.pos.x - 1, this.pos.y);  break;
			case EAST : this.pos = new GridPosition(this.pos.x + 1, this.pos.y);  break;
		}
	}
	
	public void simulate(String str){
		for (int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			switch(ch){
				case 'A': this.advance();   break;
				case 'L': this.turnLeft();  break;
				case 'R': this.turnRight(); break;
			}
		}
	}
}