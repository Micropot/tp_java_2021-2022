public class Main {
    public static void main(String[] args) {


        double h;//on defini nu object de type double
        /*if(args.length == 4){
            try{
                double latitude1 = Double.parseDouble(args[0]);
                double longitude1 = Double.parseDouble(args[1]);
                double latitude2 = Double.parseDouble(args[2]);
                double longitude2 = Double.parseDouble(args[3]);
                //h = Haversine.distance(latitude1, longitude1, latitude2, longitude2);
                myInterface f = new myInterface(latitude1, longitude1, latitude2, longitude2);





                //System.out.println("Distance calculée : "+h+"km");
            }
            catch (NumberFormatException exception){
                System.out.println("mauvais type d'argument, il faut deux doubles.");
            }
        }
        else{
            System.out.println("veuillez rentrer 4 arguments");
        }*/

        double latitude1 = 0.0;
        double longitude1 = 0.0;
        double latitude2 = 0.0;
        double longitude2 = 0.0;
        myInterface f = new myInterface(latitude1, longitude1, latitude2, longitude2);





    }
}

