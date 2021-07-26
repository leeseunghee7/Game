package weapon;

public class UserWeapon {
    private Weapon weapon; //무기

    public UserWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public Weapon getWeapon() { return weapon;}
    public void setWeapon(Weapon weapon) { this.weapon = weapon;}

}
