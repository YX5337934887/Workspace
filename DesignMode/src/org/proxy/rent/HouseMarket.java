package org.proxy.rent;

import java.util.HashSet;
import java.util.Set;

/**
 * �����г���
 * @author ����
 *
 */
public class HouseMarket {
	private static Set<RenterIFC> renters = new HashSet<RenterIFC>();
	
	public static void registerRenter(RenterIFC renter) {
		renters.add(renter);
	}
	
	public static RenterIFC findRenter() {
		return renters.iterator().next();
	}
}
