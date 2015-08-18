package model;

import java.util.ArrayList;
import java.util.List;

import model.gamelogic.Card;
import model.gamelogic.EGameType;
import model.gamelogic.Player;
import model.learning.LearningContent;

public class Model {
	private List<Player> _players;
	private List<Card> _deck;
	private LearningContent _learnContent;
	private EGameType _gameType;
	private boolean _isGameOver = true;
	private List<Card> _skat;
	
	public Model(){
		_learnContent = new LearningContent();
		_players = new ArrayList<Player>();
		_deck = Card.getNewDeck(_learnContent);
		_skat = new ArrayList<Card>();
	}

	public List<Player> getPlayers() {
		return _players;
	}

	public List<Card> getDeck() {
		return _deck;
	}
	
	public void addNewPlayer(){
		_players.add(new Player());
	}
	
	public boolean isGameOver() {
		return _isGameOver;
	}
	
	public void addCardToSkat(Card pCard){
		_skat.add(pCard);
	}
	
	public List<Card> getSkat(){
		return _skat;
	}

	public EGameType getGameType() {
		return _gameType;
	}

	public void setGameType(EGameType pGameType) {
		_gameType = pGameType;
	}

}
