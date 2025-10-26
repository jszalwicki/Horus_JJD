package horusjjd;

import java.util.List;

/**
 *
 * @author jszalwicki
 */
interface MultiFolder extends Folder {
    List<Folder> getFolders();
}