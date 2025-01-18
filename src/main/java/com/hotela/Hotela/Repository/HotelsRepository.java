package com.hotela.Hotela.Repository;

import com.hotela.Hotela.Model.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HotelsRepository extends JpaRepository<Hotels, Long> {

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END " +
            "FROM Hotels ht " +
            "WHERE ht.hotel_name = :hotelName " +
            "AND ht.phone_number = :phoneNum " +
            "AND ht.address = :address"
    )
    boolean existsByHotelDetails(@Param("hotelName") String hotelName,
                                 @Param("phoneNum") String phoneNum,
                                 @Param("address") String address);

}
