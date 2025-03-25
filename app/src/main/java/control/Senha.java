package control;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class Senha {
    private static int workload = 12;
    public static String hashSenha(String senha){
    String salt = BCrypt.gensalt(workload);
    String senhaHash = BCrypt.hashpw(senha, salt);
    return senhaHash;
    }
    public static boolean verificaSenha(String senha, String senhaArmazenada) throws SQLException {
        boolean senhaVerificada = false;
        if (null == senhaArmazenada) {
            throw new SQLException("Erro ao consultar senha");

        }
        senhaVerificada = BCrypt.checkpw(senha, senhaArmazenada);
        return senhaVerificada;
    }
}
