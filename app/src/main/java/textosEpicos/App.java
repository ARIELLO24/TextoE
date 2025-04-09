package textosEpicos;

import textosEpicos.controller.WindowPreferencesController;
import textosEpicos.view.MainForm;

public class App {
    private final WindowPreferencesController winController;
    private final MainForm                    mainForm;

    private App()
    {
        this.winController  = new WindowPreferencesController(this.getClass().getName());
        
        this.winController.apply(null);
        this.mainForm = new MainForm(this.winController);
    }

    private void run()
    {
        this.winController.apply(this.mainForm);
        this.mainForm.setVisible(true);
    }

    /**
     * Initializes the application
     * @param args - Command line arguments
     */
    public static void main(String[] args)
    {
        final var app = new App();
        app.run();
    }
}