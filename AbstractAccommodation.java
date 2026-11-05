package com.pethotel.core;

public class AbstractAccommodation {
    protected String roomId;
    protected String roomType;
    protected double basePricePerDay;
    protected boolean isOccupied;

    public AbstractAccommodation(String roomId, double basePricePerDay) {
        this.roomId = roomId;
        this.basePricePerDay = basePricePerDay;
        this.isOccupied = false;
    }

    // 抽象方法：计算总价，由子类具体实现（可能加收服务费）
    public double calculateTotalPrice(int days) {
        return 0;
    }

    public String getRoomId() { return roomId; }
    public boolean isAvailable() { return !isOccupied; }
    public void setOccupied(boolean occupied) { this.isOccupied = occupied; }
}
