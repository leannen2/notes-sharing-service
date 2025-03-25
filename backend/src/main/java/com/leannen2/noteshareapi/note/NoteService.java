package com.leannen2.noteshareapi.note;

import com.leannen2.noteshareapi.s3.S3Buckets;
import com.leannen2.noteshareapi.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final S3Service s3Service;
    private final S3Buckets s3Buckets;
    private final NoteJDBCDataAccessService dataAccessService;

    public void uploadNote(String className, MultipartFile file) {
        String noteId = UUID.randomUUID().toString();
        try {
            s3Service.putObject(
                    s3Buckets.getNote(),
                    "notes/%s/%s".formatted(className, noteId),
                    file.getBytes()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        dataAccessService.insertNote(new Note(noteId, 0, className));
    }

    public List<Note> getNotesByClassName(String className) {
        return dataAccessService.selectNoteByClassName(className);
    }


    public byte[] getNoteFile(String className, String noteId) {
        return s3Service.getObject(
                s3Buckets.getNote(),
                "notes/%s/%s".formatted(className, noteId)
        );
    }

}
