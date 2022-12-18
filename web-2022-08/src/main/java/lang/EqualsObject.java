package lang;

public class EqualsObject {
    int id;
    String name;
    public EqualsObject(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public int hashCode() {
        return this.id;
    }
    @Override
    public boolean equals(Object obj) {
      boolean b = false;
      if(obj instanceof EqualsObject) {
          EqualsObject o = (EqualsObject)obj;
          if(this.id == o.id && this.name.equals(o.name) ) {
              b=true;
          }
      }
      return b;

    }
    @Override
    public String toString() {
        String str = String.format("id : %d, name : %s", this.id, this.name);
        return str;
    }
    public static void main(String[] args) {
        EqualsObject o1 = new EqualsObject(100,"hong");
        EqualsObject o2 = new EqualsObject(100,"kim");
        
        EqualsObject o3 = new EqualsObject(200,"hong");
        EqualsObject o4 = new EqualsObject(300,"kim");
        
        EqualsObject o5 = new EqualsObject(100,"hong");
        
        System.out.println("o1==o2: " + (o1==o2));
        System.out.println("o1 equals o2: " + o1.equals(o2));
        
        System.out.println("o1==o3: " + (o1==o3));
        System.out.println("o1 equals o3: " + o1.equals(o3));
        
        System.out.println("o1==o5: " + (o1==o5));
        System.out.println("o1 equals o5: " + o1.equals(o5));
        
        System.out.println(o1.hashCode());
        System.out.println(o3.hashCode());
    }
    
}
