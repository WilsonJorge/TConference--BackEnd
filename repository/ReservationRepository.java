package TConference.BackEnd.repository;
import TConference.BackEnd.model.Reservation;
import TConference.BackEnd.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByRoom(Room room);

    List<Reservation> findByStartTimeEndTime(LocalTime startTimeEndTime);

}

