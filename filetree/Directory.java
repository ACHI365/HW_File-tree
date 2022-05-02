package filetree;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Directory extends File {

    private final List<File> files;

    public Directory(Path path, List<File> files) {
        super(path);
        this.files = files;
    }

    @Override
    public Iterator<File> iterator() {
        //create a new list
        List<File> temp = new LinkedList<>(files);

        // add main directory to the list
        temp.add(0, new Directory(getPath(), new LinkedList<>()));

        // in case of normal directory create new iterator
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return temp.size() > 0;
            }

            @Override
            public File next() {
                if (!hasNext()) throw new NoSuchElementException();
                //check next element, if it is regular remove and return its path
                if (Files.isRegularFile(temp.get(0).getPath())) {
                    return temp.remove(0);
                }
                //for convenience save directory value in new variable
                Directory directory = (Directory) temp.get(0);
                // create index value and size
                int i = 0;
                int size = directory.getFiles().size();

                //add all elements from files list to the temp list
                for (i = 0; i < size; i++){
                    temp.add(i, directory.getFiles().get(i));
                }
                // return current directory
                return temp.remove(i);
            }
        };
    }

    @Override
    public int getHeight() {
        int maxMain = 0; //create integer to store the value
        OptionalInt max = files.stream().mapToInt(File::getHeight).max(); //get maximal getHeight in entries
        if (max.isPresent()) maxMain = max.getAsInt() + 1; //if this max is present add 1 to add connection
        return maxMain; //return answer
    }

    @Override
    public boolean isRegularFile() {
        return false;
    }

    public List<File> getFiles() {
        return files;
    }

}
