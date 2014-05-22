import java.awt.Shape;
import java.awt.geom.Arc2D;

import javax.swing.JOptionPane;

/**
 * all-Klasse, fuer Ballkoordinaten- und bewegung zustaendig
 */
public class Ball extends Thread
{
	// Das Spielfeld, wird an den Ball mit uebergeben
	SpielFeld spielFeld = null;

	// Daten der Kugel (Groesse & Position)
	int kugelDurchm = 10;
	int x = 30;
	int y = 20;

	int richtungX = 1;	// Kontrollvariable fuer das Abprallverhalten in X-Richtung
	int richtungY = 1;	// Kontrollvariable fuer das Abprallverhalten in Y-Richtung
	
	/**
	 * Der Konstruktor
	 * @param spielFeld
	 */
	public Ball(SpielFeld spielFeld)
	{
		this.spielFeld = spielFeld;
	}
	
	/**
	 * Erzeugen eines Balls, aus den gegebenen Daten
	 * @return
	 */
	public Shape getBall()
	{
		int startwinkel = 0;	// Startwinkel des Arc-Objekts
		int endwinkel = 360;	// Endwinkel des Arc-Objekts, somit wird ein vollstaendiger Kreis gezeichnet
		
		// Shape erzeugen, der einen Kreis beinhaltet
		Shape arc = new Arc2D.Double( x, y, kugelDurchm, kugelDurchm, startwinkel, endwinkel, Arc2D.OPEN );
		
		return arc;	// Shape/Kreis zurueckgeben
	}
	
	@Override
	public void run()
	{
		// Eine Wartesekunde einlegen, bevor sich der Ball bewegt
		try 
		{
			sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		while(!isInterrupted())
		{
			// Spiel beenden, wenn der Ball die linke Wand beruehrt
			if( x <= 0 )
			{
				JOptionPane.showMessageDialog(null, "Leider verloren!");
				
				System.exit(0);
			}
			
			// X-Richtung des Balls aendern, wenn er den Schlaeger beruehrt
			if( x <= (spielFeld.schlaeger.x + spielFeld.schlaeger.breite) )	// Beruehrt der Ball links bzw. rechts den Schlaeger? ...
			{	// ... wenn ja ...
				if( (y+kugelDurchm) >= spielFeld.schlaeger.y && y <= (spielFeld.schlaeger.y+spielFeld.schlaeger.hoehe) )	// ... befindet sich der Ball zwischen Ober- und Unterseite des Schlaegers? ...
					richtungX = 1;	// ... wenn ja, aendere Richtung
			}
			
			// Testen, ob Ball rechte Wand beruehrt, wenn ja, Richtung aendern
			if( (x+kugelDurchm) >= spielFeld.getWidth() )
				richtungX = -1;
			
			// Testen, ob Ball obere Wand beruehrt, wenn ja, Richtung aendern
			if( y <= 0 )
				richtungY = 1;
			
			// Testen, ob Ball untere Wand beruehrt, wenn ja, Richtung aendern
			if( (y+kugelDurchm) >= spielFeld.getHeight() ) 
				richtungY = -1;
			
			// X-Position des Balls um 1px aendern
			if(richtungX == 1)
				x = x + 1;	// Aenderung nach rechts
			else
				x = x - 1;	// Aenderung nach links
			
			if(richtungY == 1)
				y = y + 1;	// Aenderung nach unten
			else
				y = y - 1;	// Aenderung nach oben
			
			spielFeld.repaint();	// Spielfeld neu zeichnen
			
			// 10ms warten, dann neue Berechnung der Ballkoordinaten. Beeinflusst die Ballgeschwindigkeit!
			try
			{
				sleep(10);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}