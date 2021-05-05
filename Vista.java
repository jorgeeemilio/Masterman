package es.studium.Masterman;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;

public class Vista extends Frame
{
	private static final long serialVersionUID = 1L;
	Color colorRojo = new Color(255,0,0);
	Color colorVerde = new Color(0,255,0);
	int color1=0, color2=0, color3=0, color4=0;
	int aciertos = 0;
	int intentos = 5;

	Dialog dlgFin = new Dialog(this, "Fin", true);
	Label lblMensaje = new Label("¡Acertaste!");

	public Vista()
	{
		setSize(400,120);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		dlgFin.setLayout(new FlowLayout());
		dlgFin.setSize(100,100);
		dlgFin.setResizable(false);
		dlgFin.add(lblMensaje);
		dlgFin.setLocationRelativeTo(null);
	}

	public void paint(Graphics g)
	{
		if(color1==0)
		{	
			g.setColor(colorRojo);
		}
		else
		{
			g.setColor(colorVerde);
		}
		g.fill3DRect(10, 40, 50, 50, true);
		if(color2==0)
		{	
			g.setColor(colorRojo);
		}
		else
		{
			g.setColor(colorVerde);
		}
		g.fill3DRect(70, 40, 50, 50, true);
		if(color3==0)
		{	
			g.setColor(colorRojo);
		}
		else
		{
			g.setColor(colorVerde);
		}
		g.fill3DRect(130, 40, 50, 50, true);
		if(color4==0)
		{	
			g.setColor(colorRojo);
		}
		else
		{
			g.setColor(colorVerde);
		}
		g.fill3DRect(190, 40, 50, 50, true);
		g.setColor(Color.black);
		g.drawRect(258, 41, 80, 16);
		g.drawRect(259, 42, 80, 16);
		g.drawRect(260, 43, 80, 16);
		g.drawString("COMPROBAR", 260, 55);
		g.drawString("Aciertos:"+aciertos, 260, 75);
		g.drawString("Intentos:"+intentos, 260, 95);
	}
	void cambiarColor(int cuadrado)
	{
		switch(cuadrado)
		{
		case 1:
			if(color1 == 0)
			{
				color1 = 1;
			}
			else
			{
				color1 = 0;
			}
			break;
		case 2:
			if(color2 == 0)
			{
				color2 = 1;
			}
			else
			{
				color2 = 0;
			}
			break;
		case 3:
			if(color3 == 0)
			{
				color3 = 1;
			}
			else
			{
				color3 = 0;
			}
			break;
		case 4:
			if(color4 == 0)
			{
				color4 = 1;
			}
			else
			{
				color4 = 0;
			}
			break;
		}
		repaint();
	}
	public void actualizar(int c)
	{
		aciertos = c;
		repaint();
	}
	public void resetear()
	{
		aciertos = 0;
		intentos = 5;
		color1 = 0;
		color2 = 0;
		color3 = 0;
		color4 = 0;
		repaint();
	}
}
