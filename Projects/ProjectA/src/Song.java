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
    private long Plays;

    public Song(int id, String name, Artist artist, long plays) {
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

    public void SetPlays(long plays) {
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

    public long GetPlays() {
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
