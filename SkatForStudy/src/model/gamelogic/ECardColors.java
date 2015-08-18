package model.gamelogic;

public enum ECardColors {
	bells("Schellen",9), hearts("Herz",10), leaves("Grün",11),acorns("Eicheln",12);
	public final String _germanWord;
	public final int _value;
	private ECardColors(String pGermanWord, int pValue){
		_germanWord = pGermanWord;
		_value = pValue;
	}
}
