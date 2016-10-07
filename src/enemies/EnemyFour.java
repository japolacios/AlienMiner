package enemies;

import processing.core.PApplet;

public class EnemyFour extends Enemy {

	public EnemyFour( int _x, int _y, PApplet _app) {
		super( _x, _y, _app);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setColors() {
		app.stroke(255, 0, 255);
		
	}
	
	public void loadShape(){
		shape =	app.loadShape("assets/enemyFour.svg");		
	}
	
	public void setSpeed(){
		speed = 2;
	}
	
	

}
