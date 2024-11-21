import java.util.Arrays;
import java.util.Scanner;

public class GestionStock {


    int[] codesProduits = new int[100]; // Contiendra les codes uniques pour chaque produit.
    String[] nomsProduits = new String[100]; //Contiendra les noms des produits.
    int[] quantites = new int[100]; //Contiendra les quantités en stock pour chaque produit.
    double[] prix = new double[100]; //Contiendra les prix unitaires de chaque produit.

    static void ajouterProduit(int code, String nom, int quantite, double prix) {

    }

    static void modifierProduit(int code, String nouveauNom, int nouvelleQuantite, double nouveauPrix) {

    }

    static void supprimerProduit(int code) {

    }

    static void afficherProduits() {

    }

    static int rechercherProduit(String nom) {
        return -1;
    }

    static double calculerValeurStock() {
        return 0;
    }

    public static void main(String[] args) {


        int choix;

        //taking value as command line argument.
        Scanner in = new Scanner(System.in);


        do {

            System.out.println(
                    """
                            ----- Gestion de Stock -----\s
                            1. Ajouter un produit\s
                            2. Modifier un produit\s
                            3. Supprimer un produit\s
                            4. Afficher la liste des produits\s
                            5. Rechercher un produit\s
                            6. Calculer la valeur totale du stock\s
                            0. Quitter
                            
                            Choisissez une option :
                            """
            );

            choix = in.nextInt();
            if (choix < 0 | choix > 6) {
                System.out.println("!!!!!! Choisissez une option entre 0 et 6. !!!!!! ");
            }
        } while (choix < 0 | choix > 6);

        /* tu dois te servir d'une variable pour gerer le nombre de produits présents dans le stock
         * Lorsque tu crée un produit, il faut l'incrémenter (+1)
         * Lorsque tu supprimer un produit, il faut le décrémenter (-1)
         *
         * */
    }


}
