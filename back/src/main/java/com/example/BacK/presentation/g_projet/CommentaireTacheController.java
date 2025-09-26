package com.example.BacK.presentation.g_projet;


import com.example.BacK.application.g_Projet.Command.commentaireTache.add.AddCommentaireTacheCommand;
import com.example.BacK.application.g_Projet.Command.commentaireTache.add.AddCommentaireTacheResponse;
import com.example.BacK.application.g_Projet.Command.commentaireTache.delete.DeleteCommentaireTacheCommand;
import com.example.BacK.application.g_Projet.Command.commentaireTache.update.UpdateCommentaireTacheCommand;
import com.example.BacK.application.g_Projet.Query.commentaireTache.GetCommentaireTacheQuery;
import com.example.BacK.application.mediator.Mediator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/CommentaireTache")
public class CommentaireTacheController {

    private final Mediator mediator;

    public CommentaireTacheController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<List<AddCommentaireTacheResponse>> add(@RequestBody AddCommentaireTacheCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediator.sendToHandlers(command));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateCommentaireTacheCommand command) {
        command.setId(id);
        mediator.sendToHandlers(command);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mediator.sendToHandlers(new DeleteCommentaireTacheCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<Object>> filter(@RequestBody GetCommentaireTacheQuery query) {
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        GetCommentaireTacheQuery query = new GetCommentaireTacheQuery();
        return ResponseEntity.ok(mediator.sendToHandlers(query));
    }
}
