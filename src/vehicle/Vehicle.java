package vehicle;

public class Vehicle {
    private VehicleNames vehicleName;//이동수단의 이름(enum)
    private String name; //이동수단의 이름(string)
    private int speed; //이동수단의 속도

    public Vehicle(VehicleNames vehicleName){
        this.vehicleName = vehicleName;

        if(vehicleName == VehicleNames.다리){
            this.name = "다리";
            this.speed = 3;
        }
        else if(vehicleName == VehicleNames.전동킥보드){
            this.name = "전동킥보드";
            this.speed = 10;
        }
        else if(vehicleName == VehicleNames.바이크){
            this.name = "바이크";
            this.speed = 30;
        }
        else if(vehicleName == VehicleNames.자동차){
            this.name = "자동차";
            this.speed = 50;
        }
    }

    public String getName() { return name;}

    public int getSpeed() { return speed;}
}
