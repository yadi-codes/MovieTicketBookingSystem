class User{
    String name,password, address, phone;

    void buyTicket(){}
    void showTicket(){}
    void cancelTicket(){}
    void logout(){}
}


public class Admin extends User {

    void addMovies(){}
    void selectMovies(){}
}




public class MovieTicketDriver {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
