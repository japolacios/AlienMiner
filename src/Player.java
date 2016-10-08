import processing.core.PApplet;

import processing.core.PShape;

public class Player {
	private PApplet app;
	private int x, y, dir, speed;
	private PShape shape;
	private int health = 100;

	private int rotateInt = 0;

	Player(PApplet _app, int _x, int _y) {
		app = _app;
		x = _x;
		y = _y;
		speed = 7;
		getShape();
	}

	public void getShape() {
		shape = app.loadShape("assets/player.svg");
	}

	public void rotateShape() {
		rotateInt = rotateInt + 10;
		if (rotateInt >= 360) {
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
		app.stroke(255);
		app.shape(shape, 0, 0);
		app.popMatrix();

	}

	// -----
	// Moves
	// -----
	public void move() {

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

		int tempNum = (int) app.random(0, 100);

		if (tempNum < 50) {

			if (y > app.mouseY) {
				dir = 1;
			}
			if (y < app.mouseY) {
				dir = 2;
			}
		}
		if (tempNum >= 50) {
			if (x > app.mouseX) {
				dir = 3;
			}
			if (x < app.mouseX) {
				dir = 4;
			}
		}
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public int getHealth(){
		return health;
	}
	
	public void imHit(int _h){
		health = health - _h;
	}
	
	public void giveHealth(){
		health = health + 10;
	}
}
