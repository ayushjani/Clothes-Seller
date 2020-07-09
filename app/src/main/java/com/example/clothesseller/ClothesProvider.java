package com.example.clothesseller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ClothesProvider {

    // Create sets of lists to include as parameters for the classes, specified in order

    public static ArrayList<ArrayList<String>> generateSale(){
        ArrayList<ArrayList<String>> listOfSale = new ArrayList<ArrayList<String>>();
        listOfSale.add(new ArrayList<String>(Arrays.asList("All Blacks","allblacks", "T-Shirts", "$45.00", "• The official All blacks jersey. \n• Cut for a fit that’s wider at the body with a straight silhouette. \n• Silky hand feel.")));
        listOfSale.add(new ArrayList<String>(Arrays.asList("Track","trackpant", "Pants", "$40.00", "• Adidas Mens trackpants. \n• Navy Blue colour with white adidas lines.")));
        listOfSale.add(new ArrayList<String>(Arrays.asList("Windbreaker","windbreaker", "Jackets", "$35.00", "• Womens light windbreaker. \n• Dulled blue colour. \n• Cord adjustable waistband and hood")));
        listOfSale.add(new ArrayList<String>(Arrays.asList("Fancy","fancy", "T-Shirts", "$20.00", "• Fancy womens tshirt. \n• Burgundy red colour. \n• Side bowtie belt.")));
        listOfSale.add(new ArrayList<String>(Arrays.asList("Ripped Jeans","ripped", "Pants", "$35.00", "• Womens Ripped jeans. \n• Faded light blue colour. \n• High ankle cut")));
        listOfSale.add(new ArrayList<String>(Arrays.asList("Faux suede","fauxsuede", "Jackets", "$30.00", "• Faux Suede Womens jacket. \n• Deep Burgundy colour. \n• Convertible Collar and Zipped Slant Pocket. ")));
        return listOfSale;
    }

    //separate list for different categories so they only have to generate one specific to what needs to be supplied for the
    //recycler view
    public static List<Clothes> getSaleitems() {
        List<Clothes> salesList = new ArrayList<Clothes>();
        ArrayList<ArrayList<String>> saleItem = generateSale();
        ArrayList<String> words = new ArrayList<String>();
        int maxRandView = 200;
        for (int i = 0; i < saleItem.size(); i++){
            //create an new array list to get each nested array list

            words = saleItem.get(i);
            String name = words.get(0);
            String image1 = words.get(1) + "_1";
            String image2 = words.get(1) + "_2";
            String image3 = words.get(1) + "_3";
            String category = words.get(2);
            String price = words.get(3);
            Random random = new Random();
            int view = random.nextInt(maxRandView);

            //check if there is a description supplied to choose the constructor by checking the number of elements in the list
            if ( words.size() == 4) {
                Clothes t = new Clothes(name, image1, image2, image3, category, price, view);
                salesList.add(t);
            //use normal constructor with a provided description
            } else {
                String description = words.get(4);
                Clothes t = new Clothes(name, image1, image2, image3, category, price, description, view);
                salesList.add(t);
            }

        }

        return salesList;
    }

    //Method that creates a list of lists for each classes parameters
   public static ArrayList<ArrayList<String>> generateTShirts() {
       ArrayList<ArrayList<String>> listOfTShirts = new ArrayList<ArrayList<String>>();
       listOfTShirts.add(new ArrayList<String>(Arrays.asList("All Blacks","allblacks", "T-Shirts", "$45.00", "• The official All blacks jersey. \n• Cut for a fit that’s wider at the body with a straight silhouette. \n- Silky hand feel.")));
       listOfTShirts.add(new ArrayList<String>(Arrays.asList("Crewneck","crewneck", "T-Shirts", "$30.00", "• Mens Ralph Lauren crewneck tee.\n• Navy blue colour. \n• Slim body fit" )));
       listOfTShirts.add(new ArrayList<String>(Arrays.asList("Exercise","exercise", "T-Shirts", "$20.00","• Womens Under Armour exercise tshirt. \n• Neon yellow colour. \n• Anti-odor technology prevents the growth of odor-causing microbes. ")));
       listOfTShirts.add(new ArrayList<String>(Arrays.asList("Fancy","fancy", "T-Shirts", "$20.00", "• Fancy womens tshirt. \n• Burgundy red colour. \n• Side bowtie belt.")));
       listOfTShirts.add(new ArrayList<String>(Arrays.asList("Freedom","freedom", "T-Shirts", "$20.00", "• Mens Under Armour tshirt. \n• Navy and Gold Colour. \n• USA flag illustrated on back.")));
       listOfTShirts.add(new ArrayList<String>(Arrays.asList("Gym","gym_t", "T-Shirts", "$10.00", "• Simple black gym tshirt. \n• Anti-odor technology prevents the growth of odor-causing microbes.")));
       listOfTShirts.add(new ArrayList<String>(Arrays.asList("Long","long", "T-Shirts", "$15.00", "• Womens long dress-style tshirt. \n• Black and white stripes.")));
       listOfTShirts.add(new ArrayList<String>(Arrays.asList("Sports","sports", "T-Shirts", "$25.00", "• Offical Nike Air sports tshirt. \n• Anti-odor technology prevents the growth of odor-causing microbes.")));
       listOfTShirts.add(new ArrayList<String>(Arrays.asList("Floral","floral", "T-Shirts", "$15.00", "• Floral womens tee. \n• Pink, Blue and Green colouring. \n• V-neck cut.")));
       listOfTShirts.add(new ArrayList<String>(Arrays.asList("V-neck","vneck", "T-Shirts", "$15.00", "• Womens V-neck tshirt. \n• Teal colour.")));
       return listOfTShirts;
   }

    public static List<Clothes> getTShirts() {
        List<Clothes> tShirtsList = new ArrayList<Clothes>();
        ArrayList<ArrayList<String>> tshirts = generateTShirts();
        ArrayList<String> words = new ArrayList<String>();
        int maxRandView = 200;
        for (int i = 0; i < tshirts.size(); i++) {

            //create an new array list to get each nested array list

            words = tshirts.get(i);
            String name = words.get(0);
            String image1 = words.get(1) + "_1";
            String image2 = words.get(1) + "_2";
            String image3 = words.get(1) + "_3";
            String category = words.get(2);
            String price = words.get(3);
            Random random = new Random();
            int view = random.nextInt(maxRandView);

            //check if there is a description supplied to choose the constructor
            if ( words.size() == 4) {
                Clothes t = new Clothes(name, image1, image2, image3, category, price, view);
                tShirtsList.add(t);

            } else {
                String description = words.get(4);
                Clothes t = new Clothes(name, image1, image2, image3, category, price, description, view);
                tShirtsList.add(t);
            }

        }

        return tShirtsList;
    }


    public static ArrayList<ArrayList<String>> generatePants() {
        ArrayList<ArrayList<String>> listOfPants = new ArrayList<ArrayList<String>>();
        listOfPants.add(new ArrayList<String>(Arrays.asList("Casual","casual", "Pants", "$40.00", "• Casual mens pants. \n• Grey colour. \n• Drop-crotch, drawsstring and elestic cuffed")));
        listOfPants.add(new ArrayList<String>(Arrays.asList("Comfy Harem","comfyharem", "Pants", "$20.00", "• Comfy womens Harem style pants. \n• Dark Blue colour. \n• Loose fit ")));
        listOfPants.add(new ArrayList<String>(Arrays.asList("Denim","denim", "Pants", "$30.00", "• Mens Stylish denim pants. \n• Dark blue colour")));
        listOfPants.add(new ArrayList<String>(Arrays.asList("Dress","dress", "Pants", "$25.00", "• Womens formal styled pants.\n• Black Colour")));
        listOfPants.add(new ArrayList<String>(Arrays.asList("Formal","formal", "Pants", "$40.00", "• Mens business formal pants. \n• Faded Blue colour. \n• High quality material")));
        listOfPants.add(new ArrayList<String>(Arrays.asList("Gym","gym", "Pants", "$50.00", "• Mens Nike gym pants.\n• Dark Blue colour.\n• Drawstring waistband and cuffed ankles")));
        listOfPants.add(new ArrayList<String>(Arrays.asList("Jogger","jogger", "Pants", "$40.00", "• Womens Jogging pants. \n• Black colour with red and white details. ")));
        listOfPants.add(new ArrayList<String>(Arrays.asList("Leggings","leggings", "Pants", "$40.00", "• Nike Womens Legging. \n• Black colour with transparent calf section \n• Thick elastic waistband")));
        listOfPants.add(new ArrayList<String>(Arrays.asList("Ripped Jeans","ripped", "Pants", "$35.00", "• Womens Ripped jeans. \n• Faded light blue colour. \n• High ankle cut")));
        listOfPants.add(new ArrayList<String>(Arrays.asList("Track","trackpant", "Pants", "$40.00", "• Adidas Mens trackpants. \n• Navy Blue colour with white adidas lines.")));
        return listOfPants;
    }

    public static List<Clothes> getPants() {
        List<Clothes> pantsList = new ArrayList<Clothes>();
        ArrayList<ArrayList<String>> pants = generatePants();
        ArrayList<String> words = new ArrayList<String>();
        int maxRandView = 200;
        for (int i = 0; i < pants.size(); i++) {

            //create an new array list to get each nested array list

            words = pants.get(i);
            String name = words.get(0);
            String image1 = words.get(1) + "_1";
            String image2 = words.get(1) + "_2";
            String image3 = words.get(1) + "_3";
            String category = words.get(2);
            String price = words.get(3);
            Random random = new Random();
            int view = random.nextInt(maxRandView);

            //check if there is a description supplied to choose the constructor
            if ( words.size() == 4) {
                Clothes p = new Clothes(name, image1, image2, image3, category, price, view);
                pantsList.add(p);

            } else {
                String description = words.get(4);
                Clothes p = new Clothes(name, image1, image2, image3, category, price, description, view);
                pantsList.add(p);
            }

        }

        return pantsList;
    }


    public static ArrayList<ArrayList<String>> generateJackets() {
        ArrayList<ArrayList<String>> listOfJackets = new ArrayList<ArrayList<String>>();
        listOfJackets.add(new ArrayList<String>(Arrays.asList("Bomber","bomber", "Jackets", "$40.00","• Mens Bomber jacket. \n• Black colour with golden zipper. \n• Side arm pocket.")));
        listOfJackets.add(new ArrayList<String>(Arrays.asList("Denim","denim_j", "Jackets", "$35.00", "• Mens Denim jacket. \n• Faded Blue colour. \n• Button close and two chest pockets.")));
        listOfJackets.add(new ArrayList<String>(Arrays.asList("Faux suede","fauxsuede", "Jackets", "$30.00", "• Faux Suede Womens jacket. \n• Deep Burgundy colour. \n• Convertible Collar and Zipped Slant Pocket. ")));
        listOfJackets.add(new ArrayList<String>(Arrays.asList("Parka","parka", "Jackets", "$45.00", "• Womens parka jacket. \n• Black colour. \n• Fur colour and custom clip belt.")));
        listOfJackets.add(new ArrayList<String>(Arrays.asList("Puffer","puffer", "Jackets", "$60.00", "• Mens Puffer jacket. \n• Bright blue colour. \n• Zipper style with zipping pockets.")));
        listOfJackets.add(new ArrayList<String>(Arrays.asList("Rain","rain", "Jackets", "$40.00","• Mens Columbia Rain jacket. \n• Red colour with gray accents. \n• Inner mesh pockets and cord adjustable waist. ")));
        listOfJackets.add(new ArrayList<String>(Arrays.asList("Hoody","hoody", "Jackets", "$20.00", "• Womens sports hoody. \n• Dark red colour. \n• Zipper style jacket with string adjustable hood. ")));
        listOfJackets.add(new ArrayList<String>(Arrays.asList("Utility","utility", "Jackets", "$40.00", "• Mens utility jacket. \n• Navy blue colour. \n• 4 front facing pockets plus side pockets")));
        listOfJackets.add(new ArrayList<String>(Arrays.asList("Windbreaker","windbreaker", "Jackets", "$35.00", "• Womens light windbreaker. \n• Dulled blue colour. \n• Cord adjustable waistband and hood")));
        listOfJackets.add(new ArrayList<String>(Arrays.asList("Womens Leather","womens_leather", "Jackets", "$40.00", "• Womens biker style leather jacket. \n• Black colour. \n• Zip style front with with textured shoulder pads")));
        return listOfJackets;
    }

    public static List<Clothes> getJackets() {
        List<Clothes> jacketsList = new ArrayList<Clothes>();
        ArrayList<ArrayList<String>> jackets = generateJackets();
        ArrayList<String> words = new ArrayList<String>();
        int maxRandView = 200;
        for (int i = 0; i < jackets.size(); i++) {

            //create an new array list to get each nested array list

            words = jackets.get(i);
            String name = words.get(0);
            String image1 = words.get(1) + "_1";
            String image2 = words.get(1) + "_2";
            String image3 = words.get(1) + "_3";
            String category = words.get(2);
            String price = words.get(3);
            Random random = new Random();
            int view = random.nextInt(maxRandView);

            //check if there is a description supplied to choose the constructor
            if ( words.size() == 4) {
                Clothes j = new Clothes(name, image1, image2, image3, category, price, view);
                jacketsList.add(j);

            } else {
                String description = words.get(4);
                Clothes j = new Clothes(name, image1, image2, image3, category, price, description, view);
                jacketsList.add(j);
            }

        }

        return jacketsList;
    }



}

