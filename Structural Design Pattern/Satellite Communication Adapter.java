

interface GroundStation {
    void sendData(String data);
}

class RadioStation {
    public void transmitRadio(String data) {
        System.out.println("Transmitting via Radio: " + data);
    }
}

class TCPStation {
    public void transmitTCP(String data) {
        System.out.println("Transmitting via TCP: " + data);
    }
}

// Adapter for Radio Communication
class RadioAdapter implements GroundStation {
    private RadioStation radioStation;

    public RadioAdapter(RadioStation radioStation) {
        this.radioStation = radioStation;
    }

    @Override
    public void sendData(String data) {
        radioStation.transmitRadio(data);  // Convert to Radio communication
    }
}

// Adapter for TCP Communication
class TCPAdapter implements GroundStation {
    private TCPStation tcpStation;

    public TCPAdapter(TCPStation tcpStation) {
        this.tcpStation = tcpStation;
    }

    @Override
    public void sendData(String data) {
        tcpStation.transmitTCP(data);  // Convert to TCP communication
    }
}

// Client Code
public class SatelliteCommunicationAdapterDemo {
    public static void main(String[] args) {
        GroundStation radioAdapter = new RadioAdapter(new RadioStation());
        GroundStation tcpAdapter = new TCPAdapter(new TCPStation());

        radioAdapter.sendData("Satellite Data for Radio Transmission");
        tcpAdapter.sendData("Satellite Data for TCP Transmission");
    }
}
