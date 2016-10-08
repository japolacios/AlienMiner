import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import enemies.*;
import processing.core.PApplet;

public class Logica {
	private PApplet app;
	private Ui ui;
	private boolean attack = false;
	private int scene = 1;
	
	//Enemy Array
	private ArrayList<EnemyOne> enemyOne;
	private ArrayList<EnemyTwo> enemyTwo;
	private ArrayList<EnemyThree> enemyThree;
	private ArrayList<EnemyFour> enemyFour;
	private ArrayList<EnemyFive> enemyFive;
	
	//Element Groups
	
	//On Stage
	ArrayList<Element> elementsArray;
	HashSet<Element> elementsHash;
	LinkedList<Element> elementsLinked;
	
	private Player player;
	
	Logica(PApplet _app) {
		app = _app;
		ui = new Ui(app);
		createEnemy();
		createPlayer();
		initializeElements();
	}
	public void paintPlayer(){
		player.pintar();
	}
	
	public void createPlayer(){
		player = new Player(app,600,350);
	}
	
	public void paint(){
		ui.paint();
		
		if (scene == 3){
		paintEnemy();
		paintPlayer();
		giveElements();
		paintElements();
		eatElements();
		checkHealth();
		}
	}
	
	public void clickSceneOne(){
		//app.ellipse(418, 585, 110, 110);
		//app.ellipse(775, 585, 110, 110);
		if(app.dist(418, 585, app.mouseX, app.mouseY)<=110){
			//PlayGame
			ui.changeScene(3);
			scene = 3;
			System.out.println("Play Game");
		}
		if(app.dist(775, 585, app.mouseX, app.mouseY)<=110){
			//Instructions
			System.out.println("Instructions");
			scene = 2;
		}
	}
	
	public void createEnemy(){
		enemyOne = new ArrayList<EnemyOne>();
		enemyTwo = new ArrayList<EnemyTwo>();
		enemyThree = new ArrayList<EnemyThree>();
		enemyFour = new ArrayList<EnemyFour>();
		enemyFive = new ArrayList<EnemyFive>();
		
		EnemyOne temp = new EnemyOne(25, 350,app);
		enemyOne.add(temp);
		
		EnemyTwo temp2 = new EnemyTwo (800,350,app);
		enemyTwo.add(temp2);
		
		EnemyThree temp3 = new EnemyThree (400,25,app);
		enemyThree.add(temp3);
		
		EnemyFour temp4 = new EnemyFour (400,675,app);
		enemyFour.add(temp4);
		
		EnemyFive tempE5 = new EnemyFive (25,25,app);
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
		setAttack();
		if(attack == true){
		
		for (int i = 0; i < enemyOne.size(); i++) {
			enemyOne.get(i).setTrack(player.getX(), player.getY());
			if (app.dist(enemyOne.get(i).getX(), enemyOne.get(i).getY(),player.getX(), player.getY()) <= 20 ){
				//Take Health
				player.imHit(enemyOne.get(i).getDamage());
			}
		}
		for (int i = 0; i < enemyTwo.size(); i++) {
			enemyTwo.get(i).setTrack(player.getX(), player.getY());
			
			if (app.dist(enemyTwo.get(i).getX(), enemyTwo.get(i).getY(),player.getX(), player.getY()) <= 20 ){
				//Take Health
				player.imHit(enemyTwo.get(i).getDamage());
			}
		}
		for (int i = 0; i < enemyThree.size(); i++) {
			enemyThree.get(i).setTrack(player.getX(), player.getY());
			
			if (app.dist(enemyThree.get(i).getX(), enemyThree.get(i).getY(),player.getX(), player.getY()) <= 20 ){
				//Take Health
				player.imHit(enemyThree.get(i).getDamage());
			}
		}
		for (int i = 0; i < enemyFour.size(); i++) {
			enemyFour.get(i).setTrack(player.getX(), player.getY());
			
			if (app.dist(enemyFour.get(i).getX(), enemyFour.get(i).getY(),player.getX(), player.getY()) <= 20 ){
				//Take Health
				player.imHit(enemyFour.get(i).getDamage());
			}
		}
		for (int i = 0; i < enemyFive.size(); i++) {
			enemyFive.get(i).setTrack(player.getX(), player.getY());
			
			if (app.dist(enemyFive.get(i).getX(), enemyFive.get(i).getY(),player.getX(), player.getY()) <= 20 ){
				//Take Health
				player.imHit(enemyFive.get(i).getDamage());
			}
		}
		} else{
			for (int i = 0; i < enemyOne.size(); i++) {
				enemyOne.get(i).setTrack(enemyOne.get(i).getBaseX(), enemyOne.get(i).getBaseY());
			}
			for (int i = 0; i < enemyTwo.size(); i++) {
				enemyTwo.get(i).setTrack(enemyTwo.get(i).getBaseX(), enemyTwo.get(i).getBaseY());
			}
			for (int i = 0; i < enemyThree.size(); i++) {
				enemyThree.get(i).setTrack(enemyThree.get(i).getBaseX(), enemyThree.get(i).getBaseY());
			}
			for (int i = 0; i < enemyFour.size(); i++) {
				enemyFour.get(i).setTrack(enemyFour.get(i).getBaseX(), enemyFour.get(i).getBaseY());
			}
			for (int i = 0; i < enemyFive.size(); i++) {
				enemyFive.get(i).setTrack(enemyFive.get(i).getBaseX(), enemyFive.get(i).getBaseY());
			}
		}
	}
	
