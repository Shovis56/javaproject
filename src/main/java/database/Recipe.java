package database;

public class Recipe {

    private int id;
    private String ingredientName;
    private String ingredientType;

    public Recipe(){
    }

    public Recipe(int id){
        this.id = id;
    }

    public Recipe(int id, String ingredientName, String ingredientType){
        this(ingredientName,ingredientType);
        this.id = id;
    }

    public Recipe(String ingredientName, String ingredientType){
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getIngredientName(){
        return ingredientName;
    }

    public void setIngredientName(String ingredientName){
        this.ingredientName = ingredientName;
    }

    public String getIngredientType(){
        return ingredientType;
    }

    public void setIngredientType(String ingredientType){
        this.ingredientType = ingredientType;
    }

}
