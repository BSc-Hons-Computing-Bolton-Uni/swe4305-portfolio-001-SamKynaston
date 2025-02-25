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