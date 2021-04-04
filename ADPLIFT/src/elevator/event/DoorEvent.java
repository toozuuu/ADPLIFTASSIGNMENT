package elevator.event;


import elevator.model.*;

public class DoorEvent extends ElevatorSimulationEvent {

   
   public DoorEvent( Object source, Location location )
   {
      super( source, location );
   }
}


 