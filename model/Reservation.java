package TConference.BackEnd.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         
    private Long id;

    @ManyToOne
    private Room room;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDateTime startDate;

    private LocalTime startTimeEndTime;

    public Reservation() {

    }

    public Reservation(Room room, LocalDateTime startDate, LocalTime startTimeEndTime,User user) {
        this.room = room;
        this.startDate = startDate;
        this.startTimeEndTime = startTimeEndTime;
        this.user = user;
    }

    public  LocalDateTime getStartDate(){
        return startDate;

    }

    public  void setStartDate(LocalDateTime startDate){
        this.startDate = startDate;
    }
    public  LocalTime getStartTimeEndTime(){
        return startTimeEndTime;
    }
    public void setStartTimeEndTime(LocalTime startTimeEndTime){
        this.startTimeEndTime = startTimeEndTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


