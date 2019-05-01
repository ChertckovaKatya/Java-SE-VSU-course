public class Car {
    @Deprecated
    public  String rudder;
    private Integer wheels;
    @Deprecated
    private Integer doors;
    @Deprecated
    public Integer pedals;

    public void setRudder(String rudder) {
        this.rudder = rudder;
    }

    public void setWheels(Integer wheels) {
        this.wheels = wheels;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public void setPedals(Integer pedals) {
        this.pedals = pedals;
    }

    public String getRudder() {
        return rudder;
    }

    public Integer getWheels() {
        return wheels;
    }

    public Integer getDoors() {
        return doors;
    }

    public Integer getPedals() {
        return pedals;
    }
}
