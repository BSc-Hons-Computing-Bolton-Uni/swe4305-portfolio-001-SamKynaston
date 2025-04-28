import Objects.Input;

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

        Songs.add(new Song(1, "Midnight Echo", Artists.get(0), 3200));
        Songs.add(new Song(2, "Neon Dreams", Artists.get(1), 2800));
        Songs.add(new Song(3, "Lost in Time", Artists.get(2), 3500));
        Songs.add(new Song(4, "Electric Pulse", Artists.get(3), 2900));
        Songs.add(new Song(5, "Echoes of You", Artists.get(4), 3100));
        Songs.add(new Song(6, "Shattered Illusions", Artists.get(5), 3300));
        Songs.add(new Song(7, "Celestial Voyage", Artists.get(6), 3700));
        Songs.add(new Song(8, "Waves of Serenity", Artists.get(7), 3000));
        Songs.add(new Song(9, "Crimson Horizon", Artists.get(8), 3400));
        Songs.add(new Song(10, "Starlit Reverie", Artists.get(9), 3600));
    }

    // Generate Sample Artists
    public static void GenerateSampleArtists() {
        Artists.add(new Artist(1, "Luna Shadows"));
        Artists.add(new Artist(2, "Neon Mirage"));
        Artists.add(new Artist(3, "Echo Phantom"));
        Artists.add(new Artist(4, "Synth Horizon"));
        Artists.add(new Artist(5, "Velvet Echoes"));
        Artists.add(new Artist(6, "Astral Drift"));
        Artists.add(new Artist(7, "Celeste Nova"));
        Artists.add(new Artist(8, "Serenity Waves"));
        Artists.add(new Artist(9, "Crimson Tide"));
        Artists.add(new Artist(10, "Starlight Reverie"));
    }

    public static void InitialisePlaylist() {
        UserPlaylist = new Playlist(1);
    }

    public static void ViewPlaylistSongs() {
        UserPlaylist.ShowPlaylist();
    }

    public static void ViewSongs(int MinimumPlaysRequired) {
        for (Song song : Songs) {
            if (song.GetPlays() < MinimumPlaysRequired) { continue; }

            System.out.println("===== [" + song.GetID() + "] =====");
            System.out.println("Song ID: " + song.GetID());
            System.out.println("Song Name: " + song.GetName());
            System.out.println("Song Plays: " + Formatter.Number(song.GetPlays()));
            System.out.println("Song Artist: " + song.GetArtist().GetName());
        }
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

            if (inp <= Songs.size()) {
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

            if (inp <= UserPlaylist.GetSize()) {
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
                    ViewPlaylistSongs();
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

    public static void GetPlaysRequired() {
        boolean executeMenu = true;

        while (executeMenu) {
            System.out.println("Enter the minimum number of views required to display a song:");

            int inp = reader.nextInt();

            if (inp > 0) {
                ViewSongs(inp);
            }

            executeMenu = false;
        }
    }

    public static Artist GetArtist() {
        boolean executeMenu = true;

        while (executeMenu) {
            for (int index = 1; index < Artists.size(); index++) {
                Artist currentArtist = Artists.get(index);

                System.out.println(index + ". " + currentArtist.GetName());
            }

            int choice = Input.ReadIntInRange("Select an Artist: ", 0, Artists.size());

            return Artists.get(choice);
        }

        return null;
    }

    public static Song GetSong() {
        boolean executeMenu = true;

        while (executeMenu) {
            for (int index = 1; index < Songs.size(); index++) {
                Song currentSong = Songs.get(index);

                System.out.println(index + ". " + currentSong.GetName());
            }

            int choice = Input.ReadIntInRange("Select an Artist: ", 0, Artists.size());

            return Songs.get(choice);
        }

        return null;
    }

    public static void AddSong() {
        boolean executeMenu = true;

        while (executeMenu) {
            String songName = Input.ReadStringWithLength("Enter a name: ", 0, 64);
            Artist selectedArtist = GetArtist();
            int plays = Input.ReadInt("Song Listens: ");

            Songs.add(new Song(Songs.getLast().GetID() + 1, songName, selectedArtist, plays));

            executeMenu = false;
        }
    }

    public static void RemoveSong() {
        boolean executeMenu = true;

        while (executeMenu) {
            Song selectedSong = GetSong();

            Songs.remove(selectedSong);

            executeMenu = false;
        }
    }

    public static void AddArtist() {
        boolean executeMenu = true;

        while (executeMenu) {
            String artistName = Input.ReadStringWithLength("Enter a name: ", 0, 64);

            Artists.add(new Artist(Artists.getLast().GetID() + 1, artistName));

            executeMenu = false;
        }
    }

    public static void RemoveArtist() {
        boolean executeMenu = true;

        while (executeMenu) {
            Artist selectedArtist = GetArtist();

            Artists.remove(selectedArtist);

            executeMenu = false;
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

            System.out.println("2. View All Songs");
            System.out.println("3. View Songs Based On Plays");
            System.out.println("4. Add a Song");
            System.out.println("5. Remove a Song");
            System.out.println("6. Add an Artist");
            System.out.println("7. Remove an Artist");

            System.out.println(Colours.RED_TEXT + "0. Terminate Program" + Colours.ANSI_RESET);

            int inp = reader.nextInt();

            switch (inp) {
                case 1:
                    if (UserPlaylist == null) {InitialisePlaylist();} else {ManagePlaylistMenu();}
                    break;
                case 2:
                    ViewSongs(0);
                    break;
                case 3:
                    GetPlaysRequired();
                    break;
                case 4:
                    AddSong();
                    break;
                case 5:
                    RemoveSong();
                    break;
                case 6:
                    AddArtist();
                    break;
                case 7:
                    RemoveArtist();
                    break;
                case 0:
                    execute = false;
                    break;
            }
        }
    }
}