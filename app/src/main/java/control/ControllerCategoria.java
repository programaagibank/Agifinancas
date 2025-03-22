//package control;
//import DAO.CategoriaDAO;
//import model.Categoria;
//import java.sql.SQLException;
//
//public class ControllerCategoria {
//    public Categoria criarCategoria (int idUsuario, String nome, String tipo){
//        try {
//            Categoria categoria = CategoriaDAO.insert(idUsuario, nome, tipo);
//            if (categoria != null) {
//                System.out.println("Categoria criada com sucesso! ");
//                return categoria;
//            }
//        } catch (SQLException e) {
//            System.out.println("Erro ao criar categoria: " + e.getMessage());
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public Categoria atualizarCategoria (int idCategoria, int idUsuario, String nome, String tipo) {
//        Categoria categoria = CategoriaDAO.update(idCategoria, idUsuario, nome, tipo);
//        if (categoria != null) {
//            System.out.println("Categoria atualizada com sucesso! ");
//            return categoria;
//        }
//        return null;
//    }
//    public boolean deletarCategoria (int idCategoria, int idUsuario) {
//        if (CategoriaDAO.delete(idCategoria, idUsuario)) {
//            System.out.println("Categoria deletada com sucesso! ");
//            return true;
//        }
//        return false;
//    }
//    public Categoria buscarCategoria (int idCategoria, int idUsuario) {
//        return CategoriaDAO.buscar(idCategoria, idUsuario);
//    }
//
//}
