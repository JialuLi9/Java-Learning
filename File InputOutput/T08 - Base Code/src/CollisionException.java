public class CollisionException extends Exception{
    MovableObject source;

//    public CollisionException() {
//        super("Player collided with wall !");
//    }
    public CollisionException(MovableObject s) {
        super(s + " collided with wall !");
        source = s;
    }


    }
