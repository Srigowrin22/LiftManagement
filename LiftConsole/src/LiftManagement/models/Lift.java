package LiftManagement.models;


import java.util.ArrayList;
import java.util.List;

public class Lift {
	
	static int var = 1;
	static int capacity = 0;
	private String name;
    private int currentPosition;
    private int startPosition;
    private int targetPosition;
    private int totalCapacity = -1;

	public Lift() {
        this.currentPosition = 0; 
        this.startPosition = 0;
        this.targetPosition = 10;
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
    
    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }
    
    public void setTargetPosition(int targetPosition) {
        this.targetPosition = targetPosition;
    }

    public static void setCapacity() {
    	capacity++;
    }
    
    public static int getCapacity() {
		return capacity;
	}

    public int getTargetPosition() {
        return targetPosition;
    }
    
    public int getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}
}
