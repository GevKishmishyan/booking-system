
package com.epam.bookingsystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime bookedFrom;
    private LocalDateTime bookedTo;
    @NotNull
    @Column(name = "all_price")
    private BigDecimal price;
    @OneToMany
    @JoinColumn(name = "review_id")
    private List<Review> review;

}
