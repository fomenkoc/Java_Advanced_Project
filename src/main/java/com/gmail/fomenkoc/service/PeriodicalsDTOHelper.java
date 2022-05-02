package com.gmail.fomenkoc.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import com.gmail.fomenkoc.domain.Periodical;

public class PeriodicalsDTOHelper {

	public static Periodical createEnity(MultipartFile image, String name,
			String description, Double price) throws IOException {

		Periodical periodical = new Periodical(name, description, price,
				Base64.getEncoder().encodeToString(image.getBytes()));

		return periodical;
	}
}
