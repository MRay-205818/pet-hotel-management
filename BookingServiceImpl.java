package com.pethotel.service;

import com.pethotel.entity.Pet;
import com.pethotel.core.AbstractAccommodation;
import com.pethotel.service.IBookingService;

public class BookingServiceImpl implements IBookingService {

    @Override
    public String bookAccommodation(Pet pet, AbstractAccommodation room, int days) {
        // 应对1万用户并发：此处需使用分布式锁（如 Redis）或数据库乐观锁
        synchronized (room) {
            if (!room.isAvailable()) {
                System.out.println("预订失败：房间已被占用！");
                return null;
            }

            // 锁定房间
            room.setOccupied(true);

            // 计算价格 (多态体现)
            double totalPrice = room.calculateTotalPrice(days);

            // 模拟生成订单
            String orderId = "ORD" + System.currentTimeMillis();
            System.out.println("预订成功！订单号: " + orderId +
                    " | 宠物: " + pet.getName() +
                    " | 总价: " + totalPrice + "元");

            return orderId;
        }
    }

    @Override
    public boolean cancelBooking(String orderId) {
        // 实现退订逻辑
        return true;
    }
}
