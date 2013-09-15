package npnets.graphicaleditor.model.project;

import java.util.List;

import ru.mathtech.npntool.npnets.highlevelnets.hlpn.HighLevelPetriNet;

public class Project {
	private List<HighLevelPetriNet> nets;

	public List<HighLevelPetriNet> getNets() {
		return nets;
	}

	public void setNets(List<HighLevelPetriNet> nets) {
		this.nets = nets;
	}
}
