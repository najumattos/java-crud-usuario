package com.javanauta.cadastro_usuario.business;
import java.util.List;

import org.springframework.stereotype.Service;
import com.javanauta.cadastro_usuario.infraestructure.repositories.UsuarioRepository;
import com.javanauta.cadastro_usuario.infraestructure.entities.Usuario;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }               

    public void SalvarUsuario(Usuario usuario) {
        usuarioRepository.saveAndFlush(usuario);
    }

    public Usuario BuscarUsuarioPorEmail(String email){

        return usuarioRepository.findByEmail(email).orElseThrow(
            () -> new RuntimeException("Email não encontrado")
        );
    }

    public void DeletarUsuarioPorEmail(String email) {
        usuarioRepository.deleteByEmail(email);
    }

   public void AtualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntity = usuarioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario não encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() :
                        usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() :
                        usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        usuarioRepository.saveAndFlush(usuarioAtualizado);
    }

    public List<Usuario> BuscarTodos() {
        return usuarioRepository.findAll();
    }
}