import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Ui {

	private PApplet app;
	private PFont font;
	
	private PImage scene1,gameOn, manual, bg;
	private int scene;
	private int ancho = 0;
	private int health = 100;
	
	Ui(PApplet _app){
		app = _app;
		loadAssets();
		scene = 1;
	}
	
	public void loadAssets(){
	scene1 = app.loadImage("assets/hubMain.png");
	bg = app.loadImage("assets/bg.jpg");
	gameOn = app.loadImage("assets/hub.png");
	font = app.createFont("assets/font.ttf",32);
	app.textFont(font);
	}
	
	public void paintGame(){
		app.image(bg, 0, 0);
		app.image(gameOn, 780, 0);
		app.textSize(20);
		app.text("HEALTH", 950, 300);
		paintHealth();
		app.noFill();
		app.stroke(0,255,0);
		app.strokeWeight(4);
		app.rect(900, 350, 225, 20);
		
	}
	
		public void paintHealth(){
			
			float floatTemp = (health/100f) * 225f;
			
			System.out.println(floatTemp);
			ancho =  (int) floatTemp;
			
			app.fill(0,255,0);
			app.noStroke();
			app.rect(900, 350, ancho, 20);
		}
	public void paintScene1(){
		app.image(bg, 0, 0);
		app.image(scene1, 25, 450);
		app.fill(70,255,20);
		app.textSize(50);
		app.text("Alien Miner", 370, 200);
	}
	
	public void paint(){
		if (scene == 1){
			paintScene1();
		}
		if (scene == 3){
			paintGame();
		}
	}
	
	public void changeScene(int _scene){
		scene = _scene;
	}
	
	public void setUIHealth(int _h){
		health = _h;
	}
}
