package com.epam.bookingsystem.model;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name = "room_pictures")
public class RoomPictures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String picUrl;
    @ManyToOne
    private ResortNumber resortNumber;
}
