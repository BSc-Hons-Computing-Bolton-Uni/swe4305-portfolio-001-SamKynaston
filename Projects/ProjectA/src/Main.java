import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
        if (IsSongInPlaylist(song)) {
            System.out.println(Colours.RED_BACKGROUND + "[ERR] Playlist " + ID + " already contains this song!" + Colours.ANSI_RESET);
            return;
        }

        Playlist.add(song); // Adds the song object to the function
    }

    public void RemoveSong(Song song) {
        // If the song doesn't exist in the playlist, print an error and terminate the function
        if (!IsSongInPlaylist(song)) {
            System.out.println(Colours.RED_BACKGROUND + "[ERR] Playlist " + ID + " does not have this song stored!" + Colours.ANSI_RESET);
            return;
        }

        // Remove the song from the Playlist
        Playlist.remove(song);
    }

    public boolean IsSongInPlaylist(Song song) {
        return Playlist.contains(song);
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

public class Main {
    private static final Scanner reader = new Scanner(System.in);
    private static Playlist UserPlaylist = null;
    private static final List<Artist> Artists = new ArrayList<>(); // Create an array for all sample artists to be stored in
    private static final List<Song> Songs = new ArrayList<>(); // Create an array for all sample songs to be stored in

    public static void GenerateSampleSongs() {
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
    public static void GenerateSampleArtists() {
        Artists.add(new Artist(1, "Test1"));
        Artists.add(new Artist(2, "Test2"));
        Artists.add(new Artist(3, "Test3"));
        Artists.add(new Artist(4, "Test4"));
        Artists.add(new Artist(5, "Test5"));
    }

    public static void InitialisePlaylist() {
        UserPlaylist = new Playlist(1);
    }

    public static void ViewSongs() {
        UserPlaylist.ShowPlaylist();
    }

    public static void AddSongMenu() {
        boolean executeAddSongMenu = true;

        while (executeAddSongMenu) {
            for (int x = 1; x < Songs.size(); x++) {
                Song song = Songs.get(x);

                if (UserPlaylist.IsSongInPlaylist(song)) {continue;}

                System.out.println(x + ". " + song.GetName());
            }

            System.out.println("0. Exit Menu");

            int inp = reader.nextInt();

            if (inp < Songs.size()) {
                if (inp == 0) {executeAddSongMenu = false;}
                else {UserPlaylist.AddSong(Songs.get(inp));}
            }
        }
    }

    public static void RemoveSongMenu() {
        boolean executeRemoveSongMenu = true;

        while (executeRemoveSongMenu) {
            for (int x = 1; x < Songs.size(); x++) {
                Song song = Songs.get(x);
                System.out.println(x + ". " + song.GetName());
            }

            System.out.println("0. Exit Menu");

            int inp = reader.nextInt();

            if (inp < Songs.size()) {
                if (inp == 0) {executeRemoveSongMenu = false;}
                else {UserPlaylist.RemoveSong(Songs.get(inp));}
            }
        }
    }

    public static void ManagePlaylistMenu() {
        boolean executePlaylistMenu = true;

        while (executePlaylistMenu) {
            System.out.println("1. View Your Playlist");
            System.out.println("2. Add a Song");
            System.out.println("3. Remove a Song");
            System.out.println("0. Exit Menu");

            int inp = reader.nextInt();

            switch (inp) {
                case 0:
                    executePlaylistMenu = false;
                    break;
                case 1:
                    ViewSongs();
                    break;
                case 2:
                    AddSongMenu();
                    break;
                case 3:
                    RemoveSongMenu();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        GenerateSampleArtists();
        GenerateSampleSongs();

        boolean execute = true;

        while (execute) {
            if (UserPlaylist == null) {
                System.out.println("1. Initialise Playlist");
            } else {
                System.out.println("1. Manage Your Playlist");
            }

            System.out.println("0. Terminate Program");

            int inp = reader.nextInt();

            switch (inp) {
                case 1:
                    if (UserPlaylist == null) {InitialisePlaylist();} else {ManagePlaylistMenu();}
                    break;
                case 0:
                    execute = false;
                    break;
            }
        }
    }
}