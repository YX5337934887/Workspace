package org.proxy.rent;

import java.util.HashSet;
import java.util.Set;

/**
 * 房产市场类
 * @author 尹兴
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
