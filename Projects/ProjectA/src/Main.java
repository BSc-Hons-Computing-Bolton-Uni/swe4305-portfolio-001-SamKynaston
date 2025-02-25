import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/*
 * ===== [ Artist Class ] =====
 * Parameters:
 * - int ID
 * - String Name
 * */
class Artist {
    private int ID;
    private String Name;

    public Artist(int ID, String Name) {
        SetID(ID);
        SetName(Name);
    }

    public void SetID(int id) {
        this.ID = id;
    }

    public void SetName(String name) {
        this.Name = name;
    }

    public int GetID() {
        return ID;
    }

    public String GetName() {
        return Name;
    }
}

/*
* ===== [ SONG Class ] =====
* Parameters:
* - int ID
* - String Name
* - Artist Artist
* - int Plays
* */
class Song {
    private int ID;
    private String Name;
    private Artist Artist;
    private int Plays;

    public Song(int id, String name, Artist artist, int plays) {
        SetID(id);
        SetName(name);
        SetArtist(artist);
        SetPlays(plays);
    }

    public void SetID(int id) {
        this.ID = id;
    }

    public void SetName(String name) {
        this.Name = name;
    }

    public void SetArtist(Artist artist) {
        this.Artist = artist;
    }

    public void SetPlays(int plays) {
        this.Plays = plays;
    }

    public int GetID() {
        return ID;
    }

    public String GetName() {
        return Name;
    }

    public Artist GetArtist() {
        return Artist;
    }

    public int GetPlays() {
        return Plays;
    }

    public void ListDetails() {
        System.out.println("ID: " + GetID()); // Print the song's ID
        System.out.println("Name: " + GetName()); // Print the song's name
        System.out.println("Artist: " + GetArtist().GetName() + " (ID: " + Artist.GetID() + ")"); // Obtain the artist's name and ID

        String Colour; // Create a new string variable to store the colour of the background

        if (Plays >= 1000 && Plays < 10000) {
            Colour = Colours.YELLOW_BACKGROUND; // Call the colour class and get a yellow background
        } else if (Plays >= 10000 && Plays < 100000) {
            Colour = Colours.GREEN_BACKGROUND; // Call the colour class and get a green background
        } else if (Plays >= 100000) {
            Colour = Colours.PURPLE_BACKGROUND; // Call the colour class and get a purple background
        } else {
            Colour = Colours.RED_BACKGROUND; // Call the colour class and get a red background
        }

        System.out.println(Colour + "Listens: " + Formatter.Number(GetPlays()) + Colours.ANSI_RESET); // Print the amount of listens the song has using the colour obtained in the logic above
    }
}

/*
 * ===== [ Playlist Class ] =====
 * Parameters:
 * - int ID
 * - ArrayList<Song> Playlist
 * */
class Playlist {
    private int ID;
    private final ArrayList<Song> Playlist = new ArrayList<>();

    public Playlist(int ID) {
        SetID(ID);
    }

    public int GetID() {
        return ID;
    }

    public void SetID(int ID) {
        this.ID = ID;
    }

    public void AddSong(Song song) {
        Playlist.add(song); // Adds the song object to the function
    }

    public void RemoveSong(Song song) {
        // If the song doesn't exist in the playlist, print an error and terminate the function
        if (!Playlist.contains(song)) {
            System.out.println(Colours.RED_BACKGROUND + "[ERR] Playlist " + ID + " does not have this song stored!" + Colours.ANSI_RESET);
            return;
        }

        // Remove the song from the Playlist
        Playlist.remove(song);
    }

    public void ShowPlaylist() {
        // If the playlist is empty, print an error and return to terminate the function
        if (Playlist.isEmpty()) {
            System.out.println(Colours.RED_BACKGROUND + "[ERR] Playlist " + ID + " is empty!" + Colours.ANSI_RESET);
            return;
        }

        System.out.println("Playlist " + GetID());

        // Go through every song in the playlist
        for (Song song : Playlist) {
            song.ListDetails(); // Calls the function that gets the song object to print its attributes
            System.out.println(); // Print a new line to divide outputs
        }
    }
}

class Colours {
    // Colours
    public static final String ANSI_RESET = "\u001B[0m"; // Resets any colouring. Must be called after any println function with a colour to prevent it from colouring the entire terminal.
    public static final String RED_BACKGROUND = "\u001B[41m"; // Display a red background behind console text
    public static final String YELLOW_BACKGROUND = "\u001B[43m"; // Displays a yellow background behind console text
    public static final String GREEN_BACKGROUND = "\u001B[42m"; // Displays a green background behind console text
    public static final String PURPLE_BACKGROUND = "\u001B[45m"; // Displays a purple background behind console text
}

class Formatter {
    // Formatting for Large Numbers
    public static String Number(int toFormat) {
        DecimalFormat newFormat = new DecimalFormat("###,###");
        return newFormat.format(toFormat);
    }
}

