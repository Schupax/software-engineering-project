package service.gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Model;
import model.gamelogic.BiddingAutomat;
import model.gamelogic.Card;
import model.gamelogic.EPlayerPosition;
import model.gamelogic.Player;
import constants.Constants;

public class GameService {
	private BiddingAutomat biddingAutomat;
	private Model _model;

	public GameService(Model pModel) {
		_model = pModel;
		for (int i = 0; i < Constants.cNUMBEROFPLAYERS; i++) {
			_model.addNewPlayer();
		}
		biddingAutomat = new BiddingAutomat(_model.getPlayers());
	}

	public void startGame() throws Exception {
		setPlayerPositions();
		dealCards();
	}

	private void setPlayerPositions() throws Exception {
		int playerCounter = 1;
		for (Player player : _model.getPlayers()) {
			switch (player.getPosition()) {
			case FirstSeat:
				player.setPosition(EPlayerPosition.SecondSeat);
			case SecondSeat:
				player.setPosition(EPlayerPosition.ThirdSeat);
			case ThirdSeat:
				player.setPosition(EPlayerPosition.FirstSeat);
			default:
				if (player.getPosition() == null) {
					switch (playerCounter) {
					case 1:
						player.setPosition(EPlayerPosition.ThirdSeat);
					case 2:
						player.setPosition(EPlayerPosition.FirstSeat);
					case 3:
						player.setPosition(EPlayerPosition.SecondSeat);
					default:
						playerCounter++;
					}
				}
			}
		}
	}

	private void dealCards() throws Exception {
		List<Card> cardsOfFirstPlayer = new ArrayList<Card>();
		List<Card> cardsOfSecondPlayer = new ArrayList<Card>();
		List<Card> cardsOfThirdPlayer = new ArrayList<Card>();
		Random rn = new Random();
		int n = Constants.cNUMBEROFPLAYERS + 2;
		for (Card card : Card.getNewDeck(null)) {
			int i = rn.nextInt() % n;
			switch (i) {
			case 0:
				if (_model.getSkat().size() < 2) {
					_model.addCardToSkat(card);
					;
					break;
				}
			case 1:
				if (cardsOfFirstPlayer.size() < 10) {
					cardsOfFirstPlayer.add(card);
					break;
				}
			case 2:
				if (cardsOfSecondPlayer.size() < 10) {
					cardsOfSecondPlayer.add(card);
					break;
				}
			case 3:
				if (cardsOfThirdPlayer.size() < 10) {
					cardsOfThirdPlayer.add(card);
					break;
				}
			default:
				if (cardsOfFirstPlayer.size() < 10) {
					cardsOfFirstPlayer.add(card);
					break;
				}
				if (cardsOfSecondPlayer.size() < 10) {
					cardsOfSecondPlayer.add(card);
					break;
				}
				if (cardsOfThirdPlayer.size() < 10) {
					cardsOfThirdPlayer.add(card);
					break;
				}
			}
		}
		for (Player player : _model.getPlayers()) {
			if (player.getPosition().equals(EPlayerPosition.FirstSeat)) {
				setHandOfPLayer(cardsOfFirstPlayer, player);
			}
			if (player.getPosition().equals(EPlayerPosition.SecondSeat)) {
				setHandOfPLayer(cardsOfSecondPlayer, player);
			}
			if (player.getPosition().equals(EPlayerPosition.ThirdSeat)) {
				setHandOfPLayer(cardsOfThirdPlayer, player);
			}
		}
	}

	public void setPositionOfPlayer(EPlayerPosition pPlayerPosition,
			Player pPlayer) throws Exception {
		if (_model.isGameOver()) {
			pPlayer.setPosition(pPlayerPosition);
		} else {
			throw new Exception();
		}
	}

	public void setHandOfPLayer(List<Card> pHand, Player pPlayer)
			throws Exception {
		if (_model.isGameOver()) {
			pPlayer.setHand(pHand);
		} else {
			throw new Exception();
		}
	}
}
