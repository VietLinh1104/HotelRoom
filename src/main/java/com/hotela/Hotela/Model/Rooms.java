package com.hotela.Hotela.Model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "rooms")
public class Rooms {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotels_id")
    private Hotels hotels;

    @Column(name = "room_type" , nullable = false)
    private String room_type;

    private String detail;
    private int num_beds;
    private String type_bed;
    private int num_room;

    @OneToMany(mappedBy = "rooms")
    private Set<RoomPrices> roomPrices;

    public Rooms() {
    }

    public Rooms(Hotels hotels, String room_type, String detail, int num_beds, String type_bed, int num_room, Set<RoomPrices> roomPrices) {
        this.id = id;
        this.hotels = hotels;
        this.room_type = room_type;
        this.detail = detail;
        this.num_beds = num_beds;
        this.type_bed = type_bed;
        this.num_room = num_room;
        this.roomPrices = roomPrices;
    }

    public Hotels getHotels() {
        return hotels;
    }

    public void setHotels(Hotels hotels) {
        this.hotels = hotels;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getNum_beds() {
        return num_beds;
    }

    public void setNum_beds(int num_beds) {
        this.num_beds = num_beds;
    }

    public String getType_bed() {
        return type_bed;
    }

    public void setType_bed(String type_bed) {
        this.type_bed = type_bed;
    }

    public int getNum_room() {
        return num_room;
    }

    public void setNum_room(int num_room) {
        this.num_room = num_room;
    }

    public Set<RoomPrices> getRoomPrices() {
        return roomPrices;
    }

    public void setRoomPrices(Set<RoomPrices> roomPrices) {
        this.roomPrices = roomPrices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "id=" + id +
                ", hotels=" + hotels +
                ", room_type='" + room_type + '\'' +
                ", detail='" + detail + '\'' +
                ", num_beds=" + num_beds +
                ", type_bed='" + type_bed + '\'' +
                ", num_room=" + num_room +
                ", roomPrices=" + roomPrices +
                '}';
    }
}
