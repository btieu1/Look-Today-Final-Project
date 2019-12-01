 public abstract class Clothing{
   protected String stackable;
   protected String permanent;
   protected String season;
   protected String color;
   protected String occasion;
   protected String type;
   protected String ID;
   
   public Clothing(String stackable, String permanent, String season, String color, String occasion, String type, String ID){
      this.stackable = stackable;
      this.permanent = permanent;
      this.season = season;
      this.color = color;
      this.occasion = occasion;
      this.type = type;
      this.ID = ID;
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
   
   public void setOccasion(String occasion){
      this.occasion = occasion;
   }
   
   public String getSeason(){
      return this.season;
   }
   
   public void setSeason(String season){
      this.season = season;
   }
   
   public String getColor(){
      return this.color;
   }
   
   public void setColor(String color){
      this.color = color;
   }
   
   public String[] getColorPalette(){
      String[] colors = new String[5];
      if(this.color.equals("beige")){
         colors = new String[]{"blue", "brown", "green", "black", "red", "white"};
      }
      
      if(this.color.equals("gray")){
         colors = new String[]{"purple", "red", "violet", "pink", "blue"};
      }
      
      if(this.color.equals("pink")){
         colors = new String[]{"brown", "white", "mint green", "olive", "gray", "turquoise", "light-blue"};
      }
      
      if(this.color.equals("purple")){
         colors = new String[]{"gray", "yellow-brown", "lime", "mint-green", "brown"};
      }
      
      if(this.color.equals("red")){
         colors = new String[]{"yellow", "white", "fulvous", "green", "blue", "black"};
      }
      
      if(this.color.equals("brown")){
         colors = new String[]{"cyan", "cream", "pink", "fawn", "green", "beige"};
      }
      
      if(this.color.equals("orange")){
         colors = new String[]{"cyan", "blue", "lilac", "violet", "white", "black"};
      }
      
      if(this.color.equals("yellow")){
         colors = new String[]{"blue", "lilac", "light-cyan", "purple", "gray", "black"};
      }
      
      if(this.color.equals("olive")){
         colors = new String[]{"orange", "light-brown", "brown"};
      }
      
      if(this.color.equals("green")){
         colors = new String[]{"golden-brown", "orange", "salad green", "yellow", "brown", "gray", "cream", "black", "creamy-white"};
      }
      
      return colors;
   }
   
   
   public String getID(){
      return this.ID;
   }
   
   public void setID(String ID){
      this.ID = ID;
   }
   
   public String getType(){
      return this.type;
   }
   
   public void setType(String Type){
      this.type = type;
   }
   
   public String toString(){
      return this.ID;
   }
}

