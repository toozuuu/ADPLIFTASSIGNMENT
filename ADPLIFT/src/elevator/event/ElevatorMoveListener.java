package elevator.event;

public interface ElevatorMoveListener {

  
   public void elevatorDeparted( ElevatorMoveEvent moveEvent );

 
   public void elevatorArrived( ElevatorMoveEvent moveEvent );
}


 