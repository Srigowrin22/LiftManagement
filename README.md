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

## MODEL: <br> 
<img width="336" alt="image" src="https://github.com/user-attachments/assets/12fb059c-0f92-4fe3-912c-56ca259d3729" />

## Screenshots -<br>
### 1. Display <br>
![Screenshot 2025-01-10 213435](https://github.com/user-attachments/assets/7c589188-7fe2-444e-818e-b2b203fa8241)
### 2. Addition of lifts <br>
![Screenshot 2025-01-10 213649](https://github.com/user-attachments/assets/fdc0c6ed-6cb5-4279-b754-a62ea2aea3a9)
### 3. Set default position to lifts <br>
![Screenshot 2025-01-10 213712](https://github.com/user-attachments/assets/f5be1d41-42ef-4b89-94f7-bbd1252e8e09)
### 4. Choose lifts with current position <br>
![Screenshot 2025-01-10 213805](https://github.com/user-attachments/assets/285c2498-4620-4e1e-8bd8-081062a3eb45)
### 5. Choose lifts with upward or downward direction <br>
![Screenshot 2025-01-10 213852](https://github.com/user-attachments/assets/337b7fc4-e393-4ea3-9bcc-2cf904a7dd6a)
### 6. Restrict lift access <br>
![Screenshot 2025-01-10 214154](https://github.com/user-attachments/assets/8e0f080d-d00b-486b-8443-b6a641a7d166)
### 7. Choose lift with least stops <br>
![Screenshot 2025-01-10 214245](https://github.com/user-attachments/assets/606fd51c-e6ff-4f36-a03a-834ee1a2d5c2)
### 8. Set capacity <br>
![Screenshot 2025-01-10 214422](https://github.com/user-attachments/assets/a08f88b3-b2cb-4207-b5e9-20bbc551297a)
### 9. Block lift access <br>
![Screenshot 2025-01-10 214625](https://github.com/user-attachments/assets/3d581ad9-dd40-48bd-ae86-c3cd02633144)

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

