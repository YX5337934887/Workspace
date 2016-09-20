package org.proxy.rent;

/**
 * ��������
 * @author ����
 *
 */
public class Deputy implements RenterIFC {
	
	private Renter renter;
	
	public void registerRenter(Renter renter) {
		this.renter = renter;
	}

	@Override
	public boolean isAgree(double expectedRent) {
		if(expectedRent < renter.getRentDeadLine()) return false;
		return renter.isAgree(expectedRent);
	}

	@Override
	public void fetchRent(double rent) {
		renter.fetchRent(rent);
	}
}
