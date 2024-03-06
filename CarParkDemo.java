class CarParkDemo {
    public static void main(String[] args) {
        int nfloors = 4;
        int noOfSpacesPerFlr = 6;

        CarPark carPark = new CarPark("CP1", nfloors, noOfSpacesPerFlr);

        System.out.println("No of open slots for car: " + carPark.getNoOfOpenSlots(VehicleType.CAR));

        String ticket1 = carPark.parkVehicle(VehicleType.CAR, "KA-01-HH-1234", "white");
        String ticket2 = carPark.parkVehicle(VehicleType.CAR, "KA-01-HH-9999", "white");
        System.out.println("After parking:");
        carPark.dispalyOccupiedSpaces(VehicleType.CAR);

        carPark.unPark(ticket2);
        carPark.dispalyOccupiedSpaces(VehicleType.CAR);

        carPark.displayOpenSpaces(VehicleType.LORRY);
        System.out.println();
        carPark.parkVehicle(VehicleType.LORRY, "LA-HH-100", "black");

        System.out.println();

        carPark.parkVehicle(VehicleType.LORRY, "LA-01-HH-4567", "white");
        carPark.parkVehicle(VehicleType.LORRY, "LA-01-HH-5678", "red");
        carPark.parkVehicle(VehicleType.LORRY, "LA-01-HH-6789", "white");
        carPark.parkVehicle(VehicleType.LORRY, "LA-01-HH-6799", "white");
        System.out.println("After parking trucks:");
        carPark.dispalyOccupiedSpaces(VehicleType.LORRY);

    }
}
