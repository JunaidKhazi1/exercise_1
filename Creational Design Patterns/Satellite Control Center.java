// Singleton Pattern in Java (Satellite Control Center)
class SatelliteControlCenter {
    private static SatelliteControlCenter instance;
    private String missionName;

    private SatelliteControlCenter() {
        missionName = "Initial Mission";
    }

    public static SatelliteControlCenter getInstance() {
        if (instance == null) {
            instance = new SatelliteControlCenter();
        }
        return instance;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }
}

public class SatelliteControlCenterDemo {
    public static void main(String[] args) {
        SatelliteControlCenter controlCenter1 = SatelliteControlCenter.getInstance();
        System.out.println("Mission: " + controlCenter1.getMissionName());

        SatelliteControlCenter controlCenter2 = SatelliteControlCenter.getInstance();
        controlCenter2.setMissionName("Mars Exploration");

        System.out.println("Control Center 1: " + controlCenter1.getMissionName());
        System.out.println("Control Center 2: " + controlCenter2.getMissionName());

        System.out.println(controlCenter1 == controlCenter2);  // true
    }
}
