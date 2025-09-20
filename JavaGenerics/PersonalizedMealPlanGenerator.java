import java.util.*;

interface MealPlan {
    String getMealType();
    List<String> getAllowedIngredients();
    List<String> getRestrictedIngredients();
}

class VegetarianMeal implements MealPlan {
    public String getMealType() { return "Vegetarian"; }
    public List<String> getAllowedIngredients() { 
        return Arrays.asList("vegetables", "fruits", "dairy", "grains", "nuts"); 
    }
    public List<String> getRestrictedIngredients() { 
        return Arrays.asList("meat", "fish", "poultry"); 
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() { return "Vegan"; }
    public List<String> getAllowedIngredients() { 
        return Arrays.asList("vegetables", "fruits", "grains", "nuts", "legumes"); 
    }
    public List<String> getRestrictedIngredients() { 
        return Arrays.asList("meat", "fish", "poultry", "dairy", "eggs"); 
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() { return "Keto"; }
    public List<String> getAllowedIngredients() { 
        return Arrays.asList("meat", "fish", "eggs", "cheese", "low-carb vegetables"); 
    }
    public List<String> getRestrictedIngredients() { 
        return Arrays.asList("grains", "sugar", "fruits", "high-carb vegetables"); 
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() { return "High-Protein"; }
    public List<String> getAllowedIngredients() { 
        return Arrays.asList("meat", "fish", "eggs", "dairy", "legumes", "nuts"); 
    }
    public List<String> getRestrictedIngredients() { 
        return Arrays.asList("processed foods", "sugar"); 
    }
}

class Meal<T extends MealPlan> {
    private String mealName;
    private T mealPlan;
    private List<String> ingredients;
    
    public Meal(String mealName, T mealPlan) {
        this.mealName = mealName;
        this.mealPlan = mealPlan;
        this.ingredients = new ArrayList<>();
    }
    
    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }
    
    public String getMealName() { return mealName; }
    public T getMealPlan() { return mealPlan; }
    public List<String> getIngredients() { return ingredients; }
    
    @Override
    public String toString() {
        return mealName + " (" + mealPlan.getMealType() + ") - Ingredients: " + ingredients;
    }
}

public class PersonalizedMealPlanGenerator {
    
    public static <T extends MealPlan> boolean validateMeal(Meal<T> meal) {
        T plan = meal.getMealPlan();
        List<String> restrictedIngredients = plan.getRestrictedIngredients();
        
        for (String ingredient : meal.getIngredients()) {
            if (restrictedIngredients.contains(ingredient)) {
                System.out.println("Invalid ingredient '" + ingredient + "' for " + plan.getMealType() + " meal plan");
                return false;
            }
        }
        return true;
    }
    
    public static <T extends MealPlan> Meal<T> generateMeal(String mealName, T mealPlan, List<String> ingredients) {
        Meal<T> meal = new Meal<>(mealName, mealPlan);
        for (String ingredient : ingredients) {
            meal.addIngredient(ingredient);
        }
        
        if (validateMeal(meal)) {
            System.out.println("Valid meal generated: " + meal);
            return meal;
        } else {
            System.out.println("Failed to generate valid meal for " + mealName);
            return null;
        }
    }
    
    public static void main(String[] args) {
        List<String> vegIngredients = Arrays.asList("vegetables", "dairy", "grains");
        generateMeal("Veggie Pasta", new VegetarianMeal(), vegIngredients);
        List<String> veganIngredients = Arrays.asList("vegetables", "nuts", "legumes");
        generateMeal("Quinoa Salad", new VeganMeal(), veganIngredients);
        List<String> ketoIngredients = Arrays.asList("meat", "cheese", "low-carb vegetables");
        generateMeal("Steak with Broccoli", new KetoMeal(), ketoIngredients);
        List<String> invalidIngredients = Arrays.asList("vegetables", "meat");
        generateMeal("Invalid Vegan Meal", new VeganMeal(), invalidIngredients);
    }
}