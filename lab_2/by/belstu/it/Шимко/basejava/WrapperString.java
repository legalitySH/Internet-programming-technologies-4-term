package by.belstu.it.Шимко.basejava;

import java.util.Objects;

public class WrapperString {

    private String str;
    public String getStr() {
        return str;
    }


    public void setStr(String str) {
        this.str = str;
    }

    public WrapperString(String someStr) {
        str = someStr;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WrapperString that)) return false;
        return Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }

    @Override
    public String toString() {
        return "WrapperString{" +
                "str='" + str + '\'' +
                '}';
    }

    public void replace(char oldChar , char newChar)
    {
        System.out.println(str.replace(oldChar , newChar));
    }
}
