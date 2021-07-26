import place.Place;
import vehicle.Vehicle;
import vehicle.VehicleNames;
import weapon.Weapon;
import weapon.WeaponNames;
//공격력과 체력을 Unit 에서 상속받아서 사용하는 클래스
public class Character extends Unit{
    private String name; //유닛의 이름

    private Weapon wearingWeapon; //착용중인 무기
    private Vehicle ridingVehicle; //타고있는 이동수단
    private int speed; //이동 속도
    private int reducedStamina = 3 ; //체력 감소
    private int additionalAttackPoint; //추가 공격력
    private boolean isEnd = true;

    public Character(){
        super(100,10); //초반 체력과 공격력을 100, 10으로 설정

        wearingWeapon = new Weapon(WeaponNames.주먹); //기본 장착 무기
        ridingVehicle = new Vehicle(VehicleNames.다리); //기본 장착 이동수단
        this.speed = 3;
        additionalAttackPoint = wearingWeapon.getAttackPoint();
    }

    public void showInfo(){
        System.out.println(this.name + "님의 현재 상태");
        System.out.println("=======================");
        System.out.println("체력 :         [" + getHealth() +"/ 100]");
        System.out.println("공격력 :        [" + getAttackPoint() +"]");
        System.out.println("이동속도 :      [" + ridingVehicle.getSpeed() + "]");
        System.out.println("무기 :         [" + wearingWeapon.getName() + "]");
        System.out.println("이동수단:       [" + ridingVehicle.getName() + "]");
        System.out.println("이동소모체력:    [" + reducedStamina + "]");
        System.out.println("=======================");
   }

    public void attack(Zombie zombie){
        int damage = this.getAttackPoint();

        System.out.println("=======================");
        System.out.println(this.name + "가 " + zombie.getZombieNames()+ "를 공격합니다.");
        zombie.noticeDamage(damage);
        System.out.println("현재 " + zombie.getZombieNames()+"의 체력은 "+zombie.getHealth()+"/"+zombie.getMaxHealth());

        if(zombie.getHealth() > damage)
            zombie.setHealth(zombie.getHealth() - damage);
        else
            zombie.setHealth(0);

        if(zombie.getHealth() <= 0){
            zombie.setHealth(0);
        }
   }

    public void recovery(){
        System.out.println("============================");
        System.out.println("플레이어 "+this.name+"님이 많이 지쳐있습니다.");
        while(isEnd) {
            if (getHealth() <= 100) {
                Main.gameModule.sleep();
                System.out.println("┌────────────────────────────────┐");
                System.out.println(this.name + "님의 체력을 10 회복합니다.");
                System.out.println("  현재 체력 :" + getHealth() + "/100");
                System.out.println("└────────────────────────────────┘");
                setHealth(getHealth()+10);
            } else if (getHealth() > 100) {
                System.out.println(this.name + "님이 충분히 휴식하였습니다.");
                System.out.println("다시 떠나 볼까요?");
                isEnd = false;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() { return speed;}

}
