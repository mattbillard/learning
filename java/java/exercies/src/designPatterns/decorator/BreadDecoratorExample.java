package designPatterns.decorator;

public class BreadDecoratorExample {
    public static void main(String[] args) {
        Bread bagel = new Bagel();

        bagel = new Butter(bagel);
        bagel = new Butter(bagel);
        bagel = new Ham2(bagel);
        bagel = new Cheese2(bagel);

        System.out.println(bagel);

        Bread bun = new Bun();
        bun = new Butter(bun);
        bun = new Jam(bun);
        bun = new Jam(bun);

        System.out.println(bun);
    }
}

abstract class Bread {
    String description;
    int kcal;

    String getDescription() {
        return description;
    }

    int getKcal() {
        return kcal;
    }

    @Override
    public String toString() {
        return getDescription() + ". kCal: " + getKcal();
    }
}

class Bagel extends Bread {

    Bagel() {
        description = "Bagel";
        kcal = 250;
    }
}

class Bun extends Bread {

    Bun() {
        description = "Bun";
        kcal = 150;
    }
}

abstract class Decorator extends Bread {
    abstract String getDescription();
    abstract int getKcal();
}

class Butter extends Decorator {
    private Bread bread;

    Butter(Bread bread) {
        this.bread = bread;
    }

    @Override
    String getDescription() {
        return bread.getDescription() + ", Butter";
    }

    @Override
    int getKcal() {
        return bread.getKcal() + 50;
    }
}

class Jam extends Decorator {

    private Bread bread;

    Jam(Bread bread) {
        this.bread = bread;
    }

    @Override
    String getDescription() {
        return bread.getDescription() + ", Jam";
    }

    @Override
    int getKcal() {
        return bread.getKcal() + 120;
    }
}

class Cheese2 extends Decorator {

    private Bread bread;

    Cheese2(Bread bread) {
        this.bread = bread;
    }

    @Override
    String getDescription() {
        return bread.getDescription() + ", Cheese2";
    }

    @Override
    int getKcal() {
        return bread.getKcal() + 40;
    }
}

class Ham2 extends Decorator {

    private Bread bread;

    Ham2(Bread bread) {
        this.bread = bread;
    }

    @Override
    String getDescription() {
        return bread.getDescription() + ", Ham2";
    }

    @Override
    int getKcal() {
        return bread.getKcal() + 2500;
    }
}
