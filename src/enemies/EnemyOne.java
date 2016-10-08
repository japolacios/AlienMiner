package enemies;

import processing.core.PApplet;

public class EnemyOne extends Enemy {

	public EnemyOne( int _x, int _y, PApplet _app) {
		super( _x, _y, _app);
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public void setColors() {
		app.stroke(90, 230, 30);
		
	}
	
	public void loadShape(){
		shape =	app.loadShape("assets/enemyOne.svg");		
	}
	
	public void setSpeed(){
		speed = 1;
		power = 2;
	}
}
