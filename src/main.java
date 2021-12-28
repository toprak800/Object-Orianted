import java.util.Scanner;

public class main {

	
	
	public static void main(String [] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		Books books = new Books();
		String name, author;
		
		int select;
		boolean condition = true;
		
		do {
			System.out.println("Choose an option:");
			System.out.println("1: Books list");
			System.out.println("2: Donate a book");
			System.out.println("3: Borrow a book");
			System.out.println("4: Show Employee List of the Library");
			System.out.println("5: System out");
			select = scan.nextInt();
		switch(select) {
		
		case 1	:
			for(int i = 0; i<books.books.size(); i++) {
				
			System.out.println(books.books.get(i).name);
			}
			break;
			
			
		case 2 :
			System.out.println("Enter the name of the book:");
			scan.skip("\\R?");
			name = scan.nextLine();
			
			System.out.println("Enter the author of the book:");
			author = scan.nextLine();
			
			books.insert(name, author);
			
			System.out.println("Done!");
			break;
		case 3:
			System.out.println("Enter the full name of the book:");
			scan.skip("\\R?");
			name = scan.nextLine();
			boolean check = books.remove(name);
			if (check) System.out.println("Done!");
			else System.out.println("Not found.");
			break;
		case 4:
			System.out.println("Show Employee List of the Library");
			Manager manager = new Manager ("Toprak Arat", "CEO", 22);
			Employee employee = new Employee ("Kadir Engin", "Sales consultant", 30);
			Employee cashier = new Employee ("Barbaros Deniz", "Cashier",25);
		    Employee organizer = new Manager("Merve Hanc�","Organizer",21);
		    
			manager.showInfos();
			employee.showInfos();
			cashier.showInfos();
			organizer.showInfos();
			break;
		case 5: 
			System.out.println("Quit. Run the program again.");
			condition = false;
			
			break;
		default:
		}
		}
		while(condition);
	
		
		
		
	

	
		}
	}

