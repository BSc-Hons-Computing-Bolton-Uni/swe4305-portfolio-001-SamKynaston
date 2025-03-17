
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectA {
    // Artist Tests
    @Test
    void createArtistAndTestID() {
        var artist = new Artist(1, "John Smith");
        assertEquals(1, artist.GetID());
    }

    @Test
    void createArtistAndTestName() {
        var artist = new Artist(1, "John Smith");
        assertEquals("John Smith", artist.GetName());
    }

    @Test
    void createSongAndTestID() {
        var artist = new Artist(1, "John Smith");
        var song = new Song(1, "Test", artist, 100);

        assertEquals(1, song.GetID());
    }

    @Test
    void createSongAndTestName() {
        var artist = new Artist(1, "John Smith");
        var song = new Song(1, "Test", artist, 100);

        assertEquals("Test", song.GetName());
    }

    @Test
    void createSongAndTestArtist() {
        var artist = new Artist(1, "John Smith");
        var song = new Song(1, "Test", artist, 100);

        assertEquals(artist, song.GetArtist());
    }

    @Test
    void createSongAndTestPlays() {
        var artist = new Artist(1, "John Smith");
        var song = new Song(1, "Test", artist, 100);

        assertEquals(100, song.GetPlays());
    }

    // Song Tests

}