package org.example.Repository;

import org.example.Entity.ConferenceRoom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConferenceRoomRepository {
    private Map<String, List<ConferenceRoom>>buildingRooms;

    public ConferenceRoomRepository() {
        this.buildingRooms = new HashMap<>();
    }

    public void addConferenceRoom(String buildingName , int floorNumber , String roomNumber){
        ConferenceRoom room = new ConferenceRoom(buildingName , floorNumber, roomNumber);
        if(!buildingRooms.containsKey(buildingName)){
            buildingRooms.put(buildingName , new ArrayList<>());
        }
        buildingRooms.get(buildingName).add(room);
    }

    public List<ConferenceRoom>getConferenceRoomsByBuilding(String buildingName){
        return buildingRooms.getOrDefault(buildingName,new ArrayList<>());
    }
}
