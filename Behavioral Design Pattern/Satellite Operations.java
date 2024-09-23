
interface Command {
    void execute();
}

class Satellite {
    public void turnOnCamera() {
        System.out.println("Camera turned on.");
    }

    public void adjustSolarPanels() {
        System.out.println("Solar panels adjusted.");
    }
}

class TurnOnCameraCommand implements Command {
    private Satellite satellite;

    public TurnOnCameraCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute() {
        satellite.turnOnCamera();
    }
}

class AdjustSolarPanelsCommand implements Command {
    private Satellite satellite;

    public AdjustSolarPanelsCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute() {
        satellite.adjustSolarPanels();
    }
}

class GroundStationController {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class SatelliteCommandDemo {
    public static void main(String[] args) {
        Satellite satellite = new Satellite();
        Command cameraCommand = new TurnOnCameraCommand(satellite);
        Command solarPanelsCommand = new AdjustSolarPanelsCommand(satellite);

        GroundStationController controller = new GroundStationController();

        controller.setCommand(cameraCommand);
        controller.pressButton();

        controller.setCommand(solarPanelsCommand);
        controller.pressButton();
    }
}
