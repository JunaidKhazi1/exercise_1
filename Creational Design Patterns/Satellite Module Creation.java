// Factory Method Pattern in Java (Satellite Module Creation)
interface SatelliteModule {
    void operate();
}

class CommunicationModule implements SatelliteModule {
    @Override
    public void operate() {
        System.out.println("Communication module operating.");
    }
}

class ImagingModule implements SatelliteModule {
    @Override
    public void operate() {
        System.out.println("Imaging module operating.");
    }
}

class SatelliteModuleFactory {
    public static SatelliteModule createModule(String type) {
        if (type.equalsIgnoreCase("communication")) {
            return new CommunicationModule();
        } else if (type.equalsIgnoreCase("imaging")) {
            return new ImagingModule();
        } else {
            throw new IllegalArgumentException("Unknown module type");
        }
    }
}

public class SatelliteModuleFactoryDemo {
    public static void main(String[] args) {
        SatelliteModule communicationModule = SatelliteModuleFactory.createModule("communication");
        communicationModule.operate();

        SatelliteModule imagingModule = SatelliteModuleFactory.createModule("imaging");
        imagingModule.operate();
    }
}