	public void initializeElements(){
		elementsArray = new ArrayList<Element>();
		elementsHash = new HashSet<Element>();
		elementsLinked = new LinkedList<Element>();
	}
	
	public void giveElements(){
		int rate =(int) app.random(0, 1000);
		
		if(rate >= 990 && elementsHash.size()< 14 && elementsLinked.size() <= 40 && elementsArray.size() < 5){
			Element elementTemp = new Element(app,(int) app.random(50, 750), (int)app.random(50, 650), (int)app.random(1, 4));
			elementsArray.add(elementTemp);
		}
	}
	
	public void paintElements(){
		//ArrayList
		for (int i = 0; i < elementsArray.size(); i++) {
			elementsArray.get(i).pintar();
		}
		
		//HashSet
		for (Iterator iterator = elementsHash.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			element.pintar();
		}
		
		//Linked
		int xL = 0;
		int yL = 0;
		for (Iterator iterator = elementsLinked.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			if(1000+ xL >= 1150){
				yL = yL + 25;
				xL = 0;
			}
			element.move(1045 + xL, 123 + yL);
			xL = xL + 20;
			element.pintar();
		}
	}

	public void eatElements(){
		for (int i = 0; i < elementsArray.size(); i++) {
			if(app.dist(player.getX(), player.getY(), elementsArray.get(i).getX(), elementsArray.get(i).getY())<= 20 ){
				if(elementsArray.get(i).getType() == 2){
					player.giveHealth();
				}
				elementsArray.get(i).move((int )app.random(850, 980), (int)app.random(120,250));
				elementsHash.add(elementsArray.get(i));
				elementsArray.remove(i);
			}
		}
	}

	public void orderElements(){
		if (elementsHash != null){
			elementsLinked.addAll(elementsHash);
			elementsHash.clear();
			}
		if (elementsLinked != null){
		Collections.sort(elementsLinked);
		}
	}
	
	public void flush(){
		elementsLinked.clear();
	}
	
	public void setAttack(){
		if (elementsHash.isEmpty() && elementsLinked.isEmpty()){
			attack = false;
		} else {
			attack = true;
		}
	}
	
	public  void checkHealth(){
		if(player.getHealth() > 0){
		ui.setUIHealth(player.getHealth());
		//System.out.println("Health: " + player.getHealth());
		}
		if (player.getHealth() <= 0){
			scene = 1;
			ui.changeScene(1);
		}
	}
	
	public void click(){
		if (scene == 1){
		clickSceneOne();
		}
	}
}
