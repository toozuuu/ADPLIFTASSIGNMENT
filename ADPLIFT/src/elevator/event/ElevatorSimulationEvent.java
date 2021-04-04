package elevator.event;

import elevator.model.*;

public class ElevatorSimulationEvent {

   
   private Location location;
   
   
   private Object source;

   
   public ElevatorSimulationEvent(Object source, Location location)
   {
      setSource( source );
      setLocation( location );
   }


   public void setLocation( Location eventLocation )
   {
      location = eventLocation;
   }

   
   public Location getLocation()
   {
      return location;
   }

   
   private void setSource( Object eventSource )
   {
      source = eventSource;
   }

   
   public Object getSource()
   {
      return source;
   }
}


