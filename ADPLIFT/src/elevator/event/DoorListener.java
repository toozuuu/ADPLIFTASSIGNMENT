package elevator.event;

public interface DoorListener {

  
   public void doorOpened( DoorEvent doorEvent );

   
   public void doorClosed( DoorEvent doorEvent );
}

