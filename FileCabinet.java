package horusjjd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 *
 * @author jszalwicki
 */
public class FileCabinet implements Cabinet {
    private List<Folder> folders;
    
    public FileCabinet(List<Folder> folders) {
        this.folders = folders;
    }
    @Override
    public Optional<Folder> findFolderByName(String name) {
        return findByCondition(folders, f -> f.getName().equalsIgnoreCase(name)).stream().findFirst();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        return findByCondition(folders, f -> f.getSize().equalsIgnoreCase(size));
    }

    @Override
    public int count() {
        return countFolders(folders);
    }
    
    private List<Folder> findByCondition(List<Folder> folders, Predicate<Folder> condition) {
        List<Folder> result = new ArrayList<>();
        for (Folder f : folders) {
            if (condition.test(f)) {
                result.add(f);
            }
            if (f instanceof MultiFolder multi) {
                result.addAll(findByCondition(multi.getFolders(), condition));
            }
        }
        return result;
    }

    private int countFolders(List<Folder> folders) {
        int count = 0;
        for (Folder f : folders) {
            count++;
            if (f instanceof MultiFolder multi) {
                count += countFolders(multi.getFolders());
            }
        }
        return count;
    }
}
