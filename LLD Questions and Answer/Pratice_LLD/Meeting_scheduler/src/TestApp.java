import models.Room;
import service.Scheduler;
import service.SchedulerImpl;

/*
notes : when ever you want to book, try to check the avaliablity -boolean
then book the room
 */

public class TestApp {
    public static void main(String[] args) {

        Scheduler scheduler = new SchedulerImpl();
        scheduler.addRoom("Atlas");
        scheduler.addRoom("Nexus");
        scheduler.addRoom("Holycow");

        System.out.println(scheduler.bookRoom(2, 5));
        System.out.println(scheduler.bookRoom(5, 8));   //Atlas
        System.out.println(scheduler.bookRoom(4, 8));    //Nexus
        System.out.println(scheduler.bookRoom(3, 6));   //Holycow
        System.out.println(scheduler.bookRoom(7, 8));    //Holycow
    }
}
