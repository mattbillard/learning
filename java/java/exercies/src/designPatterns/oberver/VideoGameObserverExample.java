package designPatterns.oberver;

import java.util.*;

interface Observable {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}

class RockstarGames implements Observable {
    public String releaseGame;
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public void release(String game) {
        this.releaseGame = game;
        notifyObserver();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers) {
            System.out.println("Notification for gamer : " + observer);
            observer.update(releaseGame);
        }
    }
}

interface Observer {
    public void update(String domain);
}

class Gamer implements Observer {
    private String name;
    private Observable observable;
    private Set<String> games = new HashSet<String>();

    public Gamer(String name,Observable observable) {
        this.name = name;
        this.observable = observable;
    }

    @Override
    public void update(String game) {
        buyGame(game);
    }

    public void buyGame(String game) {
        System.out.println(name + " says : \"Oh, Rockstar releases new game " + game + " !\"");
        games.add(game);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class VideoGameObserverExample {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String game = null;

        RockstarGames rockstarGames = new RockstarGames();

        Gamer garry = new Gamer("Garry Rose",rockstarGames);
        Gamer peter = new Gamer("Peter Johnston",rockstarGames);
        Gamer helen = new Gamer("Helen Jack",rockstarGames);

        rockstarGames.addObserver(garry);
        rockstarGames.addObserver(peter);
        rockstarGames.addObserver(helen);

        game = scanner.nextLine();
        rockstarGames.release(game);

        scanner.close();
    }
}
