package com.leannen2.noteshareapi.note;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    @GetMapping(
            value="{className}/{noteId}/file",
            produces = MediaType.APPLICATION_PDF_VALUE
    )
    public byte[] getFile(@PathVariable("className") String className, @PathVariable("noteId") String noteId) {
        return noteService.getNoteFile(className, noteId);
    }

    @GetMapping (value="{className}", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Note> getNotes(@PathVariable("className") String className) {
        return noteService.getNotesByClassName(className);
    }

}
