import java.util.Scanner;

/**
 * @ClassName GuessNumber
 * @Description TODO
 * @Author shen
 * @Date 2021/8/17
 */
public class GuessNumber {

    public static void main(String[] args) {
        // 创建Scanner来获取用户的键盘输入
        Scanner inPut = new Scanner(System.in);
        // 游戏设置
        int numStart = 30;
        int numEnd = 50;
        int guessCount = 5;
        // 游戏统计
        int totalGameCount = 0;
        int successGameCount = 0;
        // 是否结束游戏 当用户输入负数时结束
        boolean gameEnd = false;
        while (!gameEnd) {
            // 初始化游戏变量
            int leftToGuess = guessCount; // 剩余猜测次数
            boolean currentGameCount = false; //本次游戏是否开始
            boolean currentGuess = false; // 本次游戏是否猜中数字
            // 生成指定范围内的随机数
            int mod = numEnd - numStart;
            if (numStart < 0 || numEnd < 0) {
                System.out.println("开始和结束必须是正数或0");
            }
            if (mod <= 1) {
                System.out.println("非法的数字范围（" + numStart + "-" + numEnd + ")");
            }
            int bigRandom = (int) (Math.random() * (numEnd * 100));
            int numberToGuess = (bigRandom % mod) + numStart;
            if (numberToGuess <= numStart) {
                numberToGuess += 1;
            } else if (numberToGuess > numEnd) {
                numberToGuess -= 1;
            }
            System.out.println("猜数字游戏开始，范围在(" + numStart + "-" + numEnd + "),输入-1结束游戏");
            while (leftToGuess > 0) {
                System.out.print("剩余猜测次数" + leftToGuess + ",请输入本次猜测的数字：");
                int guess = inPut.nextInt();
                // 输入负数 结束游戏
                if (guess < 0) {
                    gameEnd = true;
                    currentGuess = true;
                    System.out.println("用户选择结束游戏");
                    break;
                }
                // 猜过一次就算猜了
                if (!currentGameCount) {
                    totalGameCount++;
                    currentGameCount = true;
                }
                // 可用猜测次数
                leftToGuess--;
                if (guess > numberToGuess) {
                    System.out.println("输入数字比目标数字大");
                } else if (guess < numberToGuess) {
                    System.out.println("输入数字比目标数字小");
                } else {
                    successGameCount++;
                    currentGuess = true;
                    System.out.println("恭喜猜测正确");
                    break;
                }
            }
            if (!currentGuess) {
                System.out.println("本次目标数字是：" + numberToGuess + ",没有猜中，继续努力");
            }
            System.out.println("共进行了" + totalGameCount + "局游戏，猜对了" + successGameCount + "次");
        }
    }

}
