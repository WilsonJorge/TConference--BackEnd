package TConference.BackEnd.service;
import TConference.BackEnd.model.Reservation;
import TConference.BackEnd.model.Room;
import TConference.BackEnd.model.User;
import TConference.BackEnd.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomService roomService;
    private final UserService userService;
    @Autowired
    public ReservationService(ReservationRepository reservationRepository, RoomService roomService, UserService userService) {
        this.reservationRepository = reservationRepository;
        this.roomService = roomService;
        this.userService = userService;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId).orElse(null);
    }

    public Reservation createReservation(Reservation reservation) {

        Room room = roomService.getRoomById(reservation.getRoom().getId());
        if (room == null) {
            throw new IllegalArgumentException("Room with id " + reservation.getRoom().getId() + " not found.");
        }

        User user = userService.getUserById(reservation.getUser().getId());
        if (user == null) {
            throw new IllegalArgumentException("User with id " + reservation.getUser().getId() + " not found.");
        }
        reservation.setRoom(room);
        reservation.setUser(user);

        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long reservationId, Reservation updatedReservation) {
        Reservation existingReservation = reservationRepository.findById(reservationId).orElse(null);

        if (existingReservation != null) {
            existingReservation.setStartDate(updatedReservation.getStartDate());
            existingReservation.setStartTimeEndTime(updatedReservation.getStartTimeEndTime());

            return reservationRepository.save(existingReservation);
        }

        return null;
    }

    public boolean deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
        return false;
    }
}
