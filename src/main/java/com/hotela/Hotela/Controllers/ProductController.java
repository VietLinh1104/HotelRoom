package com.hotela.Hotela.Controllers;

import com.hotela.Hotela.DTO.ProductsDTO;
import com.hotela.Hotela.Model.Hotels;
import com.hotela.Hotela.Model.Response;
import com.hotela.Hotela.Model.Rooms;
import com.hotela.Hotela.Repository.HotelsRepository;
import com.hotela.Hotela.Repository.RoomPricesRepository;
import com.hotela.Hotela.Repository.RoomsRepository;
import com.hotela.Hotela.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {

    @Autowired
    private HotelsRepository hotelRepo;

    @Autowired
    private RoomsRepository roomsRepo;

    @Autowired
    private RoomPricesRepository roomPrRepo;

    @Autowired
    private ProductService roomService;


    @PostMapping("add-hotel")
    ResponseEntity<Response> addHotel(@RequestBody Hotels hotel){
        try {
            Boolean existsHT = hotelRepo.existsByHotelDetails(hotel.getHotel_name(),hotel.getPhone_number(),hotel.getAddress());
            if(existsHT){
                Response res = new Response("data exists","Dữ liệu trùng lặp :"+ hotel.getHotel_name(), hotel);
                return ResponseEntity.status(409).body(res);
            }
            hotelRepo.save(hotel);
            Response res = new Response("ok","Lưu thành công :"+ hotel.getHotel_name(), existsHT);
            return ResponseEntity.ok(res);

        } catch (Exception e) {
            Response res = new Response("500", "Lỗi: "+e.getMessage(),hotel);
            return ResponseEntity.status(500).body(res);
        }
    }

    @PostMapping("/{hotelId}/rooms")
    ResponseEntity<Response> importRoomData(@PathVariable Long hotelId, @RequestBody List<ProductsDTO> rooms) {
        Response res = roomService.saveData(hotelId, rooms);
        if(res.getStatus() == "ok"){
            return ResponseEntity.ok(res);
        }else{
            return ResponseEntity.status(500).body(res);
        }

    }

    @GetMapping("/details")
    public List<Object[]> getRoomDetails() {
        return roomService.getRoomDetails();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getroombydate")
    public List<Object[]> getRoomByDate(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
            ){
        return roomService.getRoomDetailsByDateRange(startDate,endDate);
    }




}
