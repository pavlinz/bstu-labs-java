package by.belstu.it.vasilevskiy.basejava;

import java.util.Objects;

public class WrapperString {
    private String _string;

    public void replace(char oldchar, char newchar) {
        StringBuilder sb = new StringBuilder(_string);
        for(int i = 0; i < this._string.length(); i++) {
            if(this._string.charAt(i) == oldchar) {
                sb.setCharAt(i, newchar);
            }
        }
        _string = sb.toString();
    }

    @Override
    public String toString() {
        return _string.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(_string, that._string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_string);
    }

    public WrapperString(String _string) {
        this._string = _string;
    }

    public String getString() {
        return _string;
    }

    public void setString(String string) {
        this._string = string;
    }
}