class PlaylistTest {
    private final List<Artist> Artists = new ArrayList<>(); // Create an array for all sample artists to be stored in
    private final List<Song> Songs = new ArrayList<>(); // Create an array for all sample songs to be stored in
    private final List<Playlist> Playlists = new ArrayList<>(); // Create an array for all playlists to be stored in

    // Generate Sample Playlists
    public void GenerateSamplePlaylists() {
        Playlists.add(new Playlist(1));
        Playlists.add(new Playlist(2));
        Playlists.add(new Playlist(3));
        Playlists.add(new Playlist(4));
        Playlists.add(new Playlist(5));
    }

    // Generate Sample Songs
    public void GenerateSampleSongs() {
        if (Artists.isEmpty()) {GenerateSampleArtists();}

        Songs.add(new Song(1, "Test1", Artists.get(0), 1000));
        Songs.add(new Song(2, "Test2", Artists.get(0), 10000));
        Songs.add(new Song(3, "Test3", Artists.get(1), 100000));
        Songs.add(new Song(4, "Test4", Artists.get(1), 1000000));
        Songs.add(new Song(5, "Test5", Artists.get(2), 1000000));
        Songs.add(new Song(6, "Test6", Artists.get(2), 1000000));
        Songs.add(new Song(7, "Test7", Artists.get(3), 100000));
        Songs.add(new Song(8, "Test8", Artists.get(3), 100000));
        Songs.add(new Song(9, "Test9", Artists.get(4), 1000));
        Songs.add(new Song(10, "Test10", Artists.get(4), 1000));
    }

    // Generate Sample Artists
    public void GenerateSampleArtists() {
        Artists.add(new Artist(1, "Test1"));
        Artists.add(new Artist(2, "Test2"));
        Artists.add(new Artist(3, "Test3"));
        Artists.add(new Artist(4, "Test4"));
        Artists.add(new Artist(5, "Test5"));
    }

    // Function to add songs to playlists
    public void AddSongsToPlaylist() {
        List<Playlist> Playlists = GetSamplePlaylists();
        List<Song> Songs = GetSampleSongData();

        // Playlist One
        Playlists.getFirst().AddSong(Songs.getFirst());
        Playlists.getFirst().AddSong(Songs.get(2));
        Playlists.getFirst().AddSong(Songs.get(5));
        Playlists.getFirst().AddSong(Songs.get(9));
        Playlists.getFirst().AddSong(Songs.get(7));

        // Playlist Two
        Playlists.get(1).AddSong(Songs.getFirst());
        Playlists.get(1).AddSong(Songs.get(2));
        Playlists.get(1).AddSong(Songs.get(5));
        Playlists.get(1).AddSong(Songs.get(9));
        Playlists.get(1).AddSong(Songs.get(7));

        // Playlist Three
        Playlists.get(2).AddSong(Songs.getFirst());
        Playlists.get(2).AddSong(Songs.get(2));
        Playlists.get(2).AddSong(Songs.get(7));
        Playlists.get(2).AddSong(Songs.get(8));
        Playlists.get(2).AddSong(Songs.get(1));

        // Playlist Four
        Playlists.get(3).AddSong(Songs.getFirst());
        Playlists.get(3).AddSong(Songs.get(2));
        Playlists.get(3).AddSong(Songs.get(5));
        Playlists.get(3).AddSong(Songs.get(3));
        Playlists.get(3).AddSong(Songs.get(7));

        // Playlist Five
        Playlists.get(4).AddSong(Songs.getFirst());
        Playlists.get(4).AddSong(Songs.get(6));
        Playlists.get(4).AddSong(Songs.get(1));
        Playlists.get(4).AddSong(Songs.get(7));
        Playlists.get(4).AddSong(Songs.get(4));
    }

    public List<Song> GetSampleSongData() {
        return Songs; // Return the Songs ArrayList
    }

    public List<Artist> GetSampleArtistData() {
        return Artists; // Return the Artists ArrayList
    }

    public List<Playlist> GetSamplePlaylists() {
        return Playlists; // Return the Playlists ArrayList
    }
}

public class Main {
    // Main Function
    public static void main(String[] args) {
        PlaylistTest Test = new PlaylistTest(); // Create a new test class

        Test.GenerateSamplePlaylists(); // Call the test class's Sample Playlist generator
        Test.GenerateSampleArtists(); // Call the test class's Sample Artists generator
        Test.GenerateSampleSongs(); // Call the test class's Sample Songs generator
        Test.AddSongsToPlaylist(); // Call the test class's function to add sample songs to playlists

        List<Playlist> Playlists = Test.GetSamplePlaylists(); // Create an arraylist to store Playlists and call the function that returns all sample playlists

        // Go through all playlists
        for (Playlist playlist : Playlists) {
            System.out.println(Colours.RED_BACKGROUND + "[TEST FOR " + playlist.GetID() + "]" + Colours.ANSI_RESET);
            playlist.ShowPlaylist(); // Call the function that prints out the songs in all playlists
        }
    }
}