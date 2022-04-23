package com.epam.bookingsystem.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

	@GetMapping("/permit_all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	public String userAccess() {
		return "User";
	}

	@GetMapping("/hotel_manager")
	public String hotelManagerAccess() {
		return "Hotel Manager";
	}

	@GetMapping("/moderator")
	public String moderatorAccess() {
		return "Moderator";
	}

	@GetMapping("/admin")
	public String adminAccess() {
		return "Admin";
	}
//

}
