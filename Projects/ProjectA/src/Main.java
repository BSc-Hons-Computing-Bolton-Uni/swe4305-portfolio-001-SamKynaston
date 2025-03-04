import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

            System.out.println(Colours.RED_TEXT + "0. Exit Menu" + Colours.ANSI_RESET);

            int inp = reader.nextInt();

            if (inp < Songs.size()) {
                if (inp == 0) {executeAddSongMenu = false;}
                else {UserPlaylist.AddSong(Songs.get(inp));}
            } else {
                System.out.println(Colours.RED_BACKGROUND + "[ERR] INPUT EXCEEDS SIZE OF SONGS LIBRARY" + Colours.ANSI_RESET);
            }
        }
    }

    public static void RemoveSongMenu() {
        boolean executeRemoveSongMenu = true;

        while (executeRemoveSongMenu) {
            for (int x = 0; x < UserPlaylist.GetSize(); x++) {
                Song song = UserPlaylist.GetSongs().get(x);
                System.out.println(x+1 + ". " + song.GetName());
            }

            System.out.println(Colours.RED_TEXT + "0. Exit Menu" + Colours.ANSI_RESET);

            int inp = reader.nextInt();

            if (inp < UserPlaylist.GetSize()) {
                if (inp == 0) {
                    executeRemoveSongMenu = false;
                } else {
                    UserPlaylist.RemoveSong(UserPlaylist.GetSongs().get(inp-1));
                }
            } else {
                System.out.println(Colours.RED_BACKGROUND + "[ERR] INPUT EXCEEDS SIZE OF PLAYLIST" + Colours.ANSI_RESET);
            }
        }
    }

    public static void ManagePlaylistMenu() {
        boolean executePlaylistMenu = true;

        while (executePlaylistMenu) {
            System.out.println("1. View Your Playlist");
            System.out.println("2. Add a Song");
            System.out.println("3. Remove a Song");
            System.out.println(Colours.RED_TEXT + "0. Exit Menu" + Colours.ANSI_RESET);

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

            System.out.println(Colours.RED_TEXT + "0. Terminate Program" + Colours.ANSI_RESET);

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