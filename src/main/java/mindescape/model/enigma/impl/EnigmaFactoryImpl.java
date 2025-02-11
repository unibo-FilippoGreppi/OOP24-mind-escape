package mindescape.model.enigma.impl;

import mindescape.model.enigma.api.Enigma;
import mindescape.model.enigma.api.EnigmaFactory;
import mindescape.model.enigma.caesarcipher.impl.CaesarCipherModelImpl;
import mindescape.model.enigma.enigmapassword.impl.EnigmaPasswordModelImpl;

/**
 * Factory class that creates the enigma objects.
 */
public class EnigmaFactoryImpl implements EnigmaFactory {

    @Override
    public Enigma getEnigma(final String name) throws IllegalArgumentException {
        var enigmaName = EnigmaType.getEnigma(name);
        return (Enigma) switch (enigmaName) {
            case ENIGMA_FIRST_DOOR -> new EnigmaPasswordModelImpl(name, "Sergio Mattarella");
            case DRAWER -> new EnigmaPasswordModelImpl(name, "1213");
            case CAESAR_CIPHER -> new CaesarCipherModelImpl(name, 3);
            default -> throw new IllegalArgumentException("Unexpected enigma: " + name);
        };
    }
}
