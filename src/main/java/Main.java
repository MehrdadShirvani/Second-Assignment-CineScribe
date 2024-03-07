import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        while(runMenu());
    }



    public static boolean runMenu()
    {
        System.out.println("");
        System.out.println(" --------- MOVIE AGGREGATOR --------- ");
        System.out.println("|                                    |");
        System.out.println("|              welcome               | ");
        System.out.println("|                                    |");
        System.out.println("|  Enter the number of the command   | ");
        System.out.println("|  and press enter                   |");
        System.out.println("|                                    |");
        System.out.println("|                                    |");
        System.out.println("|           1)Search Movie           |");
        System.out.println("|           2)Exit                   |");
        System.out.println("|                                    |");
        System.out.println("|                                    |");
        System.out.println(" ------------------------------------ ");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        if(command.equals("1"))
        {
            showMovieSearch();
            return true;
        }
        else if (command.equals("2"))
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    public static void showMovieSearch()
    {
        System.out.println(" --------- SEARCHING MOVIE  ---------- ");
        System.out.println("|                                    |");
        System.out.println("|     Enter the name of the movie    | ");
        System.out.println("|                                    |");
        System.out.println(" ------------------------------------ ");
        System.out.println("");
        System.out.print(">> ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        try
        {
            Movie movie = new Movie(title);
            while(runMovieDetails(movie));
        }
        catch (IOException exception)
        {
            System.out.println("Movie Was Not Found! Please Try Again...");
            showMovieSearch();
        }
    }

    static boolean runMovieDetails(Movie movie)
    {
        System.out.println();
        System.out.println(" ---------    MOVIE INFO   ---------- ");
        System.out.println("");
        System.out.println("> " + movie.title);
        System.out.println(">> Description: " + movie.description);
        System.out.println("");
        System.out.println(">> Director: " + movie.director);
        System.out.println(">> Runtime: " + movie.runtime);
        System.out.println(" ________      Ratings:     ________ ");
        System.out.println(">> IMDB Votes: " + movie.imdbVotes);
        System.out.println(">> Ratings: " + movie.rating);
        System.out.println(" ________        Stars:       ________ ");
        int i = 1;
        for(Actors actor : movie.Actors)
        {
            System.out.println(i + ") " + actor.name);
            i++;
        }

        if(movie.Actors.size() == 0)
        {
            System.out.println("-- No Actor Was Found For This Movie --");
        }
        System.out.println("");

        System.out.println(">Enter the number of the actor: (or other thing to go back):");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        try
        {
            int actorNumber = Integer.parseInt(command);
            if(actorNumber < 1 || actorNumber > movie.Actors.size())
            {
                return false;
            }
            showActorDetials(movie.Actors.get(actorNumber-1));
            return true;
        }
        catch (NumberFormatException exception)
        {
            return false;
        }
    }

    static void showActorDetials(Actors actor)
    {
        System.out.println();
        System.out.println(" ---------    ACTOR INFO   ---------- ");
        System.out.println("");
        System.out.println("> " + actor.name);
        if(actor.isAlive == false)
        {
            System.out.println(">> Date of Death: " + actor.deathDate);
        }
        System.out.println(">> Nationality: " + actor.nationality);
        System.out.println(">> Net-Worth: " + actor.netWorth);
        System.out.println("");
        System.out.println("");

        System.out.println(">Enter anything to back:          ");
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }


}