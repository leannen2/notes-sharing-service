package com.leannen2.noteshareapi.note;

import com.leannen2.noteshareapi.s3.S3Buckets;
import com.leannen2.noteshareapi.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final S3Service s3Service;
    private final S3Buckets s3Buckets;

    public void uploadNote(String className, MultipartFile file) {
        // TODO: verify className
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

        // TODO: Store noteId to postgres
    }

    // TODO: method to get all notes for a className?

    public byte[] getNote(String className, Integer noteId) {
        return s3Service.getObject(
                s3Buckets.getNote(),
                "notes/%s/%s".formatted(className, noteId)
        );
    }

}
