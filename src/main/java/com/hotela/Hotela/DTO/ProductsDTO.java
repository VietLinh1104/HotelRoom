package com.hotela.Hotela.DTO;

import java.time.LocalDate;

public class ProductsDTO {
    private String room_type;
    private String detail;
    private int num_beds;
    private String type_bed;
    private int num_room;

    public ProductsDTO() {
    }

    public ProductsDTO(String room_type, String detail, int num_beds, String type_bed, int num_room) {
        this.room_type = room_type;
        this.detail = detail;
        this.num_beds = num_beds;
        this.type_bed = type_bed;
        this.num_room = num_room;
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

    @Override
    public String toString() {
        return "ProductsDTO{" +
                "room_type='" + room_type + '\'' +
                ", detail='" + detail + '\'' +
                ", num_beds=" + num_beds +
                ", type_bed='" + type_bed + '\'' +
                ", num_room=" + num_room +
                '}';
    }

    public static class roomPriceDTO{
        private Double price;
        private LocalDate date_start;
        private LocalDate date_end;

        public roomPriceDTO() {
        }

        public roomPriceDTO(Double price, LocalDate date_start, LocalDate date_end) {
            this.price = price;
            this.date_start = date_start;
            this.date_end = date_end;
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
            return "roomPriceDTO{" +
                    "price=" + price +
                    ", date_start=" + date_start +
                    ", date_end=" + date_end +
                    '}';
        }
    }
}
