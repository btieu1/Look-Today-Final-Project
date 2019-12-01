public class Scarf extends Clothing{
   
   //attributes or variables specific to scarves (Still Working on)
   
   //constructor
   public Scarf(String stackable, String permanent, String season, String color, String occasion, String type, String ID){
      super(stackable, permanent, season, color, occasion, type, ID);
   }
   
   public String getStackable(){
      return this.stackable;
   }
   
   public String getPermanent(){
      return this.permanent;
   }
   
   public String getOccasion(){
      return this.occasion;
   }
}
