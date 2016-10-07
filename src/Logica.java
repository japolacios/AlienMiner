import java.util.ArrayList;

import enemies.*;
import processing.core.PApplet;

public class Logica {
	private PApplet app;
	private Ui ui;
	
	//Enemy Array
	private ArrayList<EnemyOne> enemyOne;
	private ArrayList<EnemyTwo> enemyTwo;
	private ArrayList<EnemyThree> enemyThree;
	private ArrayList<EnemyFour> enemyFour;
	private ArrayList<EnemyFive> enemyFive;
	private Player player;
	
	Logica(PApplet _app) {
		app = _app;
		ui = new Ui(app);
		createEnemy();
		createPlayer();
	}
	public void paintPlayer(){
		player.pintar();
	}
	
	public void createPlayer(){
		player = new Player(app,600,350);
	}
	
	public void paint(){
		ui.paint();
		paintEnemy();
		paintPlayer();
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
		enemyTwo = new ArrayList<EnemyTwo>();
		enemyThree = new ArrayList<EnemyThree>();
		enemyFour = new ArrayList<EnemyFour>();
		enemyFive = new ArrayList<EnemyFive>();
		
		EnemyOne temp = new EnemyOne(600, 350,app);
		enemyOne.add(temp);
		
		EnemyTwo temp2 = new EnemyTwo (700,200,app);
		enemyTwo.add(temp2);
		
		EnemyThree temp3 = new EnemyThree (900,500,app);
		enemyThree.add(temp3);
		
		EnemyFour temp4 = new EnemyFour (300,100,app);
		enemyFour.add(temp4);
		
		EnemyFive tempE5 = new EnemyFive (200,200,app);
		enemyFive.add(tempE5);
	}
	
	public void paintEnemy(){
		enemyTrack();
		for (int i = 0; i < enemyOne.size(); i++) {
			enemyOne.get(i).pintar();
		}
		for (int i = 0; i < enemyTwo.size(); i++) {
			enemyTwo.get(i).pintar();
		}
		for (int i = 0; i < enemyThree.size(); i++) {
			enemyThree.get(i).pintar();
		}
		for (int i = 0; i < enemyFour.size(); i++) {
			enemyFour.get(i).pintar();
		}
		for (int i = 0; i < enemyFive.size(); i++) {
			enemyFive.get(i).pintar();
		}
	}
	
	public void enemyTrack(){
		for (int i = 0; i < enemyOne.size(); i++) {
			enemyOne.get(i).setTrack(player.getX(), player.getY());
		}
		for (int i = 0; i < enemyTwo.size(); i++) {
			enemyTwo.get(i).setTrack(player.getX(), player.getY());
		}
		for (int i = 0; i < enemyThree.size(); i++) {
			enemyThree.get(i).setTrack(player.getX(), player.getY());
		}
		for (int i = 0; i < enemyFour.size(); i++) {
			enemyFour.get(i).setTrack(player.getX(), player.getY());
		}
		for (int i = 0; i < enemyFive.size(); i++) {
			enemyFive.get(i).setTrack(player.getX(), player.getY());
		}
	}
	
	public void click(){
		clickSceneOne();
	}
}
