package com.macmak.hacker_rank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Write a class to report rating statistics of apps, given a feed of app ratings. 
 * You need to implement the following interface
 * Sample Input:
 * 1
 * Gmail 2,Facebook 3,Gmail 4,Facebook 5,Gmail 7
 */
/**
 * @author mayur.somani
 */
public class RatingStatisticsOfApps {
	public static class RatingStatisticsCollectorImpl implements RatingStatisticsCollector {
		
		Map<String, List<Integer>> map = new HashMap<>();
		
		@Override
		public void putNewRating(String app, int rating) {
			// YOUR CODE HERE
			List<Integer> list = null;
			if(map.get(app) != null) {
				list = map.get(app);
				// addition of all rating
				list.set(0, list.get(0) + rating);
				// count
				list.set(1, list.get(1) + 1);
			} else {
				list = new ArrayList<>(2);
				// addition of all rating
				list.add(rating);
				// count
				list.add(1);
				map.put(app, list);
			}
		}

		@Override
		public double getAverageRating(String app) {
			double d = ((double)map.get(app).get(0) / map.get(app).get(1));
			BigDecimal bd = BigDecimal.valueOf(d);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			return bd.doubleValue();
		}

		@Override
		public int getRatingsCount(String app) {
			return map.get(app).get(1);
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface RatingStatisticsCollector {
		// Ratings feed will call this method when new app rating information is
		// received. This is input to your class. ratings is a non negative integer
		// between 0 to 10.
		public void putNewRating(String app, int rating);

		// Report the average rating of the app.
		public double getAverageRating(String app);

		// Report the total number of rating for an app.
		public int getRatingsCount(String app);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numLines = Integer.parseInt(scanner.nextLine());
		int currentLine = 0;
		while (currentLine++ < numLines) {
			final RatingStatisticsCollector stats = new RatingStatisticsCollectorImpl();
			final Set<String> apps = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			for (int i = 0; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String app = tokens[0];
				apps.add(app);
				final int runs = Integer.parseInt(tokens[1]);

				stats.putNewRating(app, runs);

			}

			for (String app : apps) {
				System.out.println(
						String.format("%s %.2f %d", app, stats.getAverageRating(app), stats.getRatingsCount(app)));
			}

		}
		scanner.close();

	}
}