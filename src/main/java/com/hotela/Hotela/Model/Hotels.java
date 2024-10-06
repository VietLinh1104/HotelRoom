package com.hotela.Hotela.Model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "hotels")
public class Hotels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hotel_name" , nullable = false)
    private String hotel_name;

    private String phone_number;
    private String address;

    @OneToMany(mappedBy = "hotels")
    private Set<Rooms> rooms;

    public Hotels() {
    }

    public Hotels(String hotel_name, String phone_number, String address) {
        this.id = id;
        this.hotel_name = hotel_name;
        this.phone_number = phone_number;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "id=" + id +
                ", hotel_name='" + hotel_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
