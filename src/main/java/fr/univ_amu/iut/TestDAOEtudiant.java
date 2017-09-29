package fr.univ_amu.iut;

import fr.univ_amu.iut.beans.Etudiant;

import java.sql.*;
import java.util.*;

/**
 * Created by s16004678 on 29/09/17.
 */
public class TestDAOEtudiant {
    // La requete de test
    static final String req = "SELECT * " +
            "FROM ETUDIANT " +
            "WHERE VILLE_ET = 'AIX-EN-PROVENCE'";

    public static void main(String[] args) throws SQLException {
        // Connexion a la base
        System.out.println("Connexion");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            ArrayList<Etudiant> etudiants = new ArrayList<>();
            while (rset.next()){
                Etudiant etudiant = new Etudiant();
                creerEtudiant(rset, etudiant);
                etudiants.add(etudiant);
            }
            // Fermeture de l'instruction (liberation des ressources)

            for (Etudiant etudiant:etudiants) {
                System.out.println(etudiant);

            }
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }

    private static void creerEtudiant(ResultSet rset, Etudiant etudiant) throws SQLException {
        etudiant.setNumEt(rset.getInt("NUM_ET"));
        etudiant.setNomEt(rset.getString("NOM_ET"));
        etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
        etudiant.setAnnee(rset.getInt("ANNEE"));
        etudiant.setCpEt(rset.getString("CP_ET"));
        etudiant.setVilleEt(rset.getString("VILLE_ET"));
        etudiant.setGroupe(rset.getInt("GROUPE"));
    }
}

