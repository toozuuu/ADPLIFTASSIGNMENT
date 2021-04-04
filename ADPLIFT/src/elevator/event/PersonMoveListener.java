package elevator.event;

public interface PersonMoveListener {

   
   public void personCreated( PersonMoveEvent moveEvent );

   
   public void personArrived( PersonMoveEvent moveEvent );

   
   public void personDeparted( PersonMoveEvent moveEvent );

  
   public void personPressedButton(
      PersonMoveEvent moveEvent );

   
   public void personEntered( PersonMoveEvent moveEvent );

  
   public void personExited( PersonMoveEvent moveEvent );
}

