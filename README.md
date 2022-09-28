<article class="markdown-body entry-content container-lg" itemprop="text"><h1 dir="auto"><a id="user-content-file-tree" class="anchor" aria-hidden="true" href="#file-tree"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a>File Tree</h1>
<p dir="auto">Files are organized in trees (*): Directories can contain regular files and directories.
We now want to model this structure in Java.
For this purpose we define our own classes <code>File</code>,<code>Directory</code> and <code>RegularFile</code>. <code>File</code> is an abstract class from which<code>Directory</code> and <code>RegularFile</code> inherit.
The class <code>Directory</code> is used to represent directories, the class <code>RegularFile</code> represents regular files, i.e. files that are not directories.
A <code>Directory</code> manages a list of<code>files</code> of <code>File</code>s contained in the directory. </p>
<h5 id="user-content-readinfiletree" dir="auto"><a id="user-content-read-in-file-tree" class="anchor" aria-hidden="true" href="#read-in-file-tree"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a>Read in file tree</h5>
<ol dir="auto">
<li><div dir="auto"><div dir="auto">
    
    
    
    <span>read in directory tree</span>
</div>
</div>Implement the method <code>public static File toFileRepresentation (Path path)</code> in the class <code>FileUtil</code>. 
The method is intended to provide a tree representation of the directory structure which takes the file at the path <code>path</code> as its parameter. Use objects of classes <code>RegularFile</code> and <code>Directory</code> for this purpose. If the file at the path <code>path</code> is a regular file, a representation of this file should be returned. If it is a directory, a representation of the entire file tree from this directory should be returned; the directory with path <code>path</code> should be the root of the tree. If an IOException occurs, you can simply throw it.</li>
</ol>
<h5 id="user-content-traversethefiletree" dir="auto"><a id="user-content-traverse-the-file-tree" class="anchor" aria-hidden="true" href="#traverse-the-file-tree"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a>Traverse the file tree</h5>
<p dir="auto">abstract class <code>File</code> implements the<code>Iteratble &lt;File&gt;</code>interface so that files can be iterated easily.
The necessary <code>iterator</code> method should be implemented in the classes <code>Directory</code> and <code>RegularFile</code>.</p>
<ol start="2" dir="auto">
<li><div dir="auto"><div dir="auto">
    
    
    
    <span>Iterator for regular files</span>
</div>
</div>
<p dir="auto">Implement the method <code>iterator ()</code> of the interface <code>Iterable &lt;File&gt;</code> inside the class <code>RegularFile</code>.
The iterator should only iterate over the regular file itself.
If <code>next ()</code> is called on the iterator, if all elements have already been iterated, a <code>NoSuchElementException</code> must be thrown.</p></li>
<li><div dir="auto"><div dir="auto">
    
    
    
    <span>Iterator for file tree</span>
</div>
</div>
<p dir="auto">Implement the method <code>iterator ()</code> of the interface <code>Iterable &lt;File&gt;</code> inside the class <code>Directory</code>.
The method is intended to provide an iterator that iterates over the directory itself, as well as all files directly and indirectly contained (both regular files and directories).
Which means, if necessary, the iterator must also iterate over the elements in the (direct and indirect) subdirectories.
The iteration order is up to you.
If <code>next ()</code> is called on the iterator, if all elements have already been iterated, a <code>NoSuchElementException</code> must be thrown.</p></li>
</ol>
<h5 id="user-content-determinetheheightofatree" dir="auto"><a id="user-content-determine-the-height-of-a-tree" class="anchor" aria-hidden="true" href="#determine-the-height-of-a-tree"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a>Determine the height of a tree</h5>
<ol start="4" dir="auto">
<li>[task] <a href="https://artemis.ase.in.tum.de/testHeight" rel="nofollow">Height of the directory tree</a>
Implement the method <code>public int getHeight ()</code> in <code>Directory</code>.
The method should calculate and return the height of the tree. The object on which it is called is the root.
The object is already the root of a tree; you do not need to access the file system here.
The height of a file tree with a regular file as the root is 0 (already implemented).
The height of a file tree with a directory as its root that has no children (i.e. a directory with no content) is 0.
The height of a file tree with a directory with children is equal to 1 plus the maximum height of the tree that one of the children directory have as the root.</li>
</ol>
<p dir="auto">(*) You can assume that the directories to be viewed contain no symbolic links.</p>
<h5 id="user-content-hints" dir="auto"><a id="user-content-hints" class="anchor" aria-hidden="true" href="#hints"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a>Hints:</h5>
<ul dir="auto">
<li>You can see the documentation of <a href="https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/lang/Iterable.html" rel="nofollow"><code>Iterable</code></a>-Interfaces.</li>
<li>You might need to use method <a href="https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/nio/file/Files.html#list(java.nio.file.Path)" rel="nofollow"><code>Files.list(...)</code></a> Returns a Stream, the elements of which are the entries in the directory.</li>
<li>The height of the file tree for which your program must work is not greater than 1000.</li>
</ul>



</article>
