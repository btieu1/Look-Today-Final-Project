public abstract class Clothing{
   protected boolean stackable;
   protected boolean permanent;
   protected String season;
   protected String color;
   protected String occasion;
   protected String material;
   
   public Clothing(boolean stackable, boolean permanent, String season, String color, String occasion, String material){
      this.stackable = stackable;
      this.permanent = permanent;
      this.season = season;
      this.color = color;
      this.occasion = occasion;
      this.material = material;
   }
   
}