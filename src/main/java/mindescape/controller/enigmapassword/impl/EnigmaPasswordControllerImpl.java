package mindescape.controller.enigmapassword.impl;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import mindescape.controller.enigmapassword.api.EnigmaPasswordController;
import mindescape.controller.maincontroller.api.MainController;
import mindescape.model.enigma.enigmapassword.api.EnigmaPasswordModel;
import mindescape.model.enigma.enigmapassword.impl.EnigmaPasswordModelImpl;
import mindescape.view.enigmapassword.api.EnigmaPasswordView;
import mindescape.view.enigmapassword.impl.EnigmaPasswordViewImpl;

/**
 * Implementation of {@code EnigmaPasswordController} that manages user interactions
 * for password-based enigmas.
 */
public class EnigmaPasswordControllerImpl implements EnigmaPasswordController {

    private final MainController mainController;
    private final EnigmaPasswordModel model; 
    private final EnigmaPasswordView view; 

    /**
     * Constructs an {@code EnigmaPasswordControllerImpl} with the given model and main controller.
     *
     * @param model the password enigma model
     * @param mainController the main controller managing this instance
     */
    public EnigmaPasswordControllerImpl(final EnigmaPasswordModel model, final MainController mainController) {
        this.mainController = mainController;
        this.model = model; 
        this.view = new EnigmaPasswordViewImpl(this); 
    }

    /**
     * Handles user input and checks if the password is correct.
     *
     * @param input the user-provided password
     */
    @Override
    public void handleInput(final Object input) {
        if (input instanceof String) {
            this.view.showResult(this.model.hit(input)); 
        }
    }

    /**
     * Retrieves the name of the enigma.
     *
     * @return the name of the enigma as a string
     */
    @Override
    public String getName() {
        return this.model.getName(); 
    }

    /**
     * Retrieves the panel associated with this controller.
     *
     * @return the {@code JPanel} for the view
     */
    @Override
    public JPanel getPanel() {
        return this.view.getPanel(); 
    }

    /**
     * Quits the current controller and switches to another controller in the main application.
     */
    @Override
    public void quit() {
        this.mainController.setController(this.mainController.findController("World"));
    }

    /**
     * Main method to test the functionality of the password enigma controller.
     * Launches a window with an instance of the controller.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EnigmaPasswordModel model = new EnigmaPasswordModelImpl("First Room Enigma", "secret");
            EnigmaPasswordController controller = new EnigmaPasswordControllerImpl(model, null);

            JFrame frame = new JFrame("Enigma Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.add(controller.getPanel());
            frame.setVisible(true);
        });
    }
}