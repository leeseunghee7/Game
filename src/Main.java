public class Main {

    public static GameModule gameModule; //게임모듈을 main 에서 사용하기위한 정적 변수

    public static void main(String[] args){
        gameModule = new GameModule();
        gameModule.start();
    }

}
