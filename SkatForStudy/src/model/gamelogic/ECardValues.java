package model.gamelogic;

public enum ECardValues {
	Ace("Ass",7), King("König",6), Queen("Ober",5), Jack("Unter",4), Ten("Zehn",3), Nine(
			"Neun",2), Eight("Acht",1), Seven("Sieben",0);
	public final String _germanWord;
	public final int _value;

	private ECardValues(String pGermanWord, int pValue) {
		_germanWord = pGermanWord;
		_value = pValue;
	}
}
