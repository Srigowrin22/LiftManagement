# Lift Management Console Application

## Overview
This Lift Management Console Application was developed as part of a skill test for Zoho Corp. It simulates and manages the operations of lifts within a building. The project is designed using the **Singleton Design Pattern** to ensure a single point of control over lift operations. The application is structured into modular components:

- **Main Class**: Entry point of the application.
- **Data Layer Class**: Manages data storage and retrieval.
- **Model Class**: Defines data models for lifts.
- **Manage Model Class**: Handles business logic.
- **View Model Class**: Manages user interactions and displays output.

## Features
1. **Display Lifts**: View the status and details of all lifts.
2. **Insert Lift**: Add new lifts into the system.
3. **Set Positions**: Configure initial or current positions of the lifts.
4. **Assign Lift with Current Position**: Allocate lifts based on the current position.
5. **Choose Lift with Direction**: Select lifts based on desired direction (up/down).
6. **Restrict Access**: Control access to specific lifts for security or maintenance.
7. **Least Stops**: Optimize and assign lifts that have the least number of stops.
8. **Capacity**: Manage lift assignments based on passenger capacity.
9. **Block Lift**: Temporarily disable a lift for maintenance or other reasons.

## Technologies Used
- **Java** (Core language)
- **Singleton Design Pattern**
- **Console-based User Interface**

## Usage
Upon running the program, the console will display the following menu:

```
Enter your choice:
1. Display Lifts
2. Insert Lift
3. Set Positions
4. Assign Lift with Current Position
5. Choose Lift with Direction
6. Restrict Access
7. Least Stops
8. Capacity
9. Block Lift
```

Enter the corresponding number to perform the desired action.

## Future Enhancements
- GUI-based interface for better user experience
- Integration with IoT devices for real-time monitoring
- Predictive maintenance alerts
  
## Author
**Srigowri N**  
Aspiring Software Developer  

