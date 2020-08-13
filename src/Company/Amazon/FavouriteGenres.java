package Company.Amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user has listened to as values.
 * <p>
 * Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within that genre as values. The song can only belong to only one genre.
 * <p>
 * The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list of the user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * userSongs = {
 * "David": ["song1", "song2", "song3", "song4", "song8"],
 * "Emma":  ["song5", "song6", "song7"]
 * },
 * songGenres = {
 * "Rock":    ["song1", "song3"],
 * "Dubstep": ["song7"],
 * "Techno":  ["song2", "song4"],
 * "Pop":     ["song5", "song6"],
 * "Jazz":    ["song8", "song9"]
 * }
 * <p>
 * Output: {
 * "David": ["Rock", "Techno"],
 * "Emma":  ["Pop"]
 * }
 * <p>
 * Explanation:
 * David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
 * Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * userSongs = {
 * "David": ["song1", "song2"],
 * "Emma":  ["song3", "song4"]
 * },
 * songGenres = {}
 * <p>
 * Output: {
 * "David": [],
 * "Emma":  []
 * }
 */
public class FavouriteGenres {

    // have a map - song to genre
    // than for each song in user songs -
    // count how many genres he listens

    public static void main(String[] args) {
        HashMap<String, List<String>> userSongs1 = new HashMap<>();
        List<String> songsDavid = new LinkedList<>();
        songsDavid.add("song1");
        songsDavid.add("song2");
        songsDavid.add("song3");
        songsDavid.add("song4");
        songsDavid.add("song8");
        List<String> songsEmma = new LinkedList<>();
        songsEmma.add("song5");
        songsEmma.add("song6");
        songsEmma.add("song7");
        userSongs1.put("David", songsDavid);
        userSongs1.put("Emma", songsEmma);

        HashMap<String, List<String>> songGenres = new HashMap<>();
        List<String> rock = new LinkedList<>();
        List<String> dub = new LinkedList<>();
        List<String> tech = new LinkedList<>();
        List<String> pop = new LinkedList<>();
        List<String> jazz = new LinkedList<>();
        rock.add("song1");
        rock.add("song3");

        dub.add("song7");

        tech.add("song2");
        tech.add("song4");

        pop.add("song5");
        pop.add("song6");

        jazz.add("song8");
        jazz.add("song9");

        HashMap<String, List<String>> userSongs2 = new HashMap<>();

        HashMap<String, List<String>> userSongs3 = new HashMap<>();

    }
}
