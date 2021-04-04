package elevator.event;


import elevator.model.*;

public class ButtonEvent extends ElevatorSimulationEvent {


   public ButtonEvent( Object source, Location location )
   {
      super( source, location );
   }
}

