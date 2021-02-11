package com.macmak.hacker_rank;

import java.io.*;
import java.util.*;

/**
 * You are operating a restaurant.
 * People come and dine for reservation booked in advance.
 * Each reservation consists of a start and end time.
 * One table can hold only one reservation at a time and one table is sufficient to hold one reservation.
 * Find out the minimum number of reservation tables needed to accommodate all the reservations.
 * You have to implement the following method.
 * 
 * Sample Input:
 * 4
 * 5,10 0,20 25,40 35,45
 * 
 * 4
 * 5,45 0,10 20,30 40,50
 * 
 * Output:
 * 2
 */
/**
 * @author mayur.somani
 */
public class MinimumReservationTables {
	
//	4
//	5,10 0,20 25,40 35,45
//
//	[[0, 20], [5, 10], [25, 40], [35, 45]]
//
//	012345678901234567890123456789012345678901234567890
//
//	012345678901234567890
//	     567890
//		                     5678901234567890
//							           56789012345
//									   
//									   
//	s1 == s2	n++
//	e1 == e2	n++
//	e1 > e2		n++
//
//	s1 < s2	&& e1 < e2	-> n++
//	s1 < e2		???

	private static int calculateNumberOfTablesRequired(int[][] reservationStartEndTimes) {

		List<List<int[][]>> tables = new ArrayList<>();
		boolean shouldIBreak = false;
		
		for(int i = 0; i < reservationStartEndTimes.length; i++) {
			
			shouldIBreak = false;
			
			if(tables.isEmpty()) {
				List<int[][]> reservations = new ArrayList<>();
				int[][] time = new int[1][1];
				time[0] = reservationStartEndTimes[i];
				reservations.add(time);
				tables.add(reservations);
			} else {
				
				for(int j = 0; j < tables.size(); j++) {
					
					List<int[][]> reservations = tables.get(j);
					
					for(int k = 0; k < reservations.size(); k++) {
						
						int[][] time = reservations.get(k);
						
						for(int l = 0; l < time.length; l++) {
							
							if (!((reservationStartEndTimes[i][0] > time[l][0]
									&& reservationStartEndTimes[i][0] < time[l][1])
									|| (reservationStartEndTimes[i][1] > time[l][0]
											&& reservationStartEndTimes[i][1] < time[l][1]))) {
								
								// List<int[][]> newReservations = new ArrayList<>();
								int[][] newTime = new int[1][1];
								newTime[0] = reservationStartEndTimes[i];
								reservations.add(newTime);
								// tables.add(newReservations);
								
								// shouldIBreak = true;
								
							}
							
							if(shouldIBreak) {
								break;
							}
							
						}
						
						if(shouldIBreak) {
							break;
						}
						
					}
					
					if(shouldIBreak) {
						break;
					}
					
				}
				
			}
			
		}
		
		return tables.size();
		
	}

	private static void sortInAscendingOrderOfStartTime(int[][] reservationStartEndTimes) {
		for (int i = 1; i < reservationStartEndTimes.length; i++) {

			for (int j = 0; j < i; j++) {

				if (reservationStartEndTimes[i][0] < reservationStartEndTimes[j][0]) {

					int temp = reservationStartEndTimes[i][0];
					reservationStartEndTimes[i][0] = reservationStartEndTimes[j][0];
					reservationStartEndTimes[j][0] = temp;

					temp = reservationStartEndTimes[i][1];
					reservationStartEndTimes[i][1] = reservationStartEndTimes[j][1];
					reservationStartEndTimes[j][1] = temp;

				}

			}
		}
	}
	
	static int minReservationTables(int[][] reservationStartEndTimes) {

		int numberOfTablesRequired = 0;

		sortInAscendingOrderOfStartTime(reservationStartEndTimes);

		return calculateNumberOfTablesRequired(reservationStartEndTimes);
		
	}

	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] reservationStartEndTimeList = new int[n][2];
		String[] reservationStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] reservationStartEndTime = reservationStartEndTimes[i].split(",");
			for (int j = 0; j < reservationStartEndTime.length; j++) {
				reservationStartEndTimeList[i][j] = Integer.parseInt(reservationStartEndTime[j]);
			}
		}

		int out = minReservationTables(reservationStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}
}