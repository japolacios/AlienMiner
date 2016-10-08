package enemies;

import processing.core.PApplet;

public class EnemyFive extends Enemy {

	public EnemyFive( int _x, int _y, PApplet _app) {
		super( _x, _y, _app);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setColors() {
		app.stroke(255, 90, 50);
		
	}
	
	public void loadShape(){
		shape =	app.loadShape("assets/enemyFive.svg");		
	}
	
	public void setSpeed(){
		speed = 2;
		power = 1;
	}
	
	

}
