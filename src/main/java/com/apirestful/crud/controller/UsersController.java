package com.apirestful.crud.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import com.apirestful.crud.model.User;
import com.apirestful.crud.repository.UserRepository;
import com.apirestful.crud.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/users")
@Tag(name = "Usuários", description = "Operações para gerenciar usuários no sistema")
public class UsersController {

    @Autowired
    UserRepository repository;
    @Autowired
    private UserService userService;

    /**
     * Recupera todos os usuários do sistema.
     *
     * @return Lista de usuários.
     */
    @GetMapping()
    @Operation(summary = "Buscar todos os usuários", description = "Obtém uma lista de todos os usuários no sistema.")
    @ApiResponse(responseCode = "200", description = "Usuários recuperados com sucesso")
    public List<User> getUsers(){
       return userService.getAllUsers();
    };

    /**
     * Recupera um usuário específico pelo seu ID.
     *
     * @param id O ID do usuário a ser recuperado.
     * @return Detalhes do usuário, se encontrado.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuário por ID", description = "Obtém os detalhes de um usuário específico pelo seu ID.")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    public ResponseEntity<Optional<User>> getUserById(@Valid @PathVariable long id){
        Optional<User> user = Optional.ofNullable(userService.getUserById(id));
        return ResponseEntity.status(HttpStatus.OK).body(user);
    };

    /**
     * Cria um novo usuário no sistema.
     *
     * @param user O objeto do usuário a ser criado.
     * @return O usuário criado, com um cabeçalho de localização apontando para o novo recurso.
     */
    @PostMapping()
    @Operation(summary = "Criar novo usuário", description = "Cria um novo usuário no sistema.")
    @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados do usuário inválidos")
    public ResponseEntity<Optional<User>> createUser(@Valid @RequestBody User user){
        Optional<User> newUser = Optional.ofNullable(userService.createUser(user));
        return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/users/" + newUser.get())
                    .body(newUser);

    };

    /**
     * Atualiza as informações de um usuário existente pelo seu ID.
     *
     * @param id O ID do usuário a ser atualizado.
     * @param user Os dados atualizados do usuário.
     * @return Os detalhes do usuário atualizado.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar usuário", description = "Atualiza os dados de um usuário existente.")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
        public ResponseEntity<Optional<User>> updateUser(@PathVariable long id,@Valid @RequestBody User user){
        Optional<User> newUser = Optional.ofNullable(userService.updateUser(user,id));
            return ResponseEntity.status(HttpStatus.OK).body(newUser);
    };

    /**
     * Exclui um usuário pelo seu ID.
     *
     * @param id O ID do usuário a ser excluído.
     * @return Uma mensagem de confirmação da exclusão do usuário.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar usuário", description = "Exclui um usuário pelo seu ID.")
    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        Optional<User> user = Optional.ofNullable(userService.getUserById(id));
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted: " + user.get());
    };
}
