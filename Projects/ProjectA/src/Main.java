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
        System.out.println("Artist: " + Artist.Name + " (ID: " + Artist.ID + ")");
        System.out.println("Play Count: " + Main.formatter(Plays));
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
            System.out.println("[ERR] User " + ID + " does not have this song stored in their playlist!");
            return;
        }

        Playlist.remove(song);
    }

    public void ShowPlaylist() {
        if (Playlist.isEmpty()) {
            System.out.println("[ERR] User " + ID + "'s playlist is empty!");
            return;
        }

        System.out.println("Playlist for user " + ID);

        for (Song song : Playlist) {
            song.ListDetails();
            System.out.println();
        }
    }
}

public class Main {
    public static String formatter(int toFormat) {
        DecimalFormat newFormat = new DecimalFormat("###,###");
        return newFormat.format(toFormat);
    }

    public static void main(String[] args) {
        Artist artist1 = new Artist(1, "Anne-Marie");
        Artist artist2 = new Artist(2, "Ed Sheeran");
        Artist artist3 = new Artist(3, "Beyonce");
        Artist artist4 = new Artist(4, "Dave");
        Artist artist5 = new Artist(5, "Swedish House Mafia");

        Song song1 = new Song(101, "Beautiful", artist1, 863015);
        Song song2 = new Song(102, "Bad Habits", artist2, 127192542);
        Song song3 = new Song(103, "Halo", artist3, 991888598);
        Song song4 = new Song(104, "Clash (feat. Stormzy)", artist4, 7070513);
        Song song5 = new Song(105, "It Gets Better", artist5, 7563930);

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