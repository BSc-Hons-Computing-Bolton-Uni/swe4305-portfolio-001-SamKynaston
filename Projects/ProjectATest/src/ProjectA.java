
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectA {
    // Artist Tests
    @Test
    void CreateArtistAndTestID() {
        var artist = new Artist(1, "John Smith");
        assertEquals(1, artist.GetID());
    }

    @Test
    void CreateArtistAndTestName() {
        var artist = new Artist(1, "John Smith");
        assertEquals("John Smith", artist.GetName());
    }

    // Song Tests
    @Test
    void CreateSongAndTestName() {
        var artist = new Artist(1, "John Smith");
        var song = new Song(1, "Test", artist, 100);

        assertEquals("Test", song.GetName());
    }

    @Test
    void CreateSongAndTestArtist() {
        var artist = new Artist(1, "John Smith");
        var song = new Song(1, "Test", artist, 100);

        assertEquals(artist, song.GetArtist());
    }

    @Test
    void CreateSongAndTestID() {
        var artist = new Artist(1, "John Smith");
        var song = new Song(1, "Test", artist, 100);

        assertEquals(1, song.GetID());
    }

    @Test
    void CreateSongAndTestPlays() {
        var artist = new Artist(1, "John Smith");
        var song = new Song(1, "Test", artist, 100);

        assertEquals(100, song.GetPlays());
    }

    // Playlist Tests
    @Test
    void CreatePlaylistAndTestID() {
        var Playlist = new Playlist(1);
        assertEquals(1, Playlist.GetID());
    }

    @Test
    void CreatePlaylistAndAddSongTest() {
        var Playlist = new Playlist(1);
        var artist = new Artist(1, "John Smith");
        var song = new Song(1, "Test", artist, 100);

        Playlist.AddSong(song);

        assertTrue(Playlist.IsSongInPlaylist(song));
    }

    @Test
    void CreatePlaylistAndRemoveSongTest() {
        var Playlist = new Playlist(1);
        var artist = new Artist(1, "John Smith");
        var song = new Song(1, "Test", artist, 100);

        Playlist.AddSong(song);
        Playlist.RemoveSong(song);

        assertFalse(Playlist.IsSongInPlaylist(song));
    }

    @Test
    void CreatePlaylistAndTestSize() {
        var Playlist = new Playlist(1);
        var artist = new Artist(1, "John Smith");
        var song = new Song(1, "Test", artist, 100);

        Playlist.AddSong(song);

        assertEquals(1, Playlist.GetSize());
    }
}