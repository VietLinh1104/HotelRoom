package com.hotela.Hotela.Service;

import com.hotela.Hotela.DTO.ProductsDTO;
import com.hotela.Hotela.Model.Hotels;
import com.hotela.Hotela.Model.Response;
import com.hotela.Hotela.Model.RoomPrices;
import com.hotela.Hotela.Model.Rooms;
import com.hotela.Hotela.Repository.HotelsRepository;
import com.hotela.Hotela.Repository.RoomPricesRepository;
import com.hotela.Hotela.Repository.RoomsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    private RoomsRepository roomRepository;
    @Autowired
    private RoomPricesRepository roomPriceRepository;
    @Autowired
    private HotelsRepository hotelRepository;

//    save data
    public Response saveData(Long hotelId, List<ProductsDTO> rooms) {
        Response res;
        Hotels hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        for (ProductsDTO roomDTO : rooms) {
//             Kiểm tra trùng lặp phòng
            if (roomRepository.existsByRoomDetails(roomDTO.getRoom_type(), roomDTO.getDetail())) {
                return res = new Response("exists", "Phòng đã tồn tại, bỏ qua.", null);
            }

            Rooms room = new Rooms();
            room.setHotels(hotel);
            room.setRoom_type(roomDTO.getRoom_type());
            room.setDetail(roomDTO.getDetail());
            room.setNum_beds(roomDTO.getNum_beds());
            room.setType_bed(roomDTO.getType_bed());
            room.setNum_room(roomDTO.getNum_room());
            try {
                roomRepository.save(room);

            } catch (Exception e) {
                return res = new Response("err", "Error: " + e, room.getHotels());
            }


            for (ProductsDTO.roomPriceDTO priceDTO : roomDTO.getPrices()){
                RoomPrices roomPr = new RoomPrices();
                roomPr.setRooms(room);
                roomPr.setPrice(priceDTO.getPrice());
                roomPr.setDate_start(priceDTO.getDate_start());
                roomPr.setDate_end(priceDTO.getDate_end());
                roomPriceRepository.save(roomPr);

            }


        }
        return res = new Response("ok", "Luu thanh cong", null);
    }

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> getRoomDetails() {
        String jpql = "SELECT h.hotel_name, r.room_type, r.detail, r.num_beds, r.type_bed, pr.price " +
                "FROM Hotels h " +
                "JOIN h.rooms r " +
                "JOIN r.roomPrices pr";

        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    public List<Object[]> getRoomDetailsByDateRange(LocalDate startDate, LocalDate endDate) {
        String jpql = "SELECT h.hotel_name, r.room_type, r.detail, r.num_beds, r.type_bed, pr.price " +
                "FROM Hotels h " +
                "JOIN h.rooms r " +
                "JOIN r.roomPrices pr " +
                "WHERE pr.date_start <= :endDate " +
                "AND pr.date_end >= :startDate "+
                "AND :endDate >= :startDate";

        return entityManager.createQuery(jpql, Object[].class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }


}

