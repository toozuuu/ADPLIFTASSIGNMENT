package elevator.event;


import elevator.model.*;

public class ElevatorMoveEvent extends ElevatorSimulationEvent {

  
   public ElevatorMoveEvent( Object source, Location location )
   {
      super( source, location );
   }
}


