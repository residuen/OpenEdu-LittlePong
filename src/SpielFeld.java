import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

	/**
	 * Diese Klasse Beinhaltet das Spielfeld
	 */
	public class SpielFeld extends JPanel implements MouseMotionListener
	{
		Schlaeger schlaeger = new Schlaeger(this);	// Ein neues Schlaeger-Objekt erzeugen
		
		Ball ball = new Ball(this);	// Einen Ball-Thread erzeugen, der die Ballbewegung koordiniert

		public SpielFeld()
		{
			addMouseMotionListener(this);	// Noetig, um auf Mausbewegungen (Mausereignisse - engl. Mouseevents) reagieren zu koennen
			
			ball.start();	// Den Ball-Thread starten starten
		}
		
		public void paint(Graphics g)
		{
			Graphics2D g2d = (Graphics2D)g;
			
			g2d.clearRect(0, 0, getWidth(), getHeight());	// Bildschirm loeschen, damit neu gezeichnet werden kann
			
			g2d.setColor(Color.RED);	// Aktuelle Farbe zum Zeichnen (ROT)
			g2d.fill(schlaeger.getSchlaeger());	// Flaeche eines Rechtecks zeichnen fuer den Schlaeger
			
			g2d.setColor(Color.BLACK);	// Aktuelle Farbe zum Zeichnen (Schwarz)
			g2d.draw(schlaeger.getSchlaeger());	// Rahmen eines Rechtecks zeichnen fuer den Schlaeger
			
			g2d.setColor(Color.GREEN);	// Aktuelle Farbe zum Zeichnen (GRUEN)
			g2d.fill(ball.getBall());				// Ausgefuellte Kreisflaeche zeichnen
			
			g2d.setColor(Color.BLACK);	// Aktuelle Farbe zum Zeichnen (SCHWARZ)
			g2d.draw(ball.getBall());
		}

		// Maus-Bewegungs Ereignis MIT gedrueckter Maustaste
		@Override
		public void mouseDragged(MouseEvent arg0)
		{
			schlaeger.updateSchlaeger(arg0.getY());	// Y-Position des Schlaegers der Y-Position der Maus anpassen

			repaint();	
		}

		// Maus-Bewegungs Ereignis OHNE gedrueckter Maustaste
		@Override
		public void mouseMoved(MouseEvent arg0)
		{
			schlaeger.updateSchlaeger(arg0.getY());	// Y-Position des Schlaegers der Y-Position der Maus anpassen
			
			repaint();		// Spielfeld neu zeichnen
		}
	}
