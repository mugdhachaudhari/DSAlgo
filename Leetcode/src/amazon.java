import java.util.Set;
import java.util.*;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	// RETURN AN EMPTY SET IF NO SIMILAR MOVIE TO THE GIVEN MOVIE IS FOUND
	public Set<Movie> getMovieRecommendations(Movie movie, int N) {
		if (N == 0) {
			return new TreeSet<Movie>();
		}
		// WRITE YOUR CODE HERE
		PriorityQueue<Movie> pq = new PriorityQueue<Movie>(new MovieComparator());
		Queue<Movie> q = new LinkedList<Movie>();
		HashSet<Integer> st = new HashSet<Integer>();
		q.add(movie);
		st.add(movie.getId());

		while (!q.isEmpty()) {
			Movie m = q.remove();
			for (Movie sm : m.getSimilarMovies()) {
				if (pq.size() >= N) {
					if (pq.peek().getRating() < sm.getRating()) {
						pq.remove();
						pq.add(sm);
					}
				} else {
					pq.add(sm);
				}
				if (!st.contains(sm.getId())) {
					q.add(sm);
				}

			}
		}

		HashSet<Movie> res = new HashSet<Movie>();
		while (!pq.isEmpty()) {
			res.add(pq.remove());
		}
		return res;

	}
	// METHOD SIGNATURE ENDS
}

class MovieComparator implements Comparator<Movie> {

	public int compare(Movie m1, Movie m2) {
		return (new Float(m2.getRating())).compareTo(new Float(m1.getRating()));
	}
}