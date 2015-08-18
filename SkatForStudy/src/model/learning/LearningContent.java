package model.learning;

import java.util.ArrayList;
import java.util.List;

public class LearningContent {
	private List<LearningTopic> topics = new ArrayList<LearningTopic>();

	public List<LearningTopic> getTopics() {
		List<LearningTopic> result = new ArrayList<LearningTopic>();
		for (LearningTopic learningTopic : topics) {
			result.add(learningTopic);
		}
		return result;
	}

	public void addTopic(LearningTopic pTopic) throws Exception {
		if(!topics.contains(pTopic)){
		topics.add(pTopic);
		}else{
			throw new Exception();
		}
	}

	public void removeTopic(LearningTopic pTopic) throws Exception {
		if (topics.contains(pTopic)) {
			topics.remove(pTopic);
		}else{
			throw new Exception();
		}
	}
	public void changeNameOfTopic(String pNewName,LearningTopic pTopic) throws Exception{
		LearningTopic topic = null;
		boolean containsTopic = false;
		for (LearningTopic learningTopic : topics) {
			if(learningTopic.equals(pTopic)){
				topic = learningTopic;
				containsTopic = true;
			}
		}
		if(!containsTopic){
			throw new Exception();
		}
		removeTopic(topic);
		addTopic(new LearningTopic());
	}
}
