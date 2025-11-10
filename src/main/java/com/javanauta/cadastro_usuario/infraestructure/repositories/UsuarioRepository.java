package com.javanauta.cadastro_usuario.infraestructure.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javanauta.cadastro_usuario.infraestructure.entities.Usuario;
import java.util.Optional;
import jakarta.transaction.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Optional<Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);

    

}
