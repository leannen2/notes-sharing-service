package com.leannen2.noteshareapi;

import org.springframework.boot.SpringApplication;

public class TestNoteShareApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(NoteShareApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
