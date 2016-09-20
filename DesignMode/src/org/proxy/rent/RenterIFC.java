package org.proxy.rent;

public interface RenterIFC {
	public boolean isAgree(double expectedRent);
	public void fetchRent(double rent);
}
