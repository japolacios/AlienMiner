package enemies;

import processing.core.PApplet;
import processing.core.PShape;

public abstract class Enemy {

	protected int speed;

	protected int x;
	protected int y;
	private int dir;
	protected int power;
	private int baseX;
	private int baseY;
	PApplet app;
	PShape shape;
	protected int rotateInt = 0;
	private int xTrack, yTrack;
	
	// Constructor
	Enemy(int _x, int _y, PApplet _app) {
		x = _x;
		y = _y;
		baseX = x;
		baseY = y;
		app = _app;
		setSpeed();
		loadShape();

	}
	
	public void setColors(){
		
	}
	
	public void rotateShape(){
		rotateInt = rotateInt + 10;
		if(rotateInt >= 360){
			rotateInt = 0;
		}
	}
	
	public void pintar() {
		move();
		app.shapeMode(app.CENTER);
		shape.disableStyle();
		app.noFill();
		app.strokeWeight(0.25f);		
		rotateShape();
		app.pushMatrix();
		app.translate(x, y);
		app.rotate(app.radians(rotateInt));
		setColors();
		app.shape(shape,0,0);
		app.popMatrix();
		
	}

	public void loadShape(){
		
		
	}
	
	public void setSpeed(){
		
	}
	
	// -----
	// Moves
	// -----
	public void move(){		
		setDir();
		moveUp();
		moveDown();
		moveL();
		moveR();
	}
	
	public void moveUp() {
		// Arriba
		if (dir == 1) {
				y = y - speed;	
		}
	}

	public void moveDown() {
		// Abajo
		if (dir == 2) {		
				y = y + speed;			
		}
	}

	public void moveL() {
		// Izquierda
		if (dir == 3) {		
				x = x - speed;
		}
	}

	public void moveR() {
		// Derecha
		if (dir == 4) {	
				x = x + speed;	
		}
	}

	// -----------
	// Gets y Sets
	// -----------
	public void setDir() {
		
		int tempNum = (int) app.random(0,100);
		
		if(tempNum < 50){
		
		if(y>yTrack){
			dir = 1;
		}
		if(y<yTrack){
			dir = 2;
		}
		}
		if(tempNum >= 50){
		if (x>xTrack){
			dir = 3;
		}
		if(x<xTrack){
			dir = 4;
		}
		}
	}

	public int getDir() {

		return dir;
	}

	// Efecto Animacion
	public void setPos() {
		//Rotate
	}

	// Gets

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}


	public void setTrack(int _xt, int _yt) {
		xTrack = _xt;
		yTrack = _yt;
	}


	// Metodo de busqueda y ataque
	

	public int getDamage() {

		return power;
	}
	
	public int getBaseX(){
		return baseX;
	}
	
	public int getBaseY(){
		return baseY;
	}

	// End Clase Abstracta Enemy
}