import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.Delayed;


public class java_umpus {
    public static Integer[] rooms = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19
    };
    public static Integer[][] links = {
            {1, 7, 4}, {0, 9, 2}, {1, 11, 3}, {2, 13, 4}, {3, 0, 5},
            {4, 14, 6}, {5, 16, 7}, {6, 0, 8}, {7, 17, 9}, {8, 1, 10},
            {9, 18, 11}, {10, 2, 12}, {11, 19, 13}, {12, 3, 14}, {13, 5, 15},
            {14, 19, 16}, {15, 6, 17}, {16, 8, 10}, {17, 10, 19}, {18, 12, 15}
    };
    public static String BAT = "BAT";
    public static String PIT = "PIT";
    public static String WUMPUS = "WUMPUS";
    public static String NOTHING = "NOTHING";

    public static ArrayList<String> hazards = new ArrayList<>();
    public static Scanner scan = new Scanner(System.in);
    public static Random random = new Random();
    public static HashMap<String,String> hazardMessage = new HashMap<>();

    public static boolean gameover = true;

    public static int currentR;
    public static int arrowC;
    public static int wumpusR;

    public static void main(String[] args) {
        showIntro();
        initializeStaticValue();
        while (true) {
            initializePlayVariables();
            setHazards();
            delay(1000L);
            System.out.println("\n...");
            delay(1000L);
            System.out.println("...");
            delay(1000L);
            System.out.println("동굴에 들어왔습니다...");
            delay(1000L);
            System.out.println("\"섬뜩한 곳이군..\"");
            delay(1000L);
            game();
            selectReplay();
        }
    }
    private static void game(){
        while (gameover == false){
            System.out.println("\n당신은" + currentR + "번 방에 있습니다.");
            System.out.println("행동을 선택하세요.");
            System.out.println("1. 이동");
            System.out.println("2. 화살쏘기");
            System.out.println("3. 통로 목록");
            System.out.println("0. 게임 종료");

            String action = scan.nextLine();
            if (action.equals("1")){
                Integer[] nextRooms = links[currentR];

                System.out.println("\n몇 번 방으로 이동하시겠습니까?");
                System.out.println(Arrays.toString(nextRooms));

                String nextRoomInput = scan.nextLine();
                int nextR = parseIntegerOrNegative1(nextRoomInput);

                if (Arrays.asList(nextRooms).contains(nextR)) {
                    move(nextR);
                }else {
                    System.out.println("선택한 방으로는 이동할 수 없습니다.");
                }

            }
            else if (action.equals("2")){
                Integer[] nextRooms = links[currentR];
                System.out.println("\n 몇 번 방에 화살을 쏘시겠습니까?");
                System.out.println(Arrays.toString(nextRooms));

                String targetRoomInput = scan.nextLine();
                int targetRoom = parseIntegerOrNegative1(targetRoomInput);

                if (Arrays.asList(nextRooms).contains(targetRoom)){
                    shoot(targetRoom);
                }else {
                    System.out.println("선택한 방에 화살을 쏠 수 없습니다.");
                }
            }
            else if (action.equals("3")){
                System.out.println("현재 방에 연결된 통로는 다음과 같습니다.");
                System.out.println(Arrays.asList(links[currentR]));
            }
            else if (action.equals("0")){
                System.out.println("게임을 종료합니다.");
                gameover = true;
            }
            else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }


    private static void showIntro() {
        try {
            FileInputStream inputStream = new FileInputStream("src/intro.txt");
            Scanner scan = new Scanner(inputStream);
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
                delay(1000L);
            }
        } catch (FileNotFoundException e) {
            System.out.println("인트로를 불러올 수 없어 생략합니다.");
        }
    }
    private static void initializePlayVariables() {
        gameover = false;
        currentR = random.nextInt(rooms.length);
        arrowC = 5;
    }
    public static void delay(Long ms){
        try {
            Thread.sleep(ms);
        }catch (InterruptedException e){
        }
    }
    public static void initializeStaticValue() {
        hazardMessage.put(WUMPUS, "\"어디선가 끔찍한 냄새가 난다.\"");
        hazardMessage.put(BAT, "\"어디선가 부스럭거리는 소리가 난다.\"");
        hazardMessage.put(PIT, "\"바람이 부는 소리가 들리는 것 같다.\"");
        hazardMessage.put(NOTHING, "\"저 방에는 아무것도 없는 것 같다.\"");
    }

    public static void setHazards() {
        if (hazards.size() == 0) {
            for (int i = 0; i < rooms.length; i=i+1) {
                hazards.add(NOTHING);
            }
        }
        for (int i = 0; i < rooms.length; i=i+1) {
            hazards.set(i, NOTHING);
        }
        String[] ordinals = {WUMPUS, BAT, BAT, BAT, PIT, PIT};

        for (String hazard : ordinals) {
            int room;
            while (true) {
                room = random.nextInt(rooms.length);
                if (isTooCloseWithPlayer(room)) {
                    continue;
                }
                if (hazards.get(room).equals(NOTHING)) {
                    break;
                }
            }
            hazards.set(room, hazard);
            if (hazard.equals(WUMPUS)) {
                wumpusR = room;
            }
        }
    }

    public static boolean isTooCloseWithPlayer(int room) {
        if (currentR == room) {
            return true;
        }
        List<Integer> linkedRooms = Arrays.asList(links[currentR]);
        if (linkedRooms.contains(room)) {
            return true;
        }
        return false;
    }

    private static void selectReplay() {
        System.out.println("게임이 끝났습니다. 다시 플레이 하시겠습니까?");

        while (true) {
            System.out.println("1 : 종료 \n 2 : 다시 플레이");
            String action = scan.nextLine();

            if (action.equals("1")) {
                System.out.println("게임을 종료합니다.");
                System.exit(0);
            } else if (action.equals("2")) {
                System.out.println("다시 시작합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public static int parseIntegerOrNegative1(String input){
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            return -1;
        }
    }
    public static void move(int room){
        currentR = room;
        System.out.println(currentR + "번 방으로 이동합니다.");
        String hazard = hazards.get(currentR);
        delay(1000L);

        if (hazard.equals(WUMPUS)){
            System.out.println("\"으아아아악!!!\"");
            delay(300L);
            System.out.println("움퍼스에게 잡아먹혔습니다.");
            gameover = true;
        }
        else if (hazard.equals(PIT)){
            System.out.println("\"으아아아아~~\"");
            delay(1000L);
            System.out.println("쿵!");
            delay(300L);
            System.out.println("당신은 구덩이에 빠졌습니다.");
            delay(300L);
            System.out.println("더이상 움퍼스를 사냥할 수 없습니다.");
            gameover = true;
        }
        else if (hazard.equals(BAT)){
            System.out.println("쿵!");
            delay(300L);
            System.out.println("박쥐가 당신을 잡아 다른 방에 떨어뜨렸습니다.");
            do {
                currentR = random.nextInt(rooms.length);
            }while (hazards.get(currentR).equals(BAT));

            hazards.set(room,NOTHING);

            while (true){
                int newBatRoom = random.nextInt(rooms.length);

                if (newBatRoom == currentR){
                    continue;
                }

                if (hazards.get(newBatRoom).equals(NOTHING)){
                    hazards.set(newBatRoom,BAT);
                    break;
                }
            }
            move(currentR);

        }else {
            List<Integer> nextRooms = Arrays.asList(links[currentR]);
            System.out.println("\n (연결되어 있는 통로를 살핀다.)");
            for (int nextR : nextRooms){
                delay(700L);
                String hazardAround = hazards.get(nextR);
                System.out.println(hazardMessage.get(hazardAround));
            }
            Collections.shuffle(nextRooms);
        }
    }

    public static void shoot(int room){
        arrowC = arrowC -1;
        delay(1000L);
        System.out.println("슈웅");
        delay(300L);

        if (hazards.get(room).equals(WUMPUS)){
            System.out.println("푸슉!");
            delay(100L);
            System.out.println("엄청난 괴성이 들린다.");
            delay(1000L);
            System.out.println("움퍼스를 죽였습니다.");
            gameover = true;
        }else {
            System.out.println("(...)");
            delay(300L);
            System.out.println("\'화살만 낭비했군\'");
            System.out.println("남은 화살 : "+ arrowC);
            if (arrowC == 0){
                delay(300L);
                System.out.println("화살이 바닥났습니다.");
                delay(300L);
                System.out.println("당신은 움퍼스 사냥에 실패했습니다.");
                gameover = true;
            }
            else if (random.nextInt(4) !=0){
                System.out.println("당신이 움퍼스를 깨웠습니다.");
                delay(1000L);

                Integer[] nextRooms = links[wumpusR];
                int nextR = nextRooms[random.nextInt(3)];
                if (hazards.get(nextR).equals(NOTHING)){
                    hazards.set(wumpusR,NOTHING);
                    hazards.set(nextR,WUMPUS);
                    wumpusR = nextR;
                }
                if (wumpusR == currentR){
                    System.out.println("\"으아아아아악!!\"");
                    delay(500L);
                    System.out.println("움퍼스에게 잡아먹혔습니다.");
                    gameover = true;
                }
                else if (wumpusR == nextR){
                    System.out.println("움퍼스가 도망쳤습니다.");
                }
            }
        }
    }
}



