package com.bowling.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bowling.game.roll.GameRoll;

@Controller
public class BowlingGameController {

	@Autowired
	GameRoll gameRoll;

	@GetMapping("/roll")
	public ResponseEntity Roll() {
		return ResponseEntity.ok(gameRoll.roll());
	}

}