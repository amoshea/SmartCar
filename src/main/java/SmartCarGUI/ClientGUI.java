package SmartCarGUI;


import Index.AnalysisResponse;
import Index.IndexGrpc;
import Index.NumberKmRequest;
import Status.FilterStatusRequest;
import Status.FilterStatusResponse;
import Status.StatusGrpc;
import Track.TrackGrpc;
import Track.TrackRequest;
import Track.TrackResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ClientGUI implements ActionListener {

    private List<JTextField> entryFields;
    private List<JTextField> replyFields;
    private JTextField service1Entry;
    private JTextField service1Reply;
    private JTextField service2Entry;
    private JTextField service2Reply;
    private JTextField service3Entry;
    private JTextField service3Reply;


    private JPanel getServicePanel(String serviceName, String buttonLabel) {
        /*
         * Returns a JPanel containing the UI elements for the given service
         */
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(serviceName));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel inputLabel = new JLabel("Enter value:");
        JTextField inputField = new JTextField(10);
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        entryFields.add(inputField);
        panel.add(inputPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton button = new JButton(buttonLabel);
        button.addActionListener(this);
        buttonPanel.add(button);
        panel.add(buttonPanel);

        JPanel outputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel outputLabel = new JLabel("Result:");
        JTextField outputField = new JTextField(10);
        outputField.setEditable(false);
        outputPanel.add(outputLabel);
        outputPanel.add(outputField);
        replyFields.add(outputField);
        panel.add(outputPanel);

        if (serviceName.equals("Track Service")) {
            service1Entry = inputField;
            service1Reply = outputField;
        } else if (serviceName.equals("Status Service")) {
            service2Entry = inputField;
            service2Reply = outputField;
        } else if (serviceName.equals("Index Pollution Service")) {
            service3Entry = inputField;
            service3Reply = outputField;
        }

        return panel;
    }

    public static void main(String[] args) {
        /*
         * Creates a new instance of the ClientGUI and builds the UI
         */
        ClientGUI gui = new ClientGUI();
        gui.build();
    }

    private void build() {
        /*
         * Builds the UI and sets up the event listeners
         */
        entryFields = new ArrayList<>();
        replyFields = new ArrayList<>();

        JFrame frame = new JFrame("Smart Car Controller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel servicePanel = new JPanel();
        servicePanel.setLayout(new BoxLayout(servicePanel, BoxLayout.Y_AXIS));
        servicePanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        servicePanel.add(getServicePanel("Track Service", "Activate"));
        servicePanel.add(getServicePanel("Status Service", "Request"));
        servicePanel.add(getServicePanel("Index Pollution Service", "Send"));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton closeButton = new JButton("Exit");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(closeButton);

        frame.add(servicePanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
         * Handles the events triggered by the buttons
         */
        JButton button = (JButton)e.getSource();
        String label = button.getActionCommand();

        if (label.equals("Invoke Track Service")) {
            System.out.println("Track service to be invoked ...");

            // Create a new thread to invoke the service
            new Thread(() -> {
                // Track Service Definition
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
                TrackGrpc.TrackBlockingStub blockingStub = TrackGrpc.newBlockingStub(channel);

                // Prepare the request message
                TrackRequest request = TrackRequest.newBuilder().build();

                // Invoke the service and retrieve the response
                TrackResponse response = blockingStub.track(request);

                // Update the UI with the response
                SwingUtilities.invokeLater(() -> {
                    replyFields.get(0).setText(response.getTrackingStatus());
                });

                // Shutdown the channel
                channel.shutdown();
            }).start();

        } else if (label.equals("Invoke Status Service")) {
            System.out.println("Status service to be invoked ...");

            // Create a new thread to invoke the service
            new Thread(() -> {
                // Temperature Service Definition
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
                StatusGrpc.StatusBlockingStub blockingStub = StatusGrpc.newBlockingStub(channel);

                // Prepare the request message
                FilterStatusRequest request = FilterStatusRequest.newBuilder().setFilterStatus(0).build();

                // Invoke the service and retrieve the response
                FilterStatusResponse response = blockingStub.status(request);

                // Update the UI with the response
                SwingUtilities.invokeLater(() -> {
                    replyFields.get(1).setText(String.valueOf(response.getFilterStatusCurr()));
                });

                // Shutdown the channel
                channel.shutdown();
            }).start();

        } else if (label.equals("Invoke Index Service")) {
            System.out.println("Index service to be invoked ...");

            // Create a new thread to invoke the service
            new Thread(() -> {
                // Index Service Definition
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
                IndexGrpc.IndexBlockingStub blockingStub = IndexGrpc.newBlockingStub(channel);

                // Prepare the request message
                JTextField service3Entry = entryFields.get(2);
                NumberKmRequest request = NumberKmRequest.newBuilder().setKm(Double.parseDouble(service3Entry.getText())).build();

                // Invoke the service and retrieve the response
                AnalysisResponse response = blockingStub.index(request);

                // Update the UI with the response
                SwingUtilities.invokeLater(() -> {
                    replyFields.get(2).setText(String.valueOf(response.getTotal()));
                });

                // Shutdown the channel
                channel.shutdown();
            }).start();

        }
    }

}
