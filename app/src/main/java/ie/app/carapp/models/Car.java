package ie.app.carapp.models;


public class Car {

    private String carname;
    private String carColour;
    private String des;
    private int imgid;

//    public Car() {
//    }

        public Car(String carname, String carColour, String des, int imgid) {
        this.carname = carname;
        this.carColour = carColour;
        this.des = des;
        this.imgid = imgid;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getCarColour() {
        return carColour;
    }

    public void setCarColour(String carColour) {
        this.carColour = carColour;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carname='" + carname + '\'' +
                ", carColour='" + carColour + '\'' +
                ", des='" + des + '\'' +
                ", imgid=" + imgid +
                '}';
    }
}
