
import java.util.ArrayList;
import java.util.List;

interface Engineer {
    void update(String parameter, float value);
}

class Satellite {
    private List<Engineer> engineers = new ArrayList<>();
    private float fuelLevel;
    private float powerLevel;

    public void addEngineer(Engineer engineer) {
        engineers.add(engineer);
    }

    public void removeEngineer(Engineer engineer) {
        engineers.remove(engineer);
    }

    public void setFuelLevel(float fuelLevel) {
        this.fuelLevel = fuelLevel;
        notifyEngineers("Fuel Level", fuelLevel);
    }

    public void setPowerLevel(float powerLevel) {
        this.powerLevel = powerLevel;
        notifyEngineers("Power Level", powerLevel);
    }

    private void notifyEngineers(String parameter, float value) {
        for (Engineer engineer : engineers) {
            engineer.update(parameter, value);
        }
    }
}

class GroundControlEngineer implements Engineer {
    private String name;

    public GroundControlEngineer(String name) {
        this.name = name;
    }

    @Override
    public void update(String parameter, float value) {
        System.out.println("Engineer " + name + ": " + parameter + " is now at " + value);
    }
}

public class ObserverSatelliteDemo {
    public static void main(String[] args) {
        Satellite satellite = new Satellite();
        Engineer engineer1 = new GroundControlEngineer("Alice");
        Engineer engineer2 = new GroundControlEngineer("Bob");

        satellite.addEngineer(engineer1);
        satellite.addEngineer(engineer2);

        satellite.setFuelLevel(75.0f);
        satellite.setPowerLevel(50.0f);
    }
}
