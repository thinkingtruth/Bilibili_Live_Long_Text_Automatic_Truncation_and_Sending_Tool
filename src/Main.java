import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

public class Main{
    public static void main(String[] args) throws AWTException, InterruptedException {
        Scanner in = new Scanner(System.in);
        Robot robot = new Robot();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        System.out.println("在下一行输入你需要发送的文本：");
        String str = in.next();
        System.out.println("请在五秒内将光标移动到文本框内。");
        String[] divide = str.split("(?<=\\G.{20})");
        Thread.sleep(5000);
        for (String a : divide) {
            StringSelection selection = new StringSelection(a);
            clipboard.setContents(selection, null);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(500);
        }
    }
}