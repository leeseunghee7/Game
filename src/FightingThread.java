import place.Place;
import place.PlaceNames;

import java.util.ArrayList;
import java.util.Scanner;

public class FightingThread extends Thread{
    private Scanner scanner = new Scanner(System.in);

    private ArrayList<Zombie> seoulStationZombie = new ArrayList<>(); //서울역 좀비리스트
    private ArrayList<Zombie> suWonZombie = new ArrayList<>(); //수원 좀비리스트
    private ArrayList<Zombie> chungJuZombie = new ArrayList<>(); //충주 좀비리스트
    private ArrayList<Zombie> sangJuZombie = new ArrayList<>(); //상주 좀비리스트
    private ArrayList<Zombie> daeGuZombie = new ArrayList<>(); //대구 좀비리스트
    //private Place place;
    private PlaceNames movingField;
    private Zombie fieldZombie;

    private Character character = Main.gameModule.getCharacter();

    private boolean isEnd = false;

    public FightingThread(){
        initializeZombieList(PlaceNames.서울역);
        initializeZombieList(PlaceNames.수원);
        initializeZombieList(PlaceNames.충주);
        initializeZombieList(PlaceNames.상주);
        initializeZombieList(PlaceNames.대구);
        //Field = place.getPlaceNames();
    }

    @Override
    public void run(){
        synchronized (this){
            new FightingThread();
            callZombie();
            fightWithZombie();
            notify();
        }
    }

    public void initializeZombieList(PlaceNames movingField){
        if(movingField == PlaceNames.서울역){
            seoulStationZombie.add(new Zombie(ZombieNames.여학생좀비,1));
            seoulStationZombie.add(new Zombie(ZombieNames.남학생좀비,1));
        }
        else if(movingField == PlaceNames.수원){
            suWonZombie.add(new Zombie(ZombieNames.교사좀비,2));
            suWonZombie.add(new Zombie(ZombieNames.회사원좀비,2));
        }
        else if(movingField == PlaceNames.충주){
            chungJuZombie.add(new Zombie(ZombieNames.간호사좀비,3));
            chungJuZombie.add(new Zombie(ZombieNames.의사좀비,3));
        }
        else if(movingField == PlaceNames.상주){
            sangJuZombie.add(new Zombie(ZombieNames.경찰관좀비,4));
            sangJuZombie.add(new Zombie(ZombieNames.소방관좀비,4));
        }
        else if(movingField == PlaceNames.대구){
            daeGuZombie.add(new Zombie(ZombieNames.군인좀비,5));
            daeGuZombie.add(new Zombie(ZombieNames.회사원좀비,5));
        }
    }
    public void callZombie() {
        int randNum = (int)(Math.random() * 100) % 5;
        if(movingField == PlaceNames.서울역){
            for(Zombie zombie : seoulStationZombie){
                if(zombie.getZombieNames().getNum() == randNum)
                    fieldZombie = new Zombie(zombie.getZombieNames(),zombie.getLevel());
            }
        }
        else if(movingField == PlaceNames.수원){
            for(Zombie zombie : suWonZombie){
                if(zombie.getZombieNames().getNum() == randNum)
                    fieldZombie = new Zombie(zombie.getZombieNames(),zombie.getLevel());
            }
        }
        else if(movingField == PlaceNames.충주){
            for(Zombie zombie : chungJuZombie){
                if(zombie.getZombieNames().getNum() == randNum)
                    fieldZombie = new Zombie(zombie.getZombieNames(),zombie.getLevel());
            }
        }
        else if(movingField == PlaceNames.상주){
            for(Zombie zombie : sangJuZombie){
                if(zombie.getZombieNames().getNum() == randNum)
                    fieldZombie = new Zombie(zombie.getZombieNames(),zombie.getLevel());
            }
        }
        else if(movingField == PlaceNames.대구){
            for(Zombie zombie : daeGuZombie){
                if(zombie.getZombieNames().getNum() == randNum)
                    fieldZombie = new Zombie(zombie.getZombieNames(),zombie.getLevel());
            }
        }
    }

    public void fightWithZombie(){

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println( "가 나타났다 !!!!!!!!!");
        System.out.println("1번을 입력해 공격하세요 !!!");

        if(scanner.nextInt() == 1){
            while(isEnd) {
                character.attack(fieldZombie);
                if (fieldZombie.getHealth() == 0) {
                    System.out.println("┌───────────────────────────┐");
                    System.out.println("   !!  감염자 처지 완료  !!");
                    System.out.println("      " + character.getName() + "WIN");
                    System.out.println("└───────────────────────────┘");
                    isEnd = false;
                }
                else if (character.getHealth() == 0) {
                    System.out.println("캐릭터가 사망하였습니다.");
                    System.exit(0);
                }
                fieldZombie.basicAttack(character);
            }
        }
    }
}
