interface Battery {
    void charge();
}

class LithiumIonBattery {
    public void chargeLithium() {
        System.out.println("Charging Lithium-Ion Battery");
    }
}

class NickelCadmiumBattery {
    public void chargeNickel() {
        System.out.println("Charging Nickel-Cadmium Battery");
    }
}

class BatteryAdapter implements Battery {
    private Object battery;

    public BatteryAdapter(Object battery) {
        this.battery = battery;
    }

    @Override
    public void charge() {
        if (battery instanceof LithiumIonBattery) {
            ((LithiumIonBattery) battery).chargeLithium();
        } else if (battery instanceof NickelCadmiumBattery) {
            ((NickelCadmiumBattery) battery).chargeNickel();
        } else {
            throw new IllegalArgumentException("Unsupported battery type");
        }
    }
}

public class AdapterSatellitePowerDemo {
    public static void main(String[] args) {
        Battery liBattery = new BatteryAdapter(new LithiumIonBattery());
        liBattery.charge();

        Battery niBattery = new BatteryAdapter(new NickelCadmiumBattery());
        niBattery.charge();
    }
}
