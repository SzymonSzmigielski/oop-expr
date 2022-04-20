package pl.edu.mimuw;

public class TNapis implements INapis {
    private char[] r;
    private int length;

    public TNapis(char[] r){
        this.r = r;
        this.length = r.length;
    }

    public int length(){
        return length;
    }

    public char charAt(int index){
        if(index>=this.length()) throw new IllegalArgumentException("wrong index");
        return r[index];
    }


    public TNapis concat(INapis o){
        char[] r = new char[this.length()+o.length()];
        for(int i = 0; i< this.length(); i++) r[i]=this.charAt(i);
        for(int i = 0; i< o.length();i++) r[this.length()]=o.charAt(i);
        return new TNapis(r);
    }

}
