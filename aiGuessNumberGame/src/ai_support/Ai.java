package ai_support;

public class Ai {
    private int rangeStart;  //猜测下限
    private int rangeEnd;    //猜测上限
    private int guessTotal;  //一轮可猜测次数
    private int totalGameCount;  //总游戏局数
    private int totalCorrectCount;  //猜对游戏次数
    private int correctNumber;  //正确数字
    private int remainCount;  //剩余次数

    public Ai() {
        this.rangeStart = 20;
        this.rangeEnd = 40;
        this.guessTotal = 6;
        this.totalGameCount = 0;
        this.totalCorrectCount = 0;
    }

    public void genNumber() {
        int mod = rangeEnd - rangeStart;
        double randNum = Math.random();
        int num = ((int) (randNum * rangeEnd * 100)) % mod;
        num += rangeStart;
        if (num <= rangeStart) {
            num = rangeStart + 1;
        }
        if (num >= rangeEnd) {
            num = rangeEnd - 1;
        }
        this.correctNumber = num;
        this.remainCount = guessTotal;
        totalGameCount++;
        System.out.println("目标数已经生成，数字在" + rangeStart + "到" + rangeEnd + "之间，" +
                "不包括这两个数。共有" + guessTotal + "次猜测的机会。输入-1随时结束游戏。");
    }

    private boolean compareNum(int num) {
        boolean isCorrectNumber = false;
        if (correctNumber < num) {
            System.out.println("猜测的数字比目标数字大。");
            isCorrectNumber = false;
        } else if (correctNumber > num) {
            System.out.println("猜测的数字比目标数字小。");
            isCorrectNumber = false;
        } else {
            System.out.println("恭喜你猜对了！这次的数字就是" + correctNumber + "。本次你共猜了" + (guessTotal - remainCount + 1) + "次。");
            isCorrectNumber = true;
            totalCorrectCount++;
        }

        return isCorrectNumber;
    }

    private boolean hasNoRemain() {
        boolean hasNoCountRemain = false;
        if (--remainCount == 0) {
            hasNoCountRemain = true;
            System.out.println("本次的目标数字是" + correctNumber + "。这次没有猜中。");
        }
        return hasNoCountRemain;
    }

    public boolean needReset(int guessNum) {
        return compareNum(guessNum) || hasNoRemain();
    }

    public void printTotalConut() {
        if (remainCount == 6) {
            totalGameCount = totalGameCount - 1;
        }
        System.out.println("共进行了" + totalGameCount + "次游戏，其中正确的为" + totalCorrectCount + "次");
    }
}
