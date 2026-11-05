package com.pethotel.core;

public class StandardRoom extends AbstractAccommodation {
    public StandardRoom(String roomId, double basePricePerDay) {
        super(roomId, basePricePerDay);
        this.roomType = "标准笼舍";
    }

    @Override
    public double calculateTotalPrice(int days) {
        return this.basePricePerDay * days;
    }
}
