package weapon;

public class Weapon {
    private WeaponNames weaponName; //무기의 이름(enum)
    private String name; //무기의 이름 (String)
    private int attackPoint; //무기의 공격력

    //생성자 - 무기의 이름을 부여하면 이름과 공격력 설정
    public Weapon(WeaponNames weaponName){
        this.weaponName = weaponName;

        if(weaponName == WeaponNames.주먹){
            this.name = "주먹";
            this.attackPoint = 5;
        }
        else if(weaponName == WeaponNames.야구배트){
            this.name = "야구배트";
            this.attackPoint = 10;
        }
        else if(weaponName == WeaponNames.활){
            this.name = "활";
            this.attackPoint = 40;
        }
        else if(weaponName == WeaponNames.권총){
            this.name = "권총";
            this.attackPoint = 70;
        }
        else if(weaponName == WeaponNames.샷건){
            this.name = "샷건";
            this.attackPoint = 100;
        }

    }
    public String getName() { return name; }
    public int getAttackPoint() { return attackPoint;}

}
