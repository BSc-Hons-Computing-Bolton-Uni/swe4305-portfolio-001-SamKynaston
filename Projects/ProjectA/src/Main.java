import java.text.DecimalFormat;
import java.util.ArrayList;

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

class User {
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
}

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

public class Main {
    // Main Function
    public static void main(String[] args) {
        // Sample Artist Data
        Artist artist1 = new Artist(1, "Anne-Marie"); // Build an artist object for Anne-Marie with ID 1
        Artist artist2 = new Artist(2, "Ed Sheeran"); // Build an artist object for Ed Sheeran with ID 2
        Artist artist3 = new Artist(3, "Beyonce"); // Build an artist object for Beyonce with ID 3
        Artist artist4 = new Artist(4, "Dave"); // Build an artist object for Dave with ID 4
        Artist artist5 = new Artist(5, "Swedish House Mafia"); // Build an artist object for SHM with ID 5

        // Sample Song Data
        Song song1 = new Song(101, "Beautiful", artist1, 863015); // Build a song object for Anne-Marie's song "Beautiful"
        Song song2 = new Song(102, "Bad Habits", artist2, 127192542); // Build a song object for Ed Sheeran's song "Bad Habits"
        Song song3 = new Song(103, "Halo", artist3, 991888598); // Build a song object for Beyonce's song "Halo"
        Song song4 = new Song(104, "Clash (feat. Stormzy)", artist4, 7070513); // Build a song object for Dave's song "Clash"
        Song song5 = new Song(105, "It Gets Better", artist5, 7563930); // Build a song object for SHM's song "It Gets Better"

        User user1 = new User(1);
        user1.AddSong(song1);
        user1.AddSong(song3);
        user1.AddSong(song5);

        User user2 = new User(2);
        user2.AddSong(song2);
        user2.AddSong(song4);

        user1.ShowPlaylist();
        System.out.println();
        user2.ShowPlaylist();

        // Remove Songs
        user1.RemoveSong(song4);
        user1.RemoveSong(song1);
        user1.RemoveSong(song3);

        // Print User Details to test effectiveness
        user1.ShowPlaylist();
    }
}