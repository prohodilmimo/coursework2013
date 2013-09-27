package npnets.complexeditor.action;

import java.util.ArrayList;
import java.util.List;

import ru.mathtech.npntool.npnets.highlevelnets.marking.*;
import ru.mathtech.npntool.npnets.highlevelnets.hlpn.*;
import ru.mathtech.npntool.npnets.highlevelnets.tokenexpressions.*;
import ru.mathtech.npntool.npnets.highlevelnets.tokentypes.*;
import ru.mathtech.npntool.npnets.highlevelnets.npnets.model.*;

import org.eclipse.jface.action.Action;

public class StepSimulationAction extends Action {

	public StepSimulationAction(NPnetMarked nPnetMarked) {
		super();
		this.net = nPnetMarked;
	}

	protected NPnetMarked net;
	
	public void run(){
		//��� ��������� ����
		//��� ������� ��������
		for (Node t : net.getNet().getNetSystem().getNodes())
			if (t instanceof Transition ) 
				
				//��� ������ �������� ����
				for(ArcPT apt : ((Transition) t).getInArcs())
					
					//��� ������ ����� � �������, ������� ��������� � ������ ��������� �����
					for(PlaceMarking pm : net.getMarking().getMap())
						if (pm.getPlace() == apt.getSource()) 
							
							//���� ���������� �� ����, ������ ��� ����� ���������� ����� � �������
							if (apt.getInscription().getMonoms().get(0).getPower().compareTo(pm.getMarking().getWeight().get(0).getWeight()) != 1) {
								
								//���� ������ ������� - ����������������
								if (t instanceof TransitionSynchronized) {
									//���������, �� ������ �� ������������� � ������������
									if (((TransitionSynchronized) t).getSynchronization().getKey() != ENABLED) {
										//���� ��� - �������� ������ ������� ��� ���������������
										t.setComment(CHECKED);
										//� ��������� �� ������� ������ ��������������� ��������� ����� ����������������
										for (TransitionSynchronized ts : ((TransitionSynchronized) t).getSynchronization().getInvolved()) {
										//���� ��� �������� - �������� �������������, ��� ������� � ������������
											if (ts.getComment() == CHECKED) {
												((TransitionSynchronized) t).getSynchronization().setKey(ENABLED);
												ts.setComment("");
												t.setComment("");
											}
										}
										//���� ��� - ������� � ��������� �������� ����
										break;
										
										//���� ��� - ������ �� ������
									} else {
										//���� ������������� ������ � ������������ - ����� ������� � ������� ��������
										t.setComment("");
									}
								}
								
								
								ArcTP theArc = null;
								//�� ��� ����, ������� ����� �� ����������
								for (ArcTP atp : ((Transition) t).getOutArcs())
									if (atp.getInscription().getMonoms().get(0).getVariable() == apt.getInscription().getMonoms().get(0).getVariable()) {
										theArc = atp;
										break;
									}
								
								//���� ����� ����� � �������, � ������� ����� ��� ����
								for(PlaceMarking pm2 : net.getMarking().getMap())
									if (theArc != null && pm2.getPlace() == theArc.getTarget()) { 
										//�������� ��� ����������� �����, ��������� �� ����� ����
										pm2.getMarking().getWeight().get(0).getWeight().add(theArc.getInscription().getMonoms().get(0).getPower());
										//� ������� �� ����������� ������� ���������� �����, ��������� �� ����, ������� �� ���.
										pm.getMarking().getWeight().get(0).getWeight().subtract(apt.getInscription().getMonoms().get(0).getPower());
									}
							}
		//��� ���������� �����
		
		
	}

	public boolean isEnabled() {
		return true; //netIsFirable();
	}
	
	public boolean netIsFirable() {
		List<Node> places = new ArrayList<Node>();
		for (Node n : net.getNet().getNetSystem().getNodes()) {
			if (n instanceof Place)
				places.add(n);
		}
		
		if ( net.getNet().getNetSystem().getNodes() != null && net.getMarking().getMap().size() != 0 )
			return true;
		return false;
	}
	
	public void setNet(NPnetMarked net) {
		this.net = net;
	}
	
	@Override
	public String getText() {
		return "Make simulation step";
	}
}
