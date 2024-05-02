package LiftManagement.models;


import java.util.ArrayList;
import java.util.List;

public class Lift {
	
	static int var = 1;
	private String name;
    private int currentPosition;
    private int targetPosition;
    private String status;  // "stationary", "moving"
    private String direction;  // "up", "down", or "none"
//    private List<Integer> floors;

    public Lift() {
    	this.name = name;
        this.currentPosition = 0;  
        this.targetPosition = 0;
        this.status = "stationary";
        this.direction = "none";
//        this.floors = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ));  
    }

    public void setName() {
		name = "L"+var++;
	}
    
    public String getName() {
    	return name;
    }
    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(int targetPosition) {
        this.targetPosition = targetPosition;
        this.status = "moving";
        if (targetPosition > currentPosition) {
            this.direction = "up";
        } else {
            this.direction = "down";
        }
    }

    public String getStatus() {
        return status;
    }

    public String getDirection() {
        return direction;
    }

    public void moveToTarget() {
        if (status.equals("moving")) {
            this.currentPosition = targetPosition;
            this.status = "stationary";
            this.direction = "none";
        }
    }

	
}
