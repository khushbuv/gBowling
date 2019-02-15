package com.bowling.game.score;

public class BowlingScore {

	private int[] pinsDown = new int[21];
	private int presentRoll = 0;

	private int totalScore = 0;
	
	public void reset() {
		presentRoll=0;
		totalScore = 0;
	}

	public int roll(int pins, int rollPerFrame) {

		if (presentRoll < 21) {

			pinsDown[presentRoll] = pins;

		} else
			return 0;
		updateScore(rollPerFrame);
		presentRoll++;
		return pins;
	}

	public void updateScore(int rollPerFrame) {
		if (isStrike(presentRoll)) {
			totalScore += 10;
			if (presentRoll > 0 && isStrike(presentRoll - 1)) {
				totalScore += pinsDown[presentRoll];
			} else if (presentRoll > 1 && isStrike(presentRoll - 2))
				totalScore += 2 * pinsDown[presentRoll];

		} else if (presentRoll > 0) {
			if (isStrike(presentRoll - 1)) {
				totalScore += 2 * pinsDown[presentRoll];
			} else if (presentRoll > 1 && isStrike(presentRoll - 2))
				totalScore += 2 * pinsDown[presentRoll];
			else if (isSpare(presentRoll - 1) && rollPerFrame == 0) {
				totalScore += 2 * pinsDown[presentRoll];
			} else {
				totalScore += pinsDown[presentRoll];
			}
		} else {
			totalScore += pinsDown[presentRoll];
		}

	}

	public int totalScore() {
		return totalScore;
	}

	private boolean isSpare(int pr) {
		if (pr >= 1)
			return pinsDown[pr] + pinsDown[pr - 1] == 10;
		return false;
	}

	private boolean isStrike(int pr) {
		return pinsDown[pr] == 10;
	}

}
