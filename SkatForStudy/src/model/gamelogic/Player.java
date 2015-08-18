package model.gamelogic;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private EPlayerPosition _position;
	private List<Card> _hand = new ArrayList<Card>();
	
	public EPlayerPosition getPosition(){
		return _position;
	}
	
	public List<Card> getHand(){
		return _hand;
	}
	public void setHand(List<Card> pCrads) {
		_hand = pCrads;
	}
	public void setPosition(EPlayerPosition pPosition) {
		_position = pPosition;
	}
}
