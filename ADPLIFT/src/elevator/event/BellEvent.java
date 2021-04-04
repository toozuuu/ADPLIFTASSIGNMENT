package elevator.event;


import elevator.model.*;

public class BellEvent extends ElevatorSimulationEvent {


   public BellEvent( Object source, Location location )
   {
      super( source, location );
   }
}
