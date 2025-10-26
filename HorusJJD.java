package horusjjd;

import java.util.List;

/**
 *
 * @author jszalwicki
 */
public class HorusJJD {
    public static void main(String[] args) {

        Folder f1 = new SimpleFolder("f1", "SMALL");
        Folder f2 = new SimpleFolder("f2", "LARGE");
        Folder f3 = new SimpleFolder("f3", "MEDIUM");
        Folder f4 = new SimpleFolder("f4", "LARGE");

        Folder f5 = new CompositeFolder("f5", "MEDIUM", List.of(f1, f2));
        Folder f6 = new CompositeFolder("f6", "SMALL", List.of(f3, f4));
        Folder f7 = new CompositeFolder("f7", "LARGE", List.of(f5, f6));

        FileCabinet cabinet = new FileCabinet(List.of(f7));

        System.out.println("Find by name (f1): " + cabinet.findFolderByName("f1"));
        System.out.println("Find by name (f7): " + cabinet.findFolderByName("f7"));
        System.out.println("Find by size (LARGE): " + cabinet.findFoldersBySize("LARGE"));
        System.out.println("Find by size (MEDIUM): " + cabinet.findFoldersBySize("MEDIUM"));
        System.out.println("Find by size (SMALL): " + cabinet.findFoldersBySize("SMALL"));
        System.out.println("Total count: " + cabinet.count());
    }
}
