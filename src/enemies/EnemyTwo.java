package enemies;

import processing.core.PApplet;

public class EnemyTwo extends Enemy {

	public EnemyTwo( int _x, int _y, PApplet _app) {
		super( _x, _y, _app);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setColors() {
		app.stroke(255, 255, 30);
		
	}
	
	public void loadShape(){
		shape =	app.loadShape("assets/enemyTwo.svg");		
	}
	
	public void setSpeed(){
		speed = 2;
	}
	
	

}
