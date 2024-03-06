public class ParkingSpace {
    private VehicleType type;
    private Vehicle vehicle;
    private String ticketId;

    public ParkingSpace(VehicleType type) {
        this.type = type;
        this.vehicle = null;
        this.ticketId = null;
    }
    
    public VehicleType getType() {
        return type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

}
