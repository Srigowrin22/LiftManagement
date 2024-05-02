package LiftManagement.Datalayer;

import java.util.ArrayList;
import LiftManagement.models.Lift;


public class LiftDatalayer {
	
	private static LiftDatalayer liftDatalayer;
	private ArrayList<Lift> slift = new ArrayList();
	private Lift lift;
	
	private LiftDatalayer(){}

	public static LiftDatalayer getInstance() {
		if (liftDatalayer == null) {
			liftDatalayer = new LiftDatalayer();
		}
		return liftDatalayer;
	}

	public ArrayList<Lift> getLift() {
		return slift;
	}

	public void insertLift(Lift inslift) {
		slift.add(inslift);		
	}

	public boolean displayLift() {
		if(slift.size()==0) return true;
		for(Lift dlift : slift) { 
			System.out.println(dlift.getName() +" "+ dlift.getCurrentPosition()+"->"+ dlift.getTargetPosition());
		}
		return false;
	}

	public String asgnCurr(int curr, int dest) {
		boolean has = false;
		int min = Integer.MAX_VALUE;
		String id = "";
		for(Lift isLift : slift) {
			int res = Math.abs(isLift.getCurrentPosition()-curr) + Math.abs(curr - dest);
			if(res < min) {
				min = res;
				id = isLift.getName();
				has = true;
			}
		}
		if(has) {
			liftUpdate(id, dest);
			return id;
		}
		return "No Lifts";
	}

	public String asgnDirect(int curr, int dest) {
		boolean has = false;
		int direct = curr - dest;
		int min = Integer.MAX_VALUE;
		String id2 = "", id = "";
		int pos2 = 0, pos=0;
		for(Lift isLift : slift) {
			int res = Math.abs(isLift.getCurrentPosition() - curr) + Math.abs(curr - dest);
			if(res < min) {
				min = res;
				id = isLift.getName();
				pos = isLift.getCurrentPosition();
				has = true;
			}
			
			if(res == min) {
				id2 = isLift.getName();
				if(direct > 0) {
					pos = Math.max(pos, pos2);
				}
				else if(direct < 0) {
					pos = Math.min(pos, pos2);
				}
				has = true;
			}
		}
		if(has) {
			if(pos == pos2) {
				id = id2;
			}
			liftUpdate(id, dest);
			return id;
		}
		return "No Lifts";
	}
	
	public boolean liftUpdate(String id, int curr) {
		for(Lift isLift : slift) {
			if(isLift.getName().equals(id)) {
				isLift.setCurrentPosition(curr);
				return true;
			}
		}	
		return false;
	}

	public boolean restrict(String name, int from, int to) {
		for(Lift isLift : slift) {
			if(isLift.getName().equals(name)) {
				isLift.setCurrentPosition(from);
				isLift.setTargetPosition(to);
				return true;
			}
		}	
		return false;
	}
}
