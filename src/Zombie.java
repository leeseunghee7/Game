public class Zombie extends Unit{
    private int level;
    private int maxHealth;
    private ZombieNames zombieNames;

    public Zombie(ZombieNames zombieNames,int level){
        super(40 + 20 * level,10+7*level);
        this.maxHealth = 40 + 20 * level;
        this.zombieNames = zombieNames;
        this.level = level;
    }

    public void basicAttack(Character character){
        int damage = this.getAttackPoint();
        System.out.println("                          =======================");
        System.out.println("                          "+this.zombieNames + "가" + character.getName()+"를 공격합니다.");
        System.out.println("                          현재 " + character.getName()+"의 체력은 "+character.getHealth()+"/100");
        if(character.getHealth() > damage){
            character.setHealth(character.getHealth() - damage);
        }
        else{
            character.setHealth(0);
        }
    }

    public void noticeDamage(int damage){
        System.out.println(damage +"만큼 데미지를 가했습니다.");
    }

    public int getLevel() { return level;}
    public ZombieNames getZombieNames() { return zombieNames;}
    public int getMaxHealth() { return maxHealth;}
}
