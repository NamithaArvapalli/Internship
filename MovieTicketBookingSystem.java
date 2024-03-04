import java.util.Scanner;

class Movie {
    String title;
    String[] seats;
    
    public Movie(String title, int numberOfSeats) {
        this.title = title;
        this.seats = new String[numberOfSeats];
        for (int i = 0; i < numberOfSeats; i++) {
            seats[i] = "O"; // O represents available seat, X represents booked seat
        }
    }

    public String getTitle() {
        return title;
    }

    public String[] getSeats() {
        return seats;
    }

    public void bookSeat(int seatNumber) {
        if (seatNumber >= 1 && seatNumber <= seats.length && seats[seatNumber - 1].equals("O")) {
            seats[seatNumber - 1] = "X";
            System.out.println("Seat booked successfully!");
        } else {
            System.out.println("Seat is already booked or invalid seat number.");
        }
    }
}

public class MovieTicketBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create some movies
        Movie[] movies = new Movie[5];
        movies[0] = new Movie("Gunturu Karam", 10);
        movies[1] = new Movie("Hanuman", 8);
        movies[2] = new Movie("Saindhav", 12);
	movies[3] = new Movie("Eagle", 10);
	movies[4] = new Movie("Salar", 14);

        // Display movie options
        System.out.println("Available Movies:");
        for (int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i].getTitle());
        }
        System.out.println("Enter the movie number to book tickets:");

        int movieChoice = scanner.nextInt();
        if (movieChoice >= 1 && movieChoice <= movies.length) {
            Movie selectedMovie = movies[movieChoice - 1];
            System.out.println("Selected movie: " + selectedMovie.getTitle());
            System.out.println("Available Seats:");
            for (int i = 0; i < selectedMovie.getSeats().length; i++) {
                System.out.print((i + 1) + "[" + selectedMovie.getSeats()[i] + "] ");
            }
            System.out.println("\nEnter the seat number to book:");
            int seatChoice = scanner.nextInt();
            selectedMovie.bookSeat(seatChoice);
        } else {
            System.out.println("Invalid movie choice.");
        }

        scanner.close();
    }
}
