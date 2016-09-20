package org.proxy.rent;

/**
 * ×âÁŞÈËÀà
 * @author ÒüĞË
 *
 */
public class Tenant {
	private double money;
	public Tenant(double money) {
		this.money = money;
	}
	
	public boolean rentHouse(double expectedRent) {
		RenterIFC renter = HouseMarket.findRenter();
		if(!renter.isAgree(expectedRent)) return false;
		money -= expectedRent;
		renter.fetchRent(expectedRent);
		return true;
	}
	
	public double getMoney() {
		return money;
	}
}
