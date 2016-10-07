package enemies;

import processing.core.PApplet;

public class EnemyThree extends Enemy {

	public EnemyThree( int _x, int _y, PApplet _app) {
		super( _x, _y, _app);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setColors() {
		app.stroke(0, 0, 240);
		
	}
	
	public void loadShape(){
		shape =	app.loadShape("assets/enemyThree.svg");		
	}
	
	public void setSpeed(){
		speed = 4;
	}
	
	

}
