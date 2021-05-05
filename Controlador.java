package es.studium.Masterman;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, MouseListener
{
	Vista vista;
	Modelo modelo;
	int secreto[] = new int[4];
	int apuesta[] = new int[4];

	public Controlador(Vista v, Modelo m)
	{
		this.vista = v;
		this.modelo = m;

		this.vista.addWindowListener(this);
		this.vista.addMouseListener(this);

		this.vista.dlgFin.addWindowListener(this);

		this.modelo.generar(secreto);
	}

	@Override
	public void mouseClicked(MouseEvent evento)
	{
		int x = evento.getX();
		int y = evento.getY();
		if((x>=10)&&(x<=60)&&(y>=30)&&(y<=80))
		{
			// Primer cuadrado
			if(apuesta[0]==0)
			{
				apuesta[0] = 1;
			}
			else
			{
				apuesta[0] = 0;
			}
			this.vista.cambiarColor(1);
		}
		else if((x>=70)&&(x<=130)&&(y>=30)&&(y<=80))
		{
			// Segundo cuadrado
			if(apuesta[1]==0)
			{
				apuesta[1] = 1;
			}
			else
			{
				apuesta[1] = 0;
			}
			this.vista.cambiarColor(2);
		}
		else if((x>=140)&&(x<=190)&&(y>=30)&&(y<=80))
		{
			// Tercer cuadrado
			if(apuesta[2]==0)
			{
				apuesta[2] = 1;
			}
			else
			{
				apuesta[2] = 0;
			}
			this.vista.cambiarColor(3);
		}
		else if((x>=200)&&(x<=250)&&(y>=30)&&(y<=80))
		{
			// Cuarto cuadrado
			if(apuesta[3]==0)
			{
				apuesta[3] = 1;
			}
			else
			{
				apuesta[3] = 0;
			}
			this.vista.cambiarColor(4);
		}
		else if((x>=260)&&(x<=335)&&(y>=45)&&(y<=80))
		{
			// Comprobar
			boolean correcto = true;
			int contador = 0;
			for(int i = 0; i < 4; i++)
			{
				System.out.print(secreto[i]);
				if(secreto[i]!=apuesta[i])
				{
					correcto = false;
				}
				else
				{
					contador++;
				}
			}
			System.out.println();
			this.vista.actualizar(contador);
			if(correcto)
			{
				this.vista.dlgFin.setVisible(true);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0){}
	@Override
	public void mouseExited(MouseEvent arg0){}
	@Override
	public void mousePressed(MouseEvent arg0){}
	@Override
	public void mouseReleased(MouseEvent arg0){}
	@Override
	public void windowActivated(WindowEvent arg0){}
	@Override
	public void windowClosed(WindowEvent arg0){}
	@Override
	public void windowClosing(WindowEvent arg0)
	{
		if(this.vista.dlgFin.isActive())
		{
			this.vista.dlgFin.setVisible(false);
			// Reset
			this.modelo.generar(secreto);
			this.vista.resetear();
			for(int i = 0; i < 4; i++)
			{
				apuesta[i] = 0;
			}
		}
		else
		{
			System.exit(0);
		}
	}
	@Override
	public void windowDeactivated(WindowEvent arg0){}
	@Override
	public void windowDeiconified(WindowEvent arg0){}
	@Override
	public void windowIconified(WindowEvent arg0){}
	@Override
	public void windowOpened(WindowEvent arg0){}
}
