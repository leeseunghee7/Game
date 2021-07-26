import java.util.Scanner;

public class GameModule extends Thread{
    private Scanner scanner = new Scanner(System.in); //콘솔창에서 입력받기 위한 스캐너
    private int behaviorSelect; //행동을 입력받는 변수
    private Character character = new Character(); //캐릭터 객체
    private CharacterBehavior characterBehavior = CharacterBehavior.RESTING; //게임 시작시 캐릭터의 상태는 휴식으로 설정

    private String characterName; //캐릭터의 이름

    private boolean isEnd = false; //게임이 끝났는지 여부를 결정하는 변수

    public GameModule() {
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("             Covid-19 World              ");
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("=========================================");
        sleep();
        System.out.println(" 2021년 8월 세상을 떠들썩하게한 코로나바이러스는 변이를 거듭하고");
        sleep();
        System.out.println("정부와 공중 보건 전문가들은 Covid - Zombie 바이러스를 발견한다.");
        sleep();
        System.out.println("바이러스에 감염되면 자아를 잃고 사람들을 공격하기 시작하는데 ");
        sleep();
        System.out.println("대한민국의 수도 서울은 좀비바이러스의 여파로 감염자가 속출하는 상황");
        sleep();
        System.out.println("감염을 막기위해 폐쇄를 결정한 경주만이 유일하게 안전한 장소가되었다.");
        sleep();
        System.out.println("감염자들을 피해 안전한 장소 경주로 이동해야한다.");
        sleep();sleep();
        System.out.println("\n\n=======================");
        System.out.println("플레이어의 이름을 입력하세요");
        System.out.println("=======================");
        System.out.println("닉네임 : ");

        characterName = scanner.next(); //콘솔창에서 string 으로 입력 받기
        character.setName(characterName); //캐릭터 이름 set

        System.out.println("\n\n\n==========================");
        System.out.println("반갑습니다 플레이어 "+ characterName + "님");
        System.out.println("==========================");
        System.out.println();
        sleep();
        System.out.println("====================================================");
        System.out.println("서울역 -> 수원시-> 충주시 -> 상주시 -> 대구광역시 -> 경주시");
        System.out.println();
        System.out.println("   서울역에서 출발하여 마주치는 좀비들을 처지하며");
        System.out.println();
        System.out.println("   각 도시들을 통과해 경주까지 도착하면 성공 !!");
        System.out.println("====================================================");

        character.showInfo(); //게임 시작 직전 캐릭터 정보 출력

    }

    @Override
    public void run(){
        while(!isEnd){
            showBehaviorList();
            System.out.println("선택 : ");
            behaviorSelect = scanner.nextInt();
            if(behaviorSelect == 1)
                characterBehavior = CharacterBehavior.MOVING;
            else if(behaviorSelect == 2)
                characterBehavior = CharacterBehavior.RECOVERING;
            else if(behaviorSelect == 3)
                isEnd = true;

            if(characterBehavior == CharacterBehavior.MOVING){
                MovingThread movingThread = new MovingThread();
                movingThread.start();

                synchronized (movingThread) {
                    try {
                        movingThread.wait();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                sleep();
                characterBehavior = CharacterBehavior.RESTING;
            }
            else if (characterBehavior == CharacterBehavior.RECOVERING){
                if(character.getHealth() == 100)
                    System.out.println("캐릭터의 체력이 충분하여 휴식이 필요하지 않습니다.");
                else
                    character.recovery();
                characterBehavior = CharacterBehavior.RESTING;
            }

        }
    }

    public void showBehaviorList() {
        System.out.println();
        System.out.println("============================");
        System.out.println("1 : 이동하기");
        System.out.println("2 : 휴식");
        System.out.println("3 : 종료");
        System.out.println("============================");
    }

    public void sleep () {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Character getCharacter() {return character;}
}


