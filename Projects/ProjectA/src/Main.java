import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

class Artist {
    public int ID;
    public String Name;

    public Artist(int ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }
}

class Song {
    public int ID;
    public String Name;
    public Artist Artist;
    public int Plays;

    public Song(int id, String name, Artist artist, int plays) {
        this.ID = id;
        this.Name = name;
        this.Artist = artist;
        this.Plays = plays;
    }

    public void ListDetails() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + Name);
        System.out.println("Artist: " + Artist.Name + " (ID: " + Artist.ID + ")"); // Obtain the artist's name and ID
        System.out.println("Play Count: " + Formatter.Number(Plays)); // Call the main class's format function
    }
}

/*class User {
    public int ID;
    public ArrayList<Song> Playlist = new ArrayList<>();

    public User(int ID) {
        this.ID = ID;
    }

    public void AddSong(Song song) {
        Playlist.add(song);
    }

    public void RemoveSong(Song song) {
        if (!Playlist.contains(song)) {
            System.out.println(Colours.RED_BACKGROUND + "[ERR] User " + ID + " does not have this song stored in their playlist!" + Colours.ANSI_RESET);
            return;
        }

        Playlist.remove(song);
    }

    public void ShowPlaylist() {
        if (Playlist.isEmpty()) {
            System.out.println(Colours.RED_BACKGROUND + "[ERR] User " + ID + "'s playlist is empty!" + Colours.ANSI_RESET);
            return;
        }

        System.out.println("Playlist for user " + ID);

        for (Song song : Playlist) {
            song.ListDetails();
            System.out.println();
        }
    }
}*/

class Colours {
    // Colours
    public static final String ANSI_RESET = "\u001B[0m"; // Reset any colouring
    public static final String RED_BACKGROUND = "\u001B[41m"; // Display a red background on console text
}

class Formatter {
    // Formatting for Large Numbers
    public static String Number(int toFormat) {
        DecimalFormat newFormat = new DecimalFormat("###,###");
        return newFormat.format(toFormat);
    }
}

class PlaylistTest {
    public List<Artist> Artists = new ArrayList<>();
    public List<Song> Songs = new ArrayList<>();

    // Generate Sample Data Functions
    public void GenerateSampleSongs() {
        if (Artists.isEmpty()) {GenerateSampleArtists();}

        Songs.add(new Song(1, "Test1", Artists.get(0), 1000));
        Songs.add(new Song(1, "Test2", Artists.get(0), 1000));
        Songs.add(new Song(1, "Test3", Artists.get(1), 1000));
        Songs.add(new Song(1, "Test4", Artists.get(1), 1000));
        Songs.add(new Song(1, "Test5", Artists.get(2), 1000));
        Songs.add(new Song(1, "Test6", Artists.get(2), 1000));
        Songs.add(new Song(1, "Test7", Artists.get(3), 1000));
        Songs.add(new Song(1, "Test8", Artists.get(3), 1000));
        Songs.add(new Song(1, "Test9", Artists.get(4), 1000));
        Songs.add(new Song(1, "Test10", Artists.get(4), 1000));
    }

    public void GenerateSampleArtists() {
        Artists.add(new Artist(1, "Test1"));
        Artists.add(new Artist(2, "Test2"));
        Artists.add(new Artist(3, "Test3"));
        Artists.add(new Artist(4, "Test4"));
        Artists.add(new Artist(5, "Test5"));
    }

    // Get Sample Data Functions
    public List<Song> GetSampleSongData() {
        return Songs;
    }

    public List<Artist> GetSampleArtistData() {
        return Artists;
    }
}

public class Main {
    // Main Function
    public static void main(String[] args) {
        PlaylistTest Test = new PlaylistTest();

        Test.GenerateSampleArtists();
        Test.GenerateSampleSongs();

        List<Song> Songs = Test.GetSampleSongData();

        for (Song song : Songs) {
            song.ListDetails();
        }
    }
}