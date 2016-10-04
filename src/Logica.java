import java.util.ArrayList;

import enemies.*;
import processing.core.PApplet;

public class Logica {
	private PApplet app;
	private Ui ui;
	private ArrayList<EnemyOne> enemyOne;
	
	Logica(PApplet _app) {
		app = _app;
		ui = new Ui(app);
		createEnemy();
	}
	
	public void paint(){
		ui.paint();
		paintEnemy();
	}
	
	public void clickSceneOne(){
		//app.ellipse(418, 585, 110, 110);
		//app.ellipse(775, 585, 110, 110);
		if(app.dist(418, 585, app.mouseX, app.mouseY)<=110){
			//PlayGame
			ui.changeScene(3);
			System.out.println("Play Game");
		}
		if(app.dist(775, 585, app.mouseX, app.mouseY)<=110){
			//Instructions
			System.out.println("Instructions");
		}
	}
	
	public void createEnemy(){
		enemyOne = new ArrayList<EnemyOne>();
		EnemyOne temp = new EnemyOne(1, 600, 350, 11, 1, app, 1);
		enemyOne.add(temp);
	}
	
	public void paintEnemy(){
		for (int i = 0; i < enemyOne.size(); i++) {
			enemyOne.get(i).pintar();
		}
	}
	
	public void click(){
		clickSceneOne();
	}
}
