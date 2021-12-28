import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Books {
	
	public ArrayList<Book<String>> books = new ArrayList<Book<String>>();
	
	public Books() {

		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\TOPRAK\\Downloads\\books.csv"));
			boolean header = true;
			while ((line = br.readLine()) != null)
			{
				if(header) {
					header = false;
					continue;
				}
				Book<String> book = new Book<String>();
				String[] book_line = line.split(",");
				book.name = book_line[1];
				book.author = book_line[2];
				books.add(book);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(String name, String author) {
		Book<String> book = new Book<String>();
		book.name = name;
		book.author = author;
		books.add(book);
	}
	
	public boolean remove(String name) {
		BooleanFunction check = (name_, book) -> name_.equals(book.name) ? true : false;
		for (int i = 0; i < books.size(); i ++) {
			Book<String> book;
			book = books.get(i);
			if(check.run(name, book)) {
				books.remove(book);
				return true;
			}
		}
		return false;
	}
}

class Book<T> {
	public T name;
	public T author;
}

interface BooleanFunction {
	boolean run(String name_, Book book);
}