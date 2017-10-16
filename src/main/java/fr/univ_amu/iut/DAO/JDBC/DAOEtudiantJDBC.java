package fr.univ_amu.iut.DAO.JDBC;

import fr.univ_amu.iut.ConnexionUnique;
import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOEtudiantJDBC implements DAOEtudiant {

    @Override
    public int computeNbEtudiant() {
        String req = "SELECT COUNT * FROM ETUDIANT";
        System.out.println("Connexion");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            while (rset.next()){
                System.out.print(rset.getInt("COUNT"));
            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return 0;
    }

    @Override
    public List<Etudiant> findByAnnee(int annee) {
        String req = "SELECT * FROM ETUDIANT WHERE ANNEE = ?";
        System.out.println("Connexion");
        List<Etudiant> etudiants = new ArrayList<>();
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            while (rset.next()){
                Etudiant etudiant = new Etudiant();
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setGroupe(rset.getInt("GROUPE"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
                etudiants.add(etudiant);
            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return etudiants;
    }

    @Override
    public List<Etudiant> findByGroupe(int groupe) {
        String req = "SELECT * FROM ETUDIANT WHERE GROUPE = ?";
        System.out.println("Connexion");
        List<Etudiant> etudiants = new ArrayList<>();
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            while (rset.next()){
                Etudiant etudiant = new Etudiant();
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setGroupe(rset.getInt("GROUPE"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
                etudiants.add(etudiant);
            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return etudiants;
    }

    @Override
    public List<Etudiant> findByNom(String nomEt) {
        String req = "SELECT * FROM ETUDIANT WHERE NOM = ?";
        System.out.println("Connexion");
        List<Etudiant> etudiants = new ArrayList<>();
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            while (rset.next()){
                Etudiant etudiant = new Etudiant();
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setGroupe(rset.getInt("GROUPE"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
                etudiants.add(etudiant);
            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return etudiants;
    }

    @Override
    public boolean delete(Etudiant obj) {
        String req = "DELETE FROM ETUDIANT WHERE NUM_ET =" + obj.getNumEt();
        System.out.println("Connexion");
        boolean delete =false;
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );

            // Affichage du resultat
            int rset = stmt.executeUpdate(req);
            if (rset == 1){
                delete=true;
            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return delete;
    }

    @Override
    public List<Etudiant> FindAll() {
        String req = "SELECT * FROM ETUDIANT";
        System.out.println("Connexion");
        List<Etudiant> etudiants = new ArrayList<>();
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            while (rset.next()){
                Etudiant etudiant = new Etudiant();
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setGroupe(rset.getInt("GROUPE"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
                etudiants.add(etudiant);
            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return etudiants;
    }

    @Override
    public Etudiant getById(int id) {
        String req = "SELECT * FROM ETUDIANT WHERE NUM_ET = "+id;
        System.out.println("Connexion");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            while (rset.next()){
                Etudiant etudiant = new Etudiant();
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setGroupe(rset.getInt("GROUPE"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
                return etudiant;
            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return null;
    }

    @Override
    public Etudiant insert(Etudiant obj) {
        String req = "INSERT INTO ETUDIANT(NUM_ET,NOM_ET,PRENOM_ET,ANNEE,GROUPE,VILLE-ET,CP-ET) VALUES("+obj.getNumEt()+","+obj.getNomEt()+","+obj.getPrenomEt()+","+obj.getAnnee()+","+obj.getGroupe()+","+obj.getVilleEt()+","+obj.getCpEt()+")";
        System.out.println("Connexion");
        boolean delete =false;
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            // Affichage du resultat
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            while (rset.next()){
                Etudiant etudiant = new Etudiant();
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setGroupe(rset.getInt("GROUPE"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
                return etudiant;
            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return obj;
    }

    @Override
    public boolean update(Etudiant obj) {
        String req ="UPDATE ETUDIANT SET NUM_ET = " +obj.getNumEt()+ ", NOM_ET = "+obj.getNomEt()+ ", PRENOM_ET = "+obj.getPrenomEt()+ ", ANNEE = "+obj.getAnnee()+ ", GROUPE = "+obj.getGroupe()+ ", VILLE_ET = "+obj.getVilleEt()+ ", CP_ET = "+obj.getCpEt();
        System.out.println("Connexion");
        boolean update =false;
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            // Affichage du resultat
            int rset = stmt.executeUpdate(req);
            if (rset == 1){
                update=true;
            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return update;
    }
}
