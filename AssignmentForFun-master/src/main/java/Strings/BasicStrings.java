package Strings;

public class BasicStrings {

    public String flipConcat(String string1, String string2) {
        return string2+string1;
    }

    public char getChar(String string, int index) {
        return string.charAt(index);
    }

    public String iCantSee(String string) {
        StringBuffer outputBuffer = new StringBuffer(string.length());
        for (int i = 0; i < string.length(); i++){
            outputBuffer.append(" ");
        }
        return outputBuffer.toString();
    }

    public String loudAndClear(String string) {
        return string.toUpperCase();
    }

    public String reverseCase(String string) {
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if (Character.isUpperCase(c))
            {
                chars[i] = Character.toLowerCase(c);
            }
            else if (Character.isLowerCase(c))
            {
                chars[i] = Character.toUpperCase(c);
            }
        }
        return new String(chars);
    }

    public String oneAtATime(String string1, String string2) {
        StringBuilder temp = new StringBuilder("");
        for(int i=0;i<string1.length(); i++)
        {
            temp.append(string1.charAt(i));
            if(i<string2.length())
                temp.append(string2.charAt(i));
        }
        return temp.toString();
    }
}
