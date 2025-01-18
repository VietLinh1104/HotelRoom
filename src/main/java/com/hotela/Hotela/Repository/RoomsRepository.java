package com.hotela.Hotela.Repository;


import com.hotela.Hotela.Model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomsRepository extends JpaRepository<Rooms, Long> {
    @Query("SELECT CASE WHEN COUNT(rm) > 0 THEN true ELSE false END " +
            "FROM Rooms rm " +
            "WHERE rm.room_type = :room_type " +
            "AND rm.detail = :detail")
    boolean existsByRoomDetails(@Param("room_type") String room_type,
                                @Param("detail") String detail);
}
