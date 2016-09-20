package org.proxy.rent;

/**
 * 出租人类
 * @author 尹兴
 *
 */
public class Renter implements RenterIFC {
	
	private double rentDeadLine;
	private double money;
	
	public Renter(double rentDeadLine, double money) {
		this.rentDeadLine = rentDeadLine;
		this.money = money;
	}

	@Override
	public boolean isAgree(double expectedRent) {
		return expectedRent - this.rentDeadLine >= 100;
	}

	public double getRentDeadLine() {
		return rentDeadLine;
	}

	@Override
	public void fetchRent(double rent) {
		money += rent;
	}
	
	public double getMoney() {
		return money;
	}
}
