package Company.Amazon;

import java.util.*;

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
    public static Map<String, List<String>> favouriteGenres(Map<String, List<String>> userSongs,
                                                            Map<String, List<String>> songGenres) {
        Map<String, List<String>> favourites = new HashMap<>();
        // create a map sonts - genre
        Map<String, String> songToGenre = new HashMap<>();
        System.out.println(songGenres);
        for (Map.Entry<String, List<String>> e : songGenres.entrySet()) {
            // get each song
            String genre = e.getKey();
            List<String> songs = e.getValue();
            for (String song : songs) {
                songToGenre.put(song, e.getKey());
            }
        }
        System.out.println("SongToGenre");
        System.out.println(songToGenre);
        for (String user : userSongs.keySet()) {
            favourites.put(user, new LinkedList<String>());
            System.out.println(user);
            // get each user songs
            // create new hashmap of counts for each user
            HashMap<String, Integer> counts = new HashMap<>();
            List<String> uSongs = userSongs.getOrDefault(user, new LinkedList<String>());
            for (String song : uSongs) {
                // find it's genre
                String genre = songToGenre.get(song);
                if (counts.containsKey(genre)) {
                    counts.put(genre, counts.get(genre) + 1);
                } else {
                    counts.put(genre, 1);
                }
            }
            // at this point every user song has a count
            // find the max
            int max = 0;
            List favSongs = new LinkedList<>();
            for (Map.Entry<String, Integer> e : counts.entrySet()) {
                String gen = e.getKey();
                int count = e.getValue();
                if (count > max) {
                    max = count;
                }
                // find other entries that have that max
                // do not use else if, because you want the max already be incremented by now
                // and compare agains new max from prev line
                if (count == max && max != 0) {
                    favSongs.add(gen);
                }
            }
            favourites.put(user, favSongs);
        }

        return favourites;
    }

    public static void main(String[] args) {

        // ********* TEST CASE #1 ********************
        HashMap<String, List<String>> userSongs1 = new HashMap<>();
        List<String> songsDavid = new LinkedList<>();
        songsDavid.add("song5");
        songsDavid.add("song6");


        songsDavid.add("song1");
        songsDavid.add("song2");
        songsDavid.add("song3");
        songsDavid.add("song4");
        songsDavid.add("song8");

        // adding thind genre with freq 2
//        songsDavid.add("song5");
//        songsDavid.add("song6");
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
        songGenres.put("Rock", rock);
        songGenres.put("Dubstep", dub);
        songGenres.put("Techno", tech);
        songGenres.put("Pop", pop);
        songGenres.put("Jazz", jazz);

        /******** TEST CASE 2 *********************/
        HashMap<String, List<String>> userSongs2 = new HashMap<>();
        LinkedList<String> s1 = new LinkedList<>();
        LinkedList<String> s2 = new LinkedList<>();
        s1.add("song1");
        s1.add("song2");
        userSongs2.put("David", s1);
        s2.add("song3");
        s2.add("song4");
        userSongs2.put("Emma", s2);

        HashMap<String, List<String>> gens2Empty = new HashMap<>();
        HashMap<String, List<String>> userSongs3 = new HashMap<>();
        //System.out.println(favouriteGenres(userSongs1, songGenres));
        System.out.println(favouriteGenres(userSongs2, gens2Empty));

    }
}
