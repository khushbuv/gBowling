package com.bowling.game.roll;

import org.springframework.stereotype.Component;

import com.bowling.game.Game;
import com.bowling.game.score.BowlingScore;

@Component
public class GameRoll {
	private int rollPerFrame = 0;
	private int pins = 0;
	private BowlingScore bowlingScore;
	private Game game;
	private int throwNumber = 0;
	

	public GameRoll() {
		bowlingScore = new BowlingScore();
		game = new Game();
	}

	public Game roll() {
		throwNumber++;
		if(throwNumber==21) {
			bowlingScore.reset();
			throwNumber=0;
			rollPerFrame=0;
		}

		if (rollPerFrame == 0) {
			pins = (int) (10 * Math.random());
			rollPerFrame++;
			if (pins == 10)
				rollPerFrame = 0;
			bowlingScore.roll(pins, rollPerFrame);
		} else {
			pins = (int) ((10 - pins) * Math.random());
			bowlingScore.roll(pins, rollPerFrame);
			rollPerFrame = 0;

		}
		

		game.setNumberOfPins(pins);
		game.setTotalscore(bowlingScore.totalScore());
		game.setRollnumber(throwNumber);
		return game;
	}
}
