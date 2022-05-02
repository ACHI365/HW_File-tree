//package filetree;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.*;
//
//public class Directory extends File {
//
//    private final List<File> files;
//    private final List<File> temp;
//
//
//    public Directory(Path path, List<File> files) {
//        super(path);
//        this.files = files;
//        temp = new LinkedList<>(files);
//    }
//
//    @Override
//    public Iterator<File> iterator() {
//
//        if (temp.size() == 0)
//            return new Iterator<File>() { //if directory has no files return it(doing this for the root directory)
//                boolean first = true;
//                @Override
//                public boolean hasNext() {
//                    return first;
//                }
//
//                @Override
//                public File next() {
//                    if (hasNext()) {
//                        first = false;
//                        return new Directory(getPath(), temp);
//                    } else throw new NoSuchElementException();
//                }
//            };
//
//        return new Iterator<>() {
//            int counter = 0;
//            int count = -1; //create integer to know if iterator has already been called
////            int counter = 0;
//
//
//            @Override
//            public boolean hasNext() {
//                return temp.size() > 0; //if directory has files, it has next
//            }
//
//            @Override
//            public File next() {
//                if (!hasNext()) throw new NoSuchElementException();
//                if (count < 0) { //if count is less than 0 return given directory
//                    count++;
//                    return new Directory(getPath(), temp);
//                }
//
//                Iterator<File> child = temp.get(count).iterator(); //create new iterator with file list
//
//
//                if (Files.isRegularFile(temp.get(count).getPath())) { //if file is regular then remove it from the list and return
//                    return temp.remove(count);
//                } else if (Files.isDirectory(temp.get(count).getPath())) {//if it is directory create new directory
//                    Directory file = (Directory) temp.get(count);
//                    if (file.getFiles().size() != counter) { //if this directory has files
//                        if (child.hasNext() && child.next().iterator().hasNext()) {
//                            counter ++;
//                            return child.next().iterator().next(); //return first element of the directory's file
//                            //check if it has next element and if its next element has next element
//                        }
//                        else {
//                            counter = 0;
//                            return (temp.remove(count)); //if it has no next element return itself
//                        }
//
//                    } else{
//                        counter = 0;
//                        return (temp.remove(count));//if it has no files return directory
//                    }
//
//                } else throw new NoSuchElementException();
//
//            }
//        };
//    }
//
//    public List<File> getTemp() {
//        return temp;
//    }
//
//    @Override
//    public int getHeight() {
//        int maxMain = 0; //create integer to store the value
//        OptionalInt max = files.stream().mapToInt(File::getHeight).max(); //get maximal getHeight in entries
//        if (max.isPresent()) maxMain = max.getAsInt() + 1; //if this max is present add 1 to add connection
//        return maxMain; //return answer
//    }
//
//    @Override
//    public boolean isRegularFile() {
//        return false;
//    }
//
//    public List<File> getFiles() {
//        return files;
//    }
//
//}
