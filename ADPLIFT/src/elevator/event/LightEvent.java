package elevator.event;


import elevator.model.*;

public class LightEvent extends ElevatorSimulationEvent {

  
   public LightEvent( Object source, Location location )
   {
      super( source, location );
   }
}


