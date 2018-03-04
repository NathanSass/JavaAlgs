import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by nathans on 1/26/18.
 */
public class MovieLengths {

    private boolean isWholeFlightMovies(int[] movies, int totalLength) {
        Set<Integer> movieHash = new HashSet<>();

        for (int movie : movies) {
            movieHash.add(movie);
            int remainder = totalLength - movie;
            if (movieHash.contains(remainder)) {
                return true;
            }
        }

        return false;
    }
}
