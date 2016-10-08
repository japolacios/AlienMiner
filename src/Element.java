import processing.core.PApplet;
import processing.core.PShape;

public class Element implements Comparable {
	
	private PApplet app;
	private int x,y,type, rotateInt;
	private PShape shape;
	private int quality;
	
	Element(PApplet _app, int _x, int _y, int _type){
		app = _app;
		x = _x;
		y = _y;
		type = _type;
		rotateInt = 0;
		loadShape();
	}
	
	public void loadShape(){
		shape =	app.loadShape("assets/element.svg");	
	}
	
	public void selectColor(){
		if(type == 1){
			app.fill(255,0,0);
		}
		if(type == 2){
			app.fill(0,255,0);
		}
		if(type == 3){
			app.fill(0,0,255);
		}
	}
	
	public void pintar(){
		app.shapeMode(app.CENTER);
		shape.disableStyle();
		app.strokeWeight(0);		
		app.pushMatrix();
		app.translate(x, y);
		app.rotate(app.radians(rotateInt));
		rotateShape();
		selectColor();
		app.shape(shape,0,0);
		app.popMatrix();
	}
	
	
	public void rotateShape(){
		rotateInt = rotateInt + 1;
		if(rotateInt >= 360){
			rotateInt = 0;
		}
	}
	
	public void move(int _x, int _y){
		x = _x;
		y = _y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getType(){
		return type;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if (o instanceof Element){
			Element temp = (Element)o;
			return temp.getType() - type;
		} else {
		return 0;
		}
	}
	
	public int hashCode(){
		return type;
	}
	
}
