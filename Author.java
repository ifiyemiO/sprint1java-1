
import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String dateOfBirth;
    private List<LibraryItem> writtenItems;

    //constructor
    public Author(String name, String dateOfBirth, ArrayList<LibraryItem> writtenItems) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.writtenItems = writtenItems;
    }
    // Getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public List<LibraryItem> getWrittenItems() {
        return writtenItems;
    }
    public void setWrittenItems(ArrayList<LibraryItem> writtenItems) {
        this.writtenItems = writtenItems;
    }
    public void addWrittenItem(LibraryItem item) {
        writtenItems.add(item);
    }
    public void removeWrittenItem(LibraryItem item) {
        writtenItems.remove(item);
    }

    public void addToWrittenItems(LibraryItem libraryItem) {
        writtenItems.add(libraryItem);
    }


}