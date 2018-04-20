package ie.app.carapp.models;


public class Car {

    private String carname;
    private String carColour;
    private String carMake;
    private String carYear;
    private String carPrice;
    private String des;
    private int imgid;

    public Car(){

    }

    public Car(String carname, String carMake, String carYear) {
        this.carname = carname;
        this.carMake = carMake;
        this.carYear = carYear;
    }

    public Car(String carname, String carColour, String carMake, String carYear, String carPrice, String des, int imgid) {
        this.carname = carname;
        this.carColour = carColour;
        this.carMake = carMake;
        this.carYear = carYear;
        this.carPrice = carPrice;
        this.des = des;
        this.imgid = imgid;
    }

    public String getCarname() {
        return carname;
    }

    public String getCarColour() {
        return carColour;
    }

    public String getCarMake() {
        return carMake;
    }

    public String getCarYear() {
        return carYear;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public String getDes() {
        return des;
    }

    public int getImgid() {
        return imgid;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public void setCarColour(String carColour) {
        this.carColour = carColour;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carname='" + carname + '\'' +
                ", carColour='" + carColour + '\'' +
                ", carMake='" + carMake + '\'' +
                ", carYear='" + carYear + '\'' +
                ", carPrice='" + carPrice + '\'' +
                ", des='" + des + '\'' +
                ", imgid=" + imgid +
                '}';
    }
}
