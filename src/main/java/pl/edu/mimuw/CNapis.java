package pl.edu.mimuw;
import java.util.List;
public class CNapis implements INapis {
    private List<Character> s;
    private int length;

    public CNapis(List<Character> s){
        this.s = s;
        this.length = s.size();
    }

    public int length(){
        return length;
    }

    public char charAt(int index){
        if(index>=this.length()) throw new IllegalArgumentException("wrong index");
        return s.get(index);
    }

    @Override
    public INapis concat(INapis o) {
        // TODO Auto-generated method stub
        return null;
    }

}
