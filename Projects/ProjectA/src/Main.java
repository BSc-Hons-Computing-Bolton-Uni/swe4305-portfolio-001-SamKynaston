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
    public int Duration;

    public Song(int id, String name, Artist artist, int duration) {
        this.ID = id;
        this.Name = name;
        this.Artist = artist;
        this.Duration = duration;
    }

    public void ListDetails() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + Name);
        System.out.println("Artist: " + Artist.Name + " (" + Artist.ID + ")");
        System.out.println("Duration: " + Duration);
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
        Playlist.remove(song);
    }

    public void ShowPlaylist() {
        System.out.println("Playlist for user " + ID);
        for (Song song : Playlist) {
            song.ListDetails();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Artist artist1 = new Artist(1, "The Weeknd");
        Artist artist2 = new Artist(2, "Taylor Swift");
        Artist artist3 = new Artist(3, "Ed Sheeran");

        Song song1 = new Song(101, "Blinding Lights", artist1, 200);
        Song song2 = new Song(102, "Save Your Tears", artist1, 215);
        Song song3 = new Song(103, "Shake It Off", artist2, 210);
        Song song4 = new Song(104, "Perfect", artist3, 230);
        Song song5 = new Song(105, "Shape of You", artist3, 240);

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
    }
}