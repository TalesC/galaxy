package br.com.meli.galaxy.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.Point;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MatrixUtilsTest {
	
	@Test
	void mustVerifyIfPointsAreCollinear() {
		var points = Arrays.asList(
				new Point(0, 0),
				new Point(1, 1),
				new Point(2, 2),
				new Point(3, 3)
			 );
		
		var isCollinear = MatrixUtils.isCollinear(points);
		
		assertThat(isCollinear).isTrue();
	}
	
	
	@Test
	void mustVerifyIfPointsNotAreCollinear() {
		var points = Arrays.asList(
				new Point(0, 1),
				new Point(-1, 0),
				new Point(1, 0)
			 );
		
		var isCollinear = MatrixUtils.isCollinear(points);
		
		assertThat(isCollinear).isFalse();
	}
	
}
