package com.hotela.Hotela.Repository;

import com.hotela.Hotela.Model.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HotelsRepository extends JpaRepository<Hotels, Long> {

    @Query("SELECT CASE WHEN COUNT(ht) > 0 THEN true ELSE false END " +
            "FROM Hotels ht " +
            "WHERE ht.id = :hotelID " +
            "AND ht.hotel_name = :hotelName " +
            "AND ht.phone_number = :phoneNum " +
            "AND ht.address = :address")
    boolean existsByHotelDetails(@Param("hotelID") Long hotelID,
                                 @Param("hotelName") String hotelName,
                                 @Param("phoneNum") String phoneNum,
                                 @Param("address") String address);


}
