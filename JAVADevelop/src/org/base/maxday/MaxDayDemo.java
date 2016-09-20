package org.base.maxday;

public class MaxDayDemo {
	public static int maxDays(int year,int month){
		int maxDays=0;
		if(year<1900||year>2200) {
			System.out.println("请输入1900~2200之间的年份");
			return 0;
		}
		else if(month<0 ||month>12) {
			System.out.println("请输入1~12之间的月份");
			return 0;
		}
		else {
			/*if(year%4==0 && year % 100 != 0 ||year %400 == 0) {
				if(month==2) {
					maxDays=29;
				}
				else if(month==1 || month==3 || month==5 || month==7 || month==8||month==10||month==12){
					maxDays=31;
				}
				else {
					maxDays=30;
				}
			}
			else {
				if(month==2) {
					maxDays=28;
				}
				else if(month==1 || month==3 || month==5 || month==7 || month==8||month==10||month==12){
					maxDays=31;
				}
				else {
					maxDays=30;
				}
			}*/

			if(month==2) {
				if(year%4==0 && year % 100 != 0 ||year %400 == 0) {
					maxDays=29;
				}
				else {
					maxDays=28;
				}
			}
			else if(month==1 || month==3 || month==5 || month==7 || month==8||month==10||month==12){
				maxDays=31;
			}
			else {
				maxDays=30;
			}
		}
		return maxDays;
	}
	public static void main(String[] args) {
		int year = 2010;
		int month = 2;
		int maxDays = maxDays(year,month);
		System.out.println(year+"年"+month+"月的最大天数是："+maxDays);
	}
}
