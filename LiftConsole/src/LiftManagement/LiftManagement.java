package LiftManagement;

import java.util.Scanner;

import LiftManagement.manage.ManageView;

public class LiftManagement {
	
	private static LiftManagement liftmanagement;
	
	
	public static LiftManagement getInstance() {
		if (liftmanagement == null) {
			liftmanagement = new LiftManagement();
		}
		return liftmanagement;
	}

	public static void create() {
		ManageView manageView = new ManageView();
		manageView.init();
	}
	public static void main(String[] args) {
		LiftManagement.getInstance().create();		
	}
}
