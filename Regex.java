import java.util.Arrays;
import java.util.regex.*;


public class Regex {

    public static void main(String args[]) {
        String text = "Cras sodales lacus pretium cursus tempor." +
                " Nam consequat magna quis elit tempor porta. " +
                "Vestibulum nec suscipit massa. Phasellus hendrerit pretium eleifend." +
                " Morbi eu lectus ultrices, fermentum leo in 1965, blandit purus." +
                " Aenean ullamcorper nisi non justo ornare, a pulvinar diam venenatis." +
                " Aenean quis magna eget ligula elementum viverra. Aliquam sit amet dui vitae felis facilisis aliquet eget sed leo. " +
                "Sed laoreet interdum neque. Pellentesque lacus diam, tincidunt eget odio ornare, tincidunt interdum justo.";

        //this pattern prints each character
        String pattern = ".";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(text);
        Printer(matcher);

        System.out.println();
        //this pattern prints only numbers
        pattern = "\\d+";
        p = Pattern.compile(pattern);
        matcher = p.matcher(text);
        Printer(matcher);


        System.out.println();
        //this pattern prints only "Cras" from the begin
        pattern = "^Cras";
        p = Pattern.compile(pattern);
        matcher = p.matcher(text);
        Printer(matcher);


        System.out.println();
        //this pattern prints or a or b or c and count
        pattern = "[abc]+";
        p = Pattern.compile(pattern);
        matcher = p.matcher(text);
        Printer(matcher);

        System.out.println();
        //this pattern prints all word
        pattern = "\\w+";
        p = Pattern.compile(pattern);
        matcher = p.matcher(text);
        Printer(matcher);


    }


    public static void Printer(Matcher matcher) {
        int count = 0;
        while (matcher.find()) {
            System.out.print(matcher.group());
            count++;
        }
        System.out.print("  Число совпадений " + count);
    }


}
