package org.example.Service;

import org.example.Entity.ConferenceRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookingService {
    public boolean bookRoom(ConferenceRoom room , int startTime , int endTime , String userId){
        return room.bookRoom(startTime,endTime,userId);
    }
    public boolean cancelBooking(ConferenceRoom room, int startTime, int endTime, String userId) {
        return room.cancelBooking(startTime, endTime, userId);
    }
    public List<String>getBookingByUser(ConferenceRoom room , String userId){
        List<String>userBookings = new ArrayList<>();
        for(Map.Entry<Integer,String>entry : room.getBookings().entrySet()){
            if(entry.getValue().equals(userId)){
                userBookings.add("Buildings: " + room.getBuildingName() + " , Floor: " + room.getRoomNumber()+", Room: "+room.getRoomNumber()+", slot: "+entry.getValue());
            }
        }
        return  userBookings;
    }

}
