import java.util.Scanner;
public class Game {
    public static Ox ox;
    private static Scanner kb = new Scanner(System.in);
    private static int row,col;

    public static void input(){
        boolean canPut=true;
        do {
            System.out.print(ox.getCurrentPlayer() + " (Col): ");
            col = kb.nextInt();
            System.out.print(ox.getCurrentPlayer() + " (Row): ");
            row = kb.nextInt();
            canPut = ox.put(row, col);
            if (!canPut) {
                System.out.println("Please input number between 0-2");
            }
        }while(!canPut);
    }

    public static void print(){
        System.out.print(ox.getTableString());
        System.out.println("X win "+ox.getCountX());
        System.out.println("O win "+ox.getCountO());
        System.out.print("Draw "+ox.getCountDraw());
    }

    public static void main(String[]ken){
        ox = new Ox();
        while(true) {
            System.out.print(ox.getTableString());
            input();
            ox.switchPlayer();
            if(ox.checkWin(row,col) == true){
                print();
                break;
            }
        }
    }
}
