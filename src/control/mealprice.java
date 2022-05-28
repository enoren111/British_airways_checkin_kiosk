package control;

public class mealprice {
    String meals;
    public mealprice(String meals){
        this.meals=meals;
    }

    public int calculatePrice(){
        return switch (meals) {
            case "Vegetarian", "Standard and Halal", "Halal", "Standard and Vegetarian" -> 10;
            case "Gourmet Menu" -> 50;
            case "Standard and Gourmet Menu", "Vegetarian and Gourmet Menu",
                    "Halal and Gourmet Menu", "Standard; Vegetarian and Gourmet Menu" -> 60;
            case "Vegetarian and Halal", "Standard; Vegetarian and Halal" -> 20;
            case "Vegetarian; Halal and Gourmet Menu", "Standard; Vegetarian; Halal and Gourmet Menu" -> 70;
            default -> 0;
        };
    }
}
