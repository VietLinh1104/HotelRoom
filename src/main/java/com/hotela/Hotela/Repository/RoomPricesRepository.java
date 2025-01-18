package com.hotela.Hotela.Repository;

import com.hotela.Hotela.Model.Hotels;
import com.hotela.Hotela.Model.RoomPrices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface RoomPricesRepository extends JpaRepository<RoomPrices, Long> {

}
