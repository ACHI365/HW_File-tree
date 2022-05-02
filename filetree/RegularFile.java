package filetree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RegularFile extends File {

	public RegularFile(Path path) {
		super(path);
	}

	@Override
	public Iterator<File> iterator() {
		File thisfile = this;

		return new Iterator<File>() {
			boolean first = true;
			@Override
			public boolean hasNext() {
				return first;
			}

			@Override
			public File next() {
				if (hasNext()){
					first = false;
					return thisfile;
				}
				else throw new NoSuchElementException();
			}
		};
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public boolean isRegularFile() {
		return true;
	}

}
