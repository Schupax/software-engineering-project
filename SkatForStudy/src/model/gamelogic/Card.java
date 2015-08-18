package model.gamelogic;

import java.util.ArrayList;
import java.util.List;

import constants.Constants;
import model.learning.LearningContent;
import model.learning.LearningTopic.LearningKnowledge;

public class Card {
	private final ECardValues _value;
	private final ECardColors _color;
	private LearningKnowledge _knowledge;

	private Card(ECardColors pColor, ECardValues pValue) {
		_color = pColor;
		_value = pValue;
	}

	public ECardValues getValue() {
		return _value;
	}

	public ECardColors getColor() {
		return _color;
	}

	public static List<Card> getNewDeck(LearningContent pContent) {
		List<Card> newDeck = new ArrayList<Card>();
		for (ECardValues cardValue : ECardValues.values()) {
			for (ECardColors cardColor : ECardColors.values()) {
				newDeck.add(new Card(cardColor, cardValue));
			}
		}

		return newDeck;
	}

	public LearningKnowledge getKnowledge() {
		return _knowledge;
	}

	public void setKnowledge(LearningKnowledge pKnowledge) {
		_knowledge = pKnowledge;
	}

	public String getImagePath() {
		return Constants.cIMAGEPATH + _color._germanWord + _value._germanWord
				+ Constants.cDOT + Constants.cIMAGEFILETYPE;
	}
	
	@Override
	public String toString() {
		return _color._germanWord + _value._germanWord;
	}
}
