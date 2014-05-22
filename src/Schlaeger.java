import java.awt.Shape;
import java.awt.geom.Rectangle2D;


public class Schlaeger {

	// Daten des Schlaegers
	int breite = 10;
	int hoehe = 50;
	int x = 20;
	int y = 240;

	// Das Spielfeld, wird an den Schlaeger mit uebergeben
	SpielFeld spielFeld = null;

	/**
	 * Der Konstruktor
	 * @param spielFeld
	 */
	public Schlaeger(SpielFeld spielFeld)
	{
		this.spielFeld = spielFeld;
	}
	
	/**
	 * Erzeugen eines Schlaegers, aus den gegebenen Daten
	 * @return
	 */
	public Shape getSchlaeger()
	{
		// Shape erzeugen, der ein Rechteck beinhaltet
		Shape rect = new Rectangle2D.Double( x, y, breite, hoehe);
		
		return rect; // Shape/Recheck zurueckgeben
	}
	
	/**
	 * Die neue Position des Schlaegers wird berechnet
	 * @param mausPositionY
	 */
	public void updateSchlaeger(int mausPositionY)
	{
		y = mausPositionY - hoehe/2;	// Y-Position des Schlaegers der Y-Position der Maus anpassen
		
		spielFeld.repaint();	// Neu zeichnen des Spielfeldes
	}
}
