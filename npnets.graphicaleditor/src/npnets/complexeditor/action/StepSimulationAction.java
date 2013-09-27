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
		//Для системной сети
		//Для каждого перехода
		for (Node t : net.getNet().getNetSystem().getNodes())
			if (t instanceof Transition ) 
				
				//Для каждой входящей арки
				for(ArcPT apt : ((Transition) t).getInArcs())
					
					//Для набора фишек в позиции, которая соединена с данным переходом аркой
					for(PlaceMarking pm : net.getMarking().getMap())
						if (pm.getPlace() == apt.getSource()) 
							
							//Если переменная на арке, меньше или равна количеству фишек в позиции
							if (apt.getInscription().getMonoms().get(0).getPower().compareTo(pm.getMarking().getWeight().get(0).getWeight()) != 1) {
								
								//Если данный прееход - синхронизируемый
								if (t instanceof TransitionSynchronized) {
									//Проверить, не готова ли синхронизация к срабатыванию
									if (((TransitionSynchronized) t).getSynchronization().getKey() != ENABLED) {
										//Если нет - пометить данный переход как заблокированный
										t.setComment(CHECKED);
										//И проверить на наличие других заблокированных переходов среди синхронизируемых
										for (TransitionSynchronized ts : ((TransitionSynchronized) t).getSynchronization().getInvolved()) {
										//Если они найдутся - пометить синхронизацию, как готовую к срабатыванию
											if (ts.getComment() == CHECKED) {
												((TransitionSynchronized) t).getSynchronization().setKey(ENABLED);
												ts.setComment("");
												t.setComment("");
											}
										}
										//Если нет - перейти к следующей входящей арке
										break;
										
										//Если нет - ничего не делать
									} else {
										//Если синхронизация готова к срабатыванию - снять пометку с данного перехода
										t.setComment("");
									}
								}
								
								
								ArcTP theArc = null;
								//То для арки, несущей такую же переменную
								for (ArcTP atp : ((Transition) t).getOutArcs())
									if (atp.getInscription().getMonoms().get(0).getVariable() == apt.getInscription().getMonoms().get(0).getVariable()) {
										theArc = atp;
										break;
									}
								
								//Ищем набор фишек в позиции, в которую ведет эта арка
								for(PlaceMarking pm2 : net.getMarking().getMap())
									if (theArc != null && pm2.getPlace() == theArc.getTarget()) { 
										//Забиваем его количеством фишек, указанным на новой арке
										pm2.getMarking().getWeight().get(0).getWeight().add(theArc.getInscription().getMonoms().get(0).getPower());
										//И убираем из изначальной позиции количество фишек, указанное на арке, ведущей из нее.
										pm.getMarking().getWeight().get(0).getWeight().subtract(apt.getInscription().getMonoms().get(0).getPower());
									}
							}
		//Для элементных сетей
		
		
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
