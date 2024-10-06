package com.hotela.Hotela.Repository;

import com.hotela.Hotela.Model.Hotels;
import com.hotela.Hotela.Model.RoomPrices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomPricesRepository extends JpaRepository<RoomPrices, Long> {
}
