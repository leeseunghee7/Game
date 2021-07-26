/** 좀비의 이름을 나열한 클래스입니다.
 * 1필드 서울역 - 수원
 * 2필드 수원 - 충주
 * 3필드 충주 - 상주
 * 4필드 상주 - 대구
 * 5필드 대구 - 경주
 *
 */
public enum ZombieNames {
    여학생좀비(0),회사원좀비(1),의사좀비(2),경찰관좀비(3),헬창좀비(4),
    남학생좀비(0),교사좀비(1),간호사좀비(2),소방관좀비(3),군인좀비(4);

    private int num; //좀비 랜덤 소환을 위한 번호
    ZombieNames(int num) {this.num = num; }

    public int getNum(){return num;}
}
