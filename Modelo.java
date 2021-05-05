package es.studium.Masterman;

import java.util.Random;

public class Modelo
{
	Random rnd = new Random();
	
	public void generar(int[] secreto)
	{
		for(int i = 0; i < 4; i++)
		{
			secreto[i] = rnd.nextInt(3);
		}
	}
}
