package view.game;

import javafx.scene.image.Image;
import model.gamelogic.Card;

public class VCard extends Image {

	private Card _card;

	public VCard(Card pCard) {
		super(pCard.getImagePath());
		_card = pCard;
	}

	public Card getCard() {
		return _card;
	}
}
