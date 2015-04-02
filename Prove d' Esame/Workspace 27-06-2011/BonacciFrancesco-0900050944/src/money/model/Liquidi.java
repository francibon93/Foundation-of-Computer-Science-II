package money.model;

import java.util.Date;

public class Liquidi extends Conto
{

	public Liquidi(String nome)
	{
		super(nome);
	}

	public String checkVincoli(Movimento m)
	{
		String error = super.checkVincoli(m);
		if (error != null)
		{
			return error;
		}

		if (m.getSorgente().equals(getName()))
		{
			double saldo = getSaldo(m.getData());
			if (saldo < m.getDenaroMosso())
			{
				return "Non � possibile spostare pi� dei liquidi contenuti nel portafoglio: " + saldo;
			}
		}
		return null;
	}

	@Override
	public String toString()
	{
		return "Liquidi: " + super.toString() + " Disponibilit� attuale liquidi: " + getSaldo(new Date()) + " \n";
	}

}
