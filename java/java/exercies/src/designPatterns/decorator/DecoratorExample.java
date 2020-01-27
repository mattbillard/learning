package designPatterns.decorator;

interface Developer {
    public String makeJob();
}


// --------------


class JavaDeveloper implements Developer {
    public String makeJob() {
        return "Write Java Code";
    }
}

class DeveloperDecorator implements Developer {
    private Developer developer;

    public DeveloperDecorator(Developer developer) {
        this.developer = developer;
    }

    public String makeJob() {
        return developer.makeJob();
    }
}


// --------------


class SeniorJavaDeveloper extends DeveloperDecorator {
    public SeniorJavaDeveloper(Developer developer) {
        super(developer);
    }

    public String makeCodeReview() {
        return "Make code review";
    }

    public String makeJob() {
        return super.makeJob() + " " + makeCodeReview();
    }
}

class JavaTeamLead extends DeveloperDecorator {
    public JavaTeamLead(Developer developer) {
        super(developer);
    }

    public String sendWeekReport() {
        return "Send week report to customers.";
    }

    public String makeJob() {
        return super.makeJob() + " " + sendWeekReport();
    }
}


// --------------


public class DecoratorExample {
    public static void main(String[] args) {
        Developer developer = new JavaTeamLead(new SeniorJavaDeveloper(new JavaDeveloper()));

        // RECOMMENDATION - put a breakpoint here and step into every method
        System.out.println(developer.makeJob());
    }
}