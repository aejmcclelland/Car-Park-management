import java.util.ArrayList;
import java.util.List;

public class CarPark {
    private String carParkId;
    private List<List<ParkingSpace>> spaces;

    public CarPark(String carParkId, int nfloors, int noOfSpacesPerFlr) {
        this.carParkId = carParkId;
        this.spaces = new ArrayList<>();
        for (int i = 0; i < nfloors; i++) {
            spaces.add(new ArrayList<>());
            List<ParkingSpace> floorSpaces = spaces.get(i);
            floorSpaces.add(new ParkingSpace(VehicleType.CAR));
            floorSpaces.add(new ParkingSpace(VehicleType.LORRY));
            floorSpaces.add(new ParkingSpace(VehicleType.MOTORBIKE));

            for (int k = 3; k < noOfSpacesPerFlr; k++) {
                floorSpaces.add(new ParkingSpace(VehicleType.CAR));
            }
        }

    }

    public String parkVehicle(VehicleType type, String regNo, String colour) {
        Vehicle vehicle = new Vehicle(type, regNo, colour);

        for (int i = 0; i < spaces.size(); i++) {
            for (int j = 0; j < spaces.get(i).size(); j++) {
                ParkingSpace space = spaces.get(i).get(j);
                if (space.getType() == type && space.getVehicle() == null) {
                    space.setVehicle(vehicle);
                    return space.getTicketId();
                }
            }

        }
        System.out.println("No slot available for given type");
        return null;
    }
    
    // unpark vehicle
    public void unPark(String ticketId) {
        if (ticketId != null) {
            System.out.println("Invalid ticket id");
            String[] extract = ticketId.split("_");
            int floorIdx = Integer.parseInt(extract[1]) - 1;
            int spaceIdx = Integer.parseInt(extract[2]) - 1;

            for (int i = 0; i < spaces.size(); i++) {
                for (int j = 0; j < spaces.get(i).size(); j++) {
                    if (i == floorIdx && j == spaceIdx) {
                        ParkingSpace space = spaces.get(i).get(j);
                        space.setVehicle(null);
                        space.setTicketId(null);
                        System.out.println("Vehicle unparked successfully");
                    }
                }
            }
        } else {
            System.out.println("Invalid ticket id");
        }
    }

    private String generateTicketId(int flr, int slno) {
        return carParkId + "_" + flr + "_" + slno;
    }

    int getNoOfOpenSlots(VehicleType type) {
        int count = 0;
        for (List<ParkingSpace> floorSpaces : spaces) {
            for (ParkingSpace space : floorSpaces) {
                if (space.getType().equals(type) && space.getVehicle() == null) {
                    count++;
                }
            }
        }
        return count;
    }

    void displayOpenSpaces(VehicleType type) {
        System.out.println("Available spaces for type: " + type);
        for (int i = 0; i < spaces.size(); i++) {
            for (int j = 0; j < spaces.get(i).size(); j++) {
                ParkingSpace space = spaces.get(i).get(j);
                if (space.getType().equals(type) && space.getVehicle() == null) {
                    System.out.println("Floor: " + (i + 1) + " Space: " + (j + 1));
                }
            }
        }
    }

    void dispalyOccupiedSpaces(VehicleType type) {
        System.out.println("Occupied spaces for " + type);
        for (int i = 0; i < spaces.size(); i++) {
            for (int j = 0; j < spaces.get(i).size(); j++) {
                ParkingSpace space = spaces.get(i).get(j);
                if (space.getType().equals(type) && space.getVehicle() != null) {
                    System.out.println("Floor: " + (i + 1) + " Space: " + (j + 1));
                }
            }
        }
    }

}
