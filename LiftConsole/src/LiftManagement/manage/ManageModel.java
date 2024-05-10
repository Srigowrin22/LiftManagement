package LiftManagement.manage;

import LiftManagement.Datalayer.LiftDatalayer;
import LiftManagement.models.Lift;

public class ManageModel {
	private ManageView manageView;

	public ManageModel(ManageView manageView) {
		this.manageView = manageView;
	}

	public void setLift(int number) {
		int n = number;
		while(n>0) {
			Lift lift = new Lift();
			lift.setName();
			LiftDatalayer.getInstance().insertLift(lift);
			n--;
		}			
	}

	public void assignCurrent(int curr, int dest) {
		String alert = LiftDatalayer.getInstance().asgnCurr(curr, dest);
		manageView.showAlert(alert + " is assinged");
	}

	public void setPos(String name, int pos) {
		if(pos<=10) {
			LiftDatalayer.getInstance().liftUpdate(name, pos);
			manageView.showAlert("Updated");
		}else {
			manageView.showAlert("Floors do not exist! Lifts works only from 1-10 floors");
		}
		
	}

	public void assignDirect(int curr, int dest) {
		String alert = LiftDatalayer.getInstance().asgnDirect(curr, dest);
		manageView.showAlert(alert + " is assinged");
		
	}

	public void restrict(String name, int from, int to) {
		if(LiftDatalayer.getInstance().restrict(name, from, to)) {
			manageView.showAlert("Restricted");
		}else {
			manageView.showAlert("Lift Not found");
		}
		
	}

	public void leastStops(int curr, int dest) {
		String alert = LiftDatalayer.getInstance().leastStops(curr, dest);
		manageView.showAlert(alert + " is assigned");	
	}

	public void blockLift(String name) {
		if(LiftDatalayer.getInstance().blockLift(name)) {
			manageView.showAlert(name + " BLOCKED!! Lift is under maintainance!!");
		}else {
			manageView.showAlert("Lift Not found");
		}		
	}

	public void setCapacity(String name, int capacity) {
		if(LiftDatalayer.getInstance().setCapacity(name, capacity)) {
			manageView.showAlert(name + " Capacity is set! ");
		}else {
			manageView.showAlert("Lift Not found");
		}
	}
}
