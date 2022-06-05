package com.epam.bookingsystem.controllers;

import com.epam.bookingsystem.dao.JWTBlacklistDAO;
import com.epam.bookingsystem.model.Booking;
import com.epam.bookingsystem.model.Resort;
import com.epam.bookingsystem.model.ResortRegisterRequest;
import com.epam.bookingsystem.model.Room;
import com.epam.bookingsystem.repository.BookingRepository;
import com.epam.bookingsystem.repository.ResortRegisterRequestRepository;
import com.epam.bookingsystem.repository.ResortRepository;
import com.epam.bookingsystem.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    //todo to be removed
    @Autowired
    ResortRegisterRequestRepository resortRegisterRequestRepository;

    // todo to be removed
    @Autowired
    ResortRepository resortRepository;

    // todo to be removed
    @Autowired
    BookingRepository bookingRepository;

    // todo to be removed
    @Autowired
    RoomRepository roomRepository;

    final
    JWTBlacklistDAO jwtBlacklistDAO;

    public TestController(JWTBlacklistDAO jwtBlacklistDAO) {
        this.jwtBlacklistDAO = jwtBlacklistDAO;
    }

    /**
     * This URL is accessible to everyone, regardless of whether it is authenticated or not
     *
     * @return just a text "Public Content."
     */
    @GetMapping("/permit_all")
    public String permitAll() {
        log.info("permit all");
        return "Public Content.";
    }

    /**
     * Only users with the USER , MODERATOR and ADMIN roles have access to this URL
     *
     * @return just a text "User"
     */
    @GetMapping("/user")
    public String userAccess() {
        log.info("user access");
        return "User";
    }

    /**
     * Only users with the HOTEL_MANAGER , MODERATOR and ADMIN roles have access to this URL
     *
     * @return just a text "Moderator"
     */
    @GetMapping("/hotel_manager")
    public String hotelManagerAccess() {
        log.info("Hotel Manager access");
        return "Hotel Manager";
    }

    /**
     * Only users with the MODERATOR and ADMIN roles have access to this URL
     *
     * @return just a text "Moderator"
     */
    @GetMapping("/moderator")
    public String moderatorAccess() {
        log.info("Moderator access");
        return "Moderator";
    }

    /**
     * Only a user with role ADMIN has access to this URL
     *
     * @return just a text "Admin"
     */
    @GetMapping("/admin")
    public String adminAccess() {
        log.info("Admin access");
        return "Admin";
    }


    // todo to be removed
    @PostMapping("/addResort")
    public ResponseEntity<?> addResort(@RequestBody Resort resort) {
        System.out.println("saving resort");
        System.out.println("resort toString = " + resort);


        Room room = resort.getRoom().get(0);
        Booking booking = room.getBooking().get(0);

        Booking savedBooking = bookingRepository.save(booking);
        List<Booking> bookings = new ArrayList<>();
        bookings.add(savedBooking);
        room.setBooking(bookings);

        Room savedRoom = roomRepository.save(room);

        List<Room> rooms = new ArrayList<>();
        rooms.add(savedRoom);

        resort.setRoom(rooms);

        Resort savedResort = resortRepository.save(resort);

        ResortRegisterRequest resortRegisterRequest = new ResortRegisterRequest(savedResort);

        resortRegisterRequestRepository.save(resortRegisterRequest);

        return ResponseEntity.ok(savedResort);
    }

    //todo to be removed
    @GetMapping("/allResorts")
    public ResponseEntity<?> getAllResorts() {
        List<Resort> resortList = resortRepository.findAll();
        return ResponseEntity.ok(resortList);
    }


    //todo to be removed
    @GetMapping("/allRequests")
    public ResponseEntity<?> getAllRequests() {
        List<ResortRegisterRequest> requests = resortRegisterRequestRepository.findAll();
        return ResponseEntity.ok(requests);
    }


}
