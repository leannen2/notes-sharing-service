package com.leannen2.noteshareapi.note;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/notes")
public class NoteController {

    private final NoteService noteService;

    @PostMapping(
            value="{className}/file",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public void uploadFile(@PathVariable("className") String className, @RequestParam("file") MultipartFile file) {
        noteService.uploadNote(className, file);
    }

    @GetMapping(value="{className}/{noteId}/file")
    public byte[] getFile(@PathVariable("noteId") String className, @PathVariable("noteId") Integer noteId) {
        return noteService.getNote(className, noteId);
    }

}
