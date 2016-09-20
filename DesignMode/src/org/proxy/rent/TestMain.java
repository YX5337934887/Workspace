package org.proxy.rent;

public class TestMain {

	public static void main(String[] args) {
		Renter renter = new Renter(2000, 10000);
		Deputy deputy = new Deputy();
		HouseMarket.registerRenter(deputy);
		deputy.registerRenter(renter);
		Tenant tenant = new Tenant(20000);
		tenant.rentHouse(1800);
		System.out.println("renter:"+renter.getMoney()+",tenant:"+tenant.getMoney());
		tenant.rentHouse(2300);
		System.out.println("renter:"+renter.getMoney()+",tenant:"+tenant.getMoney());
	}
}
