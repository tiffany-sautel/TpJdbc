package fr.univ_amu.iut;

import fr.univ_amu.iut.beans.Etudiant;
import fr.univ_amu.iut.beans.Module;
import fr.univ_amu.iut.beans.Prof;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by s16004678 on 25/09/17.
 */
public class TestAsso1 {
    static final String req2 = "SELECT *" +
            "FROM PROF, MODULE " +
            "WHERE PROF.MAT_SPEC = MODULE.CODE";

    static final String reqProf = "SELECT *" +
            "FROM PROF " +
            "WHERE PROF.MAT_SPEC =?";

    static final String reqModule = "SELECT *" +
            "FROM MODULE " +
            "WHERE CODE =?";

    public static void main(String[] args) throws SQLException {
        // Connexion a la base
        System.out.println("Connexion");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            // Affichage du resultat
            System.out.println("Execution de la requete : " + req2 );
            ResultSet rset2 = stmt.executeQuery(req2);
            ArrayList<Prof> profs = new ArrayList<>();

            while (rset2.next()){
                Prof prof = creerProf(rset2);
                profs.add(prof);

            }
            for (Prof prof:profs) {
                System.out.println(prof);
                System.out.println(prof.getMatSpec());

            }
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }

    private static Prof creerProf(ResultSet rset2) throws SQLException {
        Prof prof = new Prof();
        prof.setNumProf(rset2.getInt("NUM_PROF"));
        prof.setNomProf(rset2.getString("NOM_PROF"));
        prof.setPrenomProf(rset2.getString("PRENOM_PROF"));
        prof.setAdrProf(rset2.getString("ADR_PROF"));
        prof.setCpProf(rset2.getString("CP_PROF"));
        prof.setVilleProf(rset2.getString("VILLE_PROF"));
        prof.setMatSpec(creerModule(rset2.getString()));
        return prof;
    }

    private static Prof creerProf(int numProf)throws SQLException{
        Connection conn = ConnexionUnique.getInstance().getConnection();
        PreparedStatement preparStt = conn.prepareStatement(reqProf);
        preparStt.setInt(1,numProf);
        ResultSet resSet = preparStt.executeQuery();
        return creerProf(resSet);

    }
    private static Module creerModule(String code)throws SQLException{
        Connection conn = ConnexionUnique.getInstance().getConnection();
        PreparedStatement preparStt = conn.prepareStatement(reqModule);
        preparStt.setString(1,code);
        ResultSet resSet = preparStt.executeQuery();
        return creerModule(resSet);
    }

    private static Module creerMatSpec(ResultSet rset2) throws SQLException {
        Module MatSpec = new Module();
        MatSpec.setCode(rset2.getString("CODE"));
        MatSpec.setLibelle(rset2.getString("LIBELLE"));
        MatSpec.sethCoursPrev(rset2.getInt("H_COURS_PREV"));
        MatSpec.sethCoursRea(rset2.getInt("H_COURS_REA"));
        MatSpec.sethTpPrev(rset2.getInt("H_TP_PREV"));
        MatSpec.sethTpRea(rset2.getInt("H_TP_REA"));
        MatSpec.setDiscipline(rset2.getString("DISCIPLINE"));
        MatSpec.setCoefCc(rset2.getInt("COEFF_CC"));
        MatSpec.setCoefTest(rset2.getInt("COEFF_TEST"));
        responsable.setNumProf(creerProf(rset2.getInt("RESP")));
        MatSpec.setResponsable(responsable);
        return MatSpec;
    }
}
