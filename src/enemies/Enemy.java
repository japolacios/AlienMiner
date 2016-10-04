package enemies;

import processing.core.PApplet;
import processing.core.PShape;

public abstract class Enemy {

	private int speed;

	private int x;
	private int y;
	private int dir;
	private int posP = 0;
	private int power;
	private int baseX;
	private int baseY;
	private int xTemp, yTemp;
	PApplet app;
	int type;
	PShape shape;
	
	// Constructor
	Enemy(int _speed, int _x, int _y, int _base, int _power, PApplet _app, int _type) {
		x = _x;
		y = _y;
		speed = _speed;
		power = _power;
		baseX = x;
		baseY = y;
		app = _app;
		type = _type;
		
		loadShape();

	}

	public void pintar() {
		move();
		app.shape(shape,x,y);
	}
   //Type 1 = red
	//type 2 = blue
	//type 3 = yellow
	//type 4 = purple
	//type 5 = green
	public void loadShape(){
		if(type == 1){
		shape =	app.loadShape("assets/enemyFive.svg");
		}
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
		if(y>app.mouseY){
			dir = 1;
		}
		if(y<app.mouseY){
			dir = 2;
		}
		if (x>app.mouseX){
			dir = 3;
		}
		if(x<app.mouseX){
			dir = 4;
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


	public void setXY(int rx1, int ry1) {
		x = rx1;
		y = ry1;
	}


	// Metodo de busqueda y ataque
	

	public int getDamage() {

		return power;
	}

	// End Clase Abstracta Enemy
}