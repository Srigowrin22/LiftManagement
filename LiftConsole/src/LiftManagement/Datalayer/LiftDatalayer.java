package LiftManagement.Datalayer;

import java.util.ArrayList;
import LiftManagement.models.Lift;

public class LiftDatalayer {

	private static LiftDatalayer liftDatalayer;
	private ArrayList<Lift> slift = new ArrayList();
	private Lift lift;

	private LiftDatalayer() {
	}

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
		if (slift.size() == 0)
			return true;
		for (Lift dlift : slift) {
			System.out.println(dlift.getName() + " --- Current: " + dlift.getCurrentPosition() + " || Access--- "
					+ dlift.getStartPosition() + " -> " + dlift.getTargetPosition());
		}
		return false;
	}

	public String asgnCurr(int curr, int dest) {
		boolean has = false;
		int min = Integer.MAX_VALUE;
		String id = "";
		for (Lift isLift : slift) {
			if(checkLift(isLift)) {
				int res = Math.abs(isLift.getCurrentPosition() - curr) + Math.abs(curr - dest);
				if (res < min) {
					min = res;
					id = isLift.getName();
					has = true;
				}
			}
		}
		if (has) {
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
		int pos2 = 0, pos = 0;
		for (Lift isLift : slift) {
			if(checkLift(isLift)) {
				int res = Math.abs(isLift.getCurrentPosition() - curr) + Math.abs(curr - dest);
				if (res < min) {
					min = res;
					res = 0;
					id = isLift.getName();
					pos = isLift.getCurrentPosition();
					has = true;
				}

				else if (res == min) {
					id2 = isLift.getName();
					pos2 = isLift.getCurrentPosition();
					if (direct > 0) {
						pos = Math.max(pos, pos2);
					} else if (direct < 0) {
						pos = Math.min(pos, pos2);
					}
					has = true;
				}
			}
		}
		if (has) {
			if (pos == pos2) {
				id = id2;
			}
			liftUpdate(id, dest);
			return id;
		}
		return "No Lifts";
	}

	public boolean liftUpdate(String id, int curr) {
		for (Lift isLift : slift) {
			if (isLift.getName().equals(id)) {
				isLift.setCurrentPosition(curr);
				return true;
			}
		}
		return false;
	}

	public boolean restrict(String name, int from, int to) {
		for (Lift isLift : slift) {
			if (isLift.getName().equals(name)) {
				isLift.setStartPosition(from);
				isLift.setTargetPosition(to);
				if(isLift.getCurrentPosition()!=0) {
					isLift.setCurrentPosition(from);
				}
				return true;
			}
		}
		return false;
	}

	public String leastStops(int curr, int dest) {
		int min = Integer.MAX_VALUE;
		boolean has = false;
		String id = "";
		int count = Integer.MAX_VALUE;
		for (Lift isLift : slift) {
			if(checkLift(isLift)) {
				if ((curr == 0) && (dest >= isLift.getStartPosition() && dest <= isLift.getTargetPosition())) {
					count = isLift.getCurrentPosition() - isLift.getStartPosition() + dest - isLift.getStartPosition() + 1;
					has = true;
				} 
				
				else if (dest == 0 && (curr >= isLift.getStartPosition() && curr <= isLift.getTargetPosition())) {
					if (curr <= isLift.getCurrentPosition()) {
						count = isLift.getCurrentPosition() - isLift.getStartPosition() + 1;
						has = true;
					} else {
						count = curr - isLift.getCurrentPosition() + curr - isLift.getStartPosition() + 1;
						has = true;
					}
				}
				
				else if (dest >= isLift.getStartPosition() && dest <= isLift.getTargetPosition()
						&& curr >= isLift.getStartPosition() && curr <= isLift.getTargetPosition()) {

					if (dest >= isLift.getCurrentPosition() && curr <= isLift.getCurrentPosition()) {
						count = 2 * (isLift.getCurrentPosition() - curr) + dest - isLift.getCurrentPosition();
					} else if (dest <= isLift.getCurrentPosition() && curr >= isLift.getCurrentPosition()) {
						count = 2 * (curr - isLift.getCurrentPosition()) + isLift.getCurrentPosition() - dest;
					} else if (dest <= isLift.getCurrentPosition() && curr <= isLift.getCurrentPosition()) {
						if (dest > curr) {
							count = (isLift.getCurrentPosition() - curr) + dest - curr;
						} else {
							count = isLift.getCurrentPosition() - dest;
						}
					} else if (dest >= isLift.getCurrentPosition() && curr >= isLift.getCurrentPosition()) {
						if (dest > curr) {
							count = dest - isLift.getCurrentPosition();
						} else {
							count = curr - isLift.getCurrentPosition() + curr - dest;
						}
					}
					has = true;
				} 
			}

			if (count < min) {
				min = count;
				count = 0;
				id = isLift.getName();
			}
		}
		if (has) {
			liftUpdate(id, dest);
			return id;
		}
		return "No lifts";
	}

	public boolean blockLift(String name) {
		for (Lift isLift : slift) {
			if (isLift.getName().equals(name)) {
				isLift.setStartPosition(-1);
				isLift.setTargetPosition(-1);
				isLift.setCurrentPosition(-1);
				return true;
			}
		}
		return false;
	}

	public boolean setCapacity(String name, int capacity) {
		for (Lift isLift : slift) {
			if (isLift.getName().equals(name)) {
				isLift.setTotalCapacity(capacity);
				return true;
			}
		}
		return false;
	}
	
	public boolean checkLift(Lift isLift1) {
		if(isLift1.getCurrentPosition()!=-1 &&(isLift1.getTotalCapacity()==-1)) {
			return true;
		}else if(isLift1.getCapacity() < isLift1.getTotalCapacity()) {
			isLift1.setCapacity();
			return true;
		}
		else {
			return false;
		}			
	}		
}
