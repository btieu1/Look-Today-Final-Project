else if(sourceEvent == addSocksButton){
         //getting all the values in the input table so tjacket a new clothing object can be made from the specified attributes      
         String stackable8 = (String)trufalsBox8.getSelectedItem();
         String permanent8 = (String)yesnoBox8.getSelectedItem();
         String season8 = (String)seasonsBox8.getSelectedItem();
         String color8 = (String)colorsBox8.getSelectedItem();
         String occasion8 = (String)occasionsBox8.getSelectedItem();
         String id8 = idField8.getText();
         //get the specific type for Socks
         String type8 = (String)typesSocksBox.getSelectedItem();
         //add the clothing type         
         Scarf addSocks = new Socks(stackable8, permanent8, season8, color8, occasion8, type8, id8); 
         socksArray.add(addSocks);
       
         for (i = 0; i < NUM_CLOTHES && i < socksArray.size(); ++i) {
            if (socksArray.get(i) == null) { // Clear table entries 
               clothingListTable8.setValueAt(null, i, num0);
               clothingListTable8.setValueAt(null, i, num1);
               clothingListTable8.setValueAt(null, i, num2);
               clothingListTable8.setValueAt(null, i, num3);
               clothingListTable8.setValueAt(null, i, num4);
               clothingListTable8.setValueAt(null, i, num5);
               clothingListTable8.setValueAt(null, i, num6);
            }
            else {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable8.setValueAt(sockArray.get(i).getStackable(), i, num0);
               clothingListTable8.setValueAt(sockArray.get(i).getPermanent(), i, num1);
               clothingListTable8.setValueAt(sockArray.get(i).getSeason(), i, num2);
               clothingListTable8.setValueAt(sockArray.get(i).getColor(), i, num3);
               clothingListTable8.setValueAt(sockArray.get(i).getOccasion(), i, num4);
               clothingListTable8.setValueAt(sockArray.get(i).getType(), i, num5);
               clothingListTable8.setValueAt(sockArray.get(i).getID(), i, num6);
            }
         }  
      }
