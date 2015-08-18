package view.game;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Model;
import model.gamelogic.Card;
import service.gamelogic.GameService;

public class View {

	private Model _model;
	private GameService _controller;
	private Stage _stage;
	private List<VCard> _cards = new ArrayList<VCard>();
	private Image _backSiteOfCard;

	public View(Model pModel, GameService pController, Stage pStage) {
		_model = pModel;
		_controller = pController;
		_stage = pStage;
		describeStage();
	}

	private void describeStage() {
		mapCards();
	}

	private void mapCards() {
		for (Card card : _model.getDeck()) {
			_cards.add(new VCard(card));
		}
	}

	public void show() {
		_stage.show();
	}

}
