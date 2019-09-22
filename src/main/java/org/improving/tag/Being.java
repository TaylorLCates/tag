package org.improving.tag;

public class Being {
    //Monsters are people too.
    private String profession;
    private int lvl;
    private int def;
    private int atk;
    private int HP;
    private int maxHP;
    private int xp;
    public int str;
    public int dex;
    public int con;
    public int intelligence;
    public int wis;
    private int numPot;


    public Being() {
        lvl = 1;
        HP = maxHP;
        maxHP = (4 * con) + 10;
        def = (2*dex);
        atk = (2*str) + weapDamage;


    }

    public void heal(){
        if(numPot > 0){
            numPot--;
            HP = maxHP;
        }
    }
}
