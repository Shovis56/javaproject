package database;


public class Recipe {

    private int id;
    private String quantity;
    private String recipeName;
    private String ingredient;
    private String quantityUnit;


    public Recipe() {
    }

    public Recipe(int id) {
        this.id = id;
    }

    public Recipe(int id, String recipeName, String ingredient, String quantity, String quantityUnit) {
        this(recipeName, ingredient, quantity, quantityUnit);
        this.id = id;
    }

    public Recipe(String recipeName, String ingredient, String quantity, String quantityUnit) {
        this.recipeName = recipeName;
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
    }


    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }


}
