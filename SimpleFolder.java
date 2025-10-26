package horusjjd;

/**
 *
 * @author jszalwicki
 */
public class SimpleFolder implements Folder {
    private final String name;
    private final String size;

    public SimpleFolder(String name, String size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getSize() { return size; }

    @Override
    public String toString() {
        return "Folder{name='%s', size='%s'}".formatted(name, size);
    }
}