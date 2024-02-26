package TConference.BackEnd.repository;

import TConference.BackEnd.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByName(String name);
    List<Room> findByCapacityGreaterThan(int capacity);
    List<Room> findByStatus(String status);
    boolean existsByName(String name);
}

