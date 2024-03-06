public class Vehicle {

    private VehicleType type;
    private String registration;
    private String colour;

    public Vehicle(VehicleType type, String registration, String colour) {
        this.type = type;
        this.registration = registration;
        this.colour = colour;
    }

    public VehicleType getType() {
        return type;
    }

    public String getRegistration() {
        return registration;
    }

    public String getColour() {
        return colour;
    }

}