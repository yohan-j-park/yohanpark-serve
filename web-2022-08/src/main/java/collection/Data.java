package collection;

public class Data {
    String id;
    String irum;
    int    age;
    
    public Data(String id, String irum, int age) {
        this.id = id;
        this.irum = irum;
        this.age = age;
    }
    
    
    public Data() {

    }


    @Override
    public String toString() {
        String str = id + ", " + irum + ", " + age + "\n";
        return str;
    }



    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return this.id.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        boolean b = false;
        if(obj instanceof Data) {   //Data로 만들어진 obj값이면
            Data temp = (Data)obj;
            if(this.id.equals(temp.getId())) {
                b = true;
            }
        }else {
            String temp = (String)obj;
            if(this.id.equals(temp)) {
                b = true;
            }
        }
        
        
        return b;
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIrum() {
        return irum;
    }
    public void setIrum(String irum) {
        this.irum = irum;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
}
