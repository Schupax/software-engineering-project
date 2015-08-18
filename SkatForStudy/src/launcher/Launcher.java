package launcher;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import service.gamelogic.GameService;
import view.game.View;


public class Launcher extends Application{
	
	private Model _model;
	private GameService _controller;
	private View _view;

	@Override
	public void start(Stage pStage) throws Exception {
		_model = new Model();
		_controller = new GameService(_model);
		_view = new View(_model,_controller,pStage);
		_view.show();
		}
	public static void main(String[] args) {
		Launcher.launch();
	}
}
