package com.hotela.Hotela.Controllers;

import com.hotela.Hotela.Model.Hotels;
import com.hotela.Hotela.Model.Response;
import com.hotela.Hotela.Repository.HotelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {

    @Autowired
    private HotelsRepository hotelRepo;

    @PostMapping("add-hotel")
    ResponseEntity<Response> addHotel(@RequestBody Hotels hotel){
        try {
            Boolean existsHT = hotelRepo.existsByHotelDetails(hotel.getId(),hotel.getHotel_name(),hotel.getPhone_number(),hotel.getAddress());
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

}
