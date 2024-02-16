package org.example;

import org.example.Entity.ConferenceRoom;
import org.example.Repository.ConferenceRoomRepository;
import org.example.Service.BookingService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ConferenceRoomRepository conferenceRoomRepository = new ConferenceRoomRepository();
        conferenceRoomRepository.addConferenceRoom("Alpha",1,"room1");
        conferenceRoomRepository.addConferenceRoom("beta",1,"room2");
        conferenceRoomRepository.addConferenceRoom("gama",2,"room3");


        ConferenceRoom roomBook = conferenceRoomRepository.getConferenceRoomsByBuilding("Alpha").get(0);

        BookingService bookingService = new BookingService();

        bookingService.bookRoom(roomBook,10,11,"User1");
        bookingService.bookRoom(roomBook,11,12,"User2");

        bookingService.cancelBooking(roomBook,10,11,"user1");

        List<String>userBookings = bookingService.getBookingByUser(roomBook,"User1");
        System.out.println("Booking by User1 : ");;
        for(String booking : userBookings){
            System.out.println(booking);
        }

    }
}