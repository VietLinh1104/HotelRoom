package com.hotela.Hotela.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "room_prices")
public class RoomPrices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rooms_id")
    private Rooms rooms;

    private Double price;
    private LocalDate date_start;
    private LocalDate date_end;

    public RoomPrices() {
    }

    public RoomPrices(Rooms rooms, Double price, LocalDate date_start, LocalDate date_end) {
        this.rooms = rooms;
        this.price = price;
        this.date_start = date_start;
        this.date_end = date_end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate_start() {
        return date_start;
    }

    public void setDate_start(LocalDate date_start) {
        this.date_start = date_start;
    }

    public LocalDate getDate_end() {
        return date_end;
    }

    public void setDate_end(LocalDate date_end) {
        this.date_end = date_end;
    }

    @Override
    public String toString() {
        return "RoomPrices{" +
                "id=" + id +
                ", rooms=" + rooms +
                ", price=" + price +
                ", date_start=" + date_start +
                ", date_end=" + date_end +
                '}';
    }
}
