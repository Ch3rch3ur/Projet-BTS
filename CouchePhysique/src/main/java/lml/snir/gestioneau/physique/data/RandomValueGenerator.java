package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author joris
 */
public class RandomValueGenerator {
    
     public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        // Génère un nombre entre min et max inclus
        return random.nextInt((max - min) + 1) + min;
    }
     
     public static double generateRandomDouble(double min, double max) {
        Random random = new Random();
        // Génère un nombre entre min et max inclus
        Double value = min + (max - min) * random.nextDouble();
        value = Math.round(value * 10.0) / 10.0;
        return value;
    }
     
    public static Date generateRandomDate() {
        // Obtenir la date actuelle
        long currentTimeMillis = System.currentTimeMillis();
        
        // Créer un générateur de nombres aléatoires
        Random random = new Random();

        // Ajouter une heure, des minutes et des secondes aléatoires
        int randomHour = random.nextInt(24);      // Heure entre 0 et 23
        int randomMinute = random.nextInt(60);    // Minute entre 0 et 59
        int randomSecond = random.nextInt(60);    // Seconde entre 0 et 59

        // Convertir le timestamp actuel en Date
        Date currentDate = new Date(currentTimeMillis);

        // Modifier l'heure de la date actuelle
        currentDate.setHours(randomHour);
        currentDate.setMinutes(randomMinute);
        currentDate.setSeconds(randomSecond);

        return currentDate;
    }
    
    // Nouvelle méthode pour générer aléatoirement "ville" ou "pluie"
    public static String generateRandomMode() {
        Random random = new Random();
        String[] modes = {"ville", "pluie"};
        return modes[random.nextInt(modes.length)];
    }
     
}
