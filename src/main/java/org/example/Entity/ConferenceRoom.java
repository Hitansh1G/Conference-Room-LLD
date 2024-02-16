package org.example.Entity;

import java.util.HashMap;
import java.util.Map;

public class ConferenceRoom {
    private String buildingName;
    private int floorNumber;
    private String roomNumber;
    private Map<Integer,String> bookings;

    public ConferenceRoom(String buildingName, int floorNumber, String roomNumber) {
        this.buildingName = buildingName;
        this.floorNumber = floorNumber;
        this.roomNumber = roomNumber;
        this.bookings = new HashMap<>();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Map<Integer, String> getBookings() {
        return bookings;
    }

    public void setBookings(Map<Integer, String> bookings) {
        this.bookings = bookings;
    }

    public boolean isSlotAvailable(int startTime, int endTime){
        for(int i=startTime ; i<endTime;i++){
            if(bookings.containsKey(i)){
                return false;
            }
        }
        return true;
    }

    public boolean bookRoom(int startTime, int endTime, String userId){
        if(!isSlotAvailable(startTime,endTime)) return false;
        for(int i=startTime;i<endTime;i++){
            bookings.put(i,userId);
        }
        return true;
    }

    public boolean cancelBooking(int startTime , int endTime , String userId){
        for(int i=startTime;i<endTime;i++){
            if(bookings.containsKey(i) && bookings.get(i).equals(userId))bookings.remove(i);
        }
        return true;
    }
}
