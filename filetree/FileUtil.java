package filetree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class FileUtil {

	public static File toFileRepresentation(Path path) throws IOException {

		if(Files.isRegularFile(path)){
			return new RegularFile(path); //if given path is just a regular file, return it
		}
		else if (Files.isDirectory(path)){ //if given file is directory do the following
			var list = new LinkedList<File>(); //create new list
			Files.list(path).forEach(e -> {   //for every path in this file
				try {
					list.add(toFileRepresentation(e)); //add file representation to the list
				} catch (IOException ex) { //catch Exceptions
					ex.printStackTrace();
				}
			});
			return new Directory(path,list);
		}
		else return null;
	}

}
