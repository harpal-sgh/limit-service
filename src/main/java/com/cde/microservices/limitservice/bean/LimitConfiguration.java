package com.cde.microservices.limitservice.bean;

public class LimitConfiguration {
	
	private int maximum;
	private int minimun;
	
	public LimitConfiguration() {
		
	}

	public LimitConfiguration(int maximum, int minimun) {
		super();
		this.maximum = maximum;
		this.minimun = minimun;
	}
	
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getMinimun() {
		return minimun;
	}
	public void setMinimun(int minimun) {
		this.minimun = minimun;
	}

}
