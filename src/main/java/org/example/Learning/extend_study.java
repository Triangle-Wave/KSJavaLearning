package org.example.Learning;

/*
 * Java继承的学习
 */
public class extend_study {
    public static void main(String[] args) {
        System.out.println("Hello World");
        mouse m = new mouse("A small mouse ");
        m.eat();
        penguin p = new penguin("A small penguin ");
        p.eat();
        whitemouse wm = new whitemouse("A small white mouse", 113);
        wm.eat();
    }
}

class Animals {
    private String name;

    public Animals(String aName) {
        name = aName;
    }

    public String getName() {
        return name;
    }

    public void eat() {
        System.out.println(name + "is eating.");
    }
}

class mouse extends Animals {
    public mouse(String mname) {
        super(mname);
    }
}

class penguin extends Animals {
    public penguin(String pname) {
        super(pname);
    }
}

class whitemouse extends mouse {
    int id;

    public whitemouse(String wmname, Integer wmid) {
        super(wmname);
        id = wmid;
    }

    @Override
    public void eat() {
        System.out.printf("%s is eating, its id is %d.", getName().toUpperCase(), id);
    }
}