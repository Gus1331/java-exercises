package command;

public class Help {
    String[] descriptions = {
            "/help - ",
            "/create - ",
            "/complete -",
            "/delete -",
            "/update - "
    };

    public void printDescriptions(){
        System.out.println("Interactions");
        System.out.println();

        for(String i : descriptions) {
            System.out.println(i);
        }
        System.out.println();
        System.out.println("----------------");
    }
}
