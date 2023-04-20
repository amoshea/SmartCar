package JmDNS;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import static java.net.InetAddress.getLocalHost;

public class ServiceDiscovery {
    private int port;
    private String host;

    public ServiceDiscovery() {
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    private static class MyServiceListener implements ServiceListener {

        private int port;
        private String host;
        private ServiceInfo serviceInfo;

        @Override
        public void serviceAdded(ServiceEvent event) {
        }

        @Override
        public void serviceRemoved(ServiceEvent event) {
        }

        @Override
        public void serviceResolved(ServiceEvent event) {

            ServiceInfo serviceInfo = event.getInfo();
            this.setServiceInfo(serviceInfo);
            InetAddress[] addresses = serviceInfo.getInet4Addresses();
            if (addresses != null && addresses.length > 0) {
                System.out.println("host " + addresses[0].getHostAddress());
                this.setHost(addresses[0].getHostAddress());
            }
            System.out.println("port " + serviceInfo.getPort());
            this.setPort(serviceInfo.getPort());
            System.out.println("type " + serviceInfo.getType());
            System.out.println("name " + serviceInfo.getName());
            System.out.println("Computer name " + serviceInfo.getServer());
            System.out.println("desc/properties " + serviceInfo.getNiceTextString());
        }

        public int getPort() {
            return port;
        }
        public void setPort(int port) {
            this.port = port;
        }
        public ServiceInfo getServiceInfo() {
            return serviceInfo;
        }
        public void setServiceInfo(ServiceInfo serviceInfo) {
            this.serviceInfo = serviceInfo;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }
    }
    public static ServiceInfo run(String service_type) throws InterruptedException {

        ServiceInfo serviceInfo = null;

        // Create an Instance of JmDNS
        try (JmDNS jmdns = JmDNS.create(getLocalHost())) {
            MyServiceListener msl = new MyServiceListener();

            //Add a Service Listener
            jmdns.addServiceListener(service_type, msl);

            //Awaiting Time
            Thread.sleep(10000);

            serviceInfo = msl.getServiceInfo();
            int port = msl.getPort();
            System.out.println("This is the port retrieved from JmDNS: "+ port);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return serviceInfo;
    }
}
