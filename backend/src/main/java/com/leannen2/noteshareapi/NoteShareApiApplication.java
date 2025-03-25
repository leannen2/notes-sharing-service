package com.leannen2.noteshareapi;

import com.leannen2.noteshareapi.note.Note;
import com.leannen2.noteshareapi.note.NoteJDBCDataAccessService;
import com.leannen2.noteshareapi.s3.S3Buckets;
import com.leannen2.noteshareapi.s3.S3Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NoteShareApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteShareApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(
			S3Service s3Service,
			S3Buckets s3Buckets,
			NoteJDBCDataAccessService sqlService
	) {
		return args -> {
			// createRandomCustomer(customerRepository, passwordEncoder);
			 testBucketUploadAndDownload(s3Service, s3Buckets, sqlService);
		};
	}

	private static void testBucketUploadAndDownload(S3Service s3Service, S3Buckets s3Buckets, NoteJDBCDataAccessService sqlService) {
//		s3Service.putObject(
////				s3Buckets.getCustomer(),
//				s3Buckets.getNote(),
//				"foo/bar/woohoo",
//				"blahblah".getBytes()
//		);
//
//		byte[] obj = s3Service.getObject(
//				s3Buckets.getNote(),
//				"foo/bar/woohoo"
//		);

//		System.out.println("Hooray: " + new String(obj));
//		Note n = new Note("new note 1", 2, "cs161");
//		sqlService.insertNote(n);
		System.out.println(sqlService.selectNoteByClassName("cs161"));
//		System.out.println("notes for cs161 exists: " + sqlService.existsNoteWithClassName("cs161"));
//		System.out.println("note with id def exists: " + sqlService.existsNoteById("def"));
//		sqlService.deleteNoteById("def");

	}


}
