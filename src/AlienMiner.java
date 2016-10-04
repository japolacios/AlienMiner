import processing.core.PApplet;

public class AlienMiner extends PApplet {

	Logica logica;
	
	@Override
	public void settings() {

		// Set Size
		int alto = 700;
		int ancho = 1200;

		size(ancho, alto);

		System.out.println("Canvas Size " + ancho + "x" + alto);
	}

	@Override
	public void setup() {
		
		System.out.println("Initializing Logic");
		logica = new Logica(this);

		// Check Logic its Live
		if (logica != null) {
			System.err.println("Logic Runing");
		}

	}

	@Override
	public void draw() {
		// Set Background White
		background(255, 255, 255);
		logica.paint();

	}

	// Program Runner
	public static void main(String[] args) {
		PApplet.main("AlienMiner");
	}

	// ------------------------------
	// Mouse Eventes
	// ------------------------------

	public void mousePressed() {
	
	}

	@Override
	public void mouseReleased() {
		
	}

	@Override
	public void mouseDragged() {
		
	}

	@Override
	public void mouseClicked() {
		logica.click();
	}
	// End Class
}
