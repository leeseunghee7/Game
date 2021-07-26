import place.Place;
import place.PlaceNames;

import java.util.Scanner;

public class MovingThread extends Thread{
    private Scanner scanner = new Scanner(System.in);
    private Place startingPoint;
    private Place destination;
    private PlaceNames placeNames;
    private int distance;
    private Character character;
    private FightingThread fightingThread = new FightingThread();

    public MovingThread(){
        character = Main.gameModule.getCharacter();
        startingPoint = new Place(PlaceNames.서울역);
        destination = new Place(PlaceNames.경주);
        distance = startingPoint.getDistance();
        placeNames = startingPoint.getPlaceNames();
    }

    @Override
    public void run(){
        synchronized (fightingThread){
            while(true) {
                showMoving(); //이동 현황
                distance = distance - character.getSpeed(); //이동속도만큼 거리 감소
                character.setHealth(character.getHealth() - 3); //이동시 체력감소
                int randNum = (int) (Math.random() * 100) % 45; //랜덤한 지역에서 좀비 출현
                if (distance == distance - randNum) {
                    fight(); //fighting 스레드 실행
                    try {
                        fightingThread.wait();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (distance > 200 && distance <= 260){
                    startingPoint = new Place(PlaceNames.수원);
                    notify();
                }
                else if (distance > 140 && distance <= 200){
                    startingPoint = new Place(PlaceNames.충주);
                    notify();
                }
                else if (distance > 60 && distance <= 140){
                    startingPoint = new Place(PlaceNames.상주);
                    notify();
                }
                else if (distance >0 && distance <= 60){
                    startingPoint = new Place(PlaceNames.대구);
                    notify();
                }
                else if (distance <= 0){
                    notify();
                }
            }
        }
    }

    public void fight(){
        fightingThread.start();
    }

    public void showMoving(){
        System.out.println("[이동 거리]");
        System.out.println("=======================");
        System.out.println("출발 :    [" + startingPoint.getName() + "]");
        System.out.println("도착 :    [" + destination.getName() + "]");
        System.out.println("남은거리 : [" + distance + "KM]");
        System.out.println("=======================");
        Main.gameModule.sleep();
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.println("  "+ character.getName() + "가 "+character.getSpeed()+"KM 이동하였습니다.");
        System.out.println("  체력이 3감소 됩니다.   현재체력" + character.getHealth()+"/100");
        System.out.println("└───────────────────────────────────────────────┘");
    }

    public void startingPoint(){

    }

}
