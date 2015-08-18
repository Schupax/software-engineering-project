package model.learning;

import java.util.ArrayList;
import java.util.List;

public class LearningTopic {
	private String _name;
	private List<LearningKnowledge> _knowledge = new ArrayList<LearningKnowledge>();
	
	public String getName(){
		return _name;
	}
	public class LearningKnowledge implements Knowledge{
		private final LearningTopic _topic;
		private String _text;
		
		private LearningKnowledge(LearningTopic pTopic){
			_topic = pTopic;
		}

		@Override
		public LearningTopic getTopic() {
			return _topic;
		}

		@Override
		public String getText() {
			return _text;
		}
		
		private void setText(String pText) {
			_text = pText;
		}
	}
	
	public void addNewKnowledge(String pText){
		LearningKnowledge newKnowledge = new LearningKnowledge(this);
		newKnowledge.setText(pText);
		_knowledge.add(newKnowledge);
	}
}
