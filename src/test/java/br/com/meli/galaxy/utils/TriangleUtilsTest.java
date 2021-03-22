package br.com.meli.galaxy.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TriangleUtilsTest {
	
	@Test
	void mustVerifyIfATriangleContainsAPoint() {
		var vertices = generatePoints();
		var point = new Point(0,0);
		
		var contains = TriangleUtils.contains(vertices, point);
		assertThat(contains).isTrue();
	}
	
	@Test
	void mustVerifyIfATriangleNotContainsAPoint() {
		var vertices = generatePoints();
		var point = new Point(10,10);
		
		var contains = TriangleUtils.contains(vertices, point);
		assertThat(contains).isFalse();
	}
	
		
	private List<Point> generatePoints(){
		return Arrays.asList(
						new Point(0, 1),
						new Point(-1, -1),
						new Point(1, -1)
					 );
	}

}
