package model.gamelogic;

import java.util.List;

public class BiddingAutomat {
	private States _actState = States.SecondFirst;
	private int _lastBidding = 0;
	private Integer[] _biddingValues = { 18, 20, 22, 23, 24, 30, 33, 35, 36,
			40, 44, 45, 46, 48, 50, 55, 60 };
	private List<Player> _players;

	public BiddingAutomat(List<Player> pPlayers) {
		_players = pPlayers;
	}

	public void changeState(EBiddingOptions pBidding) throws Exception {
		for (States state : States.values()) {
			switch (state) {
			case First:
				switch (pBidding) {
				case Bidding:
					_actState = States.FirstIsPlaying;
					break;
				case No:
					_actState = States.None;
					break;
				default:
					throw new Exception();
				}
			case FirstSecond:
				switch (pBidding) {
				case Yes:
					_actState = States.SecondFirst;
					break;
				case No:
					_actState = States.ThirdSecond;
					break;
				default:
					throw new Exception();
				}
				break;
			case FirstThird:
				switch (pBidding) {
				case Yes:
					_actState = States.ThirdFirst;
					break;
				case No:
					_actState = States.ThirdIsPlaying;
					break;
				default:
					throw new Exception();
				}
				break;
			case None:
				throw new Exception();
			case SecondIsPlaying:
				throw new Exception();
			case SecondFirst:
				switch (pBidding) {
				case Bidding:
					setLastBidding(pBidding);
					_actState = States.FirstSecond;
					break;
				case No:
					_actState = States.ThirdFirst;
					break;
				default:
					throw new Exception();
				}
				break;
			case SecondThird:
				switch (pBidding) {
				case Yes:
					_actState = States.ThirdSecond;
					break;
				case No:
					_actState = States.ThirdIsPlaying;
					break;
				default:
					throw new Exception();
				}
			case ThirdIsPlaying:
				throw new Exception();
			case ThirdFirst:
				switch (pBidding) {
				case Bidding:
					setLastBidding(pBidding);
					_actState = States.FirstThird;
					break;
				case No:
					_actState = States.First;
					break;
				default:
					throw new Exception();
				}
				break;
			case ThirdSecond:
				switch (pBidding) {
				case Bidding:
					setLastBidding(pBidding);
					_actState = States.SecondThird;
					break;
				case No:
					_actState = States.SecondIsPlaying;
					break;
				default:
					throw new Exception();
				}
				break;
			case FirstIsPlaying:
				throw new Exception();
			}
		}
	}

	public enum States {
		SecondThird(EPlayerPosition.SecondSeat), SecondFirst(
				EPlayerPosition.SecondSeat), FirstSecond(
				EPlayerPosition.FirstSeat), ThirdFirst(
				EPlayerPosition.ThirdSeat), ThirdSecond(
				EPlayerPosition.ThirdSeat), FirstThird(
				EPlayerPosition.FirstSeat), SecondIsPlaying(null), ThirdIsPlaying(
				null), First(EPlayerPosition.FirstSeat), None(null), FirstIsPlaying(
				null);

		private final EPlayerPosition _nextPlayer;

		private States(EPlayerPosition pNextPlayer) {
			_nextPlayer = pNextPlayer;
		}

		public EPlayerPosition getPositionOfNextPlayer() {
			return _nextPlayer;
		}
	}

	private void setLastBidding(EBiddingOptions pBidding) throws Exception {
		if (pBidding.getBiddingValue() != 0) {
			if (_lastBidding == 0) {
				_lastBidding = pBidding.getBiddingValue();
			} else {
				if (pBidding.getBiddingValue() > _lastBidding) {
					boolean isCorrectBiddingValue = false;
					for (int i = 0; i < _biddingValues.length; i++) {
						Integer integer = _biddingValues[i];
						if (integer == pBidding.getBiddingValue()) {
							_lastBidding = pBidding.getBiddingValue();
							isCorrectBiddingValue = true;
						}
					}
					if (!isCorrectBiddingValue) {
						throw new Exception();
					}
				} else {
					throw new Exception();
				}
			}
		} else {
			throw new Exception();
		}
	}

	public States getActState() {
		return _actState;
	}

	public Player getNextPlayerForBidding() {
		Player nextPlayer = null;
		for (Player player : _players) {
			if (player.getPosition()
					.equals(_actState.getPositionOfNextPlayer())) {
				nextPlayer = player;
			}
		}
		return nextPlayer;
	}

	public boolean isBiddingOver() {
		boolean result = false;
		if (_actState.getPositionOfNextPlayer() == null) {
			result = true;
		}
		return result;
	}
}
