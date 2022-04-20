package pl.edu.mimuw;

import java.util.List;
import java.util.ArrayList;

public class SNapis implements INapis {
    private List<String> s;
    private List<Integer> sumPref;

    public SNapis(List<String> s) {
        this.s = s;
        this.sumPref = new ArrayList<Integer>();
        sumPref.add(0);
        for (var ss : s) {
            sumPref.add(sumPref.get(sumPref.size() - 1) + ss.length());
        }
    }

    public int length() {
        return sumPref.get(sumPref.size() - 1);
    }

    public INapis concat(INapis o) {
        var r = new ArrayList<String>();
        for (var ss : s)
            r.add(ss);
        var c = new char[o.length()];
        for (int i = 0; i < o.length(); i++)
            c[i] = o.charAt(i);
        r.add(new String(c));
        return new SNapis(r);
    }

    public char charAt(int index) {
        if (index < 0 || sumPref.get(sumPref.size() - 1) <= index) {
            throw new IllegalArgumentException("wrong index");
        }
        int low = 0;
        int high = sumPref.size() - 1;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (sumPref.get(mid) <= index) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return s.get(low).charAt(index - sumPref.get(low));
    }

}