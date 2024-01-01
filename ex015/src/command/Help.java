package command;

public class Help {
    String[] descriptions = {
            "/help - Show every command and how to manipulate it.",
            "/create - Creates a new task.",
            "/complete - Complete an existing task.",
            "/edit - Edit text or completion of an existing task.",
            "/delete - Delete an existing task.",
            "/clear - Delete all tasks."
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
