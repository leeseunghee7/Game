package place;

public class Place {
    private PlaceNames placeNames;
    private String name;
    private int distance;

    public Place(PlaceNames placeNames){
        this.placeNames = placeNames;

        if(placeNames == PlaceNames.서울역){
            this.name = "서울역";
            this.distance = 320;
        }
        else if (placeNames == PlaceNames.수원){
            this.name = "수원";
            this.distance = 260;
        }
        else if (placeNames == PlaceNames.충주){
            this.name = "충주";
            this.distance = 200;
        }
        else if (placeNames == PlaceNames.상주){
            this.name = "상주";
            this.distance = 140;
        }
        else if (placeNames == PlaceNames.대구){
            this.name = "대구";
            this.distance = 60;
        }
        else if (placeNames == PlaceNames.경주){
            this.name = "경주";
            this.distance = 0;
        }
    }
    public String getName() { return name; }
    public int getDistance() { return distance;}
    public PlaceNames getPlaceNames() {return placeNames;}
}
