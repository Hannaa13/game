
import java.io.*;
import java.util.Scanner;

public class Game {
    public void choice() throws IOException {
        int win = 0;
        int lose = 0;
        String result;

        System.out.println("Введите количество попыток:  ");
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        if (count <= 0) {
            try {
                throw new IOException();

            } catch (IOException e) {
                System.out.println("Не корректно");
                System.exit(0);
            }
        }

        double n = (double) count / 2;
        String youLose = "YOU LOSE";
        String youWin = "YOU WIN";
        String tie = "TIE";


        while (count != 0) {
            System.out.println("Введите число от 0 до 2, где 0 - камень, 1 - ножницы, 2 - бумага; Для прерывания игры нажмите -1");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            if (x == -1) break;
            int y;
            double randomChoice = Math.random();
            if (0 > randomChoice && randomChoice < 0.33) {
                y = 0;
            } else if (0.34 > randomChoice && randomChoice < 0.66) {
                y = 1;
            } else {
                y = 0;
            }

            String[][] xy = {
                    {tie, youWin, youLose},
                    {youLose, tie, youWin},
                    {youWin, youLose, tie}};

            System.out.println(xy[x][y]);

            if (xy[x][y].equals(youWin)) {
                win++;
            } else if (xy[x][y].equals(youLose)) {
                lose++;
            }
            count--;
            if (win > n || lose > n) break;
        }
        if (win > lose) {
            result = youWin + " >> " + win + ":" + lose;

        } else if (win < lose)
            result = youLose + " >> " + win + ":" + lose;

        else
            result = tie + " >> " + win + ":" + lose;
        System.out.println(result);

        File resultFile = new File("gameResult");
        PrintWriter pw = new PrintWriter(resultFile);
        pw.println(result);
        pw.close();
        write(result);
    }


    private void write(String result) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\file\\result", true));
        writer.append(result);

        writer.close();
    }
}