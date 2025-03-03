import java.lang.reflect.Array;
import java.util.ArrayList;

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

    public int GetSize() {
        return Playlist.size();
    }

    public ArrayList<Song> GetSongs() {
        return Playlist;
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