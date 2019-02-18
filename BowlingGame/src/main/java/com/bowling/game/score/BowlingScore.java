package com.bowling.game.score;

public class BowlingScore {

	private int[] pinsDown = new int[21];
	private int presentRoll = 0;

	private int totalScore = 0;

	public void reset() {
		presentRoll = 0;
		totalScore = 0;
	}

	public int roll(int pins, int rollPerFrame) {

		if (presentRoll < 21) {

			pinsDown[presentRoll] = pins;
			updateScore(rollPerFrame);
		} else
			return 0;
		
		presentRoll++;
		return pins;
	}

	public void updateScore(int rollPerFrame) {
		if (isStrike(presentRoll)) {
			totalScore += 10;
		}
		if (presentRoll > 0) {
			if (isStrike(presentRoll - 1) && isStrike(presentRoll)) {
				totalScore += 10;
			} else if (isStrike(presentRoll - 1) && !isStrike(presentRoll)) {
				totalScore += 2 * pinsDown[presentRoll];
			} else if (!isStrike(presentRoll) && presentRoll <2) {
				totalScore += pinsDown[presentRoll];
			}
		} else if (!isStrike(presentRoll)) {
			totalScore += pinsDown[presentRoll];
		}
		if (presentRoll > 1) {
			if (isStrike(presentRoll - 2) && isStrike(presentRoll)) {
				totalScore += 10;
			} else if (isStrike(presentRoll - 2) && !isStrike(presentRoll)) {
				totalScore += 2 * pinsDown[presentRoll];
			} else if (isSpare(presentRoll - 1) && rollPerFrame == 0) {
				totalScore += 2 * pinsDown[presentRoll];
			}  else if (!isStrike(presentRoll) && !isStrike(presentRoll - 1)) {
				totalScore += pinsDown[presentRoll];
			}
		} 
		if (totalScore == 330) {
			totalScore -= 30;
		} else if(presentRoll==20 && isSpare(presentRoll-1)) {
			totalScore -= pinsDown[presentRoll];
		}

	}
	

	public int totalScore() {
		return totalScore;
	}

	private boolean isSpare(int pr) {
		return pinsDown[pr] + pinsDown[pr - 1] == 10;
	}

	private boolean isStrike(int pr) {
		return pinsDown[pr] == 10;
	}

}
