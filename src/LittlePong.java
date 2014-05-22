/*
Program: LittlePong - A Java-Example for Education

Copyright (C) 2011 Karsten Bettray

This program is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License
as published by the Free Software Foundation; either version 3 of the License, or (at your option) any later version.
This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
See the GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License along with this library;
if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110, USA
or look at <http://www.gnu.org/licenses/>.
*/

import javax.swing.JFrame;

public class LittlePong extends JFrame
{
	SpielFeld feld = new SpielFeld();	// Ein Spielfeld Objekt erzeugen
	
	/**
	 * Der Konstruktor
	 */
	public LittlePong()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Verhalten wenn Fenster weggeklickt wird
		setTitle("Little Pong");	// Name des Fensters
		setSize(640, 480);			// Groesse des Fensters
		
		add(feld);					// Spielfeld dem Fenster zufuegen
		
		setVisible(true);			// Nun das Fenster sichtbar machen
	}

	/**
	 * Hier startet das Programm
	 */
	public static void main(String[] args)
	{
		LittlePong start = new LittlePong();	// Starten des Programms
	}
}
