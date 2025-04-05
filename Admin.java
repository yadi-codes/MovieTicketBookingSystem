import java.util.Scanner;

public class Admin {
    
    public void addMovies() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter movie title: ");
    String title = sc.nextLine();
    System.out.print("Enter genre: ");
    String genre = sc.nextLine();
    System.out.print("Enter rating: ");
    double rating = sc.nextDouble();
    System.out.print("Enter duration (minutes): ");
    int duration = sc.nextInt();
    sc.nextLine(); // consume newline
    System.out.print("Enter synopsis: ");
    String synopsis = sc.nextLine();

    Movie m = new Movie(title, genre, rating, duration, synopsis);
    m.insertMovie();
}


    void selectMovies(){}
}
