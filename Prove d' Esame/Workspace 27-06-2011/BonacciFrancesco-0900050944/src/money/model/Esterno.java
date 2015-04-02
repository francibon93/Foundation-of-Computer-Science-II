package money.model;

public class Esterno extends Conto
{

	public Esterno()
	{
		super("esterno");
	}

	@Override
	public String checkVincoli(Movimento m)
	{
		if (!(m.getSorgente().equals(getName()) || m.getDestinazione().equals(getName())))
			throw new IllegalArgumentException("Il movimento non � relativo a questo conto");

		return null;
	}

}
