package my.task.envelo.second.second;

public class User {

    private String pin;
    private String name;
    private Integer id;

    public User(String name, Integer id, String pin){
        this.pin = pin;
        this.name = name;
        this.id = id;
    }

    public User(String name, Integer id){
        this.pin = null;
        this.name = name;
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}