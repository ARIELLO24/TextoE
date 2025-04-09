package textosEpicos.controller;


import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import java.awt.Color;
import java.util.prefs.Preferences;
import javax.swing.UIManager;

/**
 *
 * @author Arthur de Souza Manske
 */
public class WindowPreferencesController {
    private final Preferences preferences;
    
    public WindowPreferencesController(String className)
    {
        this.preferences = Preferences.userRoot().node(className);
    }
    
    public String apply(java.awt.Component c)
    {
        final FlatLaf theme = (this.getTheme().equals("dark") ? new FlatMacDarkLaf() : new FlatMacLightLaf());

        try {
            UIManager.setLookAndFeel(theme);
            if (c != null) javax.swing.SwingUtilities.updateComponentTreeUI(c);
            
            return null;
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }
    
    public void setTheme(String theme)
    {
        this.preferences.put("ui.theme", theme);
    }
    
    public void setAccentColor(Color color)
    {
        this.preferences.putInt("ui.accent_color", color.getRGB());
    }
    
    public String getTheme()
    {
        final var theme = this.preferences.get("ui.theme", null);
        return theme == null ? "FlatLafMacLight" : theme;
    }
    
    public Color getAccentColor()
    {
        final var value = this.preferences.getInt("ui.accent_color", -1);
        if (value == -1) return new Color(0x3f3f6f);
        return new Color(value);
    }    
}