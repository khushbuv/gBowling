package com.bowling.game;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bowling.game.score.BowlingScore;

public class RollTest {

	@Test
	public void test() {
		BowlingScore game = new BowlingScore();
		game.roll(10,0);
		game.roll(5,0);
		game.roll(5,1);
		game.roll(4,0);
		System.out.println(game.totalScore());
		assertEquals(game.totalScore(),38);
	}
	
	@Test
	public void test2() {
		BowlingScore game = new BowlingScore();
		game.roll(5,0);
		game.roll(5,1);
		game.roll(5,0);
		game.roll(4,1);
		System.out.println(game.totalScore());
		assertEquals(game.totalScore(),24);
	}
	
	@Test
	public void test3() {
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
	public void test4() {
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
	


}
