package br.com.meli.galaxy.model;

import java.awt.Dimension;
import java.util.List;

import br.com.meli.galaxy.model.inter.CelestialObject;

public class Galaxy {
	
	private List<CelestialObject> celestials;
	private Dimension dimension;
	
	
	public Galaxy() {
		super();
	}

	public Galaxy(List<CelestialObject> celestials, Dimension dimension) {
		super();
		this.celestials = celestials;
		this.dimension = dimension;
	}
	
	public List<CelestialObject> getCelestials() {
		return celestials;
	}
	public Dimension getDimension() {
		return dimension;
	}
	
}
