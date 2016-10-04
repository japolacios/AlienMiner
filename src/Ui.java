import processing.core.PApplet;
import processing.core.PImage;

public class Ui {

	private PApplet app;
	
	private PImage scene1,gameOn, manual, bg;
	private int scene;
	
	Ui(PApplet _app){
		app = _app;
		loadAssets();
		scene = 1;
	}
	
	public void loadAssets(){
	scene1 = app.loadImage("assets/hubMain.png");
	bg = app.loadImage("assets/bg.jpg");
	gameOn = app.loadImage("assets/hub.png");
	}
	
	public void paintGame(){
		app.image(bg, 0, 0);
		app.image(gameOn, 780, 0);
	}
	
	public void paintScene1(){
		app.image(bg, 0, 0);
		app.image(scene1, 25, 450);
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
}
