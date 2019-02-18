package com.bowling.game;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bowling.game.score.BowlingScore;

public class RollTest {

	@Test
	public void oneStrikeTest() {
		BowlingScore game = new BowlingScore();
		game.roll(10,0);
		game.roll(5,0);
		game.roll(5,1);
		game.roll(4,0);
		System.out.println(game.totalScore());
		assertEquals(game.totalScore(),38);
	}
	
	@Test
	public void oneSpareTest() {
		BowlingScore game = new BowlingScore();
		game.roll(5,0);
		game.roll(5,1);
		game.roll(5,0);
		game.roll(4,1);
		System.out.println(game.totalScore());
		assertEquals(game.totalScore(),24);
	}
	
	@Test
	public void strikeAndSpareTest() {
		BowlingScore game = new BowlingScore();
		game.roll(5,0);
		game.roll(1,1);
		game.roll(10,0);
		game.roll(4,0);
		game.roll(6,1);
		game.roll(5,0);
		System.out.println(game.totalScore());
		assertEquals(game.totalScore(),46);
	}
	
	@Test
	public void noStrikeNoSpareTest() {
		BowlingScore game = new BowlingScore();
		game.roll(5,0);
		game.roll(1,1);
		game.roll(7,0);
		game.roll(4,1);
		game.roll(9,0);
		game.roll(5,1);
		System.out.println(game.totalScore());
		assertEquals(game.totalScore(),31);
	}
	
	@Test
	public void perfectGameTest() {
		BowlingScore game = new BowlingScore();
		game.roll(10,0);
		game.roll(10,0);
		game.roll(10,0);
		game.roll(10,0);
		game.roll(10,0);
		game.roll(10,0);
		game.roll(10,0);
		game.roll(10,0);
		game.roll(10,0);
		game.roll(10,0);
		game.roll(10,0);
		game.roll(10,0);
		System.out.println(game.totalScore());
		assertEquals(game.totalScore(),300);
	}
	
	@Test
	public void allSpareTest() {
		BowlingScore game = new BowlingScore();
		game.roll(5, 0);
		game.roll(5, 1);
		game.roll(4, 0);
		game.roll(6, 1);
		game.roll(7, 0);
		game.roll(3, 1);
		game.roll(1, 0);
		game.roll(9, 1);
		game.roll(2, 0);
		game.roll(8, 1);
		game.roll(3, 0);
		game.roll(7, 1);
		game.roll(5, 0);
		game.roll(5, 1);
		game.roll(6, 0);
		game.roll(4, 1);
		game.roll(7, 0);
		game.roll(3, 1);
		game.roll(1, 0);
		game.roll(9, 1);
		game.roll(5, 0);
		System.out.println(game.totalScore());
		assertEquals(game.totalScore(), 141);
	}
	
	@Test
	public void moreThan21RollsTest() {
		BowlingScore game = new BowlingScore();
		game.roll(5, 0);
		game.roll(5, 1);
		game.roll(4, 0);
		game.roll(6, 1);
		game.roll(7, 0);
		game.roll(3, 1);
		game.roll(1, 0);
		game.roll(9, 1);
		game.roll(2, 0);
		game.roll(8, 1);
		game.roll(3, 0);
		game.roll(7, 1);
		game.roll(5, 0);
		game.roll(5, 1);
		game.roll(6, 0);
		game.roll(4, 1);
		game.roll(7, 0);
		game.roll(3, 1);
		game.roll(1, 0);
		game.roll(9, 1);
		game.roll(5, 0);
		game.roll(5, 1);
		game.roll(5, 0);
		game.roll(5, 1);
		System.out.println(game.totalScore());
		assertEquals(game.totalScore(), 141);
	}

	
	


}
